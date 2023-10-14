package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

/**
 * This is the test class for constructor in the weightedGrade class.
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class WeightedGradeConstructorTest {
	private Grade testGrade;

	/**
	 * This is set up
	 *
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.testGrade = new SimpleGrade(90.0);
	}

	/**
	 * Test1
	 */
	@Test
	public void testConstructorWithValidParametersShouldNotThrowException() {

		WeightedGrade weightedGrade = new WeightedGrade(this.testGrade, 0.5);
		assertEquals(45, weightedGrade.getValue(), 0.01);
	}

	/**
	 * Test2
	 */
	@Test
	public void testConstructorWithNegativeWeightShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(this.testGrade, -0.1);
		});
	}

	/**
	 * Test3
	 */
	@Test
	public void testConstructorShouldThrowExceptionForNullGrade() {
		Grade mockGrade = null;
		assertThrows(IllegalArgumentException.class, () -> new WeightedGrade(mockGrade, 0.5));
	}

}
