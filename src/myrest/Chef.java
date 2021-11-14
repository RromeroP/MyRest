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
public class Chef extends Thread {

    int type;
    int pace;
    Table table;
    int x1;
    int y1;
    int size1;
    int size2;

    public Chef(int type, int pace, Table table, int x1, int y1, int size1, int size2) {
        this.type = type;
        this.pace = pace;
        this.table = table;
        this.x1 = x1;
        this.y1 = y1;
        this.size1 = size1;
        this.size2 = size2;
    }

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

    public int getSize1() {
        return size1;
    }

    public void setSize1(int size1) {
        this.size1 = size1;
    }

    public int getSize2() {
        return size2;
    }

    public void setSize2(int size2) {
        this.size2 = size2;
    }

    public int getType() {
        return type;
    }

    public int getPace() {
        return pace;
    }

    public void cook() throws InterruptedException {
        //Cocinamos
        sleep(500);

        //Movemos al cocinero a la mesa
        while (this.x1 < 320) {
            ++this.x1;
            //Velocidad de movimiento
            sleep(this.pace);
        }

        //Colocamos el plato
        table.placeMeal();

        //Descansamos
        sleep(500);

        while (this.x1 > 80) {
            --this.x1;
            //Velocidad de movimiento
            sleep(this.pace);
        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                cook();
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
