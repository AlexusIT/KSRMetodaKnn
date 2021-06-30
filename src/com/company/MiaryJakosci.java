package com.company;

import java.util.ArrayList;

public class MiaryJakosci {
    public double accuracy(ArrayList<Tekst> tekstT, String kraj){
        double accu = 0;
        int sumaWyst = 0;
        if(kraj.equals("usa")||kraj.equals("canada")||kraj.equals("west-germany")||kraj.equals("france")||kraj.equals("uk")||kraj.equals("japan")){
            for(int i = 0; i<tekstT.size(); i++){
                if(tekstT.get(i).kraj.equals(kraj)){
                    sumaWyst = sumaWyst + 1;
                    if(tekstT.get(i).sklasyfikowanyKraj.equals(kraj)){
                        accu = accu + 1;
                    }
                }
            }
            System.out.println((int)accu+"/"+sumaWyst);
            return (accu/sumaWyst)*100;
        }
        else if(kraj.equals("recall")){
            double usa = accuracy(tekstT,"usa")/100;
            double canada = accuracy(tekstT,"canada")/100;
            double westGermany = accuracy(tekstT,"west-germany")/100;
            double france = accuracy(tekstT,"france")/100;
            double uk = accuracy(tekstT,"uk")/100;
            double japan = accuracy(tekstT,"japan")/100;
            return (usa + canada + westGermany + france + uk + japan)/6;
        }
        else{
            for(int i = 0; i<tekstT.size(); i++){
                if(tekstT.get(i).kraj.equals(tekstT.get(i).sklasyfikowanyKraj)){
                    accu = accu + 1;
                }
            }
            System.out.println((int)accu+"/"+tekstT.size());
            return (accu/tekstT.size())*100;
        }
    }
    public double precision(ArrayList<Tekst> tekstT, String kraj){
        double prec = 0;
        int sumaWyst = 0;
        if(kraj.equals("usa")||kraj.equals("canada")||kraj.equals("west-germany")||kraj.equals("france")||kraj.equals("uk")||kraj.equals("japan")){
            for(int i = 0; i<tekstT.size(); i++){
                if(tekstT.get(i).kraj.equals(kraj)&&tekstT.get(i).sklasyfikowanyKraj.equals(kraj)){
                    prec = prec + 1;
                    sumaWyst = sumaWyst + 1;
                }
                else if(tekstT.get(i).sklasyfikowanyKraj.equals(kraj)){
                    sumaWyst = sumaWyst + 1;
                }
            }
            if(prec==0){
                return 0.0;
            }
            return (prec/sumaWyst);
        }
        else{
            double usa = precision(tekstT,"usa");
            double canada = precision(tekstT,"canada");
            double westGermany = precision(tekstT,"west-germany");
            double france = precision(tekstT,"france");
            double uk = precision(tekstT,"uk");
            double japan = precision(tekstT,"japan");
            return (usa + canada + westGermany + france + uk + japan)/6;
        }
    }
    public double f1(ArrayList<Tekst> tekstT, String kraj){
        double f1 = 0;
        int sumaWyst = 0;
        if(kraj.equals("usa")||kraj.equals("canada")||kraj.equals("west-germany")||kraj.equals("france")||kraj.equals("uk")||kraj.equals("japan")){
            if((precision(tekstT, kraj) + (accuracy(tekstT,kraj)/100))==0){
                return 0.0;
            }
            else{
                f1 = (2 * (precision(tekstT, kraj) * (accuracy(tekstT,kraj)/100))) / (precision(tekstT, kraj) + (accuracy(tekstT,kraj)/100));
                return f1;
            }

        }
        else{
            double usa = f1(tekstT,"usa");
            double canada = f1(tekstT,"canada");
            double westGermany = f1(tekstT,"west-germany");
            double france = f1(tekstT,"france");
            double uk = f1(tekstT,"uk");
            double japan = f1(tekstT,"japan");
            return (usa + canada + westGermany + france + uk + japan)/6;
        }
    }
}
