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
    private static final String[][] matrix = new String[5][5];
    private static final String inputFile = "input/input.txt";

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            Scanner sc = new Scanner(new File(inputFile));
            int matrixPos = 0;
            while (sc.hasNext()) {
                String s = sc.nextLine();
                String[] thisOne = s.split(",");
                for (int i = 0; i<5; i++){
                matrix[matrixPos] = thisOne;
                }
                matrixPos++;
            }
            prim();
            kruskal();
        } catch (IOException x) {
            System.out.println("File not found");
        }
    }

    //Prims algorithm -- Connor Lowe
    public static void prim() {

    }

    //Kruskals algorithm - Alex Rueb
    public static void kruskal() {
        

    }

    //Floyd-Warshall's algorithm - Nicolas Tonjum
    public static void floyd() {

    }
}
