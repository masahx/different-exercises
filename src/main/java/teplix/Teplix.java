package teplix;


public class Teplix {
	
	static final String ERR_DIM = "both dimensions should be at least 2!";

	
	
//	https://stackoverflow.com/questions/15449711/transpose-double-matrix-with-a-java-function
	
//	dalje sonarqube sa code coverage
	
//	bela kutija

	
		
	boolean check(Integer [][] matrix) {
	
		MatrixOperator mo = new MatrixOperator();
		
		return mo.checkUpperTpl(matrix) && mo.checkUpperTpl(mo.transpose(matrix));
	}

}
