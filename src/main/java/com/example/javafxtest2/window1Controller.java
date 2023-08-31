package com.example.javafxtest2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;

import java.util.Optional;

import static com.example.javafxtest2.Entity.gameTimeline;
import static com.example.javafxtest2.Main.*;

public class window1Controller {
    @FXML
    public FlowPane titanFlowPane;
    @FXML
    private Label welcomeText;
    @FXML
    private Button titanActionButton1;
    @FXML
    private Button titanActionButton2;
    @FXML
    private Button titanActionButton3;
    @FXML
    private TextArea map;
    @FXML
    private TextArea output;
    @FXML
    private TextField inputField;
    @FXML
    private Button player1Titan1ParametersRefresh;
    @FXML
    private Button player1Titan1Slot1ParametersRefresh;
    @FXML
    private Button player1Titan1Slot2ParametersRefresh;
    @FXML
    private Button timelineRefresh;
    @FXML
    private TextArea player1Titan1Parameters;
    @FXML
    private TextArea player1Titan1Slot1Parameters;
    @FXML
    private TextArea player1Titan1Slot2Parameters;
    @FXML
    private TextArea timeline;
    @FXML
    private Button timelineButton1;


    private ExternalClass myExternal = new ExternalClass();

    int inputValue = 0;

    @FXML
    public void setOutputContent(String myOutputContent, String mymapContent) {
        outputContent = myOutputContent;
        mapContent = mymapContent;
    }

    @FXML
    public void initialize() {
        outputContent = "Output Content";
        mapContent = "Map Content";
        updateOutput();
        updateMap();
    }

    @FXML
    public  void updateOutput() {
        output.clear();
        output.setText(outputContent);
    }

    @FXML
    public void updateMap() {
        map.clear();
        map.setText(mapContent);
    }

    @FXML
    public void updatePlayer1Titan1Parameters() {
        player1Titan1Parameters.clear();
        player1Titan1Parameters.setText(p1T1ParamsContent);
    }

    @FXML
    public void updateTimeline() {
        timeline.clear();
        timeline.setText(timelineContent);
    }


// Parameters buttons

    @FXML
    protected void player1Titan1ParametersRefresh() {
        player1Titan1Parameters.clear();
        System.out.println("player1Titan1ParametersRefresh");
        player1Titan1Parameters.setText("parametri");
        player1Titan1Parameters.setText(Entity.players[0].titan[0].immediate_displayData());
        System.out.println(Entity.players[0].titan[0].immediate_displayData());
    }


    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void testp1t1paramas(ActionEvent actionEvent){
        p1T1ParamsContent ="gorkamorka";
        updatePlayer1Titan1Parameters();
    }

    public void timelineRefresh(ActionEvent actionEvent) {
        gameTimeline.showTimeline();
        updateTimeline();
    }

    public void testDialogButtonClick(ActionEvent actionEvent) {
        TextInputDialog textInput = new TextInputDialog();
        textInput.setHeaderText("Test Dialog Intestazione");
        textInput.setTitle("Test Dialog Titolo");
        textInput.getDialogPane().setContentText("Inserisci un valore");

        Optional<String> result = textInput.showAndWait();

        TextField input = textInput.getEditor();

        if (input.getText() != null && input.getText().toString().length() != 0) {
            System.out.println("Input: " + input.getText());
        } else {
            System.out.println("Input vuoto");
        }



    }

    public String getStringDialog(String actionName) {

        TextInputDialog textInput = new TextInputDialog();

        textInput.setTitle("Inserisci un valore");
        textInput.setHeaderText("Configura " + actionName);
        textInput.getDialogPane().setContentText("Inserisci un testo");

        String result = String.valueOf(textInput.showAndWait());

        TextField input = textInput.getEditor();

        if (input.getText() != null && input.getText().toString().length() != 0) {
            System.out.println("Input: " + input.getText());
        } else {
            System.out.println("Input vuoto");
        }

        return input.getText();

    }
}