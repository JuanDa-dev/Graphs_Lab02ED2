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
    int adjacencyMatrix[][];

    public City() {
        towers = new ArrayList();
        edges = new ArrayList();
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
        System.out.println("Matriz de adyacencia");
        adjacencyMatrix = generateAdjacencyMatrix();
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            for (int j = 0; j < adjacencyMatrix.length; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public int[][] generateAdjacencyMatrix() {
        int M[][] = new int[towers.size()][towers.size()];
        for (int i = 0; i < towers.size(); i++) {
            for (int j = 0; j < towers.size(); j++) {
                M[i][j] = 0;
            }
        }
        int Names[] = new int[towers.size()];
        int i = 0;
        for (Tower tower : towers) {
            Names[i++] = tower.getName();
        }
        i = 0;
        for (Tower tower : towers) {
            for (Edge edge : tower.getEdges()) {
                M[i][FindName(edge.getDestination().getName(), Names)] = edge.getDistance();
            }
            i++;
        }
        return M;
    }

    private int FindName(int name, int[] Names) {
        for (int i = 0; i < Names.length; i++) {
            if (Names[i] == name) {
                return i;
            }
        }
        return -1;
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
