package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import es.upm.grise.profundizacion2018.sudokuverifier.SudokuVerifier;

public class SudokuVerifierTest {
    
	SudokuVerifier sudoku_verifier = new SudokuVerifier();;
	
	String valid_values = "735614892" + 
			 "842973561" +
			 "961285374" +
			 "286349157" +
			 "413857926" +
			 "579126438" +
			 "157492683" +
			 "694738215" +
			 "328561749";


	String invalid_grid = "735614892" + 
				  "842973561" +
				  "161285374" +
				  "286349157" +
				  "413857926" +
				  "579126438" +
				  "157492683" +
				  "694738215" +
				  "328561749";
	
	String invalid_row = "835614892" + 
				 "742973561" +
				 "961285374" +
				 "286349157" +
				 "413857926" +
				 "579126438" +
				 "157492683" +
				 "694738215" +
				 "328561749";
	
	String invalid_col = "735614892" + 
				 "842973561" +
				 "961285374" +
				 "286349157" +
				 "413857926" +
				 "579126438" +
				 "157492683" +
				 "694738215" +
				 "328561479";
	
	String invalid_number =  "735614892" + 
					 "842973561" +
					 "961285374" +
					 "286349157" +
					 "413857926" +
					 "579120438" +
					 "157492683" +
					 "694738215" +
					 "328561749";
	
	@Test
	public void check_rule_1() {
		int expected = -1;
		int actual = sudoku_verifier.verify(invalid_number);
		assertEquals("Expected: " + expected + ", actual = " + actual, expected, actual);
	}
	
	@Test
	public void check_rule_2() {
		int expected = -2;
		int actual = sudoku_verifier.verify(invalid_grid);
		assertEquals("Expected: " + expected + ", actual = " + actual, expected, actual);
	}
	
	@Test
	public void check_rule_3() {
		int expected = -3;
		int actual = sudoku_verifier.verify(invalid_row);
		assertEquals("Expected: " + expected + ", actual = " + actual, expected, actual);
	}

	@Test
	public void check_rule_4() {
		int expected = -4;
		int actual = sudoku_verifier.verify(invalid_col);
		assertEquals("Expected: " + expected + ", actual = " + actual, expected, actual);
	}
	
	@Test
	public void check_rule_5() {
		int expected = 0;
		int actual = sudoku_verifier.verify(valid_values);
		assertEquals("Expected: " + expected + ", actual = " + actual, expected, actual);
	}
	
}
