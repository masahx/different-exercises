package teplix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


 class MatrixOperatorTest {
	
	static final String ERR_DIM_TEST = "both dimensions should be at least 2!";
	 
	List<Integer[][]> testMaxes = List.of(
				
							new Integer[][]  { {3, 3, -1}, 
								   		       {3, 4, 1 },
								              {-1, 1, 4 }
										    },
							
							new Integer[][]  { {-5,	0,	2,	3}, 
									   		   {4,	-4,	-3,	-4 },
									           {5,	2,	0,	-1 }, 
									           {0,	3,	-2,	-3 }
											    },
							new Integer[][]  { {-5,	4,	5,	0}, 
										 	   {0,	-4,	2,	3 },
											   {2,	-3,	0,	-2 }, 
											   {3,	-4,	-1,	-3 },
							   },
						    new Integer[1][0],
							new Integer[0][1],
							new Integer[][] { {1, 3},  // 5
								   			  {0, 1}
								   
							   },
							
							new Integer[][] { {1, 3},
						   			  	      {0, 4}
						   
							 },
							
							new Integer[][] { {1, 3, 4},
			   			  	      			  {0, 1, 5}
			   
							},
							
							new Integer[][] { {3, 2, 1},
										      {5, 3, 2},
										      {4, 5, 3},
										      {5, 4, 8},
										     
								
							},
							new Integer[0][0],
							new Integer[1][1],  // 10
							new Integer[1][2],
							new Integer[][] { {9, 2, null},
								 		      {3, 9, 2}, 
								 		      {4, 3, 9},
								 		      {1, 4, 3}
		   					    	
		 					}, 
							new Integer[2][0]
			
	);
	
	MatrixOperator m = new MatrixOperator();
	
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,2", "3,4"})
	void transposeSameSqTest(int example, int expected) {
				
		Integer[][] mxExamp = testMaxes.get(example);
				
		Integer[][] mxExp = testMaxes.get(expected);
		
		assertTrue(Arrays.deepEquals(mxExp, m.transpose(mxExamp)));
		
	}
	
	@Test
	void zeroRowsTransposeTest() {
		
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> m.transpose(testMaxes.get(4)));
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {9, 10, 3, 11, 13})
	void smallerMatrixTest(int i) {
				
		assertThrowsExactly(IllegalArgumentException.class, () -> m.checkUpperTpl(testMaxes.get(i)));
		
	}
	
	@Test
	void nullsInMatrixTest() {
				
		assertThrowsExactly(NullPointerException.class, () -> m.checkUpperTpl(testMaxes.get(12)));
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {9, 6, 7})
	void minimalDimensionsMessageTest(int i) {
		
		
		try {
			
			assertFalse(m.checkUpperTpl(testMaxes.get(i)));
			
			
		} catch(IllegalArgumentException e) {
			
			assertEquals(ERR_DIM_TEST, e.getMessage());
			
		}
		
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {5, 8})
	void upperDiagOKTest(int example) {
				
		assertTrue(m.checkUpperTpl(testMaxes.get(example)));
		
	}	
	
 }


