package binary_tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NodeTest {
	
	Node n; 
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3})
	void nodeHasValueTest(int x) {
		
		n = new Node(x);
		assertEquals(x, n.getValue());
		
	}
	
	@Test
	void nodeDoesntHaveRightValueTest() {
		
		n = new Node(-1);
		assertNull(n.getRight());
		
	}
	
	@Test
	void nodeHasRightValueTest() {
		
		n = new Node(-4);
		n.setRight(-1);
		assertEquals(-1, n.getRight().getValue());
		
	}
	
	@Test
	void nodeHasLeftValueTest() {
		
		n = new Node(-3);
		n.setLeft(-4);
		assertEquals(-4, n.getLeft().getValue());
		
	}
	
	@Test
	void nodeDoesntHaveLeftValueTest() {
		
		n = new Node(-4);
		assertNull(n.getLeft());
		
	}

}
