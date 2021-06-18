package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import static java.lang.Math.round;

public class Main {

    public static void main(String[] args) throws IOException {
        Cechy cechy = new Cechy();
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
	    operacjeNaPlikach.tworz("reut2-015.sgm");
        menu(cechy);
    }

    static void menu(Cechy cechy) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("***MENU***\n1. Wczytaj pliki\n2. Wybierz cechy\n3. Podaj % zbiorow");
        int wyborMenu = Integer.parseInt(scan.nextLine());

        switch (wyborMenu) {
            case 1:
                System.out.println("test");
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
                        wybranaCecha(i,cechy);
                    }
                }
                /*for(int j = 0; j<Kontenery.WszytkieTeksty.get(0).listaSlow.size(); j++){
                    System.out.print(Kontenery.WszytkieTeksty.get(0).listaSlow.get(j)+" ");
                }*/
                for (int i = 0; i < 50; ++i) System.out.println();
                menu(cechy);
            case 3:
                System.out.println("Podaj procętową wartość podziału tekstu na zbiór uczący, reszta procent będzie odpowiadać za zbiór testowy");
                String procent = scan.nextLine();
                double proc = Integer.parseInt(procent);
                if(proc > 0 && proc < 100){
                    proc = proc / 100;
                    double ilosc = Kontenery.WszytkieTeksty.size()*proc;
                    ilosc = round(ilosc);
                    for(int i = 0; i < Kontenery.WszytkieTeksty.size(); i++){
                        if(i < ilosc){
                            Kontenery.ZbiorTekstowUczacych.add(Kontenery.WszytkieTeksty.get(i));
                        }
                        else{
                            Kontenery.ZbiorTekstowTestowych.add(Kontenery.WszytkieTeksty.get(i));
                        }
                    }
                    for (int i = 0; i < 50; ++i) System.out.println();
                    System.out.println("Tekstow wszystkich: "+Kontenery.WszytkieTeksty.size()+ "\n"+
                            "Tekstow uczących: "+ Kontenery.ZbiorTekstowUczacych.size() + "\n" +
                            "Tekstow testowych: "+ Kontenery.ZbiorTekstowTestowych.size()+"\n");
                    menu(cechy);
                }
        }
    }

    static void wybranaCecha(int x, Cechy cechy){
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
            cechy.dodawanieWykonanychCech(Kontenery.WszytkieTeksty.get(i));
        }
    }
}
