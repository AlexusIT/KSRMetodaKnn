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
            System.out.println(tekst.listaUnikSlow.get(i)+ ": "+tekst.listaWystUnikSlow.get(i));
        }
        System.out.println("\n NOWY TEKST");
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
        if(tekst.licznikMiaryEuropa>0){
            System.out.println("europa = " + tekst.licznikMiaryEuropa);
        }
        if(tekst.licznikMiaryAmeryka>0){
            System.out.println("ameryka = " + tekst.licznikMiaryAmeryka);
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
        String E="€";

        String USD="USD";
        String usd="usd";
        String S = "$";

        String CAD="CAD";

        String JPY="JPY";
        String YEN="YEN";
        String Y="¥";

        String GBP="GBP";
        String F="£";
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
        /*for(int i=0; i<tekst.listaSlow.size(); i++){
            System.out.println(tekst.listaSlow.get(i));
        }*/
        System.out.println("EUR: "+tekst.licznikEUR);
        System.out.println("  USA: " +tekst.licznikUSD);
        System.out.println("    JPN: " +tekst.licznikJPY);
        System.out.println("      CAD: " +tekst.licznikCAD);
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
        String[] literyFranc = {"á", "à", "â", "ć", "ç", "é", "è", "ê", "ë", "í", "î", "ï", "ó", "ô", "û", "ù", "ÿ"};
        String[] literyNiem = { "Ä", "ä", "Ö", "ö", "ẞ", "ß", "Ü", "ü",};
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
        System.out.println("KRAJ: "+ tekst.kraj);
        System.out.println("LicznikUSA: "+ tekst.licznikKoncowekUSACAN);
        System.out.println("LicznikGER: "+ tekst.licznikKoncowekGER);
        System.out.println("LicznikJPN: "+ tekst.licznikKoncowekJPN);
        System.out.println("");
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
                    System.out.println("dodalem von");
                    break;
                }
                else{
                    for(int j = 0; j<przedFRC.length; j++){
                        if(tekst.listaSlow.get(i).equals(przedFRC[j])){
                            tekst.licznikFran++;
                            System.out.println(tekst.kraj);
                            System.out.println("dodalem fran");
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
        if(tekst.licznikZapyt > 0 || tekst.licznikWykrzyk > 0) {
            System.out.println("Liczba znakow zap: " + tekst.licznikZapyt);
            System.out.println("Liczba znakow wyk: " + tekst.licznikWykrzyk);
        }
    }
    public void dodawanieWykonanychCech(Tekst tekst){
        if(tekst.c1 == 1){

        }
        if(tekst.c2 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikMiaryEuropa);
            tekst.wynikiWykonanychCech.add(tekst.licznikMiaryAmeryka);
        }
        if(tekst.c3 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikMiaryTempEuropa);
            tekst.wynikiWykonanychCech.add(tekst.licznikMiaryTempAmeryka);
        }
        if(tekst.c4 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikEUR);
            tekst.wynikiWykonanychCech.add(tekst.licznikUSD);
            tekst.wynikiWykonanychCech.add(tekst.licznikCAD);
            tekst.wynikiWykonanychCech.add(tekst.licznikJPY);
            tekst.wynikiWykonanychCech.add(tekst.licznikGBP);
        }
        if(tekst.c5 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikDataEuropa);
            tekst.wynikiWykonanychCech.add(tekst.licznikDataAmeryka);
            tekst.wynikiWykonanychCech.add(tekst.licznikDataJaponia);
        }
        if(tekst.c6 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikLiterFranc);
            tekst.wynikiWykonanychCech.add(tekst.licznikLiterNiem);
        }
        if(tekst.c7 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikKoncowekUSACAN);
            tekst.wynikiWykonanychCech.add(tekst.licznikKoncowekJPN);
            tekst.wynikiWykonanychCech.add(tekst.licznikKoncowekGER);
        }
        if(tekst.c8 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikVON);
            tekst.wynikiWykonanychCech.add(tekst.licznikFran);
        }
        if(tekst.c9 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikZdan);
        }
        if(tekst.c10 == 1){
            tekst.wynikiWykonanychCech.add(tekst.licznikZapyt);
            tekst.wynikiWykonanychCech.add(tekst.licznikWykrzyk);
        }
    }
    public void normalizacja(ArrayList<Tekst> teksty){
        if(teksty.get(1).c1 == 1){

        }
        if(teksty.get(1).c2 == 1){
            int licznikMEurMin = teksty.get(0).licznikMiaryEuropa;
            int licznikMEurMax = teksty.get(0).licznikMiaryEuropa;
            int licznikMAmerMin = teksty.get(0).licznikMiaryAmeryka;
            int licznikMAmerMax = teksty.get(0).licznikMiaryAmeryka;
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
            for(int i = 1 ; i < teksty.size(); i++){
                teksty.get(i).licznikMiaryEuropa = (teksty.get(i).licznikMiaryEuropa - licznikMEurMin) / licznikMEurMax;
                teksty.get(i).licznikMiaryAmeryka = (teksty.get(i).licznikMiaryEuropa - licznikMAmerMin) / licznikMAmerMax;
            }
        }
        if(teksty.get(1).c3 == 1){
            int licznikMTEurMin = teksty.get(0).licznikMiaryTempEuropa;
            int licznikMTEurMax = teksty.get(0).licznikMiaryTempAmeryka;
            int licznikMTAmerMin = teksty.get(0).licznikMiaryTempAmeryka;
            int licznikMTAmerMax = teksty.get(0).licznikMiaryAmeryka;
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
            for(int i = 1 ; i < teksty.size(); i++){
                teksty.get(i).licznikMiaryTempEuropa = (teksty.get(i).licznikMiaryTempEuropa - licznikMTEurMin) / licznikMTEurMax;
                teksty.get(i).licznikMiaryTempAmeryka = (teksty.get(i).licznikMiaryTempEuropa - licznikMTAmerMin) / licznikMTAmerMax;
            }
        }
        if(teksty.get(1).c4 == 1){
            int licznikEURMax = teksty.get(0).licznikEUR;
            int licznikEURMin = teksty.get(0).licznikEUR;
            int licznikUSDMax = teksty.get(0).licznikUSD;
            int licznikUSDMin = teksty.get(0).licznikUSD;
            int licznikCADMax = teksty.get(0).licznikCAD;
            int licznikCADMin = teksty.get(0).licznikCAD;
            int licznikJPYMax = teksty.get(0).licznikJPY;
            int licznikJPYMin = teksty.get(0).licznikJPY;
            int licznikGBPMax = teksty.get(0).licznikGBP;
            int licznikGBPMin = teksty.get(0).licznikGBP;
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
        }
        if(teksty.get(1).c5 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }
        if(teksty.get(1).c6 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }
        if(teksty.get(1).c7 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }
        if(teksty.get(1).c8 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }
        if(teksty.get(1).c9 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }
        if(teksty.get(1).c10 == 1){
            for(int i = 1 ; i < teksty.size(); i++){

            }
        }

    }
}
