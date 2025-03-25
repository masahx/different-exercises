package smallest_modified_string;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class StringModifierTest {
	/*
	 * Daily Coding Problem #1611

	 * This problem was asked by Yahoo.

You are given a string of length N and a parameter k. The string can be manipulated by taking one of the first k letters and moving it to the end.

Write a program to determine the lexicographically smallest string that can be created after an unlimited number of moves.

For example, suppose we are given the string daily and k = 1. The best we can create in this case is ailyd.
	 * 
	 */
	private static final String ERROR_MESSAGE = "parameter k shouldn't be bigger than word's length!";
	
	StringModifier sm = new StringModifier();
	
	@ParameterizedTest
	@MethodSource("combinations")
	void ordinaryExampleTest(String original, int k, String result) {
					
		assertEquals(result, sm.getWord(original, k));
				
	}
	
	@ParameterizedTest
	@MethodSource("illegalArgumentExcept")
	void biggerKThanNTest(String word, int k) {
		
		assertThrowsExactly(IllegalArgumentException.class, () -> sm.getWord(word, k));
		
	}
	
	@ParameterizedTest
	@MethodSource("illegalArgumentExceptMessage")
	void messageInException(String word, int k) {
		
		try {
			
			sm.getWord(word, k);
			
		} catch(IllegalArgumentException e) {
			
			assertEquals(ERROR_MESSAGE, e.getMessage());
			
		}
		
	}


	private static Stream<Arguments> combinations() {	
		
		return Stream.of(
			
			Arguments.of("apple", 2, "apple"),
			Arguments.of("title", 2, "etitl"),
			Arguments.of("temperature", 3, "aturetemper")
			,Arguments.of("xiyazm", 3, "azmxiy")
		/*	,Arguments.of("", 0, "")
			,Arguments.of("a", 0, "a")  
			,Arguments.of("j", 1, "j") 
			,Arguments.of("rear", 0, "rear") 
			,Arguments.of("klba", 1, "aklb")
			,Arguments.of("eoxyky", 6, "eoxyky") 
			,Arguments.of("abcdef", 5, "abcdef")  
			,Arguments.of("bcdefg", 3, "bcdefg") 
			,Arguments.of("kok", 0, "kok") 
			,Arguments.of("aiuhihj", 1, "aiuhihj") 
			,Arguments.of("xyzfm", 2, "fmxyz") 
			,Arguments.of("sodaosj", 7, "sodaosj") 
			,Arguments.of("sakoi", 3, "akois")
			,Arguments.of("bcdefgaia", 3, "aiabcdefg") 
			,Arguments.of("a c", 1, " ca")  */
			
			// moglo bi dalje, pokrivene ne sve kombinacije, najmanji je u 1. onim koje se dohvate i 2. koje se ne dohvate
			
			
			
		);	
	}
	
	private static Stream<Arguments> illegalArgumentExcept() {
		
		return Stream.of(
				
				Arguments.of("joke", 10),
				Arguments.of("blind", 8)
		/*		,Arguments.of("", 1),  
				Arguments.of("", 2), 
				Arguments.of("", 3), 
				Arguments.of("s", 4), 
				Arguments.of("s", 5), 
				Arguments.of("ds", 4), 
				Arguments.of("de", 5), 
				Arguments.of("der", 6), 
				Arguments.of("der", 5) */
				
				
		);
		
	}
	
	private static Stream<Arguments> illegalArgumentExceptMessage() {
		
		return Stream.of(
				
				Arguments.of("joke", 10),
				Arguments.of("apple", 2)
				
		);
		
	}

}
