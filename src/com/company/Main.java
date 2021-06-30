package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) throws IOException {
        Cechy cechy = new Cechy();
        menu(cechy);
    }

    static void menu(Cechy cechy) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("***MENU***\n1. Wczytaj pliki\n2. Wybierz cechy\n3. Podaj % \n4. Wybierz metrykę");
        int wyborMenu = Integer.parseInt(scan.nextLine());

        switch (wyborMenu) {
            case 1:
                System.out.println("Podaj numery plików które chcesz wczytać [00-21]");
                String zbiorPlikowString = scan.nextLine();
                wybranyPlik(zbiorPlikowString);
                for (int i = 0; i < 50; ++i) System.out.println();
                menu(cechy);
                break;
            case 2:
                System.out.println("Cecha 1 -> '0'\nCecha 2 -> '1'\nCecha 3 -> '2'\nCecha 4 -> '3'\nCecha 5 -> '4'\nCecha 6 -> '5'\n" +
                        "Cecha 7 -> '6'\nCecha 8 -> '7'\nCecha 9 -> '8'\nCecha 10 -> '9'");
                System.out.println("Wybierz cechy których chcesz użyć:");
                String zbiorCechString = scan.nextLine();

                for (int i=0; i<10;i++){
                    if(zbiorCechString.contains(String.valueOf(i))) {
                        wykonajCechy(i,cechy);
                    }
                }
                cechy.normalizacja(Kontenery.WszytkieTeksty);
                for(int i = 0; i< Kontenery.WszytkieTeksty.size(); i++){
                    cechy.dodawanieWykonanychCech(Kontenery.WszytkieTeksty.get(i));
                }
                for (int i = 0; i < 50; ++i) System.out.println();
                menu(cechy);
                break;
            case 3:
                System.out.println("Podaj procętową wartość podziału tekstu na zbiór uczący, reszta procent będzie odpowiadać za zbiór testowy");
                String procent = scan.nextLine();
                double proc = Integer.parseInt(procent);
                if(proc > 0 && proc < 100){
                    proc = proc / 100;
                    double ilosc = Kontenery.WszytkieTeksty.size()*proc;
                    ilosc = round(ilosc);
                    for(int i = 0; i < Kontenery.WszytkieTeksty.size(); i++){
                        if(i%2==0 && i < (ilosc * 2)){
                            Kontenery.ZbiorTekstowUczacych.add(Kontenery.WszytkieTeksty.get(i));

                        }
                        else{
                            Kontenery.ZbiorTekstowTestowych.add(Kontenery.WszytkieTeksty.get(i));

                        }
                    }
                    System.out.println("Tekstow wszystkich: "+Kontenery.WszytkieTeksty.size()+ "\n"+
                            "Tekstow uczących: "+ Kontenery.ZbiorTekstowUczacych.size() + "\n" +
                            "Tekstow testowych: "+ Kontenery.ZbiorTekstowTestowych.size()+"\n");
                    for (int i = 0; i < 50; ++i) System.out.println();
                    menu(cechy);
                    break;
                }
            case 4:
                System.out.println("Wybierz metrykę");
                System.out.println("Eulidesa -> '1'\nCzybyszewa -> '2'\nManhattan -> '3'");
                String metryka = scan.nextLine();
                System.out.println("Podaj ilość sąsiadów");
                String sasiad = scan.nextLine();
                int sas = Integer.parseInt(sasiad);
                Knn knn = new Knn();
                MiaryJakosci miary = new MiaryJakosci();
                if(metryka.equals("1")){
                    knn.metrykaEuklidesa(Kontenery.ZbiorTekstowUczacych, Kontenery.ZbiorTekstowTestowych,sas);
                }
                if(metryka.equals("2")){
                    knn.metrykaCzybyszewa(Kontenery.ZbiorTekstowUczacych, Kontenery.ZbiorTekstowTestowych,sas);
                }
                if(metryka.equals("3")){
                    knn.metrykaManhattan(Kontenery.ZbiorTekstowUczacych, Kontenery.ZbiorTekstowTestowych,sas);
                }
                knn.klasyfikacja(Kontenery.ZbiorTekstowTestowych);
                System.out.println("Accuracy:");
                System.out.println("Wszystkie: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"x"));
                System.out.println("");
                System.out.println("usa: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"usa"));
                System.out.println("");
                System.out.println("canada: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"canada"));
                System.out.println("");
                System.out.println("west-germany: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"west-germany"));
                System.out.println("");
                System.out.println("france: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"france"));
                System.out.println("");
                System.out.println("uk: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"uk"));
                System.out.println("");
                System.out.println("japan: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"japan"));

                System.out.println("Precision:");
                System.out.println("Wszystkie: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"x"));
                System.out.println("");
                System.out.println("usa: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"usa"));
                System.out.println("");
                System.out.println("canada: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"canada"));
                System.out.println("");
                System.out.println("west-germany: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"west-germany"));
                System.out.println("");
                System.out.println("france: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"france"));
                System.out.println("");
                System.out.println("uk: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"uk"));
                System.out.println("");
                System.out.println("japan: "+miary.precision(Kontenery.ZbiorTekstowTestowych,"japan"));

                System.out.println("Recall:");
                System.out.println("Wszystkie: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"recall"));
                System.out.println("");
                System.out.println("usa: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"usa")/100);
                System.out.println("");
                System.out.println("canada: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"canada")/100);
                System.out.println("");
                System.out.println("west-germany: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"west-germany")/100);
                System.out.println("");
                System.out.println("france: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"france")/100);
                System.out.println("");
                System.out.println("uk: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"uk")/100);
                System.out.println("");
                System.out.println("japan: "+miary.accuracy(Kontenery.ZbiorTekstowTestowych,"japan")/100);

                System.out.println("F1:");
                System.out.println("Wszystkie: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"x"));
                System.out.println("");
                System.out.println("usa: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"usa"));
                System.out.println("");
                System.out.println("canada: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"canada"));
                System.out.println("");
                System.out.println("west-germany: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"west-germany"));
                System.out.println("");
                System.out.println("france: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"france"));
                System.out.println("");
                System.out.println("uk: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"uk"));
                System.out.println("");
                System.out.println("japan: "+miary.f1(Kontenery.ZbiorTekstowTestowych,"japan"));
                /*for (int i = 0; i<Kontenery.ZbiorTekstowTestowych.size(); i++){
                    System.out.println("Nowy tekst: "+Kontenery.ZbiorTekstowTestowych.get(i).kraj);
                    for(int j = 0; j<Kontenery.ZbiorTekstowTestowych.get(i).odleglosciOdTekstowUczacych.size(); j++){
                        System.out.print("|    |"+ + Kontenery.ZbiorTekstowTestowych.get(i).odleglosciOdTekstowUczacych.get(j).odległosc + " " + Kontenery.ZbiorTekstowTestowych.get(i).odleglosciOdTekstowUczacych.get(j).kraj);
                    }
                    System.out.println("");
                }*/
                /*for(int i=0; i<Kontenery.ZbiorTekstowTestowych.size(); i++){
                    System.out.println("Nowy tekst: "+Kontenery.ZbiorTekstowTestowych.get(i).kraj+ " === "+Kontenery.ZbiorTekstowTestowych.get(i).listaSlow);
                    for(int j = 0; j<Kontenery.ZbiorTekstowTestowych.get(i).kNajblizszychTekstow.size(); j++){
                        System.out.print("|"+Kontenery.ZbiorTekstowTestowych.get(i).kNajblizszychTekstow.get(j).odległosc + " " +Kontenery.ZbiorTekstowTestowych.get(i).kNajblizszychTekstow.get(j).kraj+"|");
                    }
                    System.out.println("");
                }*/
                for (int i = 0; i < 50; ++i) System.out.println();
                menu(cechy);
                break;
        }
    }
    static void wykonajCechy(int x, Cechy cechy){
        for(int i = 0; i< Kontenery.WszytkieTeksty.size(); i++){
              if(x==0){
                cechy.cecha1(Kontenery.WszytkieTeksty.get(i));
            } if (x==1){
                cechy.cecha2(Kontenery.WszytkieTeksty.get(i));
            } if (x==2){
                cechy.cecha3(Kontenery.WszytkieTeksty.get(i));
            } if (x==3){
                cechy.cecha4(Kontenery.WszytkieTeksty.get(i));
            } if (x==4){
                cechy.cecha5(Kontenery.WszytkieTeksty.get(i));
            } if (x==5){
                cechy.cecha6(Kontenery.WszytkieTeksty.get(i));
            } if (x==6){
                cechy.cecha7(Kontenery.WszytkieTeksty.get(i));
            } if (x==7){
                cechy.cecha8(Kontenery.WszytkieTeksty.get(i));
            } if (x==8){
                cechy.cecha9(Kontenery.WszytkieTeksty.get(i));
            } if (x==9){
                cechy.cecha10(Kontenery.WszytkieTeksty.get(i));
            }
        }
    }

    static void wybranyPlik(String pliki) throws FileNotFoundException {
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
        if (pliki.contains("00")){
            operacjeNaPlikach.wczytajPlik("reut2-000.sgm");
        }
        if (pliki.contains("01")){
            operacjeNaPlikach.wczytajPlik("reut2-001.sgm");
        }
        if (pliki.contains("02")){
            operacjeNaPlikach.wczytajPlik("reut2-002.sgm");
        }
        if (pliki.contains("03")){
            operacjeNaPlikach.wczytajPlik("reut2-003.sgm");
        }
        if (pliki.contains("04")){
            operacjeNaPlikach.wczytajPlik("reut2-004.sgm");
        }
        if (pliki.contains("05")){
            operacjeNaPlikach.wczytajPlik("reut2-005.sgm");
        }
        if (pliki.contains("06")){
            operacjeNaPlikach.wczytajPlik("reut2-006.sgm");
        }
        if (pliki.contains("07")){
            operacjeNaPlikach.wczytajPlik("reut2-007.sgm");
        }
        if (pliki.contains("08")){
            operacjeNaPlikach.wczytajPlik("reut2-008.sgm");
        }
        if (pliki.contains("09")){
            operacjeNaPlikach.wczytajPlik("reut2-009.sgm");
        }
        if (pliki.contains("10")){
            operacjeNaPlikach.wczytajPlik("reut2-010.sgm");
        }
        if (pliki.contains("11")){
            operacjeNaPlikach.wczytajPlik("reut2-011.sgm");
        }
        if (pliki.contains("12")){
            operacjeNaPlikach.wczytajPlik("reut2-012.sgm");
        }
        if (pliki.contains("13")){
            operacjeNaPlikach.wczytajPlik("reut2-013.sgm");
        }
        if (pliki.contains("14")){
            operacjeNaPlikach.wczytajPlik("reut2-014.sgm");
        }
        if (pliki.contains("15")){
            operacjeNaPlikach.wczytajPlik("reut2-015.sgm");
        }
        if (pliki.contains("16")){
            operacjeNaPlikach.wczytajPlik("reut2-016.sgm");
        }
        if (pliki.contains("17")){
            operacjeNaPlikach.wczytajPlik("reut2-017.sgm");
        }
        if (pliki.contains("18")){
            operacjeNaPlikach.wczytajPlik("reut2-018.sgm");
        }
        if (pliki.contains("19")){
            operacjeNaPlikach.wczytajPlik("reut2-019.sgm");
        }
        if (pliki.contains("20")){
            operacjeNaPlikach.wczytajPlik("reut2-020.sgm");
        }
        if (pliki.contains("21")){
            operacjeNaPlikach.wczytajPlik("reut2-021.sgm");
        }
    }
}
