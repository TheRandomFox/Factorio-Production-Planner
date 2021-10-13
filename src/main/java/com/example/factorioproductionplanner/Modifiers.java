package com.example.factorioproductionplanner;

public class Modifiers {
    //attributes
    private double am1 = 2.0;       //assembling machines 1, 2, 3
    private double am2 = 1.33;
    private double am3 = 0.8;
    private double chemPlant = 1.0;

    private double f_stone = 1.0;   //furnaces
    private double f_steel = 0.5;
    private double f_elec = 0.5;

    private double speed1 = 1/1.2;  //speed modules
    private double speed2 = 1/1.3;
    private double speed3 = 1/1.5;

    //getters
    public double getAm1() {
        return am1;
    }
    public double getAm2() {
        return am2;
    }
    public double getAm3() {
        return am3;
    }
    public double getChemPlant() {
        return chemPlant;
    }
    public double getF_stone() {
        return f_stone;
    }
    public double getF_steel() {
        return f_steel;
    }
    public double getF_elec() {
        return f_elec;
    }
    public double getSpeed1() {
        return speed1;
    }
    public double getSpeed2() {
        return speed2;
    }
    public double getSpeed3() {
        return speed3;
    }
}
