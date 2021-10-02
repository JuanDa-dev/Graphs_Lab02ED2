/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_datos2;

import java.util.ArrayList;

/**
 *
 * @author Mateo
 */
public class City {

    ArrayList<Tower> towers;
    ArrayList<Edge> edges;
    ArrayList<Edge> adjacency;

    public City() {
        towers = new ArrayList();
        edges = new ArrayList();
        adjacency = new ArrayList();
    }

    public ArrayList<Tower> getTowers() {
        return towers;
    }

    public void addTower(Tower t) {
        towers.add(t);
    }

    public Tower getTower(int name) {
        for (Tower tower : towers) {
            if (tower.getName() == name) {
                return tower;
            }
        }
        return null;
    }

    public void addEdge(Edge edge) {
        edges.add(edge);
    }

    public ArrayList<Edge> getEdges() {
        return edges;
    }

    public Tower checkSpace(int x, int y) {
        for (Tower tower : towers) {
            if (x < tower.getX() + 90 && x > tower.getX() - 90 && y < tower.getY() + 90 && y > tower.getY() - 90) {
                return tower;
            }
        }
        return null;
    }

    public void deleteTower(Tower t) {
        towers.remove(t);
        ArrayList<Edge> tempEdges = new ArrayList();
        for (Edge edge : edges) {
            if (edge.getOrigin() == t || edge.getDestination() == t) {
                tempEdges.add(edge);
            }
        }
        for (Edge edge : tempEdges) {
            edges.remove(edge);
        }
        for (Tower tower : towers) {
            tower.deleteEdges(t);
        }
    }

    void writeEverything() {
        System.out.println("Towers:");
        for (Tower tower : towers) {
            System.out.println(tower.getName());
            tower.writeEdges();
            System.out.println("__________");
        }
        System.out.println("Edges: ");
        for (Edge edge : edges) {
            System.out.println(edge.getOrigin().getName() + "--" + edge.getDestination().getName() + "||" + edge.getDistance());
        }
    }

    void adjacency_matrix() {

        int count = 0;
        int count_tower = 0;
        int count_tower1 = 0;

        System.out.println("Adjacency matrix: ");
        for (Tower tower : towers) {
            count++;

        }
        System.out.println("i:" + count + " j:" + count);

        int[][] adjacency_matrix = new int[count][count];

        for (Tower tower : towers) {

            for (int i = 0; i < tower.getAdjacency_Count(); i++) {
                adjacency.add(tower.getEdge(i));

            }
            for (Tower tower1 : towers) {

                if (tower.getName() == tower1.getName()) {

                    adjacency_matrix[count_tower][count_tower1] = 0;

                } else {
                    for (Edge e : adjacency) {

                        if (tower1.getName() == e.getDestination().getName()) {

                            adjacency_matrix[count_tower][count_tower1] = e.getDistance(); // 1 - e.getDestination().getName()
                        }
                    }
                }

                count_tower1++;
            }

            count_tower++;

            count_tower1 = 0;
        }

        // imprimir matriz
        escribirMatriz(adjacency_matrix, count);
    }

    public static void escribirMatriz(int matrix[][], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "|");
            }
            System.out.println("");
        }
    }
    
    
    // Prim Algorythm 
}
