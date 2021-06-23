package com.company;

import java.util.ArrayList;

public class Tekst {
    String kraj;
    String sklasyfikowanyKraj;
    ArrayList<String> listaSlow = new ArrayList<>();
    ArrayList<Float> wynikiWywolanychCech = new ArrayList<>();
    //cecha 1
    public int c1 = 0;
    public ArrayList<String> listaUnikSlow= new ArrayList<>();
    public ArrayList<Integer> listaWystUnikSlow= new ArrayList<>();
    //cecha 2
    public int c2 = 0;
    public float licznikMiaryEuropa = 0;
    public float licznikMiaryAmeryka = 0;
    //cecha 3
    public int c3 = 0;
    public float licznikMiaryTempEuropa = 0;
    public float licznikMiaryTempAmeryka = 0;
    //cecha 4
    public int c4 = 0;
    public float licznikEUR = 0;
    public float licznikUSD = 0;
    public float licznikCAD = 0;
    public float licznikJPY = 0;
    public float licznikGBP = 0;
    //cecha 5
    public int c5 = 0;
    public float licznikDataAmeryka = 0;
    public float licznikDataEuropa = 0;
    public float licznikDataJaponia = 0;
    //cecha 6
    public int c6 = 0;
    public float licznikLiterFranc = 0;
    public float licznikLiterNiem = 0;
    //cecha 7
    public int c7 = 0;
    public float licznikKoncowekUSACAN= 0;
    public float licznikKoncowekJPN = 0;
    public float licznikKoncowekGER = 0;
    //cecha 8
    public int c8 = 0;
    public float licznikVON = 0;
    public float licznikFran = 0;
    //cecha 9
    public int c9 = 0;
    public float licznikZdan = 0;
    //cecha 10
    public int c10 = 0;
    public float licznikZapyt = 0;
    public float licznikWykrzyk = 0;

    public Tekst(String kraj, ArrayList<String> listaSlow) {
        this.kraj = kraj;
        this.listaSlow = listaSlow;
    }
}
