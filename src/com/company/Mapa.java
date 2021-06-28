package com.company;

public class Mapa{
    String kraj;
    double odległosc;

    public Mapa(double odległosc, String kraj) {
        super();
        this.odległosc = odległosc;
        this.kraj = kraj;
    }
    public double getOdległosc() {
        return odległosc;
    }
}
