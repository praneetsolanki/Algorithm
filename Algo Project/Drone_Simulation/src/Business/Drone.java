/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Praneet
 *
 * This class represent a drone.It has all the functions which a drone needs to
 * traverse to a path
 */
public class Drone {

    private static Drone drone;
    private Node currentNode;
    private Node previousNode;
    private Node sourceNode;
    private Node destinationNode;
    public ArrayList<Node> currentPath;
    private Node nodeAfterAnomaly;
    private int fule;
    public ArrayList<Node> traversedPath;
    public ArrayList<Node> traversedPathAfterAnomaly;

    HashMap<String, Node> nodeComponentsMap;

    private Drone() {

        nodeComponentsMap = UtilityD.addNodes();
        fule = 100;
        currentPath = new ArrayList<>();
        traversedPath = new ArrayList<>();
        traversedPathAfterAnomaly = new ArrayList<>();
    }

    //Using Singlton Design Pattern
    public static Drone getInstance() {
        if (drone == null) {
            drone = new Drone();
        }
        return drone;
    }

    public ArrayList<Node> getTraversedPath() {
        return traversedPath;
    }

    public void setTraversedPath(ArrayList<Node> traversedPath) {
        this.traversedPath = traversedPath;
    }

    public ArrayList<Node> getTraversedPathAfterAnomaly() {
        return traversedPathAfterAnomaly;
    }

    public void setTraversedPathAfterAnomaly(ArrayList<Node> traversedPathAfterAnomaly) {
        this.traversedPathAfterAnomaly = traversedPathAfterAnomaly;
    }

    /*Method to find all the nodes adjecent to the current node. This returns a list of nodes
    which sorrounds the current node. With this list we determine which is the next best node(closest to destination
    and with no anomalies) to traverse*/
    public ArrayList<Node> getAdjacentNodes(Node currentNode) {
        ArrayList<Node> adjacentNodeList = new ArrayList<>();
        int x = currentNode.getX();
        int y = currentNode.getY();

        if (x == 0 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (x == 19 && y == 0) {
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        } else if (x == 0 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else if (x == 19 && y == 19) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));

        } else if (x == 0 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (y == 0 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));

        } else if (x == 19 && (y > 0 || y < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));

        } else if (y == 19 && (x > 0 || x < 19)) {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));

        } else {

            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y - 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x + 1, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x, y + 1));
            adjacentNodeList.add(returnNodeFromCoOrdinates(x - 1, y + 1));

        }
        return adjacentNodeList;
    }

    public Node returnNodeFromCoOrdinates(int x, int y) {
        String xCoOrdinate = UtilityD.getStringFromDigit(x);
        String yCoOrdinate = UtilityD.getStringFromDigit(y).substring(0, 1).toUpperCase() + UtilityD.getStringFromDigit(y).substring(1);
        StringBuilder sb = new StringBuilder();
        sb.append(xCoOrdinate);
        sb.append(yCoOrdinate);
        Node node = nodeComponentsMap.get(sb.toString());
        return node;

    }

    public ArrayList<Node> getCurrentPath() {
        return currentPath;
    }

    public void setCurrentPath(ArrayList<Node> currentPath) {
        this.currentPath = currentPath;
    }

    public Node getNodeAfterAnomaly() {
        return nodeAfterAnomaly;
    }

    public void setNodeAfterAnomaly(Node nodeAfterAnomaly) {
        this.nodeAfterAnomaly = nodeAfterAnomaly;
    }

    public HashMap<String, Node> getNodeComponentsMap() {
        return nodeComponentsMap;
    }

    public void setNodeComponentsMap(HashMap<String, Node> nodeComponentsMap) {
        this.nodeComponentsMap = nodeComponentsMap;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public Node getSourceNode() {
        return sourceNode;
    }

    public void setSourceNode(Node sourceNode) {
        this.sourceNode = sourceNode;
    }

    public Node getDestinationNode() {
        return destinationNode;
    }

    public void setDestinationNode(Node destinationNode) {
        this.destinationNode = destinationNode;
    }

    public int getFule() {
        return fule;
    }

    public void setFule(int fule) {
        this.fule = fule;
    }

    /*This method will be run each time when there is no stored path from source to destination.
    This will find the best node among the list of nodes adjacent to the current node. This method will also be called
    each time there is an anomaly and there is no stored path from the new current node.*/
    public boolean shortestDistancePathAlgo() {
        boolean flag = false;
        ArrayList<Node> adjacentNodes = getAdjacentNodes(drone.getCurrentNode());
        int xTwo = drone.getDestinationNode().getX();
        int yTwo = drone.getDestinationNode().getY();
        double smallestDistance = 40;
        Node smallestDistanceNode = null;
        currentPath.add(drone.currentNode);
        for (Node adjacentNode : adjacentNodes) {
            if (!adjacentNode.isAnomalyExists()) {
                int xOne = adjacentNode.getX();
                int yOne = adjacentNode.getY();
                //applying distance formula
                double distance = Math.sqrt((xTwo - xOne) * (xTwo - xOne) + (yTwo - yOne) * (yTwo - yOne));

               // System.out.println("distance of" + adjacentNode.getxCordinate()+adjacentNode.getyCordinate() + "is" + distance);
                if (distance <= smallestDistance) {
                    smallestDistance = distance;
                    smallestDistanceNode = adjacentNode;
                }
            }
        }

        if (smallestDistanceNode != null) {
            drone.setPreviousNode(currentNode);

            drone.setCurrentNode(smallestDistanceNode);

        }

        if (drone.getCurrentNode().equals(drone.getDestinationNode())) {
            System.out.println("flag true Done");
            flag = true;
        } else {

            flag = false;
        }
        if (drone.getCurrentNode().isLowIntesity()) {
            drone.setFule(fule - 4);
        } else {
            drone.setFule(fule - 1);
        }
        return flag;
    }

}
