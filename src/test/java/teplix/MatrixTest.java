package teplix;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


 class MatrixTest {
		
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
							new Integer[0][1]
							 		   
										    
			
	);
	
	@ParameterizedTest
	@CsvSource(value = {"0,0", "1,2", "3,4"})
	void transposeSameSqTest(int example, int expected) {
		
		Matrix m = new Matrix();
		
		Integer[][] mxExamp = testMaxes.get(example);
				
		Integer[][] mxExp = testMaxes.get(expected);
		
		assertTrue(Arrays.deepEquals(mxExp, m.transpose(mxExamp)));
		
	}

}
