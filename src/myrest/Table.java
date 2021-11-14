/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

/**
 *
 * @author Rex
 */
public class Table extends Thread {

    int type;
    int quantity;
    int capacity;
    int x1;
    int y1;
    int size1;
    int size2;

    public Table(int type, int quantity, int capacity, int x1, int y1, int size1, int size2) {
        this.type = type;
        this.quantity = quantity;
        this.capacity = capacity;
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

    public int getQuantity() {
        return quantity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public synchronized void placeMeal() throws InterruptedException {

        while (this.quantity >= this.capacity) {
            wait();
        }
        
        //Ponemos el plato
        ++this.quantity;
        sleep(50);
        notify();

    }

    public synchronized void takeMeal() throws InterruptedException {

        while (this.quantity == 0) {
            wait();
        }
        //Aqui coge el plato
        --this.quantity;
        notify();

    }

    @Override
    public void run() {

    }

}
