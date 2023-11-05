package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestWeightedGradeConstructor {

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(null, 10.0);
		});
	}
	
	/**
	 * Test2
	 */
	@Test
	public void shouldNotAllowNegativeWeight() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(new SimpleGrade(50), -10.0);
		});
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldNotAllowWeightGreaterThanOne() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(new SimpleGrade(50), 10.0);
		});
	}
}
