/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flappybird.controller;

import com.flappybird.model.Bird;
import java.awt.event.KeyEvent;

/**
 *
 * @author derickfelix
 */
public interface IStrategy {
    
    public void controller(Bird bird, KeyEvent kevent);
    public void controllerReleased(Bird bird, KeyEvent kevent);
}
