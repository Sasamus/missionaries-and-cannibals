package testing;

import java.util.ArrayList;
import java.util.Collections;

import search.BreadthFirstSearch;

/**
 * Class with main method used for testing/running the program
 * 
 * @author Albin Engström
 */
public class Tester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		// Create a BreadthFirstSearch object
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		
		// An ArrayList to hold the nodes leading to a solution
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		
		// Call breadthFirstSearch's search method and check what it returns
		if(breadthFirstSearch.search(solution)){
			
			// If true, preint the solution
			
			System.out.println("Solution Found!");
			System.out.println("It goes as follows:");
			
			Collections.reverse(solution);
			
			for(ArrayList<Integer> node : solution){
				System.out.println(node.get(0) + ":" + node.get(1) + ":"
						+ node.get(2));
			}
			
		} else {
			
			// If false, print that no solution was found
			System.out.println("No Solution found");
		}
	}
}
