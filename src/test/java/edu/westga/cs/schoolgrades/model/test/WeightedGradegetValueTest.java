package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.WeightedGrade;

/**
 * This is the test class for getValue method in WeightedGrade class
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class WeightedGradegetValueTest {
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
	public void testGetValueWithWeightOfZeroShouldReturnZero() {
		WeightedGrade weightedGrade = new WeightedGrade(this.testGrade, 0.0);
		assertEquals(0.0, weightedGrade.getValue());
	}

	/**
	 * Test2
	 */
	@Test
	public void testGetValueWithWeightOfOneShouldReturnValueOfGrade() {
		WeightedGrade weightedGrade = new WeightedGrade(this.testGrade, 1.0);
		assertEquals(this.testGrade.getValue(), weightedGrade.getValue());
	}

	/**
	 * Test3
	 */
	@Test
	public void testGetValueWithHalfWeightShouldReturnHalfValueOfGrade() {
		WeightedGrade weightedGrade = new WeightedGrade(this.testGrade, 0.5);
		assertEquals(this.testGrade.getValue() * 0.5, weightedGrade.getValue());
	}

}
