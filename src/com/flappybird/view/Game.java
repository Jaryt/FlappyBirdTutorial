/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flappybird.view;

import com.flappybird.model.ProxyImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author derickfelix
 */
public class Game extends JPanel implements ActionListener {

    private boolean isRunning = false;
    private ProxyImage proxyImage;
    private Image background;

    public Game() {

        proxyImage = new ProxyImage("/assets/background.png");
        background = proxyImage.loadImage().getImage();

        this.setFocusable(true);
        this.setDoubleBuffered(false);
        this.addKeyListener(new GameKeyAdapter());
        this.isRunning = true;
        Timer timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            ////////////////////////////////

            ///////////////////////////////
        }
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (isRunning) {
            ///////////////////////////////
            g2.drawImage(background, 0, 0, null);
            ///////////////////////////////
        }
        g.dispose();
    }

    // Key
    private class GameKeyAdapter extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                System.out.println("enter");
            }
        }
    }
}
