/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

/**
 *
 * @author Praneet
 */
public class PathLinkedList {
    
    public PathNode front;

    public PathLinkedList() {
        
        front = new PathNode();
        
    }
        
    public void enqueue(PathNode n)
    {
           PathNode current = front;
           PathNode prev = null;
            while(current!=null&&current.getConfidence()<n.getConfidence())
            {
              prev=current;
              current = current.nextPath;
            }
            if(prev==null){ // if beginning of list,
            front = n; }
            else{ // not at beginning,
            prev.nextPath = n; // prev --> new 
            n.nextPath = current;} // only for 2nd &&
    }
    
    
    
    //Method to suffle and set the front as the pathnode which has best confidence factor
    public void shuffle(PathNode n)
    {
        PathNode parent =front;
        PathNode current =front;
       
        if(front!=null)
        {
            while(!current.nextPath.equals(n))
            {
               current=current.nextPath;
            }
            current.nextPath= n.nextPath;
                parent=front;
            current=front;
            while(current.getConfidence()>n.getConfidence())
            {
                parent=current;
                current=current.nextPath;
            }
            parent.nextPath = n;
            n.nextPath =current;
            
        }
    
    }
    

    public PathNode getFront() {
        return front;
    }

    public void setFront(PathNode front) {
        this.front = front;
    }
    
    
}
