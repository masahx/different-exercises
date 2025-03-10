package binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MinBinTreePathTest {
	
	/*
	 * Daily Coding Problem: Problem #1601 [Easy]
	 This question was asked by Apple.

	Given a binary tree, find a minimum path sum from root to a leaf.
	 */
	
	Node root;
	
	@ParameterizedTest
	@ValueSource(ints = {4, 3})
	void justRootTest(int n) {
				
		root = new Node(n);
		assertEquals(n, root.getMinSum());	
		
	}
	
	@Test
	void smallTreeBothChildrenTest() {
		
//		sad bi trebalo kad ima samo levi i samo desni npr da se proveri, verovatno će proći
		root = new Node(-3);
		root.setLeft(4);
		root.setRight(-1);
		assertEquals(-4, root.getMinSum());
		
	}
	
	@Test
	void smallTreeLeftTest() {
	
		root = new Node(5);
		root.setLeft(7);
		assertEquals(12, root.getMinSum());
		
	}
	
	@Test
	void twoLevelsTest() {
		
		root = new Node(5);
		root.setLeft(0);
		root.getLeft().setLeft(-2);
		root.getLeft().setRight(3);
		root.setRight(4);
		root.getRight().setLeft(-3);
		root.getRight().setRight(0);
		
		assertEquals(3, root.getMinSum());
		
	}
 
}
