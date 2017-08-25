/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flappybird.model;

import com.flappybird.view.Window;
import java.awt.Graphics2D;

import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author derickfelix
 */
public class TubeColumn {

    private int base = Window.HEIGHT - 60;

    private List<Tube> tubes;
    private Random random;

    public TubeColumn() {
        tubes = new ArrayList<>();
        random = new Random();
        initTubes();
    }

    private void initTubes() {

        int last = base;
        int randWay = random.nextInt(10);
        
        for (int i = 0; i < 20; i++) {

            Tube tempTube = new Tube(900, last);

            last = tempTube.getY() - tempTube.getHeight();
            if (i < randWay || i > randWay + 3) {
                tubes.add(tempTube);
            }

        }

    }

    public void tick() {
        
        for (int i = 0; i < tubes.size(); i++) {
            tubes.get(i).tick();
            
            if(tubes.get(i).getX() < 0) {
                tubes.remove(tubes.get(i));
            }
        }
        if(tubes.isEmpty()) {
            initTubes();
        }
        
    }

    public void render(Graphics2D g, ImageObserver obs) {
        for (int i = 0; i < tubes.size(); i++) {
            tubes.get(i).render(g, obs);
        }

    }

}
