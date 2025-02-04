package teplix;

public class MatrixOperator {
	
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
	
	// hoću da prebacim ovo iz teplixa ovde? kao i računanje dimenzija
	boolean checkUpperTpl(Integer[][] matrix) {
		
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
