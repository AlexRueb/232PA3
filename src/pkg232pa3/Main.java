/*
 * Authors: Alex Rueb, Nicolas Tonjum, Connor Lowe
 * Date: 
 * Overview: Programming Assignment 3 -> Graph Algorithms
 *      Using Prim's, Kruskal's, and Floyd-Warshall's algorithms
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    private static int[][] matrix;
    private static final String inputFile = "input/input.txt";
    private static int edges;
    private static int vertices;

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
        } catch (IOException x) {
            System.out.println("File not found");
        }
    }

    //Prims algorithm -- Connor Lowe
    public static void prim() {
	int nodes = matrix.length; 
	System.out.println(nodes); 
	boolean[] hit = new boolean[matrix.length]; 
	int[] minCost = new int[matrix.length]; 

	hit[0] = true; 
    }
}

