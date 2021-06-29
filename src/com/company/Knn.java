package com.company;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;
import static java.util.Arrays.stream;

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
                        suma++;
                        break;
                    }
                }
            }
            wynik = suma / ((Tuu - 4 + 1));
        }
        else {
            int suma = 0;
            for (int i = 0; i < (TT.length() - 4 + 1); i++) {
                for (int j = 0; j < (TU.length() - 4 + 1); j++) {
                    if (TT.charAt(i) == TU.charAt(j) && TT.charAt(i + 1) == TU.charAt(j + 1) && TT.charAt(i + 2) == TU.charAt(j + 2) && TT.charAt(i + 3) == TU.charAt(j + 3)) {
                        suma++;
                        break;
                    }
                }
            }
            wynik = suma / ((Ttt - 4 + 1));
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
    public void klasyfikacja(ArrayList<Tekst> tekstT){
        for (int i = 0; i < tekstT.size(); i++) {
            ArrayList<Mapa> krajDoPrzypisania = new ArrayList<>();
            Mapa mapUsa = new Mapa(0,"usa");
            Mapa mapCanada = new Mapa(0,"canada");
            Mapa mapGermany = new Mapa(0,"west-germany");
            Mapa mapUk = new Mapa(0,"uk");
            Mapa mapFrance = new Mapa(0,"france");
            Mapa mapJapan = new Mapa(0,"japan");

            for (int j = 0; j < tekstT.get(i).kNajblizszychTekstow.size(); j++) {
                if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("usa")){
                    mapUsa.odległosc++;
                }
                else if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("canada")){
                    mapCanada.odległosc++;
                }
                else if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("west-germany")){
                    mapGermany.odległosc++;
                }
                else if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("uk")){
                    mapUk.odległosc++;
                }
                else if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("france")){
                    mapFrance.odległosc++;
                }
                else if(tekstT.get(i).kNajblizszychTekstow.get(j).kraj.equals("japan")){
                    mapJapan.odległosc++;
                }
            }
            krajDoPrzypisania.add(mapUsa);krajDoPrzypisania.add(mapCanada);krajDoPrzypisania.add(mapGermany);
            krajDoPrzypisania.add(mapUk);krajDoPrzypisania.add(mapFrance);krajDoPrzypisania.add(mapJapan);
            List<Mapa> krajePoSorcie = krajDoPrzypisania.stream().sorted(Comparator.comparing(Mapa::getOdległosc)).limit(6).collect(Collectors.toList());

            int randomNum = 0;
            int wskaznikRand = 0;
            if(krajePoSorcie.get(5).odległosc==krajePoSorcie.get(4).odległosc){
                    wskaznikRand = 1;
                    randomNum = ThreadLocalRandom.current().nextInt(4,6);
                if(krajePoSorcie.get(5).odległosc==krajePoSorcie.get(3).odległosc){
                    randomNum = ThreadLocalRandom.current().nextInt(3,6);
                    if(krajePoSorcie.get(5).odległosc==krajePoSorcie.get(2).odległosc){
                        randomNum = ThreadLocalRandom.current().nextInt(2,6);
                        if(krajePoSorcie.get(5).odległosc==krajePoSorcie.get(1).odległosc){
                            randomNum = ThreadLocalRandom.current().nextInt(1,6);
                            if(krajePoSorcie.get(5).odległosc==krajePoSorcie.get(0).odległosc){
                                randomNum = ThreadLocalRandom.current().nextInt(0,6);
                            }
                        }
                    }
                }
            }
            if(wskaznikRand == 1){
                tekstT.get(i).sklasyfikowanyKraj=krajePoSorcie.get(randomNum).kraj;
            }
            else{
                tekstT.get(i).sklasyfikowanyKraj=krajePoSorcie.get(5).kraj;
            }
            System.out.println("Randomowa cyfra: "+randomNum + "| Kraj/Sklasyfikowany :"+tekstT.get(i).kraj+"/"+tekstT.get(i).sklasyfikowanyKraj);
            for(int k = 0; k<krajePoSorcie.size(); k++){
                System.out.print(" |"+krajePoSorcie.get(k).odległosc + " " + krajePoSorcie.get(k).kraj+"| ");
            }
            System.out.println("");
        }
    }
}
