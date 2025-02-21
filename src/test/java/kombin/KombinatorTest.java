package kombin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class KombinatorTest {
	
	Kombinator k = new Kombinator();
	
	String enters(String commaIn) {
		
		return commaIn.replace(",", "\n");
		
	}
	
	
	@Test 
	void makeEntersTest() {
		
		assertEquals(("W\nX\nY\nZ"), enters("W,X,Y,Z"));
		
	}
	
	@ParameterizedTest
	@MethodSource("enteriDodaj")
	void makeEntersKombinTest(String expected, String input) {
		
		assertEquals(expected, k.enters(input));
		
	}
	
	@ParameterizedTest
	@MethodSource("nizovi")
	void getResultArrayTest(int code, String[] result) {
		
		assertTrue(Arrays.equals(result, k.getArray(code)));
		
	}
	
	@ParameterizedTest
	@MethodSource("decoder")
	void exampleOneTest(int n, String combo) {
				
		assertEquals(enters(combo), k.decode(n));
				
	} 	/* */
	
	private static Stream<Arguments> enteriDodaj() {
		
		return Stream.of(
		
			Arguments.of("D\nE\nF", "D,E,F"),
			Arguments.of("S\nT\nX\nV", "S,T,X,V")
		
		);				
		
	}
	
	private static Stream<Arguments> decoder() {	
				
		return Stream.of(
			
			Arguments.of(9, "W,X,Y,Z"),
			Arguments.of(3, "D,E,F"),
			Arguments.of(4, "G,H,I"),
			Arguments.of(43, "GD,GE,GF,HD,HE,HF,ID,IE,IF" )
			
		);
	
	}
	
	private static Stream<Arguments> nizovi() {
		
		return Stream.of(
				
				Arguments.of(9, new String[] {"W", "X", "Y", "Z"}),
				Arguments.of(4, new String[] {"G", "H", "I"}),
				Arguments.of(43, new String[] {"GD", "GE", "GF", "HD", "HE", "HF", "ID", "IE", "IF"}),
				Arguments.of(49, new String[] {"GW", "GX", "GY", "GZ", "HW", "HX", "HY", "HZ", "IW", "IX", "IY", "IZ"}),				
				Arguments.of(543, new String[] {"JGD", "JGE", "JGF", "JHD", "JHE", "JHF", "JID", "JIE", "JIF",
											    "KGD", "KGE", "KGF", "KHD", "KHE", "KHF", "KID", "KIE", "KIF",
											    "LGD", "LGE", "LGF", "LHD", "LHE", "LHF", "LID", "LIE", "LIF"})
		
		);
		
	}
	/*	*/

}
