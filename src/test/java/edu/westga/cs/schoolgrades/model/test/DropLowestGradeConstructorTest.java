package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CalculationStrategy;
import edu.westga.cs.schoolgrades.model.DropLowestGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This is the test class for DropLowestGradeDecorator class constructor
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class DropLowestGradeConstructorTest {

	private DropLowestGrade studentGrade;
	private CalculationStrategy baseStrategy;

	/**
	 * Setup
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.baseStrategy = new SumOfGradesStrategy();
		this.studentGrade = new DropLowestGrade(this.baseStrategy);
	}

	/**
	 * Test1
	 */
	@Test
	public void testConstructorWithNullBaseStrategyShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> new DropLowestGrade(null));
	}

	/**
	 * Test2
	 */
	@Test
	public void testCalculateWithNullGradesShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> this.studentGrade.calculate(null));
	}

	/**
	 * Test3
	 */
	@Test
	public void testCalculateWithEmptyListOfGradesShouldReturnZero() {
		List<Grade> grades = new ArrayList<>();
		assertEquals(0, this.studentGrade.calculate(grades));
	}

	/**
	 * Test4
	 */
	@Test
	public void testCalculateWithListOfMultipleGrades() {
		List<Grade> grades = new ArrayList<>();
		grades.add(new SimpleGrade(90));
		grades.add(new SimpleGrade(80));
		grades.add(new SimpleGrade(70));

		assertEquals(170, this.studentGrade.calculate(grades));
	}

}
