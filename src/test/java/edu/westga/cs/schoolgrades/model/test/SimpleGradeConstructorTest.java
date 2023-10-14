package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

/**
 * This is the test class for constructor in SimpeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class SimpleGradeConstructorTest {

	/**
	 * This is set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * Test1
	 */
	@Test
	public void testConstructorWithPositiveValueShouldSetValue() {
		SimpleGrade grade = new SimpleGrade(90.5);
		assertEquals(90.5, grade.getValue(), 0.01);
	}

	/**
	 * Test2
	 */
	@Test
	public void testConstructorWithZeroValueShouldSetValueToZero() {
		SimpleGrade grade = new SimpleGrade(0.0);
		assertEquals(0.0, grade.getValue(), 0.01);
	}

}
