package teplix;

import java.util.Arrays;

public class Teplix {
	
	static final String ERR_DIM = "both dimensions should be at least 2!";
	int x;
	int y;
	
	private void getDimensions(Integer[][] matrix) {
		
		x = matrix.length;
		
		y = (x > 0)? matrix[0].length : 0;
		
	}
	
	
	
//	https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
//	dalje sonarqube sa code coverage
	
//	bela kutija

	/*
	ne uradi testove sa mavenom, mislim da je možda ovo 
	[INFO] --- maven-surefire-plugin:3.0.0-M7:test (default-test) @ potpisivach-fajlova ---
	[INFO] Using auto detected provider org.apache.maven.surefire.junitplatform.JUnitPlatformProvider
	
	- ovako je kod KDPValidatorPotpisivanje, a u fizz-buzz mislim da ovde vuče iz JUnita 4 i možda zato 
	ne vidi testove
*/	
		
	boolean check(Integer [][] matrix) {
	
		getDimensions(matrix);
			
		if (x < 2 || y < 2) {
			
			throw new IllegalArgumentException(ERR_DIM);
			
		}	
		
		if (Arrays.stream(matrix).flatMap(Arrays::stream).anyMatch(x -> x == null)) {
		
			throw new NullPointerException();
			
		}	
		
		MatrixOperator mo = new MatrixOperator();
		
		return mo.checkUpperTpl(matrix) && mo.checkUpperTpl(mo.transpose(matrix));
	}

}
