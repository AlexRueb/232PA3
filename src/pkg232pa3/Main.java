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
    private static final String inputFile = "input/input.txt"; private static int edges;
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
            prim(matrix);
        } catch (IOException x) {
            System.out.println("File not found");
        }
    }

    //Prim's algorithm -- Connor Lowe
    public static void prim(int matrix[][]) {
	int nodes = matrix.length; //Number of vertices in graph
	int inf = Integer.MAX_VALUE; //Easy wasy to represent infinity 

	//Array for the MST 
	int tree[] = new int[nodes]; 

	//Set to help choose minimum weights 
	int weight[] = new int[nodes]; 

	//Set for all nodes not in the tree
	boolean outside[] = new boolean[nodes]; 

	//Set all the keys to inf and sets them to false to denote 
	//that they're not in the tree yet
	for (int i = 0; i < nodes; i++) { 
		outside[i] = false; 
		weight[i] = inf; 
	} 

	//Makes the weight 0 so it gets selected first 
	weight[0] = 0; 

	for (int j = 0; j < nodes-1; j++) { 
		//Calls method below to put lowest cost into a variable 
		int lowest = lowestCost(outside, weight);  

		//Put the selected node into the "outside" set 
		outside[lowest] = true;

		for (int k = 0; k < nodes; k++) { 
			if (matrix[lowest][k] < weight[k] && outside[k] == false && matrix[lowest][k] != 0) { 
				tree[k] = lowest; 
				weight[k] = matrix[lowest][k]; 
			}
		}
	}

	//Prints the tree 
	System.out.println("Node--Cost--Node"); 
	for (int i = 1; i < matrix.length; i++) { 
		//System.out.println(matrix[i][tree[i]] + "	" + tree[i] + "----" + i); 
		System.out.println("    " + tree[i] + "--" + matrix[i][tree[i]] + "--" + i); 
	}
    }

    //Function to find the node with the smallest key 
    public static int lowestCost(boolean outside[], int weight[]) { 
	int inf = Integer.MAX_VALUE;
	int smallest = -1;  
	for (int i = 0; i < matrix.length; i++) { 
		if (weight[i] < inf && outside[i] == false) { 
			inf = weight[i]; 
			smallest = i; 
		} 
	}
	return smallest;
    }
}
