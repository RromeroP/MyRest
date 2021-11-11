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

    public synchronized void placeMeal(Chef chef) throws InterruptedException {

        while (this.quantity >= this.capacity) {
            wait();
        }

        //La velocidad a la que cocina la determinamos aqui
        sleep(chef.pace);

        //Aqui coloca el plato
        ++this.quantity;

        System.out.println("Chef " + chef.type + ": " + this.quantity);

        notify();

    }

    public synchronized void takeMeal(Client client) throws InterruptedException {
        while (this.quantity == 0) {
            wait();
        }

        //Aqui coge el plato
        --this.quantity;

        //La velocidad a la que come la determinamos aqui
        sleep(client.pace);

        System.out.println("Client " + client.type + ": " + this.quantity);
        notify();
    }

    @Override
    public void run() {

    }

}
