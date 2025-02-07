package teplix;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TeplixTest {
			
	List<Integer[][]> testMaxes = List.of( 			
									      
									      new Integer[][] { {3, 4, 2, 1, 0},
								   					        {1, 3, 4, 2, 1}, 
								   					        {2, 2, 3, 4, 2},
								   					        {5, 2, 3, 3, 4}								   					    	
								   					      },
			
										   new Integer[][] { {9, 2, 4, 2},
									   					     {4, 5, 6, 7}, 
									   					     {1, 2, 3, 3} },
										   
										   new Integer[][] { {9, 2, 4, 2},
															 {3, 9, 2, 4}, 
															 {4, 3, 9, 2},
															 {1, 4, 3, 9} },
										   
										   new Integer[][] { {0, 1}, 
										   				     {1, 2}
										   				    }
												    	 	 
											);			
	
	Integer [][] matrix;
	Teplix t = new Teplix();
				
		
	@Test
	void okDimensionsTrueTest() {
		
		matrix = testMaxes.get(2);
		
		assertTrue(t.check(matrix));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {1, 3, 0})
	void okDimensionsFalseTest(int i) {
		
		matrix = testMaxes.get(i);
		
		assertFalse(t.check(matrix));
	}
	

}
