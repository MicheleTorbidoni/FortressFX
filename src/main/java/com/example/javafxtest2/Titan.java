package com.example.javafxtest2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public abstract class Titan {
    // Titan attributes
    String name;
    String kind;
    double strength;
    double dexterity;
    String behaviour;
    double selfcontrol;
    double berserkerThreshold;
    double structure_start;
    double structure_current;
    double kineticResistance;
    double electromagneticResistance;
    double thermalResistance;
    double psionicResistance;
    String location;
    int speed;
    Entity.food[] foodRequirements = new Entity.food[3];
    Entity.food tastePreference;
    Entity.clan clan;

    Method[] actions = new Method[10];
    String[] actionsNames = new String[10];
    String[] actionsDescriptions = new String[10];
    int[] actionsSetupTime = new int[10];
    Boolean[] actionsAddToTimeline = new Boolean[10];
    int[] actionsPlayerNumber = new int[10];
    String[] actionsPlayerNames = new String[10];

    public int actionsCount = 0;

    public String output;


    Minia[] slot = new Minia[2];

    public Titan (String titanName, Minia inputMiniature1, Minia inputMiniature2){
        name = titanName;
        slot[0]=inputMiniature1;
        slot[1]=inputMiniature2;
    }

    public String getName(){
        return name;
    }

    public void createActions(int inputPlayerNumber){
        Method[] localMethods = this.getClass().getDeclaredMethods();
        int actionsCount = 0;
        for (int i = 0; i < localMethods.length; i++) {
            if (localMethods[i].getName().startsWith("player_")){
                actions[actionsCount] = localMethods[i];
                this.setActionParams(localMethods[i], actionsCount);
                actionsAddToTimeline[actionsCount] = true;
                actionsPlayerNumber[actionsCount] = inputPlayerNumber+1;
                actionsPlayerNames[actionsCount] = Entity.players[inputPlayerNumber].name;
                actionsCount++;
            }
        }
    }

    public void displaySharedTitanData(){

        output = "";

        output = "----------------------------------------------\n";
        output = output + "Dati del titano "+name + "( "+kind+" )\n";
        output = output + "----------------------------------------------\n";
        output = output + "Strenght: "+ strength+"\n";
        output = output + "Dexterity: "+ dexterity+"\n";
        output = output + "Behaviour: "+ behaviour+"\n";
        output = output + "Selfcontrol: "+ selfcontrol+"\n";
        output = output + "Berserker Threshold: "+ berserkerThreshold+"\n";
        output = output + "Structure (Start): "+ structure_start+"\n";
        output = output + "Structure (Current): "+ structure_current+"\n";
        output = output + "Kinetic Resistance: "+ kineticResistance+"\n";
        output = output + "Electromagnetic Resistance: "+ electromagneticResistance+"\n";
        output = output + "Thermal Resistance: "+ thermalResistance+"\n";
        output = output + "Psionic Resistance: "+ psionicResistance+"\n";
        output = output + "Location: "+ location+"\n";
        output = output + "Speed: "+ speed+"\n";
        for (int i = 0; i < foodRequirements.length; i++) {
            output = output + "Food Requirements: "+ foodRequirements[i]+"\n";
        }
        output = output + "Taste Preference: "+ tastePreference+"\n";
        output = output + "Clan: "+ clan+"\n";

        output = output + "----------------------------------------------"+"\n";
        for (int i = 0; i < slot.length; i++) {
            output = output + "Slot "+(i+1)+": "+ slot[i].name+"\n";
        }
    }


    public void execute(int inputAction, int inputPlayerNum, boolean inTimeline) {

        int intInput[] = new int[5];
        double doubleInput[] = new double[5];
        String stringInput[] = new String[5];
        Minia miniaInput[] = new Minia[5];
        Titan titanInput[] = new Titan[5];
        Parameter[] parameters = new Parameter[5];
        String paramsTypeSequence = new String();

        Method method = actions[inputAction-1];
        parameters = method.getParameters();

        // set all values to null or 0
        for (int i = 0; i < 5; i++) {
            intInput[i] = 0;
            doubleInput[i] = 0;
            stringInput[i] = null;
            miniaInput[i] = null;
            titanInput[i] = null;
        }

        System.out.println("Azione: " + method.getName());
        System.out.println("Numero parametri: " + parameters.length + "(" + parameters[0].getType().getName() +")");


        for (int i = 0; i < parameters.length; i++) {
            switch (parameters[i].getType().getName()) {
                case "int":
                    System.out.print("Parametro " + (i+1) + " - Inserisci un valore numerico intero: ");
                    intInput[i] = new Scanner(System.in).nextInt();
                    paramsTypeSequence = paramsTypeSequence + "i";
                    break;
                case "java.lang.String":
                    System.out.print("Parametro " + (i+1)  + " - Inserisci un testo: ");
                    stringInput[i] = new Scanner(System.in).nextLine();
                    paramsTypeSequence = paramsTypeSequence + "s";
                    break;
                case "double":
                    System.out.print("Parametro " + (i+1)  + " - Inserisci un valore numerico con virgola: ");
                    doubleInput[i] = new Scanner(System.in).nextDouble();
                    paramsTypeSequence = paramsTypeSequence + "d";
                    break;
                case "com.example.javafxtest2.Minia":
                    System.out.println("Parametro " + (i+1)  + " - Identifica un bersaglio: ");
                    System.out.println();
                    System.out.println("Giocatore bersaglio: ");
                    System.out.println("1) Player 1 ("+Entity.player1.name+")");
                    System.out.println("2) Player 2 ("+Entity.player2.name+")");
                    System.out.println();
                    System.out.print("Scegli giocatore bersaglio: ");
                    int inputPlayer = new Scanner(System.in).nextInt();
                    System.out.println();

                    switch (inputPlayer) {
                        case 1:
                            System.out.println("Elenco bersagli Giocatore 1: ");
                            for (int j = 0; j < Entity.targets.length; j++) {
                                System.out.println((j + 1) + " - " + Entity.targets[0][j].name);
                            }
                            System.out.println();
                            System.out.print("Scegli bersaglio: ");
                            miniaInput[i] = Entity.targets[0][new Scanner(System.in).nextInt() - 1];
                            paramsTypeSequence = paramsTypeSequence + "m";
                            break;
                        case 2:
                            System.out.println("Elenco bersagli Giocatore 2: ");
                            for (int j = 0; j < Entity.targets.length; j++) {
                                System.out.println((j + 1) + " - " + Entity.targets[1][j].name);
                            }
                            System.out.println();
                            System.out.print("Scegli bersaglio: ");
                            miniaInput[i] = Entity.targets[1][new Scanner(System.in).nextInt() - 1];
                            paramsTypeSequence = paramsTypeSequence + "m";
                            break;
                    }
            }
        }

        if (inTimeline) {
            Entity.gameTimeline.addEvent(inputPlayerNum,this, this.name, actions[inputAction - 1], actionsNames[inputAction-1], actionsSetupTime[inputAction-1], paramsTypeSequence, intInput, doubleInput, stringInput, miniaInput, titanInput);
        } else {
            Entity.gameTimeline.doEvent(this, actions[inputAction-1], paramsTypeSequence, intInput, doubleInput, stringInput, miniaInput, titanInput);
        }

    }

    public abstract void setActionParams(Method inputMethod, int inputPosition);

    public void updateData(){

    }

    public void roundData (){
        strength = Math.round(strength * 100.0) / 100.0;
        dexterity = Math.round(dexterity * 100.0) / 100.0;
        selfcontrol = Math.round(selfcontrol * 100.0) / 100.0;
        berserkerThreshold = Math.round(berserkerThreshold * 100.0) / 100.0;
        structure_start = Math.round(structure_start * 100.0) / 100.0;
        structure_current = Math.round(structure_current * 100.0) / 100.0;
        kineticResistance = Math.round(kineticResistance * 100.0) / 100.0;
        electromagneticResistance = Math.round(electromagneticResistance * 100.0) / 100.0;
        thermalResistance = Math.round(thermalResistance * 100.0) / 100.0;
        psionicResistance = Math.round(psionicResistance * 100.0) / 100.0;

    }

    public abstract String immediate_displayData();
}
