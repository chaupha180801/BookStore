/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.ui.controls;

/**
 *
 * @author DELL
 */
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Graphics2D;
import java.awt.BasicStroke;

import javax.swing.border.Border;

public class RoundedBorder implements Border {  
    private final int radius;
        
    public RoundedBorder(int radius) {
        this.radius = radius;
    }
    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(this.radius+1, this.radius+1, this.radius+2, this.radius);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(4));
        g2.setColor(java.awt.Color.WHITE);
       
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
    }
}
