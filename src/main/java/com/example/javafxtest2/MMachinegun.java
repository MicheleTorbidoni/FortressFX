package com.example.javafxtest2;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MMachinegun extends Minia {

    Entity.fieldView viewField;
    int volley;
    int ammoMagazine_start;
    int ammoMagazine_current;
    Entity.volleyShape volleyShape;
    double accuracy;
    double weaponThrow;
    double reload_time;
    double kineticDamageBonus;
    double electromagneticDamageBonus;
    double thermalDamageBonus;
    double psionicDamageBonus;
    AmmoMachinegun loadedAmmo = new AmmoMachinegun("init");

    Scanner userInput = new Scanner(System.in);


    public MMachinegun(String inputName, String shortName, AmmoMachinegun inputAmmo){
        super(inputName, shortName);
        shield_start = Common.getRandomDouble(50, 60);
        shield_current = shield_start;
        shield_recharge = Common.getRandomDouble(5, 8);
        structure_start = Common.getRandomDouble(50, 60);
        structure_current = structure_start;
        structureCriticalThreshold = Common.getRandomDouble(10, 15);
        kineticResistance = Common.getRandomDouble(5, 6);
        electromagneticResistance = Common.getRandomDouble(5, 6);
        psionicResistance = Common.getRandomDouble(5, 6);
        movementReach = 4;
        speed = Common.getRandomDouble(5, 6);
        powerRequirement = Common.getRandomDouble(30, 35);
        powerRequirementPeraction = Common.getRandomDouble(5, 6);
        heating = 0.00;
        clan = Entity.clan.Zuolan;
        heatingIncrease = Common.getRandomDouble(5, 6);
        overheatingThreshold = Common.getRandomDouble(30, 40);
        cooling = Common.getRandomDouble(5, 6);
        workingMinions = Common.getRandomInt(5, 6);
        weaponThrow = 3;
        viewField = Entity.fieldView.VIEW_180;
        volley = Common.getRandomInt(4, 8);
        ammoMagazine_start = 25;
        ammoMagazine_current = ammoMagazine_start;
        volleyShape = Entity.volleyShape.LINE;
        accuracy = Common.getRandomDouble(30, 50);
        reload_time = Common.getRandomDouble(0.1, 0.5);
        kineticDamageBonus = Common.getRandomDouble(50, 60);
        electromagneticDamageBonus = Common.getRandomDouble(50, 60);
        thermalDamageBonus = Common.getRandomDouble(50, 60);
        psionicDamageBonus = Common.getRandomDouble(50, 60);
        loadedAmmo = inputAmmo;
    }

    // Inner workings methods

    @Override
    public void roundData (){
        shield_start = Math.round(shield_start * 100.0) / 100.0;
        shield_current = Math.round(shield_current * 100.0) / 100.0;
        shield_recharge = Math.round(shield_recharge * 100.0) / 100.0;
        structure_start = Math.round(structure_start * 100.0) / 100.0;
        structure_current = Math.round(structure_current * 100.0) / 100.0;
        shield_recharge = Math.round(shield_recharge * 100.0) / 100.0;
        structureCriticalThreshold = Math.round(structureCriticalThreshold * 100.0) / 100.0;
        kineticResistance = Math.round(kineticResistance * 100.0) / 100.0;
        electromagneticResistance = Math.round(electromagneticResistance * 100.0) / 100.0;
        thermalResistance = Math.round(thermalResistance * 100.0) / 100.0;
        psionicResistance = Math.round(psionicResistance * 100.0) / 100.0;
        powerRequirement = Math.round(powerRequirement * 100.0) / 100.0;
        powerRequirementPeraction = Math.round(powerRequirementPeraction * 100.0) / 100.0;
        heating = Math.round(heating * 100.0) / 100.0;
        heatingIncrease = Math.round(heatingIncrease * 100.0) / 100.0;
        overheatingThreshold = Math.round(overheatingThreshold * 100.0) / 100.0;
        cooling = Math.round(cooling * 100.0) / 100.0;
        weaponThrow = Math.round(weaponThrow * 100.0) / 100.0;
        accuracy = Math.round(accuracy * 100.0) / 100.0;
        reload_time = Math.round(reload_time * 100.0) / 100.0;
        kineticDamageBonus = Math.round(kineticDamageBonus * 100.0) / 100.0;
        electromagneticDamageBonus = Math.round(electromagneticDamageBonus * 100.0) / 100.0;
        thermalDamageBonus = Math.round(thermalDamageBonus * 100.0) / 100.0;
        psionicDamageBonus = Math.round(psionicDamageBonus * 100.0) / 100.0;
    }

    @Override
    public void updateData(){

        // shield recharge
        if ((shield_current + shield_recharge) > shield_start){
            shield_current = shield_start;
        } else {
            shield_current = shield_current + shield_recharge;
        }

    }

    @Override
    public void setActionParams (Method inputMethod, int inputPosition){
        switch (inputMethod.getName()){
            case "immediate_displayData":
                actionsNames[inputPosition] = "Mostra parametri";
                actionsDescriptions[inputPosition] = "Mostra parametri (immediato)";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_attack":
                actionsNames[inputPosition] = "Attacca";
                actionsDescriptions[inputPosition] = "Attacca (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_defend":
                actionsNames[inputPosition] = "Difendi";
                actionsDescriptions[inputPosition] = "Difendi (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 2;
                break;
            case "player_moveNW":
                actionsNames[inputPosition] = "Muovi NW";
                actionsDescriptions[inputPosition] = "Muovi a NW (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;
            case "player_moveNE":
                actionsNames[inputPosition] = "Muovi NE";
                actionsDescriptions[inputPosition] = "Muovi a NE (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;
            case "player_moveW":
                actionsNames[inputPosition] = "Muovi W";
                actionsDescriptions[inputPosition] = "Muovi a W (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;
            case "player_moveE":
                actionsNames[inputPosition] = "Muovi E";
                actionsDescriptions[inputPosition] = "Muovi a E (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;
            case "player_moveSW":
                actionsNames[inputPosition] = "Muovi SW";
                actionsDescriptions[inputPosition] = "Muovi SW (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;
            case "player_moveSE":
                actionsNames[inputPosition] = "Muovi SE";
                actionsDescriptions[inputPosition] = "Muovi SE (aggiungi alla timeline)";
                actionsSetupTime[inputPosition] = 1;
                break;

        }
    }

    // Miniature user actions

    public void immediate_displayData() {
        display();
        System.out.println("Reach: " + weaponThrow);
        System.out.println("View field: " + viewField);
        System.out.println("Volley: " + volley);
        System.out.println("Loaded ammo: " + loadedAmmo.name);
        System.out.println("Ammo magazine: " + ammoMagazine_current);
        System.out.println("Volley shape: " + volleyShape);
        System.out.println("Accuracy: " + accuracy);
        System.out.println("Reload time: " + reload_time);
        System.out.println("Kinetic damages bonus: " + kineticDamageBonus);
        System.out.println("Electromagnetic damages bonus: " + electromagneticDamageBonus);
        System.out.println("Thermal damages bonus: " + thermalDamageBonus);
        System.out.println("Psionic damages bonus: " + psionicDamageBonus);
        System.out.println("----------------------------------------------");
        loadedAmmo.displayData();
    }

    public void player_attack(Minia target) {
        int hitTimes = 0;

        System.out.println("----------------------------------------------");
        System.out.println("ATTACK sul bersaglio: " + target.name);
        System.out.println("----------------------------------------------");
        if (Entity.myGrid.isTargetAtRange(this, target, (int) weaponThrow)) {

            System.out.println("Bersaglio a portata!");
            System.out.println();
            System.out.println("- Lancio proiettili (Volley da " + volley + "): OK");
            ammoMagazine_current = ammoMagazine_current - volley;
            System.out.println("- Area bersaglio: " + volleyShape.name());
            System.out.println("- Precisione: " + accuracy + "%");

            for (int i = 0; i <= volley; i++) {
                if (ammoMagazine_current > 0) {
                    double accuracyRandom = Common.getRandomDouble(20, 100);
                    System.out.print("- Colpo " + i);
                    System.out.print(" - precisione (random): " + accuracyRandom);
                    if (accuracy >= accuracyRandom) {
                        System.out.println(" - COLPISCE");
                        hitTimes++;
                    } else {
                        System.out.println(" - Manca");
                    }
                } else {
                    System.out.println("Munizioni esaurite");
                    break;
                }
            }

        } else {
            System.out.println("Bersaglio fuori portata");
        }



        double damageDealt = 0;
        double totalKineticModifier = kineticDamageBonus-target.kineticResistance;
        double totalElectromagneticModifier = electromagneticDamageBonus - target.electromagneticResistance;
        double totalThermalModifier = thermalDamageBonus-target.thermalResistance;
        double totalPsionicModifier = psionicDamageBonus-target.psionicResistance;

        for (int i = 0; i < hitTimes; i++) {
            damageDealt = damageDealt + (
                    (loadedAmmo.kineticDamage + (loadedAmmo.kineticDamage * totalKineticModifier / 100))
                            + (loadedAmmo.electromagneticDamage + (loadedAmmo.electromagneticDamage * totalElectromagneticModifier / 100))
                            + (loadedAmmo.thermalDamage + (loadedAmmo.thermalDamage * totalThermalModifier / 100))
                            + (loadedAmmo.psionicDamage + (loadedAmmo.psionicDamage * totalPsionicModifier / 100)));

        }

        System.out.println("- Scudo bersaglio attuale: " + target.shield_current);
        System.out.println("- Danni inflitti a scudo: " + damageDealt);

        if (damageDealt >= target.shield_current) {
            System.out.println("- Scudo bersaglio DISTRUTTO!");
            System.out.println("- Struttura bersaglio attuale: " + target.structure_current);
            System.out.println("- Danni inflitti a struttura: " + damageDealt);
            target.structure_current = target.structure_current - (damageDealt - target.shield_current);
            target.shield_current = 0;
            if (target.structure_current <= 0) {
                System.out.println("- Struttura bersaglio attuale: " + target.structure_current);
                target.structure_current = 0;
                System.out.println("- Struttura bersaglio DISTRUTTA!");
            } else {
                System.out.println("- Struttura bersaglio attuale: " + target.structure_current);
            }
        } else {
            target.shield_current = target.shield_current - damageDealt;
            System.out.println("- Scudo bersaglio attuale: " + target.shield_current);
        }

        System.out.println("Premi invio per continuare...");
        userInput.nextLine();
    }

    public void player_defend(){
        System.out.println("----------------------------------------------");
        System.out.println("Eseguo: DEFEND");
        System.out.println("----------------------------------------------");
        System.out.println("Titano: "+this.name);
        System.out.println("----------------------------------------------");
        System.out.println("Miniatura: "+this.name+" (tipo: "+this.getClass().getSimpleName()+")");
        System.out.println("----------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println("Premi invio per continuare...");
        userInput.nextLine();
    }

    public void player_moveNW(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE NW - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
           Entity.myGrid.moveNW(this);
           System.out.println("- Spostamento: " + i);
           System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }

    public void player_moveNE(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE NE - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
            Entity.myGrid.moveNE(this);
            System.out.println("- Spostamento: " + i);
            System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }

    public void player_moveE(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE E - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
            Entity.myGrid.moveE(this);
            System.out.println("- Spostamento: " + i);
            System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }

    public void player_moveW(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE W - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
            Entity.myGrid.moveE(this);
            System.out.println("- Spostamento: " + i);
            System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }

    public void player_moveSW(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE SW - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
            Entity.myGrid.moveSW(this);
            System.out.println("- Spostamento: " + i);
            System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }

    public void player_moveSE(int inputDistance) {

        int distance;

        System.out.println("----------------------------------------------");
        System.out.println("MOVE SE - Distanza " + (int) inputDistance);
        System.out.println("----------------------------------------------");
        System.out.println();
        if (inputDistance > movementReach) {
            System.out.println("ERRORE: Distanza inserita maggiore della portata di movimento");
            System.out.println("Premi invio per continuare...");
            userInput.nextLine();
            return;
        } else if (inputDistance == 0) {
            distance = (int) movementReach;
        } else {
            distance = inputDistance;
        }
        for (int i = 0; i < distance; i++) {
            Entity.myGrid.moveSE(this);
            System.out.println("- Spostamento: " + i);
            System.out.print("- Posizione: " + this.posX +","+this.posY);
            System.out.println();

            Common.updateHeating(this,1);
            System.out.println("- Riscaldamento: "+this.heating);

            Entity.myGrid.updatePosition(this);
        }
    }


}
