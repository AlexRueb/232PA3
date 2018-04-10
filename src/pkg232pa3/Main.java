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

    private static int[][] matrix; //the adjacency matrix -- DO NOT MODIFY
    private static final String inputFile = "input/input.txt";
    public static int edges; //The amount of edges
    public static int vertices; //the amout of vertices or 'nodes'

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            Scanner sc = new Scanner(new File(inputFile));
            int matrixPos = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] thisOne = s.split(",");
                vertices = thisOne.length;
                if (matrix == null) {
                    matrix = new int[vertices][vertices];
                }
                int[] thisTwo = new int[vertices];
                for (int i = 0; i < vertices; i++) {
                    thisTwo[i] = Integer.parseInt(thisOne[i]);
                    if (thisTwo[i] != 0) {
                        edges++;
                    }
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
        Graph graph = new Graph(); //creates the graph
        int edgePos = 0; //variable for which edge we're at

        //loop through every space in the matrix
        for (int i = 0; i < Main.vertices; i++) {
            for (int j = 0; j < Main.vertices; j++) {
                //if its a zero, there is no edge connecting the corresponding vertices
                if (matrix[i][j] == 0) {
                } //if it's not a zero, there is an edge. 
                else {
                    //put the egge weight, source vertice, and destination vertices in the graph
                    graph.allEdges[edgePos].weight = matrix[i][j];
                    graph.allEdges[edgePos].source = i + 1;
                    graph.allEdges[edgePos].dest = j + 1;

                    edgePos++;
                }
            }
        }
        //sort the graph.edge array for the MST
        Arrays.sort(graph.allEdges);

        //generate the MST
        graph.findMST();
    }

    //Floyd-Warshall's algorithm - Nicolas Tonjum
    public static void floyd() {

    }
}

//Graph class and methods heavily inspired by:https://www.geeksforgeeks.org/greedy-algorithms-set-2-kruskals-minimum-spanning-tree-mst/
class Graph {

    int vertices, totalEdges; //int values for # of vertices and edges
    Edge allEdges[]; //the array of the sorted edges

    Graph() {
        vertices = Main.vertices;
        totalEdges = Main.edges;
        allEdges = new Edge[totalEdges];
        for (int i = 0; i < totalEdges; ++i) {
            allEdges[i] = new Edge();
        }
    }

    //Class to represent the edges between vertices
    class Edge implements Comparable<Edge> {

        int weight, source, dest;
        Edge[] connected = new Edge[vertices - 1];

        @Override //used for sorting the edge array
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }

    //class to represent the set of edges connected in a subset
    class subset {

        int parent, rank;
    }

    //used to find if the given subset is in the subsetList already
    //this is used in determining if an edge needs to be discarded
    int find(subset subsetList[], int i) {
        if (subsetList[i].parent == i) {
            //do nothing
        } else {
            subsetList[i].parent = find(subsetList, subsetList[i].parent);
        }
        return subsetList[i].parent;
    }

    //used to combine two subsets
    //this makes sure that when an edge is added to the tree, 
    //all of its connected vertices are accounted for
    void Combine(subset subsetList[], int x, int y) {
        int xroot = find(subsetList, x);
        int yroot = find(subsetList, y);

        // Make higher rank tree the parent of the smaller rank
        if (subsetList[xroot].rank < subsetList[yroot].rank) {
            subsetList[xroot].parent = yroot;
        } else if (subsetList[xroot].rank > subsetList[yroot].rank) {
            subsetList[yroot].parent = xroot;
        } // If ranks are same, then make one as root and make it's rank 1 higher
        else {
            subsetList[yroot].parent = xroot;
            subsetList[xroot].rank++;
        }
    }

    //the method that loops through the sorted list and finds the MST
    void findMST() {
        Edge result[] = new Edge[vertices];  // This will store the MST
        int e = 0;
        int i = 0;
        for (i = 0; i < vertices; ++i) {
            result[i] = new Edge();
        }

        // Create an array of subsets, one for each edge
        subset subsetList[] = new subset[totalEdges];
        for (i = 0; i < totalEdges; ++i) {
            subsetList[i] = new subset();
        }

        // Create subsetList with single elements equal to # of vertices
        for (int v = 0; v < vertices; v++) {
            subsetList[v].parent = v;
            subsetList[v].rank = 0;
        }

        i = 0;

        // there will be one less edge than vertices
        while (e < vertices - 1) {
            //the currentEdge will be the smallest edge not sorted already
            Edge currentEdge = allEdges[i++];

            //finds all the vertices connected to the source vertice
            int x = find(subsetList, currentEdge.source);
            //finds all the vertices connected to the destination vertice
            int y = find(subsetList, currentEdge.dest);

            //if these two subsets are not the same, then adding it will not cause
            //a cycle. It is safe to merge them, we add the current edge to the
            //results array and add the two subsetList together as they are one larger
            //subset now
            if (x != y) {
                result[e++] = currentEdge;
                Combine(subsetList, x, y);
            }
            // if they are the same, discard the currentEdge
        }

        // print the built MST
        System.out.println("The Minimum Spanning tree is:");
        int resTotal = 0;
        for (i = 0; i < e; ++i) {
            System.out.println(result[i].source + " <--> "
                    + result[i].dest + " == " + result[i].weight);
            resTotal += result[i].weight;
        }
        System.out.println("The total travel cost is: " + resTotal);
    }
}
