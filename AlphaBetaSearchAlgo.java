package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchAlgo implements ISearchAlgo {

	// function ALPHA-BETA-SEARCH(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state, Integer.MIN_VALUE , Integer.MAX_VALUE)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
		int res= maxValue(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
	}

	// function MAX-VALUE(state, alpha, beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- MIN_VALUE;
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s, alpha, beta))
	// if v >= beta then return v
	// alpha <- MAX(alpha, v)
	// return v

	public int maxValue(Node node, int alpha, int beta) {
		// Enter your code here
		if(node.isTerminal()) {
			return node.getValue();
		}
		int max = Integer.MIN_VALUE;
		List<Node> list = node.getChildren();
		Collections.sort(list, node.LabelComparator);
		for(Node nodeItem : list) {
			int minValue = minValue(nodeItem, alpha, beta);
			max = Math.max(max,minValue);
//			update alpha
			alpha = Math.max(max, alpha);
//			cắt
			if(alpha >= beta) {
				break;
			}
		}
		return max;
	}
	// function MIN-VALUE(state, alpha , beta) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s, alpha , beta))
	// if v <= alpha then return v
	// beta <- MIN(beta ,v)
	// return v

	public int minValue(Node node, int alpha, int beta) {
		// Enter your code here
		if(node.isTerminal()) {
			return node.getValue();
		}
		int min = Integer.MAX_VALUE;
		List<Node> list = node.getChildren();
		Collections.sort(list, node.LabelComparator);
		for(Node nodeItem : list) {
			int maxValue = maxValue(nodeItem, alpha, beta);
			min = Math.min(min,maxValue);
//			update beta
			beta = Math.min(min, beta);
//			cắt
			if(alpha >= beta) {
				break;
			}
		}
		return min;
	}
}
