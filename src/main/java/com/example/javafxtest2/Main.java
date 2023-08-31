package com.example.javafxtest2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    static String mapContent = null;
    static String outputContent = null;
    static String p1T1ParamsContent = null;
    static String timelineContent = null;


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("window1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        window1Controller controller = fxmlLoader.getController();

        Entity.player1.addTitan(Entity.p1Titano);
        Entity.player2.addTitan(Entity.p2Titano);
        Entity.players[0]=Entity.player1;
        Entity.players[1]=Entity.player2;

        Entity.players[0].titan[0].createActions(0);
        Entity.players[0].titan[0].slot[0].createActions(0);
        Entity.players[0].titan[0].slot[1].createActions(0);

        Entity.players[1].titan[0].createActions(1);
        Entity.players[1].titan[0].slot[0].createActions(1);
        Entity.players[1].titan[0].slot[1].createActions(1);

        Entity.myGrid.setStartingPosition(Entity.players[0].titan[0].slot[0],'l');
        Entity.myGrid.addItem(Entity.players[0].titan[0].slot[0]);
        Entity.myGrid.setStartingPosition(Entity.players[0].titan[0].slot[1],'l');
        Entity.myGrid.addItem(Entity.players[0].titan[0].slot[1]);

        Entity.myGrid.setStartingPosition(Entity.players[1].titan[0].slot[0],'r');
        Entity.myGrid.addItem(Entity.players[1].titan[0].slot[0]);
        Entity.myGrid.setStartingPosition(Entity.players[1].titan[0].slot[1],'r');
        Entity.myGrid.addItem(Entity.players[1].titan[0].slot[1]);

        Common.createTargets(1);
        Common.createTargets(2);

        p1T1ParamsContent ="ciaobao";

        controller.updatePlayer1Titan1Parameters();



        Entity.players[0].titan[0].displaySharedTitanData();



        for (int k = 0; k < Entity.players[0].titan[0].actions.length; k++) {

            if (Entity.players[0].titan[0].actions[k] != null) {
                System.out.println(Entity.players[0].titan[0].actionsDescriptions[k]);
                Button button = new Button(Entity.players[0].titan[0].actionsDescriptions[k]);
                int finalK = k;
                button.setOnAction(event -> {
                    // Azione da eseguire quando il pulsante viene premuto
                    outputContent = "Hai premuto il pulsante " + button.getText() + "\n";
                    outputContent = outputContent + "Azione: " + Entity.players[0].titan[0].actionsDescriptions[finalK] + "\n";
                    outputContent = outputContent + "Nome: " + Entity.players[0].titan[0].actionsNames[finalK] + "\n";
                    outputContent = outputContent + "Setup Time: " + Entity.players[0].titan[0].actionsSetupTime[finalK] + "\n";
                    outputContent = outputContent + "Add to Timeline? " + Entity.players[0].titan[0].actionsAddToTimeline[finalK] + "\n";
                    outputContent = outputContent + "Oggetto: " + Entity.players[0].titan[0].actions[finalK] + "\n";

                    String testInput;
                    testInput = controller.getStringDialog(Entity.players[0].titan[0].actionsNames[finalK]);
                    System.out.println("Valore ottenuto: "+ testInput);

                    //Entity.players[0].titan[0].execute(finalK+1, 1, true);

                    controller.updateOutput();
                });

                ((FlowPane) scene.lookup("#player1Titan1ActionsPane")).getChildren().add(button);
            }

            for (k = 0; k < Entity.players[0].titan[0].slot[0].actions.length; k++) {

                if (Entity.players[0].titan[0].slot[0].actions[k] != null) {
                    System.out.println(Entity.players[0].titan[0].slot[0].actionsDescriptions[k]);
                    Button button = new Button(Entity.players[0].titan[0].slot[0].actionsDescriptions[k]);
                    int finalK = k;
                    button.setOnAction(event -> {
                        // Azione da eseguire quando il pulsante viene premuto
                        outputContent = "Hai premuto il pulsante " + button.getText() + "\n";
                        outputContent = outputContent + "Azione: " + Entity.players[0].titan[0].slot[0].actionsDescriptions[finalK] + "\n";
                        outputContent = outputContent + "Nome: " + Entity.players[0].titan[0].slot[0].actionsNames[finalK] + "\n";
                        outputContent = outputContent + "Setup Time: " + Entity.players[0].titan[0].slot[0].actionsSetupTime[finalK] + "\n";
                        outputContent = outputContent + "Add to Timeline? " + Entity.players[0].titan[0].slot[0].actionsAddToTimeline[finalK] + "\n";
                        outputContent = outputContent + "Oggetto: " + Entity.players[0].titan[0].slot[0].actions[finalK] + "\n";

                        String testInput;
                        testInput = controller.getStringDialog(Entity.players[0].titan[0].slot[0].actionsNames[finalK]);
                        System.out.println("Valore ottenuto: "+ testInput);

                        //Entity.players[0].titan[0].slot[0].execute(finalK+1, 1, true);

                        controller.updateOutput();
                    });

                    ((FlowPane) scene.lookup("#player1Titan1Slot1ActionsPane")).getChildren().add(button);
                }


            }

            for (k = 0; k < Entity.players[0].titan[0].slot[1].actions.length; k++) {

                if (Entity.players[0].titan[0].slot[1].actions[k] != null) {
                    System.out.println(Entity.players[0].titan[0].slot[1].actionsDescriptions[k]);
                    Button button = new Button(Entity.players[0].titan[0].slot[1].actionsDescriptions[k]);
                    int finalK = k;
                    button.setOnAction(event -> {
                        // Azione da eseguire quando il pulsante viene premuto
                        outputContent = "Hai premuto il pulsante " + button.getText() + "\n";
                        outputContent = outputContent + "Azione: " + Entity.players[0].titan[0].slot[1].actionsDescriptions[finalK] + "\n";
                        outputContent = outputContent + "Nome: " + Entity.players[0].titan[0].slot[1].actionsNames[finalK] + "\n";
                        outputContent = outputContent + "Setup Time: " + Entity.players[0].titan[0].slot[1].actionsSetupTime[finalK] + "\n";
                        outputContent = outputContent + "Add to Timeline? " + Entity.players[0].titan[0].slot[1].actionsAddToTimeline[finalK] + "\n";
                        outputContent = outputContent + "Oggetto: " + Entity.players[0].titan[0].slot[1].actions[finalK] + "\n";

                        Entity.players[0].titan[0].slot[1].execute(finalK+1, 1, true);

                        controller.updateOutput();
                    });

                    ((FlowPane) scene.lookup("#player1Titan1Slot2ActionsPane")).getChildren().add(button);
                }


            }

            mapContent = Entity.myGrid.displayGrid();
            controller.updateMap();


            stage.setTitle("Fortress B1 (JavaFX Test)");
            stage.setScene(scene);
            stage.show();
        }
    }

    public static void main(String[] args) {



        ExternalClass myExternal = new ExternalClass();

        launch();

    }
}