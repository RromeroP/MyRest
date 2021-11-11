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

    public Chef(int type, int pace, Table table) {
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
                
                //Añadimos la comida a la mesa
                table.placeMeal(this);
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Chef.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
