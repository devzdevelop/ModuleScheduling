/* AOA Project
 * Name: Devin Brown
 * Title: AOA Project
 * Date: 11/28/2021
 * */
package moduleScheduling;

//A Java program to print topological
//sorting of a DAG
import java.io.*;
import java.util.*;
import java.util.HashMap;
//This class represents a directed graph
//using adjacency list representation
class Graph {
	 // No. of vertices
	 private int V;
	 HashMap<Integer, String> prerequisits = new HashMap<Integer, String>();
	 // Adjacency List as ArrayList of ArrayList's
	 private ArrayList<ArrayList<Integer> > adj;
	 int count = 0;

	
	 // Constructor
	 Graph(int v)
	 {
	     V = v;
	     adj = new ArrayList<ArrayList<Integer> >(v);
	     for (int i = 0; i < v; ++i)
	         adj.add(new ArrayList<Integer>());    
	 }
	
	 void acceptPreReq(String name, ArrayList<ArrayList<String>> array, int size, String []nameArr){
		 // Have 6 hard coded modules
		 
		 for(int i = 0; i < 6; i++) {
			 if(count == 0) {
				 prerequisits.put(0, nameArr[i]);
			 }
			 else if(count == 1) {
				 prerequisits.put(1, nameArr[i]);
			 }
			 else if(count == 2) {
				 prerequisits.put(2, nameArr[i]);
			 }
			 else if(count == 3) {
				 prerequisits.put(3, nameArr[i]);
			 }
			 else if(count == 4) {
				 prerequisits.put(4, nameArr[i]);
			 }
			 else if(count == 5) {
				 prerequisits.put(5, nameArr[i]);
			 }
			 count++;
		 } 
	 }
	 
	 // Function to add an edge into the graph
	 void addEdge(int v, int w) { adj.get(v).add(w); }
	
	 // A recursive function used by topologicalSort
	 void topologicalSortUtil(int v, boolean visited[],
	                          Stack<Integer> stack)
	 {
	     // Mark the current node as visited.
	 visited[v] = true;
	 Integer i;
	
	 // Recur for all the vertices adjacent
	 // to thisvertex
	 Iterator<Integer> it = adj.get(v).iterator();
	 while (it.hasNext()) {
	     i = it.next();
	     if (!visited[i])
	         topologicalSortUtil(i, visited, stack);
	 }
	
	 // Push current vertex to stack
	 // which stores result
	     stack.push(new Integer(v));
	 }
	
	 // The function to do Topological Sort.
	 // It uses recursive topologicalSortUtil()
	 void topologicalSort()
	 {
	     Stack<Integer> stack = new Stack<Integer>();
	
	     // Mark all the vertices as not visited
	 boolean visited[] = new boolean[V];
	 for (int i = 0; i < V; i++)
	     visited[i] = false;
	
	 // Call the recursive helper
	 // function to store
	 // Topological Sort starting
	 // from all vertices one by one
	 for (int i = 0; i < V; i++)
	     if (visited[i] == false)
	         topologicalSortUtil(i, visited, stack);
	
	 // Print contents of stack
	 System.out.println("");
	 while (stack.empty() == false)
	     //System.out.print(stack.pop() + ", "); 
		 //System.out.print(stack.pop() + ", ");
		 System.out.print(prerequisits.get(stack.pop()) + ", ");
		/*
		 * System.out.println("\n\n"); System.out.println(adj);
		 */
	 System.out.println("\n\n");
	 }
	 
	 
}
//This code is contributed by Aakash Hasija