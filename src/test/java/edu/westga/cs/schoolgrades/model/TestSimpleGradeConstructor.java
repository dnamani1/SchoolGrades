package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestSimpleGradeConstructor {

	private static final double DELTA = 0.001;

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNegativeGrades() {
		assertThrows(IllegalArgumentException.class, () -> {
			new SimpleGrade(-1);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldAllowZeroValue() {
		SimpleGrade grade = new SimpleGrade(0);
		assertEquals(0, grade.getValue(), DELTA);
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldAllowPositiveValue() {
		SimpleGrade grade = new SimpleGrade(50.0);
		assertEquals(50.0, grade.getValue(), DELTA);
	}

}
