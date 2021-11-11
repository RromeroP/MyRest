/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Rex
 */
public class MyRest {

    /**
     * @param args the command line arguments
     */
    private static JFrame frame;
    private static final String TITLE = "My Rest";
    private static final int WIDTH = 800;
    private static final int HEIGHT = 400;
    private static final Dimension SIZE = new Dimension(WIDTH, HEIGHT);

    public static void main(String[] args) {
        // TODO code application logic here
        Table table1 = new Table(1, 0, 10);
        table1.start();

        Chef chef1 = new Chef(1, 500, table1);
        Chef chef2 = new Chef(2, 600, table1);
        Chef chef3 = new Chef(3, 500, table1);

        chef1.start();
        chef2.start();
        chef3.start();

        Client client1 = new Client(1, 500, table1, 25, 25, 50, 50);
        Client client2 = new Client(2, 600, table1, 75, 75 , 50, 50);
        client1.start();
        client2.start();

        Chef[] arrayChefs = {chef1, chef2, chef3};
        Client[] arrayClients = {client1, client2};

        frame = new JFrame(TITLE);
        frame.setPreferredSize(SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Viewer viewer = new Viewer(SIZE, table1, arrayChefs, arrayClients);
        viewer.setRate(5);

        frame.add(viewer.getCanvas());

        frame.pack();
        frame.setVisible(true);

        viewer.run();
    }

}
