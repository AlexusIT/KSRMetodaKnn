package com.company;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cechy {
    public Cechy() {
    }

    /*void cecha1(Tekst tekst){
        ArrayList<String> listaOriSlow = new ArrayList<>();
        ArrayList<Integer> listaWystapienSlow = new ArrayList<>();
        String[] slowa = tekst.tresc.split(" ");
        System.out.println("ilosc slow: "+ slowa.length);
        for (int i = 0; i<slowa.length; i++){
            if(listaOriSlow.size()==0){
                listaOriSlow.add(slowa[i]);
                listaWystapienSlow.add(1);
            }
            else{
                for(int j = 0; j<i;j++){
                    if(slowa[i].equals(listaOriSlow.get(j))){
                        listaWystapienSlow.set(j,listaWystapienSlow.get(j)+1);
                        break;
                    }
                    else{
                        listaOriSlow.add(slowa[i]);
                        listaWystapienSlow.add(1);
                        break;
                    }
                }
            }
        }
        for(int p = 0 ; p<listaOriSlow.size(); p++){
            System.out.println(listaOriSlow.get(p) + "   " +listaWystapienSlow.get(p));
        }
    }*/

    void cecha4(Tekst tekst){
        String[] slowa = tekst.tresc.split(" ");
        for(int i=0; i<slowa.length; i++){
            Pattern patEURO = Pattern.compile("EURO"); Matcher matEURO = patEURO.matcher(slowa[i]);
            Pattern patEUR = Pattern.compile("EUR"); Matcher matEUR = patEUR.matcher(slowa[i]);
            Pattern pateuro = Pattern.compile("euro"); Matcher mateuro = pateuro.matcher(slowa[i]);
            Pattern patE = Pattern.compile("€"); Matcher matE = patE.matcher(slowa[i]);

            Pattern patDollar = Pattern.compile("Dollar"); Matcher matDollar = patDollar.matcher(slowa[i]);
            Pattern patdollar = Pattern.compile("dollar"); Matcher matdollar = patdollar.matcher(slowa[i]);
            Pattern patUSD = Pattern.compile("USD"); Matcher matUSD = patUSD.matcher(slowa[i]);
            Pattern patusd = Pattern.compile("usd"); Matcher matusd = patusd.matcher(slowa[i]);
            //Pattern patS = Pattern.compile(S); Matcher matS = patS.matcher(slowa[i]); nie działa symbol dollara

            Pattern patCAD = Pattern.compile("CAD"); Matcher matCAD = patCAD.matcher(slowa[i]);

            Pattern patJPY = Pattern.compile("JPY"); Matcher matJPY = patJPY.matcher(slowa[i]);
            Pattern patyen = Pattern.compile("yen"); Matcher matyen = patyen.matcher(slowa[i]);
            Pattern patYEN = Pattern.compile("YEN"); Matcher matYEN = patYEN.matcher(slowa[i]);

            if (matEURO.find()||matEUR.find()||mateuro.find()||matE.find()){
                tekst.licznikEURO++;
            }
            else if (matUSD.find()||matusd.find()){
                tekst.licznikUSD++;
            }
            else if (matCAD.matches()){
                tekst.licznikCAD++;
            }
            else if (matdollar.find()||matDollar.find()){
                tekst.licznikCAD++;
                tekst.licznikUSD++;
            }
            else if (matJPY.find()||matyen.find()||matYEN.find()){
                tekst.licznikJPY++;
            }
        }
        /*for(int i=0; i<slowa.length; i++){
            System.out.println(slowa[i]);
        }*/
        /*System.out.println("EUR: "+tekst.licznikEURO);
        System.out.println("  USA: " +tekst.licznikUSD);
        System.out.println("    JPN: " +tekst.licznikJPY);
        System.out.println("      CAD: " +tekst.licznikCAD);*/
    }
}
