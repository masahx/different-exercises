package kombin;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class KombinatorTest {
	
	Kombinator k = new Kombinator();
	
	String enters2(String [] inArray) {
		
		return String.join("\n", inArray);
		
	}
	
	String enters(String line) {
			
		return line.replace(",", "\n");
			
	}
	
	@Test 
	void makeEnters2Test() {
		
		assertEquals(("W\nX\nY\nZ"), enters2(new String[] {"W", "X", "Y", "Z"}));
/*		System.out.println(String.join("\n", k.getArray(4945)));
		System.out.println(String.join("\n", k.getArray(299)));
		System.out.println(String.join("\n", k.getArray(7323533))); */
	}

	@ParameterizedTest
	@MethodSource("enteriString")
	void makeEntersTest(String expected, String inString) {
		
		assertEquals(expected, enters(inString));
		
	}
	
	@ParameterizedTest
	@MethodSource("enteriDodaj")
	void makeEntersKombinTest(String expected, String[] inputArr) {
		
		assertEquals(expected, k.enters2(inputArr));
		
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
				
	} 	
	
	@Test
	void tensTest() {
		
		assertEquals(1, Kombinator.TEN_POW[0]);
		
	}
	
	@ParameterizedTest
	@ValueSource(ints = {3216544, 1000000})
	void maxLength6ExceptionTypeTest(int n) {
		
		assertThrowsExactly(ArrayIndexOutOfBoundsException.class, () -> k.decode(n));
		
	}
	
	
	@ParameterizedTest
	@ValueSource(ints = {470789180, 157988})
	void maxLength6ExceptionMessageTest(int n) {
		
		try {
			
			k.decode(n);
			
		} catch(ArrayIndexOutOfBoundsException e) {
			
			assertEquals("max length for code is 6 digits!", e.getMessage());
			
		}
		
	}
	
	private static Stream<Arguments> enteriDodaj() {
		
		return Stream.of(
		
			Arguments.of("D\nE\nF", new String[] {"D", "E", "F"}),
			Arguments.of("S\nT\nX\nV", new String[] {"S", "T", "X", "V"})
		
		);				
		
	}
	
	private static Stream<Arguments> enteriString() {	
		
		return Stream.of(
			
			Arguments.of("W\nX\nY\nZ", "W,X,Y,Z"),
			Arguments.of("D\nE\nF", "D,E,F")
		);
	
	}
	
	private static Stream<Arguments> decoder() {	
				
		return Stream.of(
			
			Arguments.of(9, "W,X,Y,Z"),
			Arguments.of(3, "D,E,F"),
			Arguments.of(4, "G,H,I"),
			Arguments.of(43, "GD,GE,GF,HD,HE,HF,ID,IE,IF" ),
			Arguments.of(543, "JGD,JGE,JGF,JHD,JHE,JHF,JID,JIE,JIF,KGD,KGE,KGF,KHD,KHE,KHF,KID,KIE,KIF,LGD,LGE,LGF,LHD,LHE,LHF,LID,LIE,LIF"),
			Arguments.of(0, "_"),
			Arguments.of(1, "_"),
			Arguments.of(2, "A,B,C"),
			Arguments.of(6, "M,N,O"),
			Arguments.of(7, "P,Q,R,S"),
			Arguments.of(8, "T,U,V")
			
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
	

}
