package com.example.javafxtest2;

import java.lang.reflect.Method;
import java.util.Scanner;

public class TMedium extends Titan {
    public final int slotNum = 2;
    Scanner userInput = new Scanner(System.in);

    static Minia[] slot = new Minia[2];

    public TMedium (String titanName, MMachinegun inputMiniature1, MMachinegun inputMiniature2){
        super(titanName, inputMiniature1, inputMiniature2);
        kind = "Titan Medium";
        strength = Common.getRandomDouble(50,60);
        dexterity = Common.getRandomDouble(50,60);
        behaviour = "Shy";
        selfcontrol = Common.getRandomDouble(50,60);
        berserkerThreshold = Common.getRandomDouble(50,60);
        structure_start = Common.getRandomDouble(50,60);
        kineticResistance = Common.getRandomDouble(50,60);
        electromagneticResistance = Common.getRandomDouble(50,60);
        thermalResistance = Common.getRandomDouble(50,60);
        psionicResistance = Common.getRandomDouble(50,60);
        location = "x e y";
        speed = Common.getRandomInt(5,6);
        foodRequirements[0] = Entity.food.Tensolifati;
        foodRequirements[1] = Entity.food.Groteine;
        foodRequirements[2] = Entity.food.Macromine;
        tastePreference = Entity.food.Tensolifati;
        clan = Entity.clan.Zuolan;

        slot[0]=inputMiniature1;
        slot[1]=inputMiniature2;
    }


    // Inner workings methods

    public String getName(){
        return name;
    }

    @Override
    public void setActionParams (Method inputMethod, int inputPosition){
        switch (inputMethod.getName()){
            case "immediate_displayData":
                actionsNames[inputPosition] = "Mostra parametri";
                actionsDescriptions[inputPosition] = "Mostra parametri";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_attack":
                actionsNames[inputPosition] = "Attacca";
                actionsDescriptions[inputPosition] = "Aggiungi \"Attacca\" alla Timeline";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_move":
                actionsNames[inputPosition] = "Muovi";
                actionsDescriptions[inputPosition] = "Aggiungi \"Muovi\" alla Timeline";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_defend":
                actionsNames[inputPosition] = "Difendi";
                actionsDescriptions[inputPosition] = "Aggiungi \"Difendi\" alla Timeline";
                actionsSetupTime[inputPosition] = 2;
                break;
        }
    }

    @Override
    public void updateData(){

    }


    // Titan user actions

    @Override
    public String immediate_displayData()  {
        displaySharedTitanData();

        output = output + "altri dati specific di TMedium\n";

        return output;
    }

    public void player_attack(Minia target, int damage){

        System.out.println("----------------------------------------------");
        System.out.println("Eseguo: ATTACK sul bersaglio: "+target.name);
        System.out.println("----------------------------------------------");
        System.out.println("Valore struttura bersaglio: "+target.structure_current);
        target.structure_current = target.structure_current - damage;
        System.out.println("Valore struttura bersaglio dopo attacco: "+target.structure_current);
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println("Premi invio per continuare...");
        userInput.nextLine();
    }

    public void player_move(int distance, String inputText){

        System.out.println("----------------------------------------------");
        System.out.println("Eseguo: MOVE"+" ("+distance+")" + " "+inputText);
        System.out.println("----------------------------------------------");
        System.out.println("Titano: "+this.name);
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Premi invio per continuare...");
        userInput.nextLine();

    }

    public void player_defend(Minia inputTarget){

        System.out.println("----------------------------------------------");
        System.out.println("Eseguo: DEFEND" + " (" + inputTarget.name + ")");
        System.out.println("----------------------------------------------");
        System.out.println("Titano: "+this.name);
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Premi invio per continuare...");
        userInput.nextLine();
    }




}
