package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * Test class for setStrategy method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class CompositeGradeSetStrategyTest {
	private CompositeGrade studentGrade;
	private SumOfGradesStrategy sumStrategy;
	private AverageOfGradesStrategy avgStrategy;

	/**
	 * Setup
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		this.sumStrategy = new SumOfGradesStrategy();
		this.avgStrategy = new AverageOfGradesStrategy();
		this.studentGrade = new CompositeGrade(this.sumStrategy);
	}

	/**
	 * Test
	 */
	@Test
	public void testSetStrategyWithValidStrategyChangesCalculation() {

		this.studentGrade.addGrade(new SimpleGrade(90));
		this.studentGrade.addGrade(new SimpleGrade(80));
		assertEquals(170, this.studentGrade.getValue());

		this.studentGrade.setStrategy(this.avgStrategy);
		assertEquals(85, this.studentGrade.getValue());
	}

}
