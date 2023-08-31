package com.example.javafxtest2;

import static com.example.javafxtest2.Main.mapContent;
import static com.example.javafxtest2.Main.outputContent;

public class ExternalClass {

    public  void sendOutputContent (int value) {


        mapContent = "** Titan Action Button 3 Clicked! + Value: " + value +"\n";
        mapContent= mapContent +" ciao";
        mapContent= mapContent + "\n";
        mapContent= mapContent +" bao";

        outputContent = "** Titan Action Button 3 Clicked! + Value: " + value +"\n";
        outputContent= outputContent +" ciao";
        outputContent= outputContent + "\n";
        outputContent= outputContent +" bao";
    }
}
