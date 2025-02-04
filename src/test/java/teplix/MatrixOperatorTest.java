package teplix;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


 class MatrixOperatorTest {
		
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
										      {5, 4, 8}
								
							}
										    
			
	);
	
	MatrixOperator m = new MatrixOperator();
	
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,2", "3,4"})
	void transposeSameSqTest(int example, int expected) {
				
		Integer[][] mxExamp = testMaxes.get(example);
				
		Integer[][] mxExp = testMaxes.get(expected);
		
		assertTrue(Arrays.deepEquals(mxExp, m.transpose(mxExamp)));
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {5, 8})
	void upperDiagOKTest(int example) {
		
		MatrixOperator m = new MatrixOperator();
		
		assertTrue(m.checkUpperTpl(testMaxes.get(example)));
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {6, 7})
	void upperDiagNotOKTest(int example) {
		
		MatrixOperator m = new MatrixOperator();
		
		assertFalse(m.checkUpperTpl(testMaxes.get(example)));
		
	}

}
