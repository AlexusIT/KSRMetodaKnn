package com.company;

import java.util.ArrayList;

public class Knn {
    public Knn() {
    }

    public Float nGram(Tekst tekstU, Tekst tekstT){
        float wynik = 0;
        String TU = tekstU.wszystkieSlowa;
        String TT = tekstT.wszystkieSlowa;
        float Tuu = TU.length();
        float Ttt = TT.length();
        if(TU.length()>=TT.length()){
            int suma = 0;
            for(int i = 0; i<(TU.length()-4+1); i++){
                for(int j = 0; j<(TT.length()-4+1); j++){
                    if(TU.charAt(i)==TT.charAt(j) && TU.charAt(i+1)==TT.charAt(j+1) && TU.charAt(i+2)==TT.charAt(j+2) && TU.charAt(i+3)==TT.charAt(j+3)){
                        System.out.println("char: "+(TU.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            System.out.println("suma: "+suma);
            System.out.println("dzilnik: "+ (TU.length()-4+1));
            wynik = suma/((Tuu-4+1));
            System.out.println("Wynik NGRAM = "+ wynik);
        }
        else {
            int suma = 0;
            for(int i = 0; i<(TT.length()-4+1); i++){
                for(int j = 0; j<(TU.length()-4+1); j++){
                    if(TT.charAt(i)==TU.charAt(j) && TT.charAt(i+1)==TU.charAt(j+1) && TT.charAt(i+2)==TU.charAt(j+2) && TT.charAt(i+3)==TU.charAt(j+3)){
                        System.out.println("char: "+(TT.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            System.out.println("suma: "+suma);
            System.out.println("dzilnik: "+ (TT.length()-4+1));
            wynik = suma/((Ttt-4+1));
            System.out.println("Wynik NGRAM = "+ wynik);
        }
        return wynik;
    }
}
