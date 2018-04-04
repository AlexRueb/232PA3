/*
 * Authors: Alex Rueb, Nicolas Tonjum, Connor Lowe
 * Date: 
 * Overview: Programming Assignment 3 -> Graph Algorithms
 *      Using Prim's, Kruskal's, and Floyd-Warshall's algorithms
 */
import java.util.*; 
import java.lang.*:
import java.io.*; 

package pkg232pa3;

public class Main {
    private static final String inputFile = "input/input.txt"; 
    public static void main(String[] args) throws IOException { 
	try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
		Scanner sc = new Scanner(new File(inputFile)); 
		whlie (sc.hasNext()) {
			String s = sc.nextLine(); 
		}
	}
	catch (IOException x) { 
		System.out.println("File not found"); 
	}
    }

    //Prims algorithm -- Connor Lowe
public void prim() {

}

    //Kruskals algorithm - Alex Rueb
public void kruskal(){
    
}


    //Floyd-Warshall's algorithm - Nicolas Tonjum
public void floyd(){
    
	
}
}


