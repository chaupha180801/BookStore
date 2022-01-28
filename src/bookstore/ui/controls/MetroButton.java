/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.ui.controls;


import java.awt.*;
import javax.swing.border.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.lang.Math;

/**
 *
 * @author DELL
 */
public class MetroButton extends javax.swing.JButton{
    private Color hoverColor;
    private Color currentHoverColor;
    
    private Color pressedColor;
    private Color currentPressedColor;
    
    private Boolean changeBorder;
    
    
    public MetroButton(){
        super();
        this.initialize();
    }
    
    public MetroButton(String text){
        super(text);
        this.initialize();
    }
    
    protected void initialize(){
        this.setBackground(new Color(78, 43, 114));
        this.setForeground(new Color(255, 255, 255));
        this.setFont(new Font("Sogoe Ui", Font.BOLD, 16));
        this.setOpaque(true);
        this.setFocusPainted(false);
        this.setBorder(null);
        
        this.hoverColor = null;
        this.pressedColor = null;
        this.currentHoverColor = null;
        this.currentPressedColor = null;
        this.changeBorder = false;
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                handleMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                handleMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                handleMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                handleMouseReleased(evt);
            }
        });
    }
    
    protected void handleMousePressed(MouseEvent e){
        if (this.getBorder() == null){
            this.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));
            this.changeBorder = true;
        }
        Color newColor = this.pressedColor;
        
        if (this.pressedColor == null){
            Color currentColor = this.getBackground();
            int currentRed = currentColor.getRed();
            int currentGreen = currentColor.getGreen();
            int currentBlue = currentColor.getBlue();

            int newRed = Math.min(255, currentRed + 50);
            int newGreen = Math.min(255, currentGreen + 50);
            int newBlue = Math.min(255, currentBlue + 50);
            
            newColor = new Color(newRed, newGreen, newBlue);
        }
        
        this.currentPressedColor = this.getBackground();
        this.setBackground(newColor);
    }
    
    protected void handleMouseReleased(MouseEvent e){
        if (this.changeBorder){
            this.setBorder(null);
            this.changeBorder = false;
        }
        
        this.setBackground(this.currentPressedColor);
        this.currentPressedColor = null;
    }
    
    protected void handleMouseEntered(MouseEvent e){
        Color newColor = this.hoverColor;
        
        if (this.hoverColor == null){
            Color currentColor = this.getBackground();
            int currentRed = currentColor.getRed();
            int currentGreen = currentColor.getGreen();
            int currentBlue = currentColor.getBlue();

            int newRed = Math.min(255, currentRed + 20);
            int newGreen = Math.min(255, currentGreen + 20);
            int newBlue = Math.min(255, currentBlue + 20);
            
            newColor = new Color(newRed, newGreen, newBlue);
        }
        
        this.currentHoverColor = this.getBackground();
        this.setBackground(newColor);
    }
    
    protected void handleMouseExited(MouseEvent e){
        this.setBackground(this.currentHoverColor);
        this.currentHoverColor = null;
    }
    
    public void setHoverColor(Color c){
        this.hoverColor = c;
    }
    
    public void setPressedColor(Color c){
        this.pressedColor = c;
    }
}
