package com.example.javafxtest2;

public class Common {

    public static void createTargets(int playerNumber) {
        playerNumber = playerNumber - 1;
        int targetCount = 0;

        if (playerNumber == 0) {

            // Player 1 (Slots)
            for (int i = 0; i < Entity.p1Titano.slot.length; i++) {
                Entity.targets[playerNumber][targetCount] = Entity.p1Titano.slot[i];
                targetCount++;
            }
        } else if (playerNumber == 1) {

            // Player 2 (Slots)
            for (int i = 0; i < Entity.p2Titano.slot.length; i++) {
                Entity.targets[playerNumber][targetCount] = Entity.p2Titano.slot[i];
                targetCount++;
            }
        }
    }

    public static void updateHeating (Minia targetMinia, double inputHeat){
        targetMinia.heating+=inputHeat;
        if (targetMinia.heating>100){
            targetMinia.heating=100;
            System.out.println(targetMinia.name+" surriscaldata!");
        }
    }

    public static double getRandomDouble(double min, double max) {
        double randomValue = (Math.random() * ((max - min) + 1)) + min;
        return Math.round(randomValue * 100.0) / 100.0;
    }

    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }

    public static void endRound() {
        // update entities
        for (int i = 0; i < 2; i++) {
            Entity.players[i].titan[0].updateData();
            Entity.players[i].titan[0].roundData();
            for (int j = 0; j < 2; j++) {
                Entity.players[i].titan[0].slot[j].updateData();
                Entity.players[i].titan[0].slot[j].roundData();
            }
        }
        GameLoop.Round++;
    }
}
