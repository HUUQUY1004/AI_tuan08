package lab8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AlphaBetaSearchRightToLeftAlgo implements ISearchAlgo {

	@Override
	public void execute(Node node) {
		// TODO Auto-generated method stub
		int v = max(node, Integer.MAX_VALUE, Integer.MIN_VALUE);
		
		
	}
	public int max(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int max = Integer.MIN_VALUE;
        List<Node> children = new ArrayList<>(node.getChildren());
//        Đảo 
        Collections.reverse(children); // Reverse the order

        for (Node child : children) {
            max = Math.max(max, min(child, alpha, beta));
            alpha = Math.max(alpha, max);
            if (max >= beta) {
                break; // Beta cut-off
            }
        }

        return max;
    }
	public int min(Node node, int alpha, int beta) {
        if (node.isTerminal()) {
            return node.getValue();
        }

        int min = Integer.MAX_VALUE;
        List<Node> children = new ArrayList<>(node.getChildren());
        Collections.reverse(children); // Reverse the order

        for (Node child : children) {
            min = Math.min(min, max(child, alpha, beta));
            beta = Math.min(beta, min);
//            Cắt
            if (min <= alpha) {
                break;
            }
        }

        return min;
    }

}
