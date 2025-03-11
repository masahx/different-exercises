package binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
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
	
	@ParameterizedTest
	@MethodSource("makeTree")
	void twoLevelsTest(Node rootX, int summ) {
		
				
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
	
	private static Node tree1() {
		
		Node rootX = new Node(0);
		rootX.setLeft(2);
		rootX.getLeft().setLeft(2);
		
		return rootX;
	}
	
	private static Node tree2() {
		
		Node rootX = new Node(-2);
		rootX.setLeft(-3);
		rootX.getLeft().setRight(-2);
		
		return rootX;
		
	}
	
	private static Node tree3() {
		
		Node rootX = new Node(-3);
		rootX.setRight(5);
		rootX.getRight().setLeft(5);
		
		return rootX;
		
	}
	
	private static Node tree4() {
		
		Node rootX = new Node(-4);
		rootX.setRight(1);
		rootX.getRight().setRight(2);
		
		return rootX;
		
	}
	
	
	private static Node tree30() {
		
		Node rootY = tree0();
		
		rootY.getRight().getRight().setRight(-2);
		rootY.getRight().getRight().setLeft(5);
		rootY.getRight().getLeft().setRight(-1);
		rootY.getRight().getLeft().setLeft(3);
		rootY.getLeft().getRight().setRight(0);
		rootY.getLeft().getRight().setLeft(-1);
		rootY.getLeft().getLeft().setRight(2);
		rootY.getLeft().getLeft().setLeft(2);		
		
		return rootY;
		
	}
	
	private static Node tree31() {
		
		Node rootY = tree1();
		
		rootY.getLeft().getLeft().setLeft(-3);
		
		return rootY;
		
	}
	
	private static Node tree32() {
		
		Node rootY = tree2();
		
		rootY.getLeft().getRight().setLeft(-3);
		
		return rootY;
		
	}
	
	private static Node tree33() {
		
		Node rootY = tree3();
		
		rootY.getRight().getLeft().setLeft(5);
		rootY.getRight().getLeft().setRight(-1);
		
		return rootY;
		
	}
	
	private static Node tree34() {
		
		Node rootY = tree4();
		
		rootY.getRight().getRight().setLeft(2);
		rootY.getRight().getRight().setRight(-2);
		
		return rootY;
		
	}
	
	private static Node tree311() {
		
		Node rootY = tree1();
		
		rootY.getLeft().getLeft().setRight(5);
		
		return rootY;
		
	}
	
	private static Node tree300() {
		
		Node rootY = tree0();
		
		rootY.getLeft().getLeft().setRight(-4);
		rootY.getLeft().getRight().setRight(5);
		rootY.getRight().getLeft().setRight(-5);
		rootY.getRight().getRight().setRight(-3);
		
		return rootY;
		
	}
	
	private static Node tree200() {
		
		Node rootX = new Node(-5);
		rootX.setLeft(-2);
		rootX.getLeft().setRight(4);
		rootX.setRight(4);
		rootX.getRight().setLeft(5);
		rootX.getRight().setRight(2);
		
		rootX.getLeft().getRight().setLeft(-2);
		rootX.getLeft().getRight().setRight(1);
		rootX.getRight().getLeft().setLeft(-5);
		rootX.getRight().getRight().setLeft(3);
		
		return rootX;
		
	}
	
	private static Node tree321() {
		
		Node rootY = tree2();
		
		rootY.getLeft().getRight().setRight(5);
		
		return rootY;
		
	}
	
	private static Stream<Arguments> makeTree() {	
		
		return Stream.of(
			
			Arguments.of(tree0(), 3)
	//		Arguments.of(tree1(), 4)
	//		Arguments.of(tree2(), -7),
	//		,Arguments.of(tree3(), 7)
	//		,Arguments.of(tree4(), -1)
	//		,Arguments.of(tree30(), 5)
	//		,Arguments.of(tree31(), 1)
	//		,Arguments.of(tree32(), -10)
	//		,Arguments.of(tree33(), 6)
	//		,Arguments.of(tree34(), -3)
	//		,Arguments.of(tree311(), 9)
	//		,Arguments.of(tree300(), -1)
	//		,Arguments.of(tree200(), -5)
	//		,Arguments.of(tree321(), -2)
			
		);
	
	}
	
	
 
}
