package com.example.javafxtest2;

public class Player {
    String name;
    Titan[] titan = new Titan[3];

    public Player (String inputName){
        name=inputName;
    }

    public void addTitan (Titan inputTitan){
        for (int i = 0; i < titan.length; i++) {
            if (titan[i]==null){
                titan[i]=inputTitan;
                break;
            }
        }
    }



}
