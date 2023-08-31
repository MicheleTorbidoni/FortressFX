package com.example.javafxtest2;

import java.util.Scanner;


public class GameLoop {


    static int Round = 1;
    public static void endRound() {
        Round++;
    }

    public static void run() {
        Scanner userInput = new Scanner(System.in);
        int inputPlayer;

        System.out.println();
        System.out.println();
        System.out.println("----------------------------------------------");
        System.out.println("Benvenuto in FORTRESS SIMULATOR");
        System.out.println("rev. 0.1a");
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();

        while (true) {

            // Choose player

            Entity.myGrid.displayGrid();
            System.out.println();
            System.out.println("----------------------------------------------");
            System.out.println("Round:" + Round);
            System.out.println("----------------------------------------------");
            System.out.println();
            System.out.println("1) Scegli Player 1 (" + Entity.player1.name + ")");
            System.out.println("2) Scegli Player 2 (" + Entity.player2.name + ")");
            System.out.println("3) Mostra timeline");
            System.out.println("4) Risolvi timeline e termina round");
            System.out.println();
            System.out.print("> ");
            inputPlayer = userInput.nextInt();
            System.out.println();
            System.out.println();

            if (inputPlayer == 3) {
                Entity.gameTimeline.showTimeline();
            } else if (inputPlayer == 4) {
                Entity.gameTimeline.resolveTimeline();
                Entity.gameTimeline.resetTimeline();
                Common.endRound();
            } else  {

                // Choose titan or miniature

                System.out.println("----------------------------------------------");
                System.out.println("Scegli Entità di giocatore #" + inputPlayer);
                System.out.println("----------------------------------------------");

                System.out.println("1) Titano 1 (" + Entity.players[inputPlayer - 1].titan[0].name + ")");

                for (int i = 1; i <= 2; i++) {
                    System.out.println((i + 1) + ") Slot 0" + (i) + ": " + Entity.players[inputPlayer - 1].titan[0].slot[i - 1].name + " (" + Entity.players[inputPlayer - 1].titan[0].slot[i - 1].shortName+")");
                }
                System.out.println();
                System.out.print("> ");
                int inputItem = userInput.nextInt();
                System.out.println();
                System.out.println();

                // Titan selected

                if (inputItem == 1) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Scegli Azioni:");
                    System.out.println("----------------------------------------------");
                    for (int i = 0; i < Entity.players[inputPlayer - 1].titan[0].actions.length; i++) {
                        if (Entity.players[inputPlayer - 1].titan[0].actions[i] != null) {
                            System.out.println((i + 1) + ") " + Entity.players[inputPlayer - 1].titan[0].actionsDescriptions[i]);
                        }
                    }
                    System.out.println();
                    System.out.print("Scegli: ");
                    int inputAction = userInput.nextInt();
                    System.out.println();

                    Entity.players[inputPlayer-1].titan[0].execute(inputAction, inputPlayer, Entity.players[inputPlayer - 1].titan[0].actionsAddToTimeline[inputAction-1]);

                    // Miniature selected

                } else if (inputItem > 1) {
                    System.out.println("----------------------------------------------");
                    System.out.println("Scegli Azioni:");
                    System.out.println("----------------------------------------------");

                    System.out.println("----------------------------------------------");
                    for (int i = 0; i < Entity.players[inputPlayer - 1].titan[0].slot[inputItem-2].actions.length; i++) {
                        if (Entity.players[inputPlayer - 1].titan[0].slot[inputItem-2].actions[i] != null) {
                            System.out.println((i + 1) + ") " + Entity.players[inputPlayer - 1].titan[0].slot[inputItem - 2].actionsDescriptions[i]);
                        }
                    }
                    System.out.println();
                    System.out.print("Scegli: ");
                    int inputAction = userInput.nextInt();
                    System.out.println();

                    Entity.players[inputPlayer-1].titan[0].slot[inputItem - 2].execute(inputAction, inputPlayer, Entity.players[inputPlayer - 1].titan[0].slot[inputItem - 2].actionsAddToTimeline[inputAction-1]);
                } else {
                    System.out.println("Errore numero entità selezionata.");
                }

            }

        }
    }

    }

