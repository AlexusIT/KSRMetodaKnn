package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class OperacjeNaPlikach {
    public void wczytajPlik(String nazwaPliku) throws FileNotFoundException {
        File file = new File(nazwaPliku);
        boolean exists = file.exists();
        //System.out.println("Czy plik istnieje: " + exists);
        Scanner scanner = new Scanner(file);
        Pattern patternKraj = Pattern.compile("<PLACES><D>");
        while(scanner.hasNextLine()){
            String kraj = scanner.nextLine();
            int end = kraj.length()-13;
            Matcher matcherKraj = patternKraj.matcher(kraj);
            if(matcherKraj.find()){
                String krajPoWycieciu = kraj.substring(11, end);
                if(krajPoWycieciu.equals("west-germany") || krajPoWycieciu.equals("usa") || krajPoWycieciu.equals("france") || krajPoWycieciu.equals("canada") || krajPoWycieciu.equals("japan") || krajPoWycieciu.equals("uk")){
                    Pattern patternTekst = Pattern.compile("</DATELINE><BODY>");
                    while(scanner.hasNextLine()){
                        String tekst = scanner.nextLine();
                        Matcher matcherTekst = patternTekst.matcher(tekst);
                        if(matcherTekst.find()){
                            String tekstPoWycieciu = null;
                            for(int i = tekst.length(); i > 0; i--){
                                if(tekst.charAt(i-1)=='>' && tekst.charAt(i-2)=='Y'){
                                    tekstPoWycieciu = tekst.substring(i);
                                    break;
                                }
                            }
                            while(scanner.hasNextLine()){
                                String nextText = scanner.nextLine();
                                if(nextText.equals(" Reuter") || nextText.equals(" REUTER") || nextText.contains("&#3;") ){
                                    break;
                                }
                                tekstPoWycieciu = tekstPoWycieciu + nextText;
                            }
                            String[] slowa = tekstPoWycieciu.split(" ");
                            ArrayList<String> listaSlow = new ArrayList<>(Arrays.asList(slowa));
                            //int licz = listaSlow.size();
                            //int l = 0;
                            //niech to na chwile zostanie
                            /*for(int i = 0; i < licz; i++){
                                if(l==licz){
                                    break;
                                }
                                if(listaSlow.get(i).isEmpty()){
                                    listaSlow.remove(i);
                                    i--;
                                }
                                l++;
                            }*/
                            for(int i = 0; i < listaSlow.size(); i++){

                                if(listaSlow.get(i).isEmpty()){
                                    listaSlow.remove(i);
                                    i--;
                                }
                            }
                            Kontenery.WszytkieTeksty.add(new Tekst(krajPoWycieciu,listaSlow));
                            break;
                        }
                    }
                }
            }
        }

    }
}
