/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.Hashtable;
import Business.Drone;
import java.util.ArrayList;
/**
 *
 * @author Praneet
 */
public class MachineLearning {
    
    private static MachineLearning machineL;
    public Hashtable<Node,PathLinkedList> dataSet;
    
    //Using Singlton Design Pattern
    public  static MachineLearning getInstance() {
        if (machineL == null) {
            machineL = new MachineLearning();
        }
        return machineL;
    } MachineLearning()
    {
        dataSet = new Hashtable<>();
   
    }


    
}
