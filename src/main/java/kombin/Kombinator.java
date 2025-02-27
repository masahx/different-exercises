package kombin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kombinator {
	
	private static final String MAX_LEN_ERROR = "max length for code is 6 digits!";
	static final int[] TEN_POW = {1, 10, 100, 1000, 10000, 100000};
	static final String[][] keyboard = new String[10][];
	
	static {
				
		keyboard[0] = 				
		keyboard[1] = new String[] {"_"};		
		keyboard[2] = new String[] {"A", "B", "C"};
		keyboard[3] = new String[] {"D", "E", "F"};
		keyboard[4] = new String[] {"G", "H", "I"};
		keyboard[5] = new String[] {"J", "K", "L"};
		keyboard[6] = new String[] {"M", "N", "O"};
		keyboard[7] = new String[] {"P", "Q", "R", "S"};
		keyboard[8] = new String[] {"T", "U", "V"};
		keyboard[9] = new String[] {"W", "X", "Y", "Z"};
		
	}
	

// publishuj Git, pa izbriši štampanje rezultata i opet commituj
// dodaj Main sledeći put i isprobaj neke šifre
	
	String enters2(String [] resArray) {
		
		return String.join("\n", resArray);
		
	}
	
	String[] getArray(int code) {
		
		String [] arrA;
		String [] arrB;
		String [] res;
		if (code > 9 && code < 10000000) {
						
			int myTen = TEN_POW[(int) Math.log10(code)];
			arrA = keyboard[code / myTen];
			arrB = getArray(code % myTen);
			
			res = new String[arrA.length * arrB.length];
			
			for (int i = 0; i < arrA.length; i++) {
				
				for (int j = 0; j < arrB.length; j++) {
					
					res[i * arrB.length + j] = arrA[i] + arrB[j];					
					
				}
				
			}
			
			System.out.println(code + " x " + Arrays.toString(res));
			return res;
			
		} else if (code <= 9) {
			
			return keyboard[code];
			
		} else {
			
			throw new ArrayIndexOutOfBoundsException(MAX_LEN_ERROR);
			
		}
		
		
	}
	
	String decode(int n) {
		
		return enters2(getArray(n));	
		
		
	}
	
}
