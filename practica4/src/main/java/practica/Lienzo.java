/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author gioel
 */
public class Lienzo extends JPanel {
    
    private Color backgroundColor;
    private Color foregroundColor;
    private int numberPoints;
    private int delay;
    private final ArrayList<Point> points;
    private int size;
    
    public Lienzo (){
        this.backgroundColor = Color.white;
        this.foregroundColor = Color.black;
        this.numberPoints = 5;
        this.delay = 1;
        this.size = 10;
        this.points = new ArrayList<>();
    }
    @Override 
    public void paintComponent (Graphics g){
        super.paintComponent(g);
        
        this.setBackground(backgroundColor);
        this.setForeground(foregroundColor);
        for(Point p : points){
            g.fillOval(p.x, p.y, size, size);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException ex) {
                Logger.getLogger(Lienzo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void addPoint (Point p){
        points.add(p);
    }
    
    public void removePoint (){
        if (points.size()> numberPoints)
            points.remove(0);
    }
    
    public void changeDelay (int delay){
        this.delay = delay;
        
    }
    
    public void change_background (Color color){
        this.backgroundColor= color;
        this.setBackground(backgroundColor);

    }
    
    public void change_foreground (Color color){
        this.foregroundColor= color;
        this.setForeground(foregroundColor);
    }
    
}
