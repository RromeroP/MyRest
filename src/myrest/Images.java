/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myrest;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Rex
 */
public class Images {

    BufferedImage floor;

    BufferedImage food;

    BufferedImage chef[];

    BufferedImage l_r1;
    BufferedImage l_r2;

    BufferedImage l_l1;
    BufferedImage l_l2;

    public Images() throws IOException {
        this.floor = ImageIO.read(new File("src\\img\\floor.png"));

        this.food = ImageIO.read(new File("src\\img\\food.png"));

        this.chef = new BufferedImage[]{
            ImageIO.read(new File("src\\img\\chef_wait_l.png")),
            ImageIO.read(new File("src\\img\\chef_wait_r.png")),
            ImageIO.read(new File("src\\img\\chef_rigth.png")),
            ImageIO.read(new File("src\\img\\chef_left.png"))
        };

        this.l_r1 = ImageIO.read(new File("src\\img\\r_1.png"));
        this.l_r2 = ImageIO.read(new File("src\\img\\r_2.png"));

        this.l_l1 = ImageIO.read(new File("src\\img\\l_1.png"));
        this.l_l2 = ImageIO.read(new File("src\\img\\l_2.png"));
    }

    public BufferedImage getFloor() {
        return floor;
    }

    public BufferedImage getFood() {
        return food;
    }

    public BufferedImage[] getChef() {
        return chef;
    }

    public BufferedImage getL_r1() {
        return l_r1;
    }

    public BufferedImage getL_r2() {
        return l_r2;
    }

    public BufferedImage getL_l1() {
        return l_l1;
    }

    public BufferedImage getL_l2() {
        return l_l2;
    }

}
