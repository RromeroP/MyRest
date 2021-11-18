/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.awt.image.BufferedImage;
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
    int size1;
    int size2;

    Images img_list;
    BufferedImage img;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
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

    public Client(int type, int pace, Table table, int x1, int y1, int size1, int size2, Images img_list) {
        this.type = type;
        this.pace = pace;
        this.table = table;

        this.x1 = x1;
        this.y1 = y1;
        this.size1 = size1;
        this.size2 = size1;

        this.img_list = img_list;
        this.img = img_list.getL_r1();

    }

    public int getType() {
        return type;
    }

    public int getPace() {
        return pace;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void eat() throws InterruptedException {

        //Cogemos el plato
        table.takeMeal();

        //Aqui podriamos empezara la animacion
        while (this.x1 < 660) {
            this.img = this.img_list.getL_r1();

            ++this.x1;
            //Velocidad de movimiento
            sleep(this.pace);
        }

        //Comemos
        sleep(500);

        //Descansamos
        sleep(500);

        while (this.x1 > 430) {
            this.img = this.img_list.getL_l1();

            --this.x1;
            //Velocidad de movimiento
            sleep(this.pace);
        }
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
