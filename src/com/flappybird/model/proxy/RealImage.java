/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flappybird.model.proxy;

import javax.swing.ImageIcon;

/**
 *
 * @author derickfelix
 */
public class RealImage implements IImage {

    private final String src;
    private ImageIcon imageIcon;
    
    public RealImage(String src) {
        this.src = src;
    }
    @Override
    public ImageIcon loadImage() {
        if(imageIcon == null) {
            this.imageIcon = new ImageIcon(getClass().getResource(src));
        }
        return imageIcon;
    }
    
}
