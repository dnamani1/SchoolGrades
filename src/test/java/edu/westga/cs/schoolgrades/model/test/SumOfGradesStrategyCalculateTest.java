package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This is the test class for calculate metho in SumOfGradesStrategy class
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class SumOfGradesStrategyCalculateTest {
	private Grade grade1;
	private Grade grade2;
	private Grade grade3;
	private SumOfGradesStrategy strategy;

	/**
	 * This is the set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.strategy = new SumOfGradesStrategy();
		this.grade1 = new SimpleGrade(85);
		this.grade2 = new SimpleGrade(90);
		this.grade3 = new SimpleGrade(95);
	}

	/**
	 * Test1
	 */
	@Test
	public void testCalculateShouldThrowExceptionIfListIsNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.strategy.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void testCalculateForEmptyListShouldReturnZero() {
		List<Grade> grades = new ArrayList<>();
		double result = this.strategy.calculate(grades);
		assertEquals(0, result);
	}

	/**
	 * Test3
	 */
	@Test
	public void testCalculateForListOfGradesShouldReturnCorrectSum() {
		List<Grade> grades = new ArrayList<>();
		grades.add(this.grade1);
		grades.add(this.grade2);
		grades.add(this.grade3);

		double expectedSum = this.grade1.getValue() + this.grade2.getValue() + this.grade3.getValue();

		double result = this.strategy.calculate(grades);
		assertEquals(expectedSum, result);
	}

}
