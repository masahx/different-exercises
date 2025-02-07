package teplix;

import java.util.Arrays;

public class MatrixOperator {
	
	static final String ERR_DIM_TEST = "both dimensions should be at least 2!";
	 
	Integer[][] matrix;
	
	Integer[][] transpose(Integer[][] inMatrix) {
				
		int outN = inMatrix.length;
		int outM = inMatrix[0].length;
		
		Integer[][] outMatrix = new Integer[outM][outN];
		
		for (int i = 0; i < outN; i++) {
			
			for (int j = 0; j < outM; j++) {
				
				outMatrix[j][i] = inMatrix[i][j];
				
			}
			
		}
		
		return outMatrix;
		
	}
	
	
	private void dimensionCheck() {
		
		if (matrix.length < 2 || matrix[0].length < 2) {
			
			throw new IllegalArgumentException(ERR_DIM_TEST);
			
		}
		
	}
	
	private void nullCheck() {
		
		if (Arrays.stream(matrix).flatMap(Arrays::stream).anyMatch(e -> e == null)) {
			
			throw new NullPointerException();
			
		}	
		
	}
	
	boolean checkUpperTpl(Integer[][] matrix) {
		
		this.matrix = matrix;
		
		dimensionCheck();
		
		nullCheck();			
		
		int elem;
		int limit;
		
		for (int i = 0; i < matrix[0].length - 1; i++) {
			
			elem = matrix[0][i];
			limit = Integer.min(matrix.length, matrix[0].length - i);
			
			for (int j = 1; j < limit; j++ ) {
				
				if (matrix[j][j + i] != elem) {
					
					return false;
					
				}
				
			}
			
		}
		
		return true;
		
	}

}
