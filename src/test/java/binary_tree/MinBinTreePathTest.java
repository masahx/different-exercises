package binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class MinBinTreePathTest {
	
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
	void roothBothChildrenTest() {
		
		root = new Node(-3);
		root.setLeft(4);
		root.setRight(-1);
		assertEquals(-4, root.getMinSum());
		
	}
	
	@Test
	void rootJustLeftTest() {
	
		root = new Node(5);
		root.setLeft(7);
		assertEquals(12, root.getMinSum());
		
	}
	
	@ParameterizedTest
	@MethodSource("makeTree")
	void twoLevelsTreeTest(Node rootX, int summ) {
		
				
		assertEquals(summ, rootX.getMinSum());
		
	}
	
	private static Node tree0()  {
		
		Node rootX = new Node(5);
		rootX.setLeft(0);
		rootX.getLeft().setLeft(-2);
		rootX.getLeft().setRight(3);
		rootX.setRight(4);
		rootX.getRight().setLeft(-3);
		rootX.getRight().setRight(0);
		
		return rootX;
	}
		
	private static Node tree2() {
		
		Node rootX = new Node(-2);
		rootX.setLeft(-3);
		rootX.getLeft().setRight(-2);
		
		return rootX;
		
	}

	
	private static Stream<Arguments> makeTree() {	
		
		return Stream.of(
			
			Arguments.of(tree0(), 3)
		   ,Arguments.of(tree2(), -7)
			
		);
	
	}	
 
}
