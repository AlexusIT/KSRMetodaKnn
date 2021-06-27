package com.company;

import java.util.ArrayList;

public class Knn {
    public Knn() {
    }

    public Double nGram(Tekst tekstU, Tekst tekstT){
        double wynik = 0;
        String TU = tekstU.wszystkieSlowa;
        String TT = tekstT.wszystkieSlowa;
        float Tuu = TU.length();
        float Ttt = TT.length();
        if(TU.length()>=TT.length()){
            int suma = 0;
            for(int i = 0; i<(TU.length()-4+1); i++){
                for(int j = 0; j<(TT.length()-4+1); j++){
                    if(TU.charAt(i)==TT.charAt(j) && TU.charAt(i+1)==TT.charAt(j+1) && TU.charAt(i+2)==TT.charAt(j+2) && TU.charAt(i+3)==TT.charAt(j+3)){
                        //System.out.println("char: "+(TU.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            //System.out.println("suma: "+suma);
            //System.out.println("dzilnik: "+ (TU.length()-4+1));
            wynik = suma/((Tuu-4+1));
            //System.out.println("Wynik NGRAM = "+ wynik);
        }
        else {
            int suma = 0;
            for(int i = 0; i<(TT.length()-4+1); i++){
                for(int j = 0; j<(TU.length()-4+1); j++){
                    if(TT.charAt(i)==TU.charAt(j) && TT.charAt(i+1)==TU.charAt(j+1) && TT.charAt(i+2)==TU.charAt(j+2) && TT.charAt(i+3)==TU.charAt(j+3)){
                        //System.out.println("char: "+(TT.charAt(i)));
                        suma++;
                        break;
                    }
                }
            }
            //System.out.println("suma: "+suma);
            //System.out.println("dzilnik: "+ (TT.length()-4+1));
            wynik = suma/((Ttt-4+1));
            //System.out.println("Wynik NGRAM = "+ wynik);
        }
        return wynik;
    }
    public void miaraEuklidesa(ArrayList<Tekst> tekstU, ArrayList<Tekst> tekstT){
        for(int i = 0; i<tekstT.size(); i++){
            for(int j = 0; j<tekstU.size(); j++){
                double suma = 0;
                if(tekstT.get(i).c1==1){
                    double ngram = nGram(tekstU.get(j),tekstT.get(i));
                    //System.out.println("Ngram: "+ngram );
                    suma = suma + ngram;
                }

                for(int k = 0; k<tekstU.get(j).wynikiWywolanychCech.size(); k++){
                    double wynikDzialania = 0;
                    wynikDzialania = (tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k)) * (tekstT.get(i).wynikiWywolanychCech.get(k) - tekstU.get(j).wynikiWywolanychCech.get(k));
                    if(wynikDzialania<0){
                        wynikDzialania = wynikDzialania * (-1);
                    }
                    //System.out.println(tekstT.get(i).wynikiWywolanychCech.get(k) + " - " + tekstU.get(j).wynikiWywolanychCech.get(k) + " * " +tekstT.get(i).wynikiWywolanychCech.get(k) + " - " + tekstU.get(j).wynikiWywolanychCech.get(k) +" = "+wynikDzialania);
                    suma = suma + wynikDzialania;
                    //System.out.println("Suma= "+ suma);
                }
                suma = Math.sqrt(suma);
                //System.out.println("xxx: "+suma);
                //System.out.println("TT: "+ tekstT.get(i).wszystkieSlowa +" |TU: "+ tekstU.get(j).wszystkieSlowa);
                //System.out.println("Petla TekstT: "+i+" |Petla TekstU: " + j+" |suma: "+ suma);
                tekstT.get(i).odleglosciOdTekstowUczacych.add(suma);
            }
        }
    }
}
