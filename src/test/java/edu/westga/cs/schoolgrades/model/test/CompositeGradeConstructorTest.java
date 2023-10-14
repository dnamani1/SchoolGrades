package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CalculationStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;

/**
 * This test class test the constructor of the CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class CompositeGradeConstructorTest {
	private CalculationStrategy strategy;

	/**
	 * This is set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.strategy = gradeList -> 0.0;
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenStrategyIsNull() {
		assertThrows(IllegalArgumentException.class, () -> new CompositeGrade(null));
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldInitializeEmptyGradeListWhenCreated() {
		CompositeGrade grade = new CompositeGrade(this.strategy);
		assertEquals(0.0, grade.getValue());
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldSetStrategySuccessfully() {
		CompositeGrade grade = new CompositeGrade(this.strategy);
		assertNotNull(grade);
	}
}
