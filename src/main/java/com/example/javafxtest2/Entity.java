package com.example.javafxtest2;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class Entity {


    public static int width = 10;
    public static int height = 10;

    public static Minia[] mapItems = new Minia[2];
    public static Grid myGrid = new Grid(width, height);

    static Minia[][] targets = new Minia[2][20];
    static Player[] players = new Player[2];
    static Method[][] actionMethods = new Method[2][20];
    static Object[][] actionObjects = new Object[2][20];
    static Parameter[][][] actionParameters = new Parameter[2][20][5];
    static String[][] actionNames = new String[2][20];
    static Timeline gameTimeline = new Timeline();

    public enum resources {
        Luminitea,
        Terrafluorite,
        Omegastone,
        Vexagem,
    }

    public enum damageType{
        kinetic,
        electroagnetic,
        thermal,
        psionic,
    }

    public enum fieldView {
        VIEW_30(30),
        VIEW_60(60),
        VIEW_90(90),
        VIEW_180(180),
        VIEW_360(360);

        private int degrees;

        private fieldView(int degrees) {
            this.degrees = degrees;
        }

        public int getDegrees() {
            return degrees;
        }
    }

    public enum volleyShape {
        LINE(1),
        NARROW(2),
        WIDE(4),
        BROAD(8);

        private int width;

        private volleyShape(int width) {
            this.width = width;
        }

        public int getWidth() {
            return width;
        }

    }

    public enum damageArea {
        PINPOINT(1),
        TINY(2),
        SMALL(4),
        MEDIUM(8),
        LARGE(16),
        HUGE(32);

        private int radius;

        private damageArea(int radius) {
            this.radius = radius;
        }

        public int getRadius() {
            return radius;
        }

    }

    public enum food {
        Groteine,
        Tensolifati,
        Mexarali,
        Macromine,
    }

    public enum clan {
        Zuolan,
        Vigardia,
        Noondoom,
        Idominia,
        Avax,
    }



    // PLAYER 1
    static Player player1 = new Player("Michele");
    static AmmoMachinegun ammo01 = new AmmoMachinegun("Munizioni 1");
    static AmmoMachinegun ammo02 = new AmmoMachinegun("Munizioni 2");
    static MMachinegun mitragliaGialla = new MMachinegun("Mitraglia Gialla", "1a", ammo01);
    static MMachinegun mitragliaRossa = new MMachinegun("Mitraglia Rossa","1b",ammo02 );
    static TMedium p1Titano = new TMedium("Kajiu Ciccio", mitragliaGialla, mitragliaRossa);

    // PLAYER 2
    static Player player2 = new Player("Lele");
    static AmmoMachinegun ammo03 = new AmmoMachinegun("Munizioni 3");
    static AmmoMachinegun ammo04 = new AmmoMachinegun("Munizioni 4");
    static MMachinegun mitragliaAlta = new MMachinegun("Mitraglia Alta", "2a", ammo03);
    static MMachinegun mitragliaBassa = new MMachinegun("Mitraglia Bassa","2b", ammo04);
    static TMedium p2Titano = new TMedium("Kajiu Secco", mitragliaAlta, mitragliaBassa);

}
