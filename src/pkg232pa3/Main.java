/*
 * Authors: Alex Rueb, Nicolas Tonjum, Connor Lowe
 * Date: 
 * Overview: Programming Assignment 3 -> Graph Algorithms
 *      Using Prim's, Kruskal's, and Floyd-Warshall's algorithms
 */
package pkg232pa3;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    private static int[][] matrix;
    private static final String inputFile = "input/input.txt";
    public static int edges;
    public static int vertices;
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            Scanner sc = new Scanner(new File(inputFile));
            int matrixPos = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] thisOne = s.split(",");
                vertices = thisOne.length;
                if(matrix == null){
                    matrix = new int[vertices][vertices];
                }
                int[] thisTwo = new int[vertices];
                for (int i = 0; i<vertices; i++){
                thisTwo[i] = Integer.parseInt(thisOne[i]);
                if(thisTwo[i] != 0){ edges++;}
                }
                matrix[matrixPos] = thisTwo;
                matrixPos++;
            }
            prim();
            kruskal();
            floyd();
        } catch (IOException x) {
            System.out.println("File not found");
        }
    }

    //Prims algorithm -- Connor Lowe
    public static void prim() {
	        
    }

    //Kruskals algorithm - Alex Rueb
    public static void kruskal() {
        Edge allEdges[] = new Edge[Main.edges];
        int edgePos = 0;
        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 5; j++){
                if(matrix[i][j] == 0){} 
                else {
                    Edge edge = new Edge();
                    edge.weight = matrix[i][j];
                    edge.source = i;
                    edge.dest = j;
                    allEdges[edgePos] = edge;
                }
            }
        }
        System.out.println("");
    }

    //Floyd-Warshall's algorithm - Nicolas Tonjum
    public static void floyd() {

    }
}

class Edge implements Comparable<Edge> {
    int weight, source, dest;
    @Override
    public int compareTo(Edge o) {
       return weight-o.weight;
    }
    
}
    
