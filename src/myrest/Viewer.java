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
        //Aqui poner lo que iria dentro de un bucle para dibujarse

        for (int i = 0; i < this.arrayClients.length; i++) {
            g.setColor(Color.yellow);
            g.fillRect(this.arrayClients[i].x1, this.arrayClients[i].y1, this.arrayClients[i].x2, this.arrayClients[i].y2);
        }

    }

    @Override
    public void run() {
        //Aqui se crea el bucle poniendo repaint como ejecutar paint()
        while (stoped == false) {
            this.setBackground(Color.GRAY);

            this.repaint();

            try {
                sleep(rate);
            } catch (InterruptedException ex) {
                Logger.getLogger(Viewer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
