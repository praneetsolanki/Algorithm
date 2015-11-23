/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;

/**
 *
 * @author Praneet
 */
public class PathNode {
    
    public PathNode nextPath;
    
    public int confidence;
    public int distance;
    public int fuelConsumed;
    
    public ArrayList<Node> nodesInPath;

    public PathNode() {
        confidence=0;
        distance=0;
        fuelConsumed=0;
    nodesInPath = new ArrayList<Node>();    
    }

public void addNodeInNodesInPath(Node node)
{
    nodesInPath.add(node);
}
    public PathNode getNextPath() {
        return nextPath;
    }

    public void setNextPath(PathNode nextPath) {
        this.nextPath = nextPath;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public ArrayList<Node> getNodesInPath() {
        return nodesInPath;
    }

    public void setNodesInPath(ArrayList<Node> nodesInPath) {
        this.nodesInPath = nodesInPath;
    }

    public int getFuelConsumed() {
        return fuelConsumed;
    }

    public void setFuelConsumed(int fuelConsumed) {
        this.fuelConsumed = fuelConsumed;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
   
    
}
