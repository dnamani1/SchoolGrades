package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This is the test class for getvalue method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class CompositeGradeGetValueTest {
	private CompositeGrade studentGrade;
	private SumOfGradesStrategy sumStrategy;

	/**
	 * Set up
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
	public void testGetValueWithNoGradesShouldReturnZero() {
		assertEquals(0, this.studentGrade.getValue());
	}

	/**
	 * Test2
	 */
	@Test
	public void testGetValueWithSingleGradeShouldReturnGradeValue() {
		SimpleGrade grade = new SimpleGrade(90);
		this.studentGrade.addGrade(grade);
		assertEquals(90, this.studentGrade.getValue());
	}

	/**
	 * Test3
	 */
	@Test
	public void testGetValueWithMultipleGradesShouldReturnSum() {
		SimpleGrade grade1 = new SimpleGrade(90);
		SimpleGrade grade2 = new SimpleGrade(80);
		this.studentGrade.addGrade(grade1);
		this.studentGrade.addGrade(grade2);
		assertEquals(170, this.studentGrade.getValue());
	}

	/**
	 * Test4
	 */
	@Test
	public void testGetValueAfterRemovingAGradeShouldReturnCorrectValue() {
		SimpleGrade grade1 = new SimpleGrade(90);
		SimpleGrade grade2 = new SimpleGrade(80);
		this.studentGrade.addGrade(grade1);
		this.studentGrade.addGrade(grade2);
		this.studentGrade.removeGrade(grade1);
		assertEquals(80, this.studentGrade.getValue());
	}

}
