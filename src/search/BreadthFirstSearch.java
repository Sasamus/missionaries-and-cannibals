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
	 *  The node holding the state, currently the starting state
	 *  
	 *  The numbers represent, in order from left to right,
	 *  Number of missionaries on the starting bank,
	 *  number of cannibals on the starting bank,
	 *  is the boat on the starting bank, 1 = true, 0 = false.
	 */
	ArrayList<Integer> node = (ArrayList<Integer>) Arrays.asList(3, 3, 1);
	
	/**
	 *  The goal state
	 */
	ArrayList<Integer> goal = (ArrayList<Integer>) Arrays.asList(0, 0, 0);
	
	/**
	 *  Holds the nodes of the frontier
	 */
	ArrayDeque<ArrayList<Integer>> frontier = new ArrayDeque<ArrayList<Integer>>();
	
	/**
	 *  Holds the explored nodes
	 */
	HashSet<ArrayList<Integer>> explored = new HashSet<ArrayList<Integer>>();

	/**
	 * Constructor
	 */
	public BreadthFirstSearch() {
		
	}
	
	public boolean Search(){
		
		// Return true if the starting state is the goal state
		if(node.equals(goal)){
			return true;
		}
		
		// Loop forever
		while(1 < 2){
			
			// Return false if frontier is empty
			if(frontier.isEmpty()){
				return false;
			}
			
			// Get a node form frontier
			node = frontier.remove();
			
			// Add node to explored
			explored.add(node);
			
			// Apply actions to node
			applyActions(node);
			
		}
	}
	
	private boolean applyActions(ArrayList<Integer> node){
		
		// Holds the number of people that can currently use the boat
		int movableMissionaries = 0;
		int movableCannibals = 0;
		
		// Check which bank the boat is on, count the movable people accordingly
		if(node.get(2) == 1){
			
			// Get the number of movable people
			movableMissionaries = node.get(0);
			movableCannibals = node.get(1);
			
		} else {
			
			// Get the number of movable people
			movableMissionaries = 3 - node.get(0);
			movableCannibals = 3 - node.get(1);
		}
		
		
		return true;
	}

}
