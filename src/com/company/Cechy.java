package com.company;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cechy {
    public Cechy() {
    }

    public void cecha1(Tekst tekst){
        tekst.c1 = 1;
        ArrayList<String> slowaUnik = new ArrayList<>();
        ArrayList<Integer> liczbaWystSlowUnik = new ArrayList<>();
        for(int i = 0; i < tekst.listaSlow.size(); i++){
            if(tekst.listaSlow.get(i).length()>3){
                if(slowaUnik.isEmpty()){
                    slowaUnik.add(tekst.listaSlow.get(i));
                    liczbaWystSlowUnik.add(1);
                }
                else{
                    int wskaznik=0;
                    for(int j = 0; j < slowaUnik.size(); j++){
                        if(tekst.listaSlow.get(i).equals(slowaUnik.get(j))){
                            liczbaWystSlowUnik.set(j,liczbaWystSlowUnik.get(j)+1);
                            wskaznik = 1;
                            break;
                        }
                    }
                    if(wskaznik == 0){
                        slowaUnik.add(tekst.listaSlow.get(i));
                        liczbaWystSlowUnik.add(1);
                    }
                }
            }
        }
        ArrayList<String> najSlowa = new ArrayList<>();
        ArrayList<Integer> liczbNajSlowa = new ArrayList<>();
        int tmp = 0;
        for(int i = 0; i < liczbaWystSlowUnik.size(); i++){
            if(liczbaWystSlowUnik.get(i) > tmp){
                tmp = liczbaWystSlowUnik.get(i);
            }
        }
        for(int i = 0; i < liczbaWystSlowUnik.size(); i++){
            if(liczbaWystSlowUnik.get(i).equals(tmp)){
                najSlowa.add(slowaUnik.get(i));
                liczbNajSlowa.add(liczbaWystSlowUnik.get(i));
            }
        }
        tekst.listaUnikSlow = najSlowa;
        tekst.listaWystUnikSlow = liczbNajSlowa;
        for(int i = 0; i < tekst.listaUnikSlow.size(); i++){
            if(tekst.wszystkieSlowa.equals("qwerty")){
                tekst.wszystkieSlowa = tekst.listaUnikSlow.get(i);
            }
            else{
                tekst.wszystkieSlowa = tekst.wszystkieSlowa + tekst.listaUnikSlow.get(i);
            }
        }
    }
    public void cecha2(Tekst tekst){
        tekst.c2 = 1;
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
    }
    public void cecha3(Tekst tekst){
        tekst.c3 = 1;
        for(int i=0; i<tekst.listaSlow.size(); i++){
            if(tekst.listaSlow.get(i).equals("Celsius") || tekst.listaSlow.get(i).equals("celsius")){
                tekst.licznikMiaryEuropa++;
                break;
            }

            else if(tekst.listaSlow.get(i).equals("Fahrenheit") || tekst.listaSlow.get(i).equals("fahrenheit")){
                tekst.licznikMiaryAmeryka++;
                break;
            }
        }
    }
    public void cecha4(Tekst tekst){
        tekst.c4 = 1;
        String EURO = "EURO";
        String EUR="EUR";
        String euro="euro";
        String E="???";

        String USD="USD";
        String usd="usd";
        String S = "$";

        String CAD="CAD";

        String JPY="JPY";
        String YEN="YEN";
        String Y="??";

        String GBP="GBP";
        String F="??";
        for(int i=0; i<tekst.listaSlow.size(); i++){
            if (tekst.listaSlow.get(i).contains(EURO)||tekst.listaSlow.get(i).contains(EUR)||tekst.listaSlow.get(i).endsWith(euro)||tekst.listaSlow.get(i).contains(E)){
                tekst.licznikEUR++;
                break;
            }
            else if (tekst.listaSlow.get(i).contains(USD)||tekst.listaSlow.get(i).contains(usd)||tekst.listaSlow.get(i).contains(S)){
                tekst.licznikUSD++;
                break;
            }
            else if (tekst.listaSlow.get(i).contains(CAD)){
                tekst.licznikCAD++;
                break;
            }
            else if (tekst.listaSlow.get(i).contains(JPY)||tekst.listaSlow.get(i).contains(YEN)||tekst.listaSlow.get(i).contains(Y)){
                tekst.licznikJPY++;
                break;
            }
            else if (tekst.listaSlow.get(i).contains(GBP)||tekst.listaSlow.get(i).contains(F)){
                tekst.licznikGBP++;
                break;
            }
        }
    }

    public void cecha5(Tekst tekst){
        tekst.c5 = 1;
        for(int i = 0; i<tekst.listaSlow.size(); i++){
            ///EUROPA
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("d.M.uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataEuropa++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("d-M-uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataEuropa++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("d/M/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataEuropa++;
            } catch (DateTimeParseException ignored){
            }
            ///Ameryka
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("M.d.uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataAmeryka++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("M-d-uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataAmeryka++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("M/d/uuuu")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataAmeryka++;
            } catch (DateTimeParseException ignored){
            }
            ///JAPONIA
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("uuuu.M.d")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataJaponia++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("uuuu-M-d")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataJaponia++;
            } catch (DateTimeParseException ignored){
            }
            try {
                LocalDate.parse(tekst.listaSlow.get(i), DateTimeFormatter.ofPattern("uuuu/M/d")
                        .withResolverStyle(ResolverStyle.STRICT)
                );
                tekst.licznikDataJaponia++;
            } catch (DateTimeParseException ignored){
            }
        }
    }

    public void cecha6(Tekst tekst){
        tekst.c6 = 1;
        String[] literyFranc = {"??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??", "??"};
        String[] literyNiem = { "??", "??", "??", "??", "???", "??", "??", "??",};
        for(int i = 0; i<tekst.listaSlow.size(); i++){
            for(int j = 0; j<literyFranc.length; j++){
                if(tekst.listaSlow.get(i).contains(literyFranc[j])){
                    tekst.licznikLiterFranc++;
                    break;
                }
                else if(tekst.listaSlow.get(i).contains(literyNiem[0])||tekst.listaSlow.get(i).contains(literyNiem[1])||
                        tekst.listaSlow.get(i).contains(literyNiem[2])||tekst.listaSlow.get(i).contains(literyNiem[3])||
                        tekst.listaSlow.get(i).contains(literyNiem[4])||tekst.listaSlow.get(i).contains(literyNiem[5])||
                        tekst.listaSlow.get(i).contains(literyNiem[6])||tekst.listaSlow.get(i).contains(literyNiem[7])) {
                    tekst.licznikLiterNiem++;
                    break;
                }
            }
        }
    }
    public void cecha7(Tekst tekst){
        tekst.c7 = 1;
        //Japonia na koncu imienia/nazwiska
        String[] koncJPN = {"mi","ko","ato","uki","oki","shi","oto","abe","ito","chi","ura","oro","iro"};
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
                    break;
                } else if (tekst.listaSlow.get(i).endsWith(er)||tekst.listaSlow.get(i+1).endsWith(er)) {
                    tekst.licznikKoncowekGER++;
                    break;
                } else {
                    for (int j = 0; j < koncJPN.length; j++) {
                        if (tekst.listaSlow.get(i).endsWith(koncJPN[j]) || tekst.listaSlow.get(i+1).endsWith(koncJPN[j])) {
                            tekst.licznikKoncowekJPN++;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void cecha8(Tekst tekst){
        tekst.c8 = 1;
        //Francja przed nazwiskiem
        String[] przedFRC = {"Le","le","La","la","Les","les","De","de","Du","du","Del","del","Dela","dela","Des","des"};
        //Niemieckie
        String von = "von";
        for(int i = 0; i<tekst.listaSlow.size()-1; i++){
            if(Character.isUpperCase(tekst.listaSlow.get(i+1).charAt(0))){
                if(tekst.listaSlow.get(i).equals(von)){
                    tekst.licznikVON++;
                    break;
                }
                else{
                    for(int j = 0; j<przedFRC.length; j++){
                        if(tekst.listaSlow.get(i).equals(przedFRC[j])){
                            tekst.licznikFran++;
                            break;
                        }
                    }
                }
            }
        }
    }
    public void cecha9(Tekst tekst){
        tekst.c9 = 1;
        for(int i = 0; i < tekst.listaSlow.size(); i++){
            if(Character.isUpperCase(tekst.listaSlow.get(i).charAt(0))){
                for(int j = 0; j<tekst.listaSlow.size(); j++){
                    i++;
                    if(tekst.listaSlow.get(j).endsWith(".")||tekst.listaSlow.get(j).endsWith("?")||tekst.listaSlow.get(j).endsWith("!")){
                        tekst.licznikZdan++;
                        break;
                    }
                }
            }
        }
    }
    public void cecha10(Tekst tekst){
        tekst.c10 = 1;
        for(int i = 0; i < tekst.listaSlow.size(); i++){
            if(tekst.listaSlow.get(i).contains("?")){
                tekst.licznikZapyt++;
            }
            else if(tekst.listaSlow.get(i).contains("!")){
                tekst.licznikWykrzyk++;
            }
        }
    }
    public void dodawanieWykonanychCech(Tekst tekst){
        if(tekst.c2 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikMiaryEuropa);
            tekst.wynikiWywolanychCech.add(tekst.licznikMiaryAmeryka);
        }
        if(tekst.c3 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikMiaryTempEuropa);
            tekst.wynikiWywolanychCech.add(tekst.licznikMiaryTempAmeryka);
        }
        if(tekst.c4 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikEUR);
            tekst.wynikiWywolanychCech.add(tekst.licznikUSD);
            tekst.wynikiWywolanychCech.add(tekst.licznikCAD);
            tekst.wynikiWywolanychCech.add(tekst.licznikJPY);
            tekst.wynikiWywolanychCech.add(tekst.licznikGBP);
        }
        if(tekst.c5 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikDataEuropa);
            tekst.wynikiWywolanychCech.add(tekst.licznikDataAmeryka);
            tekst.wynikiWywolanychCech.add(tekst.licznikDataJaponia);
        }
        if(tekst.c6 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikLiterFranc);
            tekst.wynikiWywolanychCech.add(tekst.licznikLiterNiem);
        }
        if(tekst.c7 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikKoncowekUSACAN);
            tekst.wynikiWywolanychCech.add(tekst.licznikKoncowekJPN);
            tekst.wynikiWywolanychCech.add(tekst.licznikKoncowekGER);
        }
        if(tekst.c8 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikVON);
            tekst.wynikiWywolanychCech.add(tekst.licznikFran);
        }
        if(tekst.c9 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikZdan);
        }
        if(tekst.c10 == 1){
            tekst.wynikiWywolanychCech.add(tekst.licznikZapyt);
            tekst.wynikiWywolanychCech.add(tekst.licznikWykrzyk);
        }
    }
    public void normalizacja(ArrayList<Tekst> teksty){
        if(teksty.get(1).c2 == 1){
            double licznikMEurMin = teksty.get(0).licznikMiaryEuropa;
            double licznikMEurMax = teksty.get(0).licznikMiaryEuropa;
            double licznikMAmerMin = teksty.get(0).licznikMiaryAmeryka;
            double licznikMAmerMax = teksty.get(0).licznikMiaryAmeryka;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikMiaryEuropa>licznikMEurMax){
                    licznikMEurMax = teksty.get(i).licznikMiaryEuropa;
                }
                if(teksty.get(i).licznikMiaryEuropa<licznikMEurMin){
                    licznikMEurMin = teksty.get(i).licznikMiaryEuropa;
                }
                if(teksty.get(i).licznikMiaryAmeryka>licznikMAmerMax){
                    licznikMAmerMax = teksty.get(i).licznikMiaryAmeryka;
                }
                if(teksty.get(i).licznikMiaryAmeryka<licznikMAmerMin){
                    licznikMAmerMin = teksty.get(i).licznikMiaryAmeryka;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikMEurMax!=0){
                    teksty.get(i).licznikMiaryEuropa = (teksty.get(i).licznikMiaryEuropa - licznikMEurMin) / licznikMEurMax;
                }
                if(licznikMAmerMax!=0){
                    teksty.get(i).licznikMiaryAmeryka = (teksty.get(i).licznikMiaryAmeryka - licznikMAmerMin) / licznikMAmerMax;
                }
            }
        }
        if(teksty.get(1).c3 == 1){
            double licznikMTEurMin = teksty.get(0).licznikMiaryTempEuropa;
            double licznikMTEurMax = teksty.get(0).licznikMiaryTempAmeryka;
            double licznikMTAmerMin = teksty.get(0).licznikMiaryTempAmeryka;
            double licznikMTAmerMax = teksty.get(0).licznikMiaryAmeryka;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikMiaryTempAmeryka>licznikMTEurMax){
                    licznikMTEurMax = teksty.get(i).licznikMiaryTempAmeryka;
                }
                if(teksty.get(i).licznikMiaryTempAmeryka<licznikMTEurMin){
                    licznikMTEurMin = teksty.get(i).licznikMiaryTempAmeryka;
                }
                if(teksty.get(i).licznikMiaryTempAmeryka>licznikMTAmerMax){
                    licznikMTAmerMax = teksty.get(i).licznikMiaryTempAmeryka;
                }
                if(teksty.get(i).licznikMiaryTempAmeryka<licznikMTAmerMin){
                    licznikMTAmerMin = teksty.get(i).licznikMiaryTempAmeryka;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikMTAmerMax!=0){
                    teksty.get(i).licznikMiaryTempAmeryka = (teksty.get(i).licznikMiaryTempAmeryka - licznikMTAmerMin) / licznikMTAmerMax;
                }
                if(licznikMTEurMax!=0){
                    teksty.get(i).licznikMiaryTempEuropa = (teksty.get(i).licznikMiaryTempEuropa - licznikMTEurMin) / licznikMTEurMax;
                }
            }
        }
        if(teksty.get(1).c4 == 1){
            double licznikEURMax = teksty.get(0).licznikEUR;
            double licznikEURMin = teksty.get(0).licznikEUR;
            double licznikUSDMax = teksty.get(0).licznikUSD;
            double licznikUSDMin = teksty.get(0).licznikUSD;
            double licznikCADMax = teksty.get(0).licznikCAD;
            double licznikCADMin = teksty.get(0).licznikCAD;
            double licznikJPYMax = teksty.get(0).licznikJPY;
            double licznikJPYMin = teksty.get(0).licznikJPY;
            double licznikGBPMax = teksty.get(0).licznikGBP;
            double licznikGBPMin = teksty.get(0).licznikGBP;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikEUR>licznikEURMax){
                    licznikEURMax = teksty.get(i).licznikEUR;
                }
                if(teksty.get(i).licznikEUR<licznikEURMin){
                    licznikEURMin = teksty.get(i).licznikEUR;
                }
                if(teksty.get(i).licznikUSD>licznikUSDMax){
                    licznikUSDMax = teksty.get(i).licznikUSD;
                }
                if(teksty.get(i).licznikUSD<licznikUSDMin){
                    licznikUSDMin = teksty.get(i).licznikUSD;
                }
                if(teksty.get(i).licznikCAD>licznikCADMax){
                    licznikCADMax = teksty.get(i).licznikCAD;
                }
                if(teksty.get(i).licznikCAD<licznikCADMin){
                    licznikCADMin = teksty.get(i).licznikCAD;
                }
                if(teksty.get(i).licznikJPY>licznikJPYMax){
                    licznikJPYMax = teksty.get(i).licznikJPY;
                }
                if(teksty.get(i).licznikJPY<licznikJPYMin){
                    licznikJPYMin = teksty.get(i).licznikJPY;
                }
                if(teksty.get(i).licznikGBP>licznikGBPMax){
                    licznikGBPMax = teksty.get(i).licznikGBP;
                }
                if(teksty.get(i).licznikGBP<licznikGBPMin){
                    licznikGBPMin = teksty.get(i).licznikGBP;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikEURMax!=0){
                    teksty.get(i).licznikEUR = (teksty.get(0).licznikEUR - licznikEURMin) / licznikEURMax;

                }
                if(licznikUSDMax!=0){
                    teksty.get(i).licznikUSD = (teksty.get(0).licznikUSD - licznikUSDMin) / licznikUSDMax;

                }
                if(licznikCADMax!=0){
                    teksty.get(i).licznikCAD = (teksty.get(0).licznikCAD - licznikCADMin) / licznikCADMax;

                }
                if(licznikJPYMax!=0){
                    teksty.get(i).licznikJPY = (teksty.get(0).licznikJPY - licznikJPYMin) / licznikJPYMax;

                }
                if(licznikGBPMax!=0){
                    teksty.get(i).licznikGBP = (teksty.get(0).licznikGBP - licznikGBPMin) / licznikGBPMax;

                }
            }
        }
        if(teksty.get(1).c5 == 1){
            double licznikDataAmerykaMax = teksty.get(0).licznikDataAmeryka;
            double licznikDataAmerykaMin = teksty.get(0).licznikDataAmeryka;
            double licznikDataEuropaMax = teksty.get(0).licznikDataEuropa;
            double licznikDataEuropaMin = teksty.get(0).licznikDataEuropa;
            double licznikDataJaponiaMax = teksty.get(0).licznikDataJaponia;
            double licznikDataJaponiaMin = teksty.get(0).licznikDataJaponia;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikDataAmeryka>licznikDataAmerykaMax){
                    licznikDataAmerykaMax = teksty.get(i).licznikDataAmeryka;
                }
                if(teksty.get(i).licznikDataAmeryka<licznikDataAmerykaMin){
                    licznikDataAmerykaMin = teksty.get(i).licznikDataAmeryka;
                }
                if(teksty.get(i).licznikDataEuropa>licznikDataEuropaMax){
                    licznikDataEuropaMax = teksty.get(i).licznikDataEuropa;
                }
                if(teksty.get(i).licznikDataEuropa<licznikDataEuropaMin){
                    licznikDataEuropaMin = teksty.get(i).licznikDataEuropa;
                }
                if(teksty.get(i).licznikDataJaponia>licznikDataJaponiaMax){
                    licznikDataJaponiaMax = teksty.get(i).licznikDataJaponia;
                }
                if(teksty.get(i).licznikDataJaponia<licznikDataJaponiaMin){
                    licznikDataJaponiaMin = teksty.get(i).licznikDataJaponia;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikDataAmerykaMax!=0){
                    teksty.get(i).licznikDataAmeryka = (teksty.get(i).licznikDataAmeryka - licznikDataAmerykaMin) / licznikDataAmerykaMax;
                }
                if(licznikDataEuropaMax!=0){
                    teksty.get(i).licznikDataEuropa = (teksty.get(i).licznikDataEuropa - licznikDataEuropaMin) / licznikDataEuropaMax;
                }
                if(licznikDataJaponiaMax!=0){
                    teksty.get(i).licznikDataJaponia = (teksty.get(i).licznikDataJaponia - licznikDataJaponiaMin) / licznikDataJaponiaMax;
                }
            }
        }
        if(teksty.get(1).c6 == 1){
            double licznikLiterFrancMax = teksty.get(0).licznikLiterFranc;
            double licznikLiterFrancMin = teksty.get(0).licznikLiterFranc;
            double licznikLiterNiemMax = teksty.get(0).licznikLiterNiem;
            double licznikLiterNiemMin = teksty.get(0).licznikLiterNiem;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikLiterFranc>licznikLiterFrancMax){
                    licznikLiterFrancMax = teksty.get(i).licznikLiterFranc;
                }
                if(teksty.get(i).licznikLiterFranc<licznikLiterFrancMin){
                    licznikLiterFrancMin = teksty.get(i).licznikLiterFranc;
                }
                if(teksty.get(i).licznikLiterNiem>licznikLiterNiemMax){
                    licznikLiterNiemMax = teksty.get(i).licznikLiterNiem;
                }
                if(teksty.get(i).licznikLiterNiem<licznikLiterNiemMin){
                    licznikLiterNiemMin = teksty.get(i).licznikLiterNiem;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikLiterFrancMax!=0){
                    teksty.get(i).licznikLiterFranc = (teksty.get(i).licznikLiterFranc - licznikLiterFrancMin) / licznikLiterFrancMax;
                }
                if(licznikLiterNiemMax!=0){
                    teksty.get(i).licznikLiterNiem = (teksty.get(i).licznikLiterNiem - licznikLiterNiemMin) / licznikLiterNiemMax;
                }
            }
        }
        if(teksty.get(1).c7 == 1){
            double licznikKoncowekUSACANMax = teksty.get(0).licznikKoncowekUSACAN;
            double licznikKoncowekUSACANMin = teksty.get(0).licznikKoncowekUSACAN;
            double licznikKoncowekJPNMax = teksty.get(0).licznikKoncowekJPN;
            double licznikKoncowekJPNMin = teksty.get(0).licznikKoncowekJPN;
            double licznikKoncowekGERMax = teksty.get(0).licznikKoncowekGER;
            double licznikKoncowekGERMin = teksty.get(0).licznikKoncowekGER;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikKoncowekUSACAN>licznikKoncowekUSACANMax){
                    licznikKoncowekUSACANMax = teksty.get(i).licznikKoncowekUSACAN;
                }
                if(teksty.get(i).licznikKoncowekUSACAN<licznikKoncowekUSACANMin){
                    licznikKoncowekUSACANMin = teksty.get(i).licznikKoncowekUSACAN;
                }
                if(teksty.get(i).licznikKoncowekJPN>licznikKoncowekJPNMax){
                    licznikKoncowekJPNMax = teksty.get(i).licznikKoncowekJPN;
                }
                if(teksty.get(i).licznikKoncowekJPN<licznikKoncowekJPNMin){
                    licznikKoncowekJPNMin = teksty.get(i).licznikKoncowekJPN;
                }
                if(teksty.get(i).licznikKoncowekGER>licznikKoncowekGERMax){
                    licznikKoncowekGERMax = teksty.get(i).licznikKoncowekGER;
                }
                if(teksty.get(i).licznikKoncowekGER<licznikKoncowekGERMin){
                    licznikKoncowekGERMin = teksty.get(i).licznikKoncowekGER;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikKoncowekGERMax!=0){
                    teksty.get(i).licznikKoncowekGER = (teksty.get(i).licznikKoncowekGER - licznikKoncowekGERMin) / licznikKoncowekGERMax;
                }
                if(licznikKoncowekJPNMax!=0){
                    teksty.get(i).licznikKoncowekJPN = (teksty.get(i).licznikKoncowekJPN - licznikKoncowekJPNMin) / licznikKoncowekJPNMax;
                }
                if(licznikKoncowekUSACANMax!=0){
                    teksty.get(i).licznikKoncowekUSACAN = (teksty.get(i).licznikKoncowekUSACAN - licznikKoncowekUSACANMin) / licznikKoncowekUSACANMax;
                }
            }
        }
        if(teksty.get(1).c8 == 1){
            double licznikVONMax = teksty.get(0).licznikVON;
            double licznikVONMin = teksty.get(0).licznikVON;
            double licznikFranMax = teksty.get(0).licznikFran;
            double licznikFranMin = teksty.get(0).licznikFran;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikVON>licznikVONMax){
                    licznikVONMax = teksty.get(i).licznikVON;
                }
                if(teksty.get(i).licznikVON<licznikVONMin){
                    licznikVONMin = teksty.get(i).licznikVON;
                }
                if(teksty.get(i).licznikFran>licznikFranMax){
                    licznikFranMax = teksty.get(i).licznikFran;
                }
                if(teksty.get(i).licznikFran<licznikFranMin){
                    licznikFranMin = teksty.get(i).licznikFran;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikFranMax!=0){
                    teksty.get(i).licznikFran = (teksty.get(i).licznikFran - licznikFranMin) / licznikFranMax;
                }
                if(licznikVONMax!=0){
                    teksty.get(i).licznikVON = (teksty.get(i).licznikVON - licznikVONMin) / licznikVONMax;
                }
            }
        }
        if(teksty.get(1).c9 == 1){
            double licznikZdanMax = teksty.get(0).licznikZdan;
            double licznikZdanMin = teksty.get(0).licznikZdan;
            for(int i = 1 ; i < teksty.size(); i++){
                if(teksty.get(i).licznikZdan>licznikZdanMax){
                    licznikZdanMax = teksty.get(i).licznikZdan;
                }
                if(teksty.get(i).licznikZdan<licznikZdanMin){
                    licznikZdanMin = teksty.get(i).licznikZdan;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikZdanMax!=0){
                    teksty.get(i).licznikZdan = (teksty.get(i).licznikZdan - licznikZdanMin) / licznikZdanMax;
                }
            }
        }
        if(teksty.get(1).c10 == 1){
            double licznikZapytMax = teksty.get(0).licznikZapyt;
            double licznikZapytMin = teksty.get(0).licznikZapyt;
            double licznikWykrzykMax = teksty.get(0).licznikWykrzyk;
            double licznikWykrzykMin = teksty.get(0).licznikWykrzyk;
            for(int i = 1 ; i< teksty.size(); i++){
                if(teksty.get(i).licznikZapyt>licznikZapytMax){
                    licznikZapytMax = teksty.get(i).licznikZapyt;
                }
                if(teksty.get(i).licznikZapyt<licznikZapytMin){
                    licznikZapytMin = teksty.get(i).licznikZapyt;
                }
                if(teksty.get(i).licznikWykrzyk>licznikWykrzykMax){
                    licznikWykrzykMax = teksty.get(i).licznikWykrzyk;
                }
                if(teksty.get(i).licznikWykrzyk<licznikWykrzykMin){
                    licznikWykrzykMin = teksty.get(i).licznikWykrzyk;
                }
            }
            for(int i = 0 ; i < teksty.size(); i++){
                if(licznikWykrzykMax!=0){
                    teksty.get(i).licznikWykrzyk = (teksty.get(i).licznikWykrzyk - licznikWykrzykMin) / licznikWykrzykMax;
                }
                if(licznikZapytMax!=0){
                    teksty.get(i).licznikZapyt = (teksty.get(i).licznikZapyt - licznikZapytMin) / licznikZapytMax;
                }
            }
        }
    }
}
