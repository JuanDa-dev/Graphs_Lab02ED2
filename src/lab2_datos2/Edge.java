/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_datos2;

/**
 *
 * @author Mateo
 */
public class Edge {
    private Tower origin;
    private Tower destination;
    private int distance;
 
    public Edge(Tower origin, Tower destination, int distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
        this.origin.addEdge(destination, distance);
        this.destination.addEdge(origin, distance);
    }
    public Edge(Tower destination, int distance){
        this.origin = null;
        this.destination = destination;
        this.distance = distance;
    }

    public Tower getOrigin() {
        return origin;
    }

    public Tower getDestination() {
        return destination;
    }

    public int getDistance() {
        return distance;
    }
    
    
}
