package binary_tree;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.Arrays;

public class Node {
	
	final static Node DUMMY = new Node(0);
	
	int value;
	Node right;
	Node left;
	
	Node(int n) {
		
		value = n;
		
	}
	
	int getValue() {
		
		return value;
		
	}
	
	Node getRight() {
		
		return right;
	}
	
	void setRight(int n) {
		
		right = new Node(n);
		
	}
	
	Node getLeft() {
		
		return left;
		
	}
	
	void setLeft(int n) {
		
		left = new Node(n);
		
	}
	
	Function<Node, Integer> childValue = node -> Optional.ofNullable(node).orElse(DUMMY).getValue();  
	
	int getMinSum() {
		
//		return value + Math.min(childValue.apply(left), childValue.apply(right));
		
		
	//	Optional.ofNullable(left)
		
		int sum = value;
		
		if (left != null && right != null) {
			
			sum += Math.min(left.getMinSum(), right.getMinSum());
			
		} else if (left != null) {
			
			sum += left.getMinSum();
			
		} else if (right != null) {
			
			sum += right.getMinSum();
		}
		
		return sum;
		
		
/*		
		return value + Arrays.stream(new Node[] {left, right})
			       .filter(n -> n != null)
			       .map(n -> n.getValue())
			       .min(Comparator.naturalOrder())
			       .orElse(0);
	*/
//		return value + Math.min(left.getValue(), right.getValue());
	
	}

}
