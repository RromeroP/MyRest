/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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

    public static void main(String[] args) throws IOException {

        // TODO code application logic here
        Table table1 = new Table(1, 0, 10, WIDTH / 2 - 25, 25, 50, HEIGHT - 90);
        table1.start();

        Images img_list = new Images();

        Chef chef1 = new Chef(1, 5, table1, 100, ((HEIGHT - 90) / 5) * 1 - 30, 45, 45, img_list);
        Chef chef2 = new Chef(2, 10, table1, 100, ((HEIGHT - 90) / 5) * 2 - 30, 45, 45, img_list);
        Chef chef3 = new Chef(3, 15, table1, 100, ((HEIGHT - 90) / 5) * 3 - 30, 45, 45, img_list);
        Chef chef4 = new Chef(4, 20, table1, 100, ((HEIGHT - 90) / 5) * 4 - 30, 45, 45, img_list);
        Chef chef5 = new Chef(5, 25, table1, 100, ((HEIGHT - 90) / 5) * 5 - 30, 45, 45, img_list);

        chef1.start();
        chef2.start();
        chef3.start();
        chef4.start();
        chef5.start();

        Client client1 = new Client(1, 10, table1, WIDTH / 2 + 50, ((HEIGHT - 90) / 5) * 1 - 30, 45, 45, img_list);
        Client client2 = new Client(2, 15, table1, WIDTH / 2 + 50, ((HEIGHT - 90) / 5) * 2 - 30, 45, 45, img_list);
        Client client3 = new Client(3, 20, table1, WIDTH / 2 + 50, ((HEIGHT - 90) / 5) * 3 - 30, 45, 45, img_list);
        Client client4 = new Client(4, 25, table1, WIDTH / 2 + 50, ((HEIGHT - 90) / 5) * 4 - 30, 45, 45, img_list);
        Client client5 = new Client(5, 30, table1, WIDTH / 2 + 50, ((HEIGHT - 90) / 5) * 5 - 30, 45, 45, img_list);

        client1.start();
        client2.start();
        client3.start();
        client4.start();
        client5.start();

        Chef[] arrayChefs = {chef1, chef2, chef3, chef4, chef5};
        Client[] arrayClients = {client1, client2, client3, client4, client5};

        frame = new JFrame(TITLE);
        frame.setPreferredSize(SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Viewer viewer = new Viewer(SIZE, table1, arrayChefs, arrayClients, img_list);
        viewer.setRate(50);

        frame.add(viewer.getCanvas());

        frame.pack();
        frame.setVisible(true);

        viewer.run();
    }

}
