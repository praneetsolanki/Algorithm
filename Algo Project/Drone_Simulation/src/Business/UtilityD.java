/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import javax.swing.JLabel;
import sun.util.calendar.CalendarUtils;

/**
 *
 * @author Praneet
 */
public final class UtilityD {
    
    

// This method creates two types of anomalies. The anomalies are hight intensity where drone cannot go and needs to change its path, eample drone face an obstacle and needs to change the path. The other 
// anomaly is low intensity anomaly, example wind in opposite direction of drone flight.Drone will travel throughthe wind but this will consume more fuel
 //This method is called every second to create anomalies on nodes.   
    public static void createAnomalies(HashMap<String,Node>  map)
    {
        int anomalyCount = 0+( int )( Math.random() * 300 );
        
        for(int i=0;i<=anomalyCount;i++)
        {   
      int xNum=  0+( int )( Math.random() * 20 );
      int yNum=  0+( int )( Math.random() * 20 );
    StringBuffer sb = new StringBuffer();
    sb.append(getStringFromDigit(xNum));
    sb.append(getStringFromDigit(yNum).substring(0, 1).toUpperCase() );
    sb.append( getStringFromDigit(yNum).substring(1));
            
    Node n = map.get(sb.toString());
    
    if((xNum+yNum)%3==0)
    {
        n.setLowIntesity(true);
        //n.setAnomalyExists(true);
    }
    else{
        n.setAnomalyExists(true);
   
   
    }
    
   // n.setAnomalyExists(true);
        }
    }
    
    //this method is called every second to delete the previously created anomalies.
    public static void deleteAnomalies(HashMap<String, Node> map)
    {
       Collection<Node> nodeList = map.values();
        for(Node n: nodeList)
        {
            if(n.isAnomalyExists()==true || n.isLowIntesity()==true)
            {
                n.setAnomalyExists(false);
                n.setLowIntesity(false);
                
            }
        }
        
    }
    
     public static void clearTraversedPath(HashMap<String, Node> map)
    {
       Collection<Node> nodeList = map.values();
        for(Node n: nodeList)
        {
            if(n.isTraversed==true )
            {
                n.isTraversed=false;
                
            }
        }
        
    }
    
    public static HashMap<String, Node> addNodes()
    {
        HashMap<String, Node> nodeComponentsMap = new HashMap();
        
        for(int i=0;i<20;i++)
        {for(int j=0;j<20;j++)
        {       
              
        StringBuffer sb = new StringBuffer();
        String xC = UtilityD.getStringFromDigit(i);
        String yC =UtilityD.getStringFromDigit(j);
        
        sb.append(xC);
        sb.append(yC.substring(0, 1).toUpperCase() );
        sb.append( yC.substring(1));
        Node node = new Node(xC,yC.substring(0, 1).toUpperCase()+yC.substring(1),i,j);
           
          //  System.out.println(" "+ sb.toString());
            nodeComponentsMap.put(sb.toString(), node);
       
        }
        }
        return nodeComponentsMap;
    }
    
    
    //This method is just to print the paths stored in dataset of Machinelearned paths.
    
    public static void printMap(Hashtable<Node, PathLinkedList> mapOfNode) {
       
        for (HashMap.Entry<Node, PathLinkedList> entry : mapOfNode.entrySet()) {
            
            Node node=entry.getKey();
            System.err.println("KEY:"+node.getxCordinate()+node.getyCordinate());
            PathLinkedList link=mapOfNode.get(node);
              PathNode tmp = link.front;
        while(tmp != null){

               for(Node node1:tmp.getNodesInPath()){
                   System.out.print(node.getxCordinate()+node.getyCordinate()+"\t");
               }
            System.out.println(tmp.getNodesInPath());
            tmp = tmp.getNextPath();

        }
      }
   }
    

    
   //this method is to get coordinates (node) name by providing node coordinates. 
    //Mainly used to access the jlable components which represent nodes in mainframe
   public static void setAnomalyColor(JLabel jlabel, Node node){
                    if (node.isAnomalyExists()) {

                        jlabel.setForeground(Color.RED);

                    } else if (node.isLowIntesity()) {
                        jlabel.setForeground(Color.ORANGE);
                    } else {
                        jlabel.setForeground(Color.BLACK);
                    }
                    if (node.isIsTraversed()) {
                        jlabel.setForeground(Color.BLUE);
                    }
                }
        
    
   public static void colorSearchPath(PathNode searchPath)
    {
        for (Node n:searchPath.getNodesInPath())
        {
           JLabel jlabel = (JLabel)n.getjLable();
           jlabel.setForeground(Color.WHITE);
        }
    }
    
   public static String getStringFromDigit(int digit) {

        String digitToString = "";
        switch (digit) {
            case 0:
                digitToString = "zero";
                break;
            case 1:
                digitToString = "one";
                break;
            case 2:
                digitToString = "two";
                break;
            case 3:
                digitToString = "three";
                break;
            case 4:
                digitToString = "four";
                break;
            case 5:
                digitToString = "five";
                break;
            case 6:
                digitToString = "six";
                break;
            case 7:
                digitToString = "seven";
                break;
            case 8:
                digitToString = "eight";
                break;
            case 9:
                digitToString = "nine";
                break;
            case 10:
                digitToString = "ten";
                break;
            case 11:
                digitToString = "eleven";
                break;
            case 12:
                digitToString = "twelve";
                break;
            case 13:
                digitToString = "thirteen";
                break;
            case 14:
                digitToString = "fourteen";
                break;
            case 15:
                digitToString = "fifteen";
                break;
            case 16:
                digitToString = "sixteen";
                break;
            case 17:
                digitToString = "seventeen";
                break;
            case 18:
                digitToString = "eighteen";
                break;
            case 19:
                digitToString = "nineteen";
                break;
            default:
                digitToString = "Invalid month";
                break;
        }
        return digitToString;

    }
    
    
}
