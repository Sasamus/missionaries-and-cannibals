package search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


/**
 * Performs a Breadth First Search
 * 
 * @author Albin Engström
 */
public class BreadthFirstSearch {

	/**
	 * Constructor
	 */
	public BreadthFirstSearch() {
		
	}
	
	public boolean Search(){
		
		// The node holding the state, currently the starting state
		ArrayList<Integer> node = (ArrayList<Integer>) Arrays.asList(3, 3, 1);
		
		// The goal state
		ArrayList<Integer> goal = (ArrayList<Integer>) Arrays.asList(0, 0, 0);
		
		// Holds the nodes of the frontier
		ArrayDeque<ArrayList<Integer>> frontier = new ArrayDeque<ArrayList<Integer>>();
		
		// Holds the explored nodes
		HashSet<ArrayList<Integer>> explored = new HashSet<ArrayList<Integer>>();
		
		return true;
	}

}
