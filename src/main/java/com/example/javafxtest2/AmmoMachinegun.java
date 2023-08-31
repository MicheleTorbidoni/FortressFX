package com.example.javafxtest2;

public class AmmoMachinegun {
    // Ammunition for Machinegun attributes
    String name;
    String type;
    int quantity;
    double velocity;
    double perforation;
    double throwModifier;
    double kineticDamage;
    double thermalDamage;
    double electromagneticDamage;
    double psionicDamage;
    Entity.damageArea damageArea;

    public AmmoMachinegun(String inputName){
        name=inputName;
        type="ammo";
        quantity=100;
        velocity= Common.getRandomDouble(2.0,4.0);
        perforation= Common.getRandomDouble(2.0,3.0);
        throwModifier= Common.getRandomDouble(0.5,1.0);
        kineticDamage= Common.getRandomDouble(2.0,3.0);
        thermalDamage= Common.getRandomDouble(2.0,3.0);
        electromagneticDamage= Common.getRandomDouble(2.0,3.0);
        psionicDamage= Common.getRandomDouble(2.0,3.0);
        damageArea= Entity.damageArea.TINY;
    }

    public void displayData(){
        System.out.println("Name: "+name);
        System.out.println("Type: "+type);
        System.out.println("Quantity: "+quantity);
        System.out.println("Velocity: "+velocity);
        System.out.println("Perforation: "+perforation);
        System.out.println("Throw Modifier: "+throwModifier);
        System.out.println("Kinetic Damage: "+kineticDamage);
        System.out.println("Thermal Damage: "+thermalDamage);
        System.out.println("Electromagnetic Damage: "+electromagneticDamage);
        System.out.println("Psionic Damage: "+psionicDamage);
        System.out.println("Damage Area: "+damageArea);
    }

}
