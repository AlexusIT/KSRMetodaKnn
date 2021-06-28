package com.company;



import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Tekst {
    String kraj;
    String sklasyfikowanyKraj;
    ArrayList<String> listaSlow = new ArrayList<>();
    ArrayList<Double> wynikiWywolanychCech = new ArrayList<>();
    ArrayList<Mapa> odleglosciOdTekstowUczacych = new ArrayList<>();
    public List<Mapa> kNajblizszychTekstow;
    //cecha 1
    public int c1 = 0;
    public ArrayList<String> listaUnikSlow= new ArrayList<>();
    public String wszystkieSlowa = "qwerty";
    public ArrayList<Integer> listaWystUnikSlow= new ArrayList<>();
    //cecha 2
    public int c2 = 0;
    public double licznikMiaryEuropa = 0;
    public double licznikMiaryAmeryka = 0;
    //cecha 3
    public int c3 = 0;
    public double licznikMiaryTempEuropa = 0;
    public double licznikMiaryTempAmeryka = 0;
    //cecha 4
    public int c4 = 0;
    public double licznikEUR = 0;
    public double licznikUSD = 0;
    public double licznikCAD = 0;
    public double licznikJPY = 0;
    public double licznikGBP = 0;
    //cecha 5
    public int c5 = 0;
    public double licznikDataAmeryka = 0;
    public double licznikDataEuropa = 0;
    public double licznikDataJaponia = 0;
    //cecha 6
    public int c6 = 0;
    public double licznikLiterFranc = 0;
    public double licznikLiterNiem = 0;
    //cecha 7
    public int c7 = 0;
    public double licznikKoncowekUSACAN= 0;
    public double licznikKoncowekJPN = 0;
    public double licznikKoncowekGER = 0;
    //cecha 8
    public int c8 = 0;
    public double licznikVON = 0;
    public double licznikFran = 0;
    //cecha 9
    public int c9 = 0;
    public double licznikZdan = 0;
    //cecha 10
    public int c10 = 0;
    public double licznikZapyt = 0;
    public double licznikWykrzyk = 0;

    public Tekst(String kraj, ArrayList<String> listaSlow) {
        this.kraj = kraj;
        this.listaSlow = listaSlow;
    }
}
