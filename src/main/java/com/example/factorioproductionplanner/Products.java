package com.example.factorioproductionplanner;

import java.util.List;

public class Products {
    //attributes
    private String name;            //displayed item name
    private double baseTime;        //base crafting time in seconds
    private int noOfOutputs;        //number of output products per cycle
    private String[] madeIn;        //list of machines that can produce this item
    public Object[][] components;   //for each object in array == {name, qty}

    public Products() {         //default constructor
        this.name = "ItemName";
        this.baseTime = 0.0;
        this.noOfOutputs = 0;
    }

    //getters
    public String getName() {
        return name;
    }
    public double getBaseTime() {
        return baseTime;
    }
    public int getNoOfOutputs() {
        return noOfOutputs;
    }
    public String[] getMadeIn() {
        return madeIn;
    }
    public Object[][] getComponents() {
        return components;
    }

    //Populate item database
    /*
    Excluded elements due to lack of time:
        - All Production tech
        - All Military tech
        - All nuclear tech
        - Most of Logistics tech
     */
    public static void products(String[] args)
    {
        /*      template to copy-paste
        Products  = new Products();
        .name = "";
        .baseTime = ;
        .noOfOutputs = ;
        .madeIn = new String[]{};
        .components = new Object[][]{{}};
         */

        //SUBGROUP: FLUIDS
        Products water = new Products();
        water.name = "Water";

        Products petrol = new Products();
        petrol.name = "Petroleum gas";

        Products lightOil = new Products();
        lightOil.name = "Light oil";

        Products heavyOil = new Products();
        heavyOil.name = "Heavy oil";

        Products sulAcid = new Products();
        sulAcid.name = "Sulphuric acid";

        //SUBGROUP: RESOURCES
        Products ironOre = new Products();
        ironOre.name = "Iron ore";

        Products copperOre = new Products();
        copperOre.name = "Copper ore";

        Products coal = new Products();
        coal.name = "Coal";

        Products stone = new Products();
        stone.name = "Stone";

        //SUBGROUP: MATERIALS
        Products ironPlate = new Products();
        ironPlate.name = "Iron plate";
        ironPlate.baseTime = 3.2;
        ironPlate.noOfOutputs = 1;
        ironPlate.madeIn = new String[]{"f_stone", "f_steel", "f_elec"};
        ironPlate.components = new Object[][]{{ironOre, 1}};

        Products copperPlate = new Products();
        copperPlate.name = "Copper plate";
        copperPlate.baseTime = 3.2;
        copperPlate.noOfOutputs = 1;
        copperPlate.madeIn = new String[]{"f_stone", "f_steel", "f_elec"};
        copperPlate.components = new Object[][]{{copperOre, 1}};

        Products steelPlate = new Products();
        steelPlate.name = "Steel plate";
        steelPlate.baseTime = 16.0;
        steelPlate.noOfOutputs = 1;
        steelPlate.madeIn = new String[]{"f_stone", "f_steel", "f_elec"};
        steelPlate.components = new Object[][]{{ironPlate, 5}};

        Products plasticBar = new Products();
        plasticBar.name = "Plastic bar";
        plasticBar.baseTime = 1.0;
        plasticBar.noOfOutputs = 2;
        plasticBar.madeIn = new String[]{"chemPlant"};
        plasticBar.components = new Object[][]{{petrol, 20}};

        Products sulphur = new Products();
        sulphur.name = "Sulphur";
        sulphur.baseTime = 1.0;
        sulphur.noOfOutputs = 2;
        sulphur.madeIn = new String[]{"chemPlant"};
        sulphur.components = new Object[][]{{petrol, 30}, {water, 30}};

        Products battery = new Products();
        battery.name = "Battery";
        battery.baseTime = 4.0;
        battery.noOfOutputs = 1;
        battery.madeIn = new String[]{"chemPlant"};
        battery.components = new Object[][]{{"copperPlate", 1}, {"ironPlate", 1}, {"sulAcid", 20}};

        Products explosive = new Products();
        explosive.name = "Explosives";
        explosive.baseTime = 4;
        explosive.noOfOutputs = 2;
        explosive.madeIn = new String[]{"chemPlant"};
        explosive.components = new Object[][]{{"coal", 1}, {"sulphur", 1}, {"water", 10}};

        //SUBGROUP: INTERMEDIATE PRODUCTS
        Products copperCable = new Products();
        copperCable.name = "Copper cable";
        copperCable.baseTime = 0.5;
        copperCable.noOfOutputs = 2;
        copperCable.madeIn = new String[]{"am1", "am2", "am3"};
        copperCable.components = new Object[][]{{"copperPlate", 1}};

        Products ironStick = new Products();
        ironStick.name = "Iron stick";
        ironStick.baseTime = 0.5;
        ironStick.noOfOutputs = 2;
        ironStick.madeIn = new String[]{"am1", "am2", "am3"};
        ironStick.components = new Object[][]{{"ironPLate", 1}};

        Products ironGear = new Products();
        ironGear.name = "Iron gear wheel";
        ironGear.baseTime = 0.5;
        ironGear.noOfOutputs = 1;
        ironGear.madeIn = new String[]{"am1", "am2", "am3"};
        ironGear.components = new Object[][]{{"ironPlate", 2}};

        Products grnCircuit = new Products();
        grnCircuit.name = "Electronic circuit";
        grnCircuit.baseTime = 0.5;
        grnCircuit.noOfOutputs = 1;
        grnCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        grnCircuit.components = new Object[][]{{"copperCable", 3}, {"ironPlate", 1}};

        Products redCircuit = new Products();
        redCircuit.name = "Advanced circuit";
        redCircuit.baseTime = 6;
        redCircuit.noOfOutputs = 1;
        redCircuit.madeIn = new String[]{"am1", "am2", "am3"};
        redCircuit.components = new Object[][]{{"copperCable", 4}, {"grnCircuit", 2}, {"plasticBar", 2}};

        Products blueCircuit = new Products();
        blueCircuit.name = "Processing unit";
        blueCircuit.baseTime = 10;
        blueCircuit.noOfOutputs = 1;
        blueCircuit.madeIn = new String[]{"am2", "am3"};
        blueCircuit.components = new Object[][]{{"redCircuit", 2}, {"grnCircuit", 20}, {"sulAcid", 5}};

        Products engineUnit = new Products();
        engineUnit.name = "Engine unit";
        engineUnit.baseTime = 10;
        engineUnit.noOfOutputs = 1;
        engineUnit.madeIn = new String[]{"am1", "am2", "am3"};
        engineUnit.components = new Object[][]{{"ironGear", 1}, {"pipe", 2}, {"steelPlate", 1}};

        Products elecEngine = new Products();
        elecEngine.name = "Electric engine unit";
        elecEngine.baseTime = 10;
        elecEngine.noOfOutputs = 1;
        elecEngine.madeIn = new String[]{"am2", "am3"};
        elecEngine.components = new Object[][]{{"grnCircuit", 2}, {}};

        /*
        To do:
        - flying robot frame
        - rocket part
        - rocket control unit
        - low density structure
        - rocket fuel
        - red science
        - green science
        - black science
        - blue science
        - purple science
        - yellow science
         */
    }
}
