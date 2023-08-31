package com.example.javafxtest2;

import java.lang.reflect.Method;

import static com.example.javafxtest2.Main.timelineContent;

public class Timeline {

    int inputPlayerNum = 0;
    int[][] playerNumber = new int[2][10];
    String[][] playerName = new String[2][10];
    Object[][] objects = new Object[2][10];
    String[][] objectNames = new String[2][10];
    Method[][] methods = new Method[2][10];
    String[][] methodNames = new String[2][10];
    int[][][] intInput = new int[2][10][5];
    double[][][] doubleInput = new double[2][10][5];
    String[][][] stringInput = new String[2][10][5];
    Minia[][][] miniaInput = new Minia[2][10][5];
    Titan[][][] titanInput = new Titan[2][10][5];
    String[][] paramsTypeSequence = new String[2][10];

    int count[] = new int[2];

    public Timeline() {
        resetTimeline();
    }

    public void resetTimeline() {
        count[0] = 0;
        count[1] = 0;
        for (int a = 0; a < 2; a++) {
            for (int i = 0; i < 10; i++) {
                playerNumber[a][i] = 0;
                objects[a][i] = null;
                objectNames[a][i] = null;
                methods[a][i] = null;
                for (int j = 0; j < 5; j++) {
                    intInput[a][i][j] = 0;
                    doubleInput[a][i][j] = 0.00;
                    stringInput[a][i][j] = null;
                    miniaInput[a][i][j] = null;
                    titanInput[a][i][j] = null;
                }
            }
        }
    }

    public void addEvent(int inputPlayerNumber, Object object, String objectName, Method method, String methodNames, int inputSetupTime , String inputParamSequence, int intInput[], double doubleInput[], String stringInput[], Minia miniaInput[], Titan titanInput[]) {
        if ((count[inputPlayerNumber-1] + inputSetupTime) > 9) {
            System.out.println("La timeline è piena");
            return;
        } else {
            count[inputPlayerNumber-1] = count[inputPlayerNumber-1] + inputSetupTime;

            playerNumber[inputPlayerNumber-1][count[inputPlayerNumber-1]] = inputPlayerNumber-1;
            objects[inputPlayerNumber-1][count[inputPlayerNumber-1]] = object;
            objectNames[inputPlayerNumber-1][count[inputPlayerNumber-1]] = objectName;
            methods[inputPlayerNumber-1][count[inputPlayerNumber-1]] = method;
            this.methodNames[inputPlayerNumber-1][count[inputPlayerNumber-1]] = methodNames;
            paramsTypeSequence[inputPlayerNumber-1][count[inputPlayerNumber-1]] = inputParamSequence;
            this.intInput[inputPlayerNumber-1][count[inputPlayerNumber-1]] = intInput;
            this.doubleInput[inputPlayerNumber-1][count[inputPlayerNumber-1]] = doubleInput;
            this.stringInput[inputPlayerNumber-1][count[inputPlayerNumber-1]] = stringInput;
            this.miniaInput[inputPlayerNumber-1][count[inputPlayerNumber-1]] = miniaInput;
            this.titanInput[inputPlayerNumber-1][count[inputPlayerNumber-1]] = titanInput;
        }
    }
    public void doEvent(Object object, Method method, String inputParamSequence, int intInput[], double doubleInput[], String stringInput[], Minia miniaInput[], Titan titanInput[]) {
        switch (inputParamSequence.length()) {
            case 0:
                try {
                    method.invoke(object);
                } catch (Exception e) {
                    System.out.println("Errore (no params) invoke: " + e);
                }
                break;
            case 1:
                switch (inputParamSequence) {
                    case "i":
                        try {
                            method.invoke(object, intInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (int) invoke: " + e);
                        }
                        break;
                    case "s":
                        try {
                            method.invoke(object, stringInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (String) invoke: " + e);
                        }
                        break;
                    case "d":
                        try {
                            method.invoke(object, doubleInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (double) invoke: " + e);
                        }
                        break;
                    case "m":
                        try {
                            method.invoke(object, miniaInput[0]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia) invoke: " + e);
                        }
                }
            case 2:
                switch (inputParamSequence) {
                    case "ii":
                        try {
                            method.invoke(object, intInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, int) invoke: " + e);
                        }
                        break;
                    case "id":
                        try {
                            method.invoke(object, intInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, double) invoke: " + e);
                        }
                        break;
                    case "im":
                        try {
                            method.invoke(object, intInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, Minia) invoke: " + e);
                        }
                        break;
                    case "is":
                        try {
                            method.invoke(object, intInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (int, String) invoke: " + e);
                        }
                        break;
                    case "di":
                        try {
                            method.invoke(object, doubleInput[0], intInput[1]);
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
                            method.invoke(object, doubleInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, Minia) invoke: " + e);
                        }
                        break;
                    case "ds":
                        try {
                            method.invoke(object, doubleInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (double, String) invoke: " + e);
                        }
                        break;
                    case "mi":
                        try {
                            method.invoke(object, miniaInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, int) invoke: " + e);
                        }
                        break;
                    case "md":
                        try {
                            method.invoke(object, miniaInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, double) invoke: " + e);
                        }
                        break;
                    case "mm":
                        try {
                            method.invoke(object, miniaInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, Minia) invoke: " + e);
                        }
                        break;
                    case "ms":
                        try {
                            method.invoke(object, miniaInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (Minia, String) invoke: " + e);
                        }
                        break;
                    case "si":
                        try {
                            method.invoke(object, stringInput[0], intInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, int) invoke: " + e);
                        }
                        break;
                    case "sd":
                        try {
                            method.invoke(object, stringInput[0], doubleInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, double) invoke: " + e);
                        }
                        break;
                    case "sm":
                        try {
                            method.invoke(object, stringInput[0], miniaInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, Minia) invoke: " + e);
                        }
                        break;
                    case "ss":
                        try {
                            method.invoke(object, stringInput[0], stringInput[1]);
                        } catch (Exception e) {
                            System.out.println("Errore (String, String) invoke: " + e);
                        }
                        break;
                }
        }
    }

    public void showTimeline () {
            timelineContent="----------------------------------------------\n";
        for (int i = 0; i < 10; i++) {
            if (objects[0][i] != null) {
                timelineContent = timelineContent + "Minuto " + (i+1) + " Player 1 ("+Entity.players[playerNumber[0][i]].name + ") > " + objectNames[0][i] + " > " + methodNames[0][i] +" ("+paramsTypeSequence[0][i]+")\n";
            } else {
                timelineContent = timelineContent + "Minuto " + (i+1) + " Player 1 -\n";
            }
            if (objects[1][i] != null) {
                timelineContent = timelineContent + "       " + (i+1) + " Player 2 ("+Entity.players[playerNumber[1][i]].name + ") > " + objectNames[1][i] + " > " + methodNames[1][i] +" ("+paramsTypeSequence[1][i]+")\n";
            } else {
                timelineContent = timelineContent + "       " + (i+1) + " Player 2 -\n";;
            }

            timelineContent = timelineContent + "\n";
        }
        timelineContent = timelineContent + "\n";
    }

    public void resolveTimeline () {
        for (int i = 0; i < 10; i++) {
            // Da completare perché risolve arbitrariamente prima il giocatore 1 e poi il 2

            if (objects[0][i] != null) {
                doEvent(objects[0][i], methods[0][i], paramsTypeSequence[0][i],intInput[0][i],doubleInput[0][i],stringInput[0][i],miniaInput[0][i],null);
                System.out.println("Ho risolto l'evento " + objectNames[0][i] + " " + methodNames[0][i] + " (" + paramsTypeSequence[0][i] + ")");
            }
            if (objects[1][i] != null) {
                doEvent(objects[1][i], methods[1][i], paramsTypeSequence[1][i],intInput[1][i],doubleInput[1][i],stringInput[1][i],miniaInput[1][i],null);
                System.out.println("Ho risolto l'evento " + objectNames[1][i] + " " + methodNames[1][i] + " (" + paramsTypeSequence[1][i] + ")");
            }
        }
    }





}
