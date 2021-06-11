package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OperacjeNaPlikach {

    void tworz(String nazwaPliku) throws FileNotFoundException {
        File file = new File(nazwaPliku);
        boolean exists = file.exists();
        System.out.println("Czy plik istnieje: " + exists);
        Scanner scanner = new Scanner(file);
        Pattern patternKraj = Pattern.compile("<PLACES><D>");
        while(scanner.hasNextLine()){
            String kraj = scanner.nextLine();
            int end = kraj.length()-13;
            Matcher matcherKraj = patternKraj.matcher(kraj);
            if(matcherKraj.find()){
                String krajPoWycieciu = kraj.substring(11, end);
                if(krajPoWycieciu.equals("west-germany") || krajPoWycieciu.equals("usa") || krajPoWycieciu.equals("france") || krajPoWycieciu.equals("canada") || krajPoWycieciu.equals("japan")){
                    Pattern patternTekst = Pattern.compile("</DATELINE><BODY>");
                    while(scanner.hasNextLine()){
                        String tekst = scanner.nextLine();
                        Matcher matcherTekst = patternTekst.matcher(tekst);
                        if(matcherTekst.find()){
                            System.out.println(krajPoWycieciu);
                            System.out.println(tekst);
                            break;
                        }

                    }
                }
            }
        }

    }

}
