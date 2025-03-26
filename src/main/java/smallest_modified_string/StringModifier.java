package smallest_modified_string;

public class StringModifier {
	
	private static final String ERROR_MESSAGE = "parameter k shouldn't be bigger than word's length!";
	
	String getWord(String original, int k) {
		
		if (k > original.length()) {
			
			throw new IllegalArgumentException(ERROR_MESSAGE);
			
		}
		
		String mixed = original; 
		String minMixed = original;
		
		do {
			
			mixed = mixed.substring(k) + mixed.substring(0, k);
			if (mixed.compareTo(minMixed) < 0) {
				
				minMixed = mixed;
				
			}
			
		} while (!mixed.equals(original));
		
		return minMixed;
		
	}

}
