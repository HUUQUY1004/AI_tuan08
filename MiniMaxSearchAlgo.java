package lab8;

import java.util.Collections;
import java.util.List;

public class MiniMaxSearchAlgo implements ISearchAlgo {

	// function MINIMAX-DECISION(state) returns an action
	// inputs: state, current state in game
	// v <- MAX-VALUE(state)
	// return the action in SUCCESSORS(state) with value v
	@Override
	public void execute(Node node) {
		// Enter your code here
//		Chạy cái tốt nhất
		int res  = maxValue(node);
		System.out.println("excute " + res);
	}

	// function MAX-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MIN_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MAX(v, MIN-VALUE(s))
	// return v
	public int maxValue(Node node) {
//		Nếu nó ko có co thì trả về giá trị của nó
		if (node.isTerminal()) {
			return node.getValue();
		}
		int max = Integer.MIN_VALUE;
//		List con
		List<Node> list = node.getChildren();
		Collections.sort(list, node.LabelComparator);

		for (Node nodeItem : list) {
//			Get đc min của từng ông
			int minValue = minValue(nodeItem);
			max = Math.max(max, minValue);
		}

		// Enter your code here
		return max;
	}
	// function MIN-VALUE(state) returns a utility value
	// if TERMINAL-TEST(state) then return UTILITY(state)
	// v <- Integer.MAX_VALUE
	// for each s in SUCCESSORS(state) do
	// v <- MIN(v, MAX-VALUE(s))
	// return v

	public int minValue(Node node) {
		// Enter your code here
		if (node.isTerminal()) {
			return node.getValue();
		}
		int min = Integer.MAX_VALUE;
		List<Node> list = node.getChildren();
		Collections.sort(list,node.LabelComparator);
		for (Node nodeItem : list) {
			int maxValue = maxValue(nodeItem);
			min = Math.min(min, maxValue);
		}
		return min;
	}
}
