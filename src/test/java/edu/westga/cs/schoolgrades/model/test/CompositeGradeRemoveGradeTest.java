package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This is the test class for the removeGrade method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class CompositeGradeRemoveGradeTest {
	private CompositeGrade studentGrade;

	/**
	 * Setup
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		SumOfGradesStrategy sumStrategy = new SumOfGradesStrategy();
		this.studentGrade = new CompositeGrade(sumStrategy);
	}

	/**
	 * Test1
	 */
	@Test
	public void testAddAndRemoveSingleGrade() {
		SimpleGrade grade = new SimpleGrade(90);
		this.studentGrade.addGrade(grade);
		assertEquals(90, this.studentGrade.getValue());

		this.studentGrade.removeGrade(grade);
		assertEquals(0, this.studentGrade.getValue());
	}

	/**
	 * Test2
	 */
	@Test
	public void testAddMultipleAndRemoveSingleGrade() {
		SimpleGrade grade1 = new SimpleGrade(90);
		SimpleGrade grade2 = new SimpleGrade(80);
		SimpleGrade grade3 = new SimpleGrade(70);

		this.studentGrade.addGrade(grade1);
		this.studentGrade.addGrade(grade2);
		this.studentGrade.addGrade(grade3);

		assertEquals(240, this.studentGrade.getValue());

		this.studentGrade.removeGrade(grade2);
		assertEquals(160, this.studentGrade.getValue());
	}

	/**
	 * Test3
	 */
	@Test
	public void testGetValueWithEmptyGradeList() {
		assertEquals(0, this.studentGrade.getValue());
	}

}
