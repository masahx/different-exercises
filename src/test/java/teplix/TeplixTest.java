package teplix;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class TeplixTest {
		
	static final String ERR_DIM_TEST = "both dimensions should be at least 2!";
	List<Integer[][]> testMaxes = List.of( new Integer[0][0],
										   new Integer[][] { {3} },
										   new Integer[][] { {9, 2, 4, 2},
									   					     {4, 5, 6, 7}, 
									   					     {1, 2, 3, 3} },
										   
										   new Integer[][] { {9, 2, 4, 2},
															 {3, 9, 2, 4}, 
															 {4, 3, 9, 2},
															 {1, 4, 3, 9} },
										   new Integer[][] { {5, 6, 7, 2},
										   				     {4, 5, 6, 7}
									   					    },
										   new Integer[][] { {0, 1},  // 5
									   					     {1, 2}
									   					    } ,
										   new Integer[][] { {3, 4, 2, 1, 0},
									   					     {1, 3, 4, 2, 1},
									   					     {2, 2, 3, 4, 2},
									   					     {5, 2, 3, 3, 4}								   					    	
									   					    },
										   new Integer[][] { { 1 },
									   					     { 2 },
									   					     { 1}
									   					    },
										   new Integer[][] { {9, 2, null},
															 {3, 9, 2}, 
															 {4, 3, 9},
															 {1, 4, 3}
									   					    	
									   					    },
										   new Integer[][] { {9, 2, 4},
															 {3, 9, 2}, 
															 {4, 3, 9},
															 {1, 4, 3}
										   					    	
										   					    },
										   new Integer[][] { {9, 2, 1},
															 {null, 9, 2} // 10
											   					    	
											     },
										   new Integer[][] { { 2, 3, 0, 5, 6},
											    	 		 { 3, 2, 3, -1, 4},
											    	 		 { 3, 3, 2, 3, 0} },
										   
										   new Integer[][] { { 2, 3},
												    		 { 3, 2},
												    	 	 { 3, 3},
												    	 	 { 4, -1}    },
										   
										   new Integer[][] { {-2, -5, -5},										 
															 {-3, 2, 2}, 
															 {2, 1, 1},
															 {-5, -3, null}
											 	 	  }
												    	 	 
											);
			
	
	Integer [][] matrix;
	Teplix t = new Teplix();
	
	@ParameterizedTest
	@ValueSource(ints = {0, 7})
	void minimalDimensionsTest(int i)  {
		
		matrix = testMaxes.get(i);
		
		assertThrowsExactly(IllegalArgumentException.class, () -> t.check(matrix));
		
	}
		
	@ParameterizedTest
	@ValueSource(ints = {0, 2})
	void minimalDimensionsMessageTest(int i) {
		
		matrix = testMaxes.get(i);
		
		try {
			
			assertFalse(t.check(matrix));
			
			
		} catch(IllegalArgumentException e) {
			
			assertEquals(ERR_DIM_TEST, e.getMessage());
			
		}
		
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {2, 5, 6, 11, 12})
	void okDimensionsFalseTest(int i) {
		
		matrix = testMaxes.get(i);	
		
		assertFalse(t.check(matrix));
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {3, 4, 9})
	void okDimensionsTrueTest(int i) {
		
		matrix = testMaxes.get(i);
		
		assertTrue(t.check(matrix));
	}
	
	@ParameterizedTest
	@ValueSource(ints = {8, 10, 13, 14})
	void nullPointerExceptTest(int i)  {
		
		matrix = testMaxes.get(i);
		
		assertThrowsExactly(NullPointerException.class, () -> t.check(matrix));
		
	}	
	

}
