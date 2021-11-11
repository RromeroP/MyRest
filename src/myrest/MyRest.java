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
public class MyRest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Table table1 = new Table(1, 0, 10);
        table1.start();

        Chef chef1 = new Chef(1, 500, table1);
        Chef chef2 = new Chef(2, 600, table1);

        chef1.start();
        chef2.start();

        Client client1 = new Client(1, 500, table1);
        client1.start();
        
    }

}
