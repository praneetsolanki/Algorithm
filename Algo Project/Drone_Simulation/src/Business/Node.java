/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import javax.swing.JLabel;

/**
 *
 * @author Praneet
 */
public class Node {
 
    String xCordinate;
    String yCordinate;
    int x;
    int y;
    boolean anomalyExists;
    boolean lowIntesity;
    boolean isTraversed;
    JLabel jLable;
    
    public Node(String xC, String yC, int x, int y)
            {
                xCordinate=xC;
                yCordinate=yC;
                this.x=x;
                this.y=y;
                isTraversed=false;
            }

    public String getxCordinate() {
        return xCordinate;
    }

    public void setxCordinate(String xCordinate) {
        this.xCordinate = xCordinate;
    }

    public String getyCordinate() {
        return yCordinate;
    }

    public void setyCordinate(String yCordinate) {
        this.yCordinate = yCordinate;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JLabel getjLable() {
        return jLable;
    }

    public void setjLable(JLabel jLable) {
        this.jLable = jLable;
    }

    public boolean isAnomalyExists() {
        return anomalyExists;
    }

    public void setAnomalyExists(boolean anomalyExists) {
        this.anomalyExists = anomalyExists;
    }

    public boolean isLowIntesity() {
        return lowIntesity;
    }

    public void setLowIntesity(boolean lowIntesity) {
        this.lowIntesity = lowIntesity;
    }

    public boolean isIsTraversed() {
        return isTraversed;
    }

    public void setIsTraversed(boolean isTraversed) {
        this.isTraversed = isTraversed;
    }

    
    
    
    @Override
    public String toString() {
        return  xCordinate + yCordinate;
    }
    
    
    
}
