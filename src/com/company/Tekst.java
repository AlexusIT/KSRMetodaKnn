package com.company;

import java.util.ArrayList;

public class Tekst {
    String kraj;
    //String[] tresc;
    ArrayList<String> listaSlow = new ArrayList<>();
    //cecha 4
    public int licznikEURO = 0;
    public int licznikUSD = 0;
    public int licznikCAD = 0;
    public int licznikJPY = 0;
    //cecha 7
    public int licznikKoncowekUSACAN= 0;
    public int licznikKoncowekJPN = 0;
    public int licznikKoncowekGER = 0;
    //cecha 2
    public int licznikMiaryEuropa = 0;
    public int licznikMiaryAmeryka = 0;
    //cecha 3
    public int licznikMiaryTempEuropa = 0;
    public int licznikMiaryTempAmeryka = 0;

    public Tekst(String kraj, ArrayList<String> listaSlow) {
        this.kraj = kraj;
        this.listaSlow = listaSlow;
    }
}
