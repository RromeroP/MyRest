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

    public Client(int type, int pace, Table table) {
        this.type = type;
        this.pace = pace;
        this.table = table;
    }

    public int getType() {
        return type;
    }

    public int getPace() {
        return pace;
    }

    @Override
    public void run() {

        while (true) {
            try {
                //Cogemos la comida de la mesa
                table.takeMeal(this);
            } catch (InterruptedException ex) {
                Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
