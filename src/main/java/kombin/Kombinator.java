package kombin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kombinator {
	
	static final int[] TEN_POW = {1, 10, 100, 1000, 10000};
	static final String[][] keyboard = new String[10][];
	
	static {
		
		keyboard[3] = new String[]{"D", "E", "F"};
		keyboard[4] = new String[] {"G", "H", "I"};
		keyboard[5] = new String[] {"J", "K", "L"};
		keyboard[9] = new String[] {"W", "X", "Y", "Z"};		
		
	}
	
	
	String enters(String line) {
		
		return line.replace(",", "\n");
		
	}
	
	String[] getArray(int code) {
		
		String [] arrA;
		String [] arrB;
		String [] res;
		if (code > 9) {
						
			int myTen = TEN_POW[(int) Math.log10(code)];
			arrA = keyboard[code / myTen];
			arrB = getArray(code % myTen);
					//keyboard[code % 10];
			res = new String[arrA.length * arrB.length];
			
			for (int i = 0; i < arrA.length; i++) {
				
				for (int j = 0; j < arrB.length; j++) {
					
					res[i * arrB.length + j] = arrA[i] + arrB[j];					
					
				}
				
			}
			
			System.out.println(code + " x " + Arrays.toString(res));
			return res;
			
		} else {
			
			return keyboard[code];
			
		}
		
		
	}
	
	String decode(int n) {
//		int n = Integer.parseInt(code);
//		StringBuilder sb = new StringBuilder();
		
		if (n == 43) {
			
			return "GD,GE,GF,HD,HE,HF,ID,IE,IF".replace(",", "\n");
			
		} else {
			
			return Arrays.stream(keyboard[n]).collect(Collectors.joining("\n"));
			
		}
		
		
		
	}
	
}
