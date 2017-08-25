/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flappybird.view;

import com.flappybird.controller.Controller;
import com.flappybird.model.Bird;
import com.flappybird.model.Tube;
import com.flappybird.model.TubeColumn;
import com.flappybird.model.proxy.ProxyImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;
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
    private Bird bird;
    private TubeColumn tubeColumn;

    public Game() {

        proxyImage = new ProxyImage("/assets/background.png");
        background = proxyImage.loadImage().getImage();
        this.setFocusable(true);
        this.setDoubleBuffered(false);
        this.addKeyListener(new GameKeyAdapter());

        Timer timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (isRunning) {
            ////////////////////////////////
            bird.tick();
            tubeColumn.tick();
            
            ///////////////////////////////
        }

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (isRunning) {
            ///////////////////////////////
            g2.drawImage(background, 0, 0, null);
            this.bird.render(g2, this);
            this.tubeColumn.render(g2, this);
            
            ///////////////////////////////
        } else {
            g2.setColor(Color.cyan);
            g2.fillRect(0, 0, Window.WIDTH, Window.HEIGHT);
            g2.setColor(Color.black);
            g2.drawString("Press Enter to Start the Game", Window.WIDTH / 2 - 100, Window.HEIGHT / 2);
        }
        System.out.println(isRunning);
        g.dispose();
    }

    private void restartGame() {
        if (!isRunning) {
            this.isRunning = true;
            this.bird = new Bird(Window.WIDTH / 2, Window.HEIGHT / 2);
            this.tubeColumn = new TubeColumn();
        }
    }

    // Key
    private class GameKeyAdapter extends KeyAdapter {

        private Controller controller;

        public GameKeyAdapter() {
            controller = new Controller();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                restartGame();
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (isRunning) {
                controller.controllerReleased(bird, e);
            }
        }
    }
}
