package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Cechy cechy = new Cechy();
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
	    operacjeNaPlikach.tworz("reut2-005.sgm");
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
    }
}
