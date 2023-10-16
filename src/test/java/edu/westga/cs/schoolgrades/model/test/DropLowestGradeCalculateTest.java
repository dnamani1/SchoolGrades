package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.DropLowestGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * Test case for calculate method in DropLowestGradeDecorator class
 * 
 * @author Deeksha Namani
 * @version 10/15/1023
 */
public class DropLowestGradeCalculateTest {
	private DropLowestGrade studentGrade;

	/**
	 * Set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		SumOfGradesStrategy sumStrategy = new SumOfGradesStrategy();
		this.studentGrade = new DropLowestGrade(sumStrategy);
	}

	/**
	 * Test1
	 */
	@Test
	public void testCalculateWithNullGradesShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.studentGrade.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void testCalculateWithEmptyListOfGradesShouldReturnZero() {
		List<Grade> grades = new ArrayList<>();
		assertEquals(0, this.studentGrade.calculate(grades));
	}

	/**
	 * Test3
	 */
	@Test
	public void testCalculateWithMultipleGradesShouldDropLowestAndReturnSum() {
		List<Grade> grades = Arrays.asList(new SimpleGrade(90), new SimpleGrade(80), new SimpleGrade(70));

		assertEquals(170, this.studentGrade.calculate(grades));
	}

	/**
	 * Test4
	 */
	@Test
	public void testCalculateWithSameGradesShouldDropOneAndReturnSum() {
		List<Grade> grades = Arrays.asList(new SimpleGrade(90), new SimpleGrade(90), new SimpleGrade(90));

		assertEquals(180, this.studentGrade.calculate(grades));
	}

}
