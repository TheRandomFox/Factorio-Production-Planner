package com.example.factorioproductionplanner;

public class Modifiers {
    /*
    Desc:
    Contains values of speed multipliers applied by each different source.
    Contains capacities of yellow, red and blue transport belts. Belt capacity measured in items/sec.
    All values are final constants.
     */

    //attributes
    private static final double am1 = 2.0;       //assembling machines 1, 2, 3
    private static final double am2 = 1.33;
    private static final double am3 = 0.8;
    private static final double chemPlant = 1.0; //chemical plant

    private static final double stoneFur = 1.0;  //furnaces stone, steel, electric
    private static final double steelFur = 0.5;
    private static final double elecFur = 0.5;

    private static final double speed1 = 1/1.2;  //speed modules 1, 2, 3
    private static final double speed2 = 1/1.3;
    private static final double speed3 = 1/1.5;

    private static final double yBeltCap = 15;   //transport belt capacities Yellow, Red, Blue
    private static final double rBeltCap = 30;
    private static final double bBeltCap = 45;

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
    public double getstoneFur() {
        return stoneFur;
    }
    public double getsteelFur() {
        return steelFur;
    }
    public double getelecFur() {
        return elecFur;
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
    public static double getYBeltCap() {
        return yBeltCap;
    }
    public static double getRBeltCap() {
        return rBeltCap;
    }
    public static double getBBeltCap() {
        return bBeltCap;
    }
}
