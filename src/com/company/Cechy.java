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

        for(int i=0; i<tekst.listaSlow.size(); i++){
            Pattern patEURO = Pattern.compile("EURO"); Matcher matEURO = patEURO.matcher(tekst.listaSlow.get(i));
            Pattern patEUR = Pattern.compile("EUR"); Matcher matEUR = patEUR.matcher(tekst.listaSlow.get(i));
            Pattern pateuro = Pattern.compile("euro"); Matcher mateuro = pateuro.matcher(tekst.listaSlow.get(i));
            Pattern patE = Pattern.compile("€"); Matcher matE = patE.matcher(tekst.listaSlow.get(i));

            Pattern patDollar = Pattern.compile("Dollar"); Matcher matDollar = patDollar.matcher(tekst.listaSlow.get(i));
            Pattern patdollar = Pattern.compile("dollar"); Matcher matdollar = patdollar.matcher(tekst.listaSlow.get(i));
            Pattern patUSD = Pattern.compile("USD"); Matcher matUSD = patUSD.matcher(tekst.listaSlow.get(i));
            Pattern patusd = Pattern.compile("usd"); Matcher matusd = patusd.matcher(tekst.listaSlow.get(i));
            //Pattern patS = Pattern.compile(S); Matcher matS = patS.matcher(tekst.listaSlow.get(i)); nie działa symbol dollara

            Pattern patCAD = Pattern.compile("CAD"); Matcher matCAD = patCAD.matcher(tekst.listaSlow.get(i));

            Pattern patJPY = Pattern.compile("JPY"); Matcher matJPY = patJPY.matcher(tekst.listaSlow.get(i));
            Pattern patYEN = Pattern.compile("YEN"); Matcher matYEN = patYEN.matcher(tekst.listaSlow.get(i));

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
            else if (matJPY.find()||matYEN.find()){
                tekst.licznikJPY++;
            }
        }
        /*for(int i=0; i<tekst.listaSlow.size(); i++){
            System.out.println(tekst.listaSlow.get(i));
        }*/
        System.out.println("EUR: "+tekst.licznikEURO);
        System.out.println("  USA: " +tekst.licznikUSD);
        System.out.println("    JPN: " +tekst.licznikJPY);
        System.out.println("      CAD: " +tekst.licznikCAD);

    }
    void cecha7(Tekst tekst){
        //Francja przed nazwiskiem PRZENIESC DO CECHY 8
        String Le = "Le";
        String le = "le";
        String La = "La";
        String la = "la";
        String Les = "Les";
        String les = "les";
        String De = "De";
        String de = "de";
        String Du = "Du";
        String du = "du";
        String Del = "Del";
        String del = "del";
        String Dela = "Dela";
        String dela = "dela";
        String Des = "Des";
        String des = "des";
        //Japonia na koncu imienia/nazwiska
        String[] koncJPN = {"mi","ko","ato","uki","oki","shi","oto","abe","ito","chi","ura","oro","iro"};
        String mi = "mi";
        String ko = "ko";
        String ato = "ato";
        String uki = "uki";
        String oki = "oki";
        String shi = "shi";
        String oto = "oto";
        String abe = "abe";
        String ito = "ito";
        String chi = "chi";
        String ura = "ura";
        String uro = "oro";
        String iro = "iro";
        //Niemcy
        String er = "er";
        //USA CANADA
        String son = "son";
        String ez = "ez";
        String tt = "tt";
        String ell = "ell";

        for(int i = 0; i < tekst.listaSlow.size()-1; i++){
            if(Character.isUpperCase(tekst.listaSlow.get(i).charAt(0)) && Character.isUpperCase(tekst.listaSlow.get(i+1).charAt(0))) {
                if (tekst.listaSlow.get(i).endsWith(son) || tekst.listaSlow.get(i+1).endsWith(son) || tekst.listaSlow.get(i).endsWith(tt) || tekst.listaSlow.get(i+1).endsWith(tt) ||
                        tekst.listaSlow.get(i).endsWith(ell) || tekst.listaSlow.get(i+1).endsWith(ell) || tekst.listaSlow.get(i).endsWith(ez) || tekst.listaSlow.get(i+1).endsWith(ez)) {
                    tekst.licznikKoncowekUSACAN++;
                } else if (tekst.listaSlow.get(i).endsWith(er)||tekst.listaSlow.get(i+1).endsWith(er)) {
                    tekst.licznikKoncowekGER++;
                } else {
                    for (int j = 0; j < koncJPN.length; j++) {
                        if (tekst.listaSlow.get(i).endsWith(koncJPN[j]) || tekst.listaSlow.get(i+1).endsWith(koncJPN[j])) {
                            tekst.licznikKoncowekJPN++;
                        }
                    }
                }
            }
        }
        System.out.println("KRAJ: "+ tekst.kraj);
        System.out.println("LicznikUSA: "+ tekst.licznikKoncowekUSACAN);
        System.out.println("LicznikGER: "+ tekst.licznikKoncowekGER);
        System.out.println("LicznikJPN: "+ tekst.licznikKoncowekJPN);
        System.out.println("");
    }
    void cecha2(Tekst tekst){
        for(int i=0; i<tekst.listaSlow.size(); i++){
            Pattern patMeter = Pattern.compile("Meter"); Matcher matMeter = patMeter.matcher(tekst.listaSlow.get(i));
            Pattern patMeters = Pattern.compile("Meters"); Matcher matMeters = patMeters.matcher(tekst.listaSlow.get(i));
            Pattern patmeter = Pattern.compile("meter"); Matcher matmeter = patmeter.matcher(tekst.listaSlow.get(i));
            Pattern patmeters = Pattern.compile("meters"); Matcher matmeters = patmeters.matcher(tekst.listaSlow.get(i));

            if(matMeter.find() || matMeters.find() || matmeter.find() || matmeters.find()){
                tekst.licznikMiaryEuropa++;
            }
            if(tekst.listaSlow.get(i).equals("yards") || tekst.listaSlow.get(i).equals("Yards") || tekst.listaSlow.get(i).equals("Yard") || tekst.listaSlow.get(i).equals("yard")
                    || tekst.listaSlow.get(i).equals("miles") || tekst.listaSlow.get(i).equals("mile") || tekst.listaSlow.get(i).equals("Miles") || tekst.listaSlow.get(i).equals("Mile")
                    || tekst.listaSlow.get(i).equals("foot") || tekst.listaSlow.get(i).equals("foots") || tekst.listaSlow.get(i).equals("Foot") || tekst.listaSlow.get(i).equals("Foots")
                    || tekst.listaSlow.get(i).endsWith("foot") || tekst.listaSlow.get(i).equals("inch") || tekst.listaSlow.get(i).equals("Inch") || tekst.listaSlow.get(i).endsWith("inch")
                    || tekst.listaSlow.get(i).endsWith("Inch")){
                tekst.licznikMiaryAmeryka++;
            }

        }
        if(tekst.licznikMiaryEuropa>0){
            System.out.println("europa = " + tekst.licznikMiaryEuropa);
        }
        if(tekst.licznikMiaryAmeryka>0){
            System.out.println("ameryka = " + tekst.licznikMiaryAmeryka);
        }
    }

    void cecha3(Tekst tekst){
        for(int i=0; i<tekst.listaSlow.size(); i++){
            if(tekst.listaSlow.get(i).equals("Celsius") || tekst.listaSlow.get(i).equals("celsius")){
                tekst.licznikMiaryEuropa++;
            }

            if(tekst.listaSlow.get(i).equals("Fahrenheit") || tekst.listaSlow.get(i).equals("fahrenheit")){
                tekst.licznikMiaryAmeryka++;
            }
        }
    }
}
