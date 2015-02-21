package testing;

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
		
		BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
		
		System.out.println(breadthFirstSearch.Search());

	}

}
