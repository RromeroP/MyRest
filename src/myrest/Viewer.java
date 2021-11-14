/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dam
 */
public class Viewer extends Canvas implements Runnable {

    private final Canvas canvas;
    int rate;
    boolean paused = false;
    boolean stoped = false;
    Table table;
    Chef[] arrayChefs;
    Client[] arrayClients;

    public Viewer(Dimension size, Table table, Chef[] arrayChefs, Client[] arrayClients) {

        this.table = table;
        this.arrayChefs = arrayChefs;
        this.arrayClients = arrayClients;

        this.canvas = new Canvas();

        this.canvas.setPreferredSize(size);
        this.canvas.setMaximumSize(size);
        this.canvas.setMinimumSize(size);
    }

    public Canvas getCanvas() {
        return this;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setStoped(boolean stoped) {
        this.stoped = stoped;
    }

    @Override
    public void paint(Graphics g) {

        //Dibujamos la cocina
        g.setColor(Color.BLACK);
        g.fillRect(25, 25, table.getSize1(), table.getSize2());

        //Dibujamos la cocina
        g.setColor(Color.BLACK);
        g.fillRect(715, 25, table.getSize1(), table.getSize2());

        //Dibujamos la mesa
        g.setColor(Color.DARK_GRAY);
        g.fillRect(table.getX1(), table.getY1(), table.getSize1(), table.getSize2());

        //Dibujamos los platos
        for (int i = 0; i < table.getQuantity(); i++) {
            g.setColor(Color.WHITE);

            if (i % 2 == 0) {
                g.fillOval(table.getX1() + 25, table.getY1() + 5 + (31 * i), 20, 20);
            } else {
                g.fillOval(table.getX1() + 5, table.getY1() + 5 + (31 * i), 20, 20);
            }

        }

        //Dibujamos los clientes
        for (int i = 0; i < this.arrayClients.length; i++) {
            g.setColor(Color.yellow);
            g.fillOval(arrayClients[i].getX1(), arrayClients[i].getY1(), arrayClients[i].getSize1(), arrayClients[i].size2);
        }

        //Dibujamos los chefs
        for (int i = 0; i < this.arrayChefs.length; i++) {
            g.setColor(Color.red);
            g.fillOval(arrayChefs[i].getX1(), arrayChefs[i].getY1(), arrayChefs[i].getSize1(), arrayChefs[i].size2);
        }

    }

    @Override
    public void run() {
        //Aqui se crea el bucle poniendo repaint como ejecutar paint()
        while (stoped == false) {
            this.repaint();

            try {
                sleep(rate);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
