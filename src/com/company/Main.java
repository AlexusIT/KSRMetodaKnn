package com.company;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Cechy cechy = new Cechy();
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
	    operacjeNaPlikach.tworz("reut2-015.sgm");
        //String kraj= "jprdl";
        //String tekstt[] = "dwa euopa 1 YEN EUR in dwa in USD $ JPY";
        //Tekst tekst = new Tekst(kraj,tekstt);
        //cechy.cecha4(tekst);
        for(int i = 0; i< Kontenery.WszytkieTeksty.size(); i++){
            //cechy.cecha7(Kontenery.WszytkieTeksty.get(i));
            //cechy.cecha2(Kontenery.WszytkieTeksty.get(i));
            //cechy.cecha3(Kontenery.WszytkieTeksty.get(i));
            //cechy.cecha4(Kontenery.WszytkieTeksty.get(i));
        }

        menu(cechy);
    }

    static void menu(Cechy cechy) throws IOException {
        Scanner scan = new Scanner(System.in);
        System.out.println("***MENU***\n1. Wczytaj pliki\n2. Wybierz cechy");
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
                for (int i = 0; i < 50; ++i) System.out.println();
                menu(cechy);
        }
    }

    static void wybranaCecha(int x, Cechy cechy){
        for(int i = 0; i< Kontenery.WszytkieTeksty.size(); i++){
            if(x==0){

            } if (x==1){
                cechy.cecha2(Kontenery.WszytkieTeksty.get(i));
            } if (x==2){
                cechy.cecha3(Kontenery.WszytkieTeksty.get(i));
            } if (x==3){
                cechy.cecha4(Kontenery.WszytkieTeksty.get(i));
            } if (x==4){

            } if (x==5){
                cechy.cecha6(Kontenery.WszytkieTeksty.get(i));
            } if (x==6){
                cechy.cecha7(Kontenery.WszytkieTeksty.get(i));
            } if (x==7){
                cechy.cecha8(Kontenery.WszytkieTeksty.get(i));
            } if (x==8){

            } if (x==9){

            }
        }

    }
}
