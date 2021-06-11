package com.company;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        OperacjeNaPlikach operacjeNaPlikach = new OperacjeNaPlikach();
	    operacjeNaPlikach.tworz("reut2-000.sgm");
	    System.out.println(Kontenery.WszytkieTeksty.size());
	    for(int i = 0; i < Kontenery.WszytkieTeksty.size(); i++){
            System.out.println(Kontenery.WszytkieTeksty.get(i).kraj + "   " + Kontenery.WszytkieTeksty.get(i).tresc);
	    }
    }
}
