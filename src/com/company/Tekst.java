package com.company;

import java.util.ArrayList;

public class Tekst {
    String kraj;
    //String[] tresc;
    ArrayList<String> listaSlow = new ArrayList<>();

    //cecha 1
    public ArrayList<String> listaUnikSlow= new ArrayList<>();
    public ArrayList<Integer> listaWystUnikSlow= new ArrayList<>();
    //cecha 2
    public int licznikMiaryEuropa = 0;
    public int licznikMiaryAmeryka = 0;
    //cecha 3
    public int licznikMiaryTempEuropa = 0;
    public int licznikMiaryTempAmeryka = 0;
    //cecha 4
    public int licznikEURO = 0;
    public int licznikUSD = 0;
    public int licznikCAD = 0;
    public int licznikJPY = 0;
    public int licznikGBP = 0;
    //cecha 6
    public int licznikLiterFranc = 0;
    public int licznikLiterNiem = 0;
    //cecha 7
    public int licznikKoncowekUSACAN= 0;
    public int licznikKoncowekJPN = 0;
    public int licznikKoncowekGER = 0;
    //cecha 8
    public int licznikVON = 0;
    public int licznikFran = 0;
    //cecha 9
    public int licznikZdan = 0;
    //cecha 10
    public int licznikZapyt = 0;
    public int licznikWykrzyk = 0;

    public Tekst(String kraj, ArrayList<String> listaSlow) {
        this.kraj = kraj;
        this.listaSlow = listaSlow;
    }
}
