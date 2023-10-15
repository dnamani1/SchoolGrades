package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;

/**
 * This is the test class for AverageOfGrades method calculate.
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class AverageOfGradesStrategyCalculateTest {
	private AverageOfGradesStrategy strategy;

	/**
	 * This is set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.strategy = new AverageOfGradesStrategy();
	}

	/**
	 * Test1
	 */
	@Test
	public void testCalculateWithNullGradesShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.strategy.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void testCalculateWithListOfOneGrade() {
		List<Grade> grades = new ArrayList<>();
		grades.add(new SimpleGrade(90));
		assertEquals(90, this.strategy.calculate(grades));
	}

	/**
	 * Test3
	 */
	@Test
	public void testCalculateWithListOfMultipleGrades() {
		List<Grade> grades = new ArrayList<>();
		grades.add(new SimpleGrade(90));
		grades.add(new SimpleGrade(80));
		grades.add(new SimpleGrade(70));
		double expectedAverage = 80.0;
		assertEquals(expectedAverage, this.strategy.calculate(grades));
	}

	/**
	 * Test4
	 */
	@Test
	public void testCalculateWithListOfGradesWithDecimalValues() {
		List<Grade> grades = new ArrayList<>();
		grades.add(new SimpleGrade(95.5));
		grades.add(new SimpleGrade(65.5));
		grades.add(new SimpleGrade(75.5));
		double expectedAverage = (95.5 + 65.5 + 75.5) / 3.0;
		assertEquals(expectedAverage, this.strategy.calculate(grades));
	}

}
