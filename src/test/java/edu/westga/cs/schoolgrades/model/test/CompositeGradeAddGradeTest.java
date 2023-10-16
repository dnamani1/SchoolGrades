package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This test class test the addGrade method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class CompositeGradeAddGradeTest {
	private CompositeGrade studentGrade;
	private SumOfGradesStrategy sumStrategy;

	/**
	 * This is the set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.sumStrategy = new SumOfGradesStrategy();
		this.studentGrade = new CompositeGrade(this.sumStrategy);
	}

	/**
	 * Test1
	 */
	@Test
	public void testAddGradeWithNullShouldThrowException() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.studentGrade.addGrade(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void testAddGradeWithValidGrade() {
		Grade grade = new SimpleGrade(90);
		this.studentGrade.addGrade(grade);
		assertEquals(90, this.studentGrade.getValue());
	}

	/**
	 * Test3
	 */
	@Test
	public void testAddMultipleGrades() {
		Grade grade1 = new SimpleGrade(90);
		Grade grade2 = new SimpleGrade(80);
		Grade grade3 = new SimpleGrade(70);

		this.studentGrade.addGrade(grade1);
		this.studentGrade.addGrade(grade2);
		this.studentGrade.addGrade(grade3);

		assertEquals(240, this.studentGrade.getValue());
	}

	/**
	 * Test4
	 */
	@Test
	public void testRemoveGradeAfterAdding() {
		Grade grade = new SimpleGrade(90);
		this.studentGrade.addGrade(grade);
		this.studentGrade.removeGrade(grade);
		assertEquals(0, this.studentGrade.getValue());
	}
}