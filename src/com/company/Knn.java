package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class Knn {
    public Knn() {
    }

    public Double nGram(Tekst tekstU, Tekst tekstT) {
        double wynik = 0;
        String TU = tekstU.wszystkieSlowa;
        String TT = tekstT.wszystkieSlowa;
        float Tuu = TU.length();
        float Ttt = TT.length();
        if (TU.length() >= TT.length()) {
            int suma = 0;
            for (int i = 0; i < (TU.length() - 4 + 1); i++) {
                for (int j = 0; j < (TT.length() - 4 + 1); j++) {
                    if (TU.charAt(i) == TT.charAt(j) && TU.charAt(i + 1) == TT.charAt(j + 1) && TU.charAt(i + 2) == TT.charAt(j + 2) && TU.charAt(i + 3) == TT.charAt(j + 3)) {
                        //System.out.println("char: "+(TU.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            //System.out.println("suma: "+suma);
            //System.out.println("dzilnik: "+ (TU.length()-4+1));
            wynik = suma / ((Tuu - 4 + 1));
            //System.out.println("Wynik NGRAM = "+ wynik);
        } else {
            int suma = 0;
            for (int i = 0; i < (TT.length() - 4 + 1); i++) {
                for (int j = 0; j < (TU.length() - 4 + 1); j++) {
                    if (TT.charAt(i) == TU.charAt(j) && TT.charAt(i + 1) == TU.charAt(j + 1) && TT.charAt(i + 2) == TU.charAt(j + 2) && TT.charAt(i + 3) == TU.charAt(j + 3)) {
                        //System.out.println("char: "+(TT.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            //System.out.println("suma: "+suma);
            //System.out.println("dzilnik: "+ (TT.length()-4+1));
            wynik = suma / ((Ttt - 4 + 1));
            //System.out.println("Wynik NGRAM = "+ wynik);
        }
        return wynik;
    }

    public void metrykaEuklidesa(ArrayList<Tekst> tekstU, ArrayList<Tekst> tekstT, int K) {
        for (int i = 0; i < tekstT.size(); i++) {
            for (int j = 0; j < tekstU.size(); j++) {
                double suma = 0;
                if (tekstT.get(i).c1 == 1) {
                    double ngram = nGram(tekstU.get(j), tekstT.get(i));
                    suma = suma + ngram;
                }
                for (int k = 0; k < tekstU.get(j).wynikiWywolanychCech.size(); k++) {
                    double wynikDzialania = 0;
                    wynikDzialania = (tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k)) * (tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k));
                    suma = suma + wynikDzialania;

                }
                suma = Math.sqrt(suma);
                Mapa mapa = new Mapa(suma, tekstU.get(j).kraj);
                tekstT.get(i).odleglosciOdTekstowUczacych.add(mapa);
            }
            tekstT.get(i).kNajblizszychTekstow = tekstT.get(i).odleglosciOdTekstowUczacych.stream().sorted(Comparator.comparing(Mapa::getOdległosc)).limit(K).collect(Collectors.toList());
        }
    }

    public void metrykaCzybyszewa(ArrayList<Tekst> tekstU, ArrayList<Tekst> tekstT, int K) {
        for (int i = 0; i < tekstT.size(); i++) {
            for (int j = 0; j < tekstU.size(); j++) {
                double suma = 0;
                if (tekstT.get(i).c1 == 1) {
                    double ngram = nGram(tekstU.get(j), tekstT.get(i));
                    suma = ngram;
                }
                for (int k = 0; k < tekstU.get(j).wynikiWywolanychCech.size(); k++) {
                    double wynikDzialania;
                    wynikDzialania = tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k);
                    if (wynikDzialania < 0) {
                        wynikDzialania = wynikDzialania * (-1);
                    }
                    if (wynikDzialania > suma) {
                        suma = wynikDzialania;
                    }
                }
                Mapa mapa = new Mapa(suma, tekstU.get(j).kraj);
                tekstT.get(i).odleglosciOdTekstowUczacych.add(mapa);
            }
            tekstT.get(i).kNajblizszychTekstow = tekstT.get(i).odleglosciOdTekstowUczacych.stream().sorted(Comparator.comparing(Mapa::getOdległosc)).limit(K).collect(Collectors.toList());
        }
    }
    public void metrykaManhattan(ArrayList<Tekst> tekstU, ArrayList<Tekst> tekstT, int K){
        for (int i = 0; i < tekstT.size(); i++) {
            for (int j = 0; j < tekstU.size(); j++) {
                double suma = 0;
                if (tekstT.get(i).c1 == 1) {
                    double ngram = nGram(tekstU.get(j), tekstT.get(i));
                    suma = suma + ngram;
                }
                for (int k = 0; k < tekstU.get(j).wynikiWywolanychCech.size(); k++) {
                    double wynikDzialania = 0;
                    wynikDzialania = (tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k));
                    if (wynikDzialania < 0) {
                        wynikDzialania = wynikDzialania * (-1);
                    }
                    suma = suma + wynikDzialania;
                }
                Mapa mapa = new Mapa(suma, tekstU.get(j).kraj);
                tekstT.get(i).odleglosciOdTekstowUczacych.add(mapa);
            }
            tekstT.get(i).kNajblizszychTekstow = tekstT.get(i).odleglosciOdTekstowUczacych.stream().sorted(Comparator.comparing(Mapa::getOdległosc)).limit(K).collect(Collectors.toList());
        }
    }
}
