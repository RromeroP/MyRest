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

    public Table(int type, int quantity, int capacity) {
        this.type = type;
        this.quantity = quantity;
        this.capacity = capacity;
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

        if (this.quantity < this.capacity) {
            //Aqui coloca el plato
            ++this.quantity;
            notifyAll();
        } else {
            wait();
        }

    }

    public synchronized void takeMeal() throws InterruptedException {

        if (this.quantity > 0) {
            //Aqui coge el plato
            --this.quantity;
            notifyAll();
        } else {
            wait();
        }
    }

    @Override
    public void run() {

    }

}
