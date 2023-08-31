package com.example.javafxtest2;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.util.Scanner;

public class Grid {
    Minia[][] myMap;
    int width;
    int height;

    static String mapContent = null;
    static String outputContent = null;

    Scanner scanner = new Scanner(System.in);

    public Grid(int inputWidth, int inputHeight) {
        width = inputWidth;
        height = inputHeight;
        myMap = new Minia[width][height];
        for (int i = 0; i < width-1; i++){
            for (int j = 0; j < height-1; j++){
                myMap[i][j] = null;
            }
        }
    }

    public void addItem(Minia inputItem){
        myMap[inputItem.posY][inputItem.posX] = inputItem;
    }

    public void removeItem(Minia inputItem){
        myMap[inputItem.oldPosY][inputItem.oldPosX] = null;
        System.out.println("Rimosso " + inputItem.name + " da " + inputItem.oldPosX + "," + inputItem.oldPosY);
    }

    public void updatePosition(Minia inputItem){
        myMap[inputItem.posY][inputItem.posX] = inputItem;
        removeItem(inputItem);
    }

    public Boolean checkBoundaries (int inputPosX, int inputPosY){
        if (inputPosX < 0 || inputPosX > width-1 || inputPosY < 0 || inputPosY > height-1){
            return false;
        } else {
            return true;
        }
    }

    public String displayGrid() {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("window1.fxml"));

        window1Controller controller = fxmlLoader.getController();

        for (int i = 0; i < height; i++) {

            if (i%2 == 0) {
                mapContent = mapContent +"    ";
            }

            for (int j = 0; j < width; j++) {
                mapContent = mapContent + "|  " + j + "," + i + "  ";
            }
            mapContent = mapContent + "|\n";

            if (i%2 == 0) {
                mapContent = mapContent +"    ";
            }

            for (int j = 0; j < width; j++) {

                if (myMap[i][j] == null) {
                    mapContent = mapContent +"|       ";
                } else {
                    mapContent = mapContent +"|   " + myMap[i][j].shortName + "  ";
                }
            }
            mapContent = mapContent + "|\n";

            for (int j = 0; j < width; j++) {
                mapContent = mapContent + "+---+---";
            }
            mapContent = mapContent + "+\n";
        }
        return mapContent;
    }

    public int distance (int startX, int startY, int endX, int endY) {
        int distance = 0;
        int aPosX = startX;
        int aPosY = startY;
        int bPosX = endX;
        int bPosY = endY;
        int[] path = new int[2];
        while (aPosX != bPosX || aPosY != bPosY) {
            if (aPosX < bPosX && aPosY < bPosY){
                aPosX++;
                aPosY++;
                distance++;
            } else if (aPosX < bPosX && aPosY > bPosY){
                aPosX++;
                aPosY--;
                distance++;
            } else if (aPosX > bPosX && aPosY < bPosY){
                aPosX--;
                aPosY++;
                distance++;
            } else if (aPosX > bPosX && aPosY > bPosY){
                aPosX--;
                aPosY--;
                distance++;
            } else if (aPosX < bPosX && aPosY == bPosY){
                aPosX++;
                distance++;
            } else if (aPosX > bPosX && aPosY == bPosY){
                aPosX--;
                distance++;
            } else if (aPosX == bPosX && aPosY < bPosY){
                aPosY++;
                distance++;
            } else if (aPosX == bPosX && aPosY > bPosY){
                aPosY--;
                distance++;
            }
        }
        distance ++;
        return distance;
    }

    public Boolean isTargetAtRange(Minia sourceItem, Minia targetItem, int inputThrow) {
        int distance = distance(sourceItem.posX, sourceItem.posY, targetItem.posX, targetItem.posY);
        if (inputThrow >= distance) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isPositionAtRange(Minia sourceItem, int targetPosX, int targetPosY, int inputThrow) {
        int distance = distance(sourceItem.posX, sourceItem.posY, targetPosX, targetPosY);
        if (inputThrow >= distance) {
            return true;
        } else {
            return false;
        }
    }

    public Boolean isEmpty(int inputPosX, int inputPosY){
        if (myMap[inputPosY][inputPosX] == null){
            return true;
        } else {
            return false;
        }
    }

    public void showPosition(Minia inputItem){
        System.out.println("Posizione X: "+inputItem.posX);
        System.out.println("Posizione Y: "+inputItem.posY);
    }

    public void setRandomPosition(Minia inputItem, int inputMaxwidth, int inputMaxheight){
        inputItem.posX = (int) (Math.random() * inputMaxwidth);
        inputItem.posY = (int) (Math.random() * inputMaxheight);
    }

    public void setStartingPosition(Minia inputItem, char side){
        int leftSideRandomX = (int) (Math.random() * 3);
        int leftSideRandomY = (int) (Math.random() * height);

        int rightSideRandomX = (int) (width - (Math.random() * 3));
        int rightSideRandomY = (int) (Math.random() * height);

        if (side == 'l'){
            while  (isEmpty(leftSideRandomX, leftSideRandomY) == false){
                leftSideRandomX = (int) (Math.random() * 3);
                leftSideRandomY = (int) (Math.random() * height);
            }
            inputItem.posX = leftSideRandomX;
            inputItem.posY = leftSideRandomY;

        } else if (side == 'r'){
            while  (isEmpty(rightSideRandomX, rightSideRandomY) == false){
                rightSideRandomX = (int) (width - (Math.random() * 3));
                rightSideRandomY = (int) (Math.random() * height);
            }
            inputItem.posX = rightSideRandomX;
            inputItem.posY = rightSideRandomY;
        }

    }

    public void reposition(Minia inputItem){
        System.out.print("Nuova posizione X : ");
        int toBeCheckedPosX = scanner.nextInt();
        System.out.println();
        System.out.print("Nuova posizione Y : ");
        int toBeCheckedPosY = scanner.nextInt();
        System.out.println();
        if (Entity.myGrid.checkBoundaries(toBeCheckedPosX, toBeCheckedPosY)){
            inputItem.oldPosY = inputItem.posY;
            inputItem.oldPosX = inputItem.posX;
            inputItem.posX = toBeCheckedPosX;
            inputItem.posY = toBeCheckedPosY;
            removeItem(inputItem);
        } else {
            System.out.println("Posizione non valida");
        }
    }



    public Boolean moveNW (Minia inputItem) {
        boolean isEven = (inputItem.posY % 2 == 0);
        if (isEven) {
            if (checkBoundaries(inputItem.posX, inputItem.posY - 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posY--;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        } else {
            if (checkBoundaries(inputItem.posX - 1, inputItem.posY - 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posX--;
                inputItem.posY--;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        }
    }

    public Boolean moveNE (Minia inputItem) {
        boolean isEven = (inputItem.posY % 2 == 0);
        if (isEven) {
            if (checkBoundaries(inputItem.posX + 1, inputItem.posY - 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posX++;
                inputItem.posY--;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        } else {
            if (checkBoundaries(inputItem.posX, inputItem.posY - 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posY--;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        }
    }

    public Boolean moveE(Minia inputItem) {
        if (checkBoundaries(inputItem.posX+1, inputItem.posY)){
            inputItem.oldPosX = inputItem.posX;
            inputItem.oldPosY = inputItem.posY;
            inputItem.posX++;
            System.out.println("Vecchia posizione: "+inputItem.oldPosX+","+inputItem.oldPosY);
            System.out.println("Nuova posizione: "+inputItem.posX+","+inputItem.posY);
            return true;
        } else {
            System.out.println("Posizione non valida");
            return false;
        }
    }

    public Boolean moveW(Minia inputItem) {
        if (checkBoundaries(inputItem.posX-1, inputItem.posY)){
            inputItem.oldPosX = inputItem.posX;
            inputItem.oldPosY = inputItem.posY;
            inputItem.posX--;
            System.out.println("Vecchia posizione: "+inputItem.oldPosX+","+inputItem.oldPosY);
            System.out.println("Nuova posizione: "+inputItem.posX+","+inputItem.posY);
            return true;
        } else {
            System.out.println("Posizione non valida");
            return false;
        }
    }

    public Boolean moveSW (Minia inputItem) {
        boolean isEven = (inputItem.posY % 2 == 0);
        if (isEven) {
            if (checkBoundaries(inputItem.posX, inputItem.posY + 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posY++;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        } else {
            if (checkBoundaries(inputItem.posX-1, inputItem.posY+1)){
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posX--;
                inputItem.posY++;
                System.out.println("Vecchia posizione: "+inputItem.oldPosX+","+inputItem.oldPosY);
                System.out.println("Nuova posizione: "+inputItem.posX+","+inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        }
    }

    public Boolean moveSE (Minia inputItem) {
        boolean isEven = (inputItem.posY % 2 == 0);
        if (isEven) {
            if (checkBoundaries(inputItem.posX+1, inputItem.posY + 1)) {
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posX++;
                inputItem.posY++;
                System.out.println("Vecchia posizione: " + inputItem.oldPosX + "," + inputItem.oldPosY);
                System.out.println("Nuova posizione: " + inputItem.posX + "," + inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        } else {
            if (checkBoundaries(inputItem.posX, inputItem.posY+1)){
                inputItem.oldPosX = inputItem.posX;
                inputItem.oldPosY = inputItem.posY;
                inputItem.posY++;
                System.out.println("Vecchia posizione: "+inputItem.oldPosX+","+inputItem.oldPosY);
                System.out.println("Nuova posizione: "+inputItem.posX+","+inputItem.posY);
                return true;
            } else {
                System.out.println("Posizione non valida");
                return false;
            }
        }
    }
}
