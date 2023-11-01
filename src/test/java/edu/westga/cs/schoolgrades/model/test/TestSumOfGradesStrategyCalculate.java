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
public class TestSumOfGradesStrategyCalculate {
	private static final double DELTA = 0.001;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	private List<Grade> grades;
	private SumOfGradesStrategy strategy;

	/**
	 * setup
	 */
	@BeforeEach
	public void setup() {
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);

		this.grades = new ArrayList<Grade>();

		this.strategy = new SumOfGradesStrategy();
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.strategy.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldCalculateSumOfOneGrades() {
		this.grades.add(this.grade0);
		assertEquals(this.grade0.getValue(), this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * Test4
	 */
	@Test
	public void shouldCalculateSumOManyGrades() {
		this.grades.add(this.grade0);
		this.grades.add(this.grade1);
		this.grades.add(this.grade2);
		assertEquals(60, this.strategy.calculate(this.grades), DELTA);
	}

}
