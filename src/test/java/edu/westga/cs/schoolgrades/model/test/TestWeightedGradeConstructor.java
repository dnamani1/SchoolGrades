package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

/**
 * This is the test class for constructor in the weightedGrade class.
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
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
