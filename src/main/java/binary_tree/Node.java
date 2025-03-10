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
		int child;		
		
	//	Optional.ofNullable(left)
		
		int sumL = 0;
		int sumR = 0;
		
		if (left != null) {
			
			sumL = left.getValue();
			
		} 
		
		if (right != null) {
			
			sumR = right.getValue();
			
		}
		
		
		
		
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
