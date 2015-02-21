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
	 * The node holding the state
	 * 
	 * The numbers represent, in order from left to right, Number of
	 * missionaries on the starting bank, number of cannibals on the starting
	 * bank, is the boat on the starting bank, 1 = true, 0 = false.
	 */
	ArrayList<Integer> node = new ArrayList<Integer>();

	/**
	 * The goal state
	 */
	ArrayList<Integer> goal = new ArrayList<Integer>();

	/**
	 * Holds the nodes of the frontier
	 */
	ArrayDeque<ArrayList<Integer>> frontier = new ArrayDeque<ArrayList<Integer>>();

	/**
	 * Holds the explored nodes
	 */
	HashSet<ArrayList<Integer>> explored = new HashSet<ArrayList<Integer>>();

	/**
	 * Holds the child nodes
	 */
	ArrayList<ArrayList<Integer>> childNodes = new ArrayList<ArrayList<Integer>>();

	/**
	 * Constructor
	 */
	public BreadthFirstSearch() {

		// Initialize node to the starting state
		node.add(3);
		node.add(3);
		node.add(1);

		// Initialize goal to the goal state
		goal.add(0);
		goal.add(0);
		goal.add(0);
	}

	public boolean Search() {

		// Return true if the starting state is the goal state
		if (node.equals(goal)) {
			return true;
		}

		// Loop forever
		while (1 < 2) {

			// Return false if frontier is empty
			if (frontier.isEmpty()) {
				return false;
			}

			// Get a node form frontier
			node = frontier.remove();

			// Add node to explored
			explored.add(node);

			// Apply actions to node, populating the childNodes List
			applyActions(node);

			// Iterate through childNodes
			for (ArrayList<Integer> tmpNode : childNodes) {

				// Check if an equivalent of tmpNode exists in explored or
				// frontier
				if (!explored.contains(tmpNode) && !frontier.contains(tmpNode)) {

					// Check if tmpNode equals goal
					if (tmpNode.equals(goal)) {

						// Return true if so
						return true;

					} else {

						// Add tmpNode to frontier otherwise
						frontier.add(tmpNode);
					}
				}
			}
		}
	}

	private void applyActions(ArrayList<Integer> node) {

		// Reset childNodes
		ArrayList<ArrayList<Integer>> childNodes = new ArrayList<ArrayList<Integer>>();

		// Initialize the child nodes to their parent's state
		for (int i = 0; i < 5; i++) {
			childNodes.add((ArrayList<Integer>) Arrays.asList(node.get(0),
					node.get(1), node.get(2)));
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

		// Iterate through childNodes
		for (ArrayList<Integer> tmpNode : childNodes) {

			// Check if tmpNode was created by an illegal action, remove if so
			if (tmpNode.get(0) < 0 || tmpNode.get(0) > 3) {

				childNodes.remove(tmpNode);

			} else if (tmpNode.get(1) < 0 || tmpNode.get(1) > 3) {

				childNodes.remove(tmpNode);
			}
		}
	}

	private void createChildState(ArrayList<Integer> node, int missionaries,
			int cannibals, int boatPostition) {

		if (boatPostition == 1) {
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
