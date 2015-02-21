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
		
//		// Holds the number of people that can currently use the boat
//		int movableMissionaries = 0;
//		int movableCannibals = 0;
//		
//		// Check which bank the boat is on, count the movable people accordingly
//		if(node.get(2) == 1){
//			
//			// Get the number of movable people
//			movableMissionaries = node.get(0);
//			movableCannibals = node.get(1);
//			
//		} else {
//			
//			// Get the number of movable people
//			movableMissionaries = 3 - node.get(0);
//			movableCannibals = 3 - node.get(1);
//		}
//		
//		if(movableMissionaries == 3){
//			if(movableCannibals == 1){
//				
//			}
//		}
//		
		
		// A list of child nodes
		ArrayList<ArrayList<Integer>> childNodes = new ArrayList<ArrayList<Integer>>();
		
		// Initialize the child nodes to their parent's state
		for(int i=0; i < 10; i++){
			childNodes.add((ArrayList<Integer>) Arrays.asList(node.get(0), node.get(1), node.get(2)));
		}
		
		// Get the boat's position
		int boatPosition = node.get(2);
		
		// Applies actions to give the child nodes new states
		
		// One missionary goes by boat
		createChildState(childNodes.get(0), 1, 0, boatPosition);
		
		// Two missionaries goes by boat
		createChildState(childNodes.get(1), 2, 0, boatPosition);
		
		// One cannibal goes by boat
		createChildState(childNodes.get(2), 0, 1, boatPosition);
		
		// Two cannibals goes by boat
		createChildState(childNodes.get(3), 0, 2, boatPosition);
		
		// One of each goes by boat
		createChildState(childNodes.get(4), 1, 1, boatPosition);
		
		
		return true;
	}
	
	private void createChildState(ArrayList<Integer> node, int missionaries, int cannibals, int boatPostition){
		
		if(boatPostition == 1){
			node.set(0, node.get(0) - missionaries);
			node.set(1, node.get(1) - cannibals);
			node.set(2, node.get(2) - 1);
		} else {
			node.set(0, node.get(0) + missionaries);
			node.set(1, node.get(1) + cannibals);
			node.set(2, node.get(2) + 1);
		}
		
	}

}
