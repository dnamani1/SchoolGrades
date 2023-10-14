package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CalculationStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;

/**
 * This test class test the addGrade method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class CompositeGradeAddGradeTest {

	private CompositeGrade compositeGrade;
	private Grade theGrade;

	/**
	 * This is set up
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
		CalculationStrategy grades = gradeList -> 0.0;
		this.compositeGrade = new CompositeGrade(grades);
		this.theGrade = () -> 100.0;
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldThrowIllegalArgumentExceptionWhenAddedGradeIsNull() {
		assertThrows(IllegalArgumentException.class, () -> this.compositeGrade.addGrade(null));
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldReflectAddedGradeInGetValue() {
		CalculationStrategy sumStrategy = gradeList -> gradeList.stream().mapToDouble(Grade::getValue).sum();
		this.compositeGrade.setStrategy(sumStrategy);
		this.compositeGrade.addGrade(this.theGrade);
		assertEquals(100.0, this.compositeGrade.getValue());
	}

//	/**
//	 * Test3
//	 */
//	@Test
//	public void shouldAddMultipleGradesSuccessfully() {
//		this.compositeGrade.addGrade(this.theGrade);
//		this.compositeGrade.addGrade(this.theGrade);
//		assertEquals(2, this.compositeGrade.getValue());
//	}

}
