package binary_tree;


public class Node {
	
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
	
	int getMinSum() {
		
		int sum = value;
		
		if (left != null && right != null) {
			
			sum += Math.min(left.getMinSum(), right.getMinSum());
			
		} else if (left != null) {
			
			sum += left.getMinSum();
			
		} else if (right != null) {
			
			sum += right.getMinSum();
		}
		
		return sum;	
	}

}
