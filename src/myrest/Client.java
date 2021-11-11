/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rex
 */
public class Client extends Thread {

    int type;
    int pace;
    Table table;

    //Prueba para dibujar
    int x1;
    int y1;
    int x2;
    int y2;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Client(int type, int pace, Table table, int x1, int y1, int x2, int y2) {
        this.type = type;
        this.pace = pace;
        this.table = table;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int getType() {
        return type;
    }

    public int getPace() {
        return pace;
    }

    public void eat() throws InterruptedException {

        //Cogemos el plato
        table.takeMeal();
        System.out.println("Client " + this.type + ": " + table.getQuantity());

        //Comemos
        sleep(this.pace);
        
        ++this.x1;
        ++this.y1;

        //Descansamos
        sleep(this.pace);
    }

    @Override
    public void run() {

        while (true) {
            try {
                eat();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
