package teplix;

public class Matrix {
	
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

}
