package com.example.javafxtest2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

public abstract class Minia {
    // Miniature attributes
    String name;
    String shortName;
    int guid;
    String miniaType;
    double shield_start;
    double shield_current;
    double shield_recharge;
    double structure_start;
    double structure_current;
    double structureCriticalThreshold;
    double kineticResistance;
    double electromagneticResistance;
    double thermalResistance;
    double psionicResistance;
    double movementReach;
    double speed;
    int posX;
    int posY;
    int oldPosX;
    int oldPosY;
    double powerRequirement;
    double powerRequirementPeraction;
    double heating;
    double heatingIncrease;
    double overheatingThreshold;
    double cooling;
    int workingMinions;
    Entity.clan clan;


    // Action attributes
    Scanner userInput = new Scanner(System.in);
    Method[] actions = new Method[10];
    String[] actionsNames = new String[10];
    String[] actionsDescriptions = new String[10];
    int[] actionsSetupTime = new int[10];
    Boolean[] actionsAddToTimeline = new Boolean[10];
    int[] actionsPlayerNumber = new int[10];
    String[] actionsPlayerNames = new String[10];
    public int actionsCount = 0;

    public Minia(String inputMiniaName, String inputShortName) {
        name = inputMiniaName;
        shortName = inputShortName;
        guid = 9887;
    }

    public String getName(){
        return name;
    }


    // Inner working methods

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

    public abstract void setActionParams(Method inputMethod, int inputPosition);

    public void doAction (int inputAction) {

        int intInput[] = new int[5];
        double doubleInput[] = new double[5];
        String stringInput[] = new String[5];
        Minia miniaInput[] = new Minia[5];
        Titan titanInput[] = new Titan[5];
        Parameter[] parameters = new Parameter[5];
        String paramsTypeSequence = new String();

        Method method = actions[inputAction - 1];
        parameters = method.getParameters();

        System.out.println("Azione: " + method.getName());
        System.out.println("Parametri: " + parameters.length);


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
                case "Minia":
                    System.out.println("Parametro " + (i+1)  + " - Identifica un bersaglio: ");
                    System.out.println();
                    System.out.println("Giocatore bersaglio: ");
                    System.out.println("1) Player 1 ("+ Entity.player1.name+")");
                    System.out.println("2) Player 2 ("+ Entity.player2.name+")");
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

        //Componi gli identificativi dei tipi di parametro

        switch (parameters.length) {
            case 0:
                try {
                    method.invoke(this);
                } catch (Exception e) {
                    System.out.println("Errore (no params) invoke: " + e);
                }
                break;
            case 1:
                switch (paramsTypeSequence) {
                    case "i":
                        try {
                            method.invoke(this, intInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (int) invoke: " + e);
                        }
                        break;
                    case "s":
                        try {
                            method.invoke(this, stringInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (String) invoke: " + e);
                        }
                        break;
                    case "d":
                        try {
                            method.invoke(this, doubleInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (double) invoke: " + e);
                        }
                        break;
                    case "m":
                        try {
                            method.invoke(this, miniaInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia) invoke: " + e);
                        }
                }
            case 2:
                switch (paramsTypeSequence) {
                    case "ii":
                        try {
                            method.invoke(this, intInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, int) invoke: " + e);
                        }
                        break;
                    case "id":
                        try {
                            method.invoke(this, intInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, double) invoke: " + e);
                        }
                        break;
                    case "im":
                        try {
                            method.invoke(this, intInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, Minia) invoke: " + e);
                        }
                        break;
                    case "is":
                        try {
                            method.invoke(this, intInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, String) invoke: " + e);
                        }
                        break;
                    case "di":
                        try {
                            method.invoke(this, doubleInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, int) invoke: " + e);
                        }
                        break;
                    case "dd":
                        try {
                            method.invoke(this, doubleInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, double) invoke: " + e);
                        }
                        break;
                    case "dm":
                        try {
                            method.invoke(this, doubleInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, Minia) invoke: " + e);
                        }
                        break;
                    case "ds":
                        try {
                            method.invoke(this, doubleInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, String) invoke: " + e);
                        }
                        break;
                    case "mi":
                        try {
                            method.invoke(this, miniaInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, int) invoke: " + e);
                        }
                        break;
                    case "md":
                        try {
                            method.invoke(this, miniaInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, double) invoke: " + e);
                        }
                        break;
                    case "mm":
                        try {
                            method.invoke(this, miniaInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, Minia) invoke: " + e);
                        }
                        break;
                    case "ms":
                        try {
                            method.invoke(this, miniaInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, String) invoke: " + e);
                        }
                        break;
                    case "si":
                        try {
                            method.invoke(this, stringInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, int) invoke: " + e);
                        }
                        break;
                    case "sd":
                        try {
                            method.invoke(this, stringInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, double) invoke: " + e);
                        }
                        break;
                    case "sm":
                        try {
                            method.invoke(this, stringInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, Minia) invoke: " + e);
                        }
                        break;
                    case "ss":
                        try {
                            method.invoke(this, stringInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, String) invoke: " + e);
                        }
                        break;
                }
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

        Method method = actions[inputAction - 1];
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
                    System.out.println("1) Player 1 ("+ Entity.player1.name+")");
                    System.out.println("2) Player 2 ("+ Entity.player2.name+")");
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

    public void roundData (){
    }

    public void updateData(){

    }

    public void display() {
        System.out.println("----------------------------------------------");
        System.out.println("Dati della miniatura "+ name + " (Tipo: "+miniaType+")");
        System.out.println("----------------------------------------------");
        System.out.println("Guid: "+ guid);
        System.out.println("Shield (Start value): "+ shield_start);
        System.out.println("Shield (Current value): "+ shield_current);
        System.out.println("Structure (Start value): "+ structure_start);
        System.out.println("Structure (Current value): "+ structure_current);
        System.out.println("Shield recharge: "+ shield_recharge);
        System.out.println("Structure critical threshold: "+ structureCriticalThreshold);
        System.out.println("Kinetic resistance: "+ kineticResistance);
        System.out.println("Electromagnetic resistance: "+ electromagneticResistance);
        System.out.println("Thermal resistance: "+ thermalResistance);
        System.out.println("Psionic resistance: "+ psionicResistance);
        System.out.println("Location: "+ posX +","+ posY);
        System.out.println("Movement reach: "+ movementReach);
        System.out.println("Speed: "+ speed);
        System.out.println("Power requirement: "+ powerRequirement);
        System.out.println("Power requirement per action: "+ powerRequirementPeraction);
        System.out.println("Heating: "+ heating);
        System.out.println("Heating increase: "+ heatingIncrease);
        System.out.println("Overheating threshold: "+ overheatingThreshold);
        System.out.println("Cooling: "+ cooling);
        System.out.println("Working minions: "+ workingMinions);
        System.out.println("Clan: "+ clan);
        System.out.println("Premi invio per continuare...");
        userInput.nextLine();
    }

    public Method getMethod(int methodNum){
        Method[] tempMethod = this.getClass().getDeclaredMethods();
        return tempMethod[methodNum];
    }

    public void showActions(){
        for (int i = 0; i < actions.length; i++) {
            System.out.println(i +") "+ actions[i].getName());
        }
    }




}
