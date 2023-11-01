package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;

/**
 * This test class test the constructor of the CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class TestCompositeGradeConstructor {

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullStrategy() {
		assertThrows(IllegalArgumentException.class, () -> {
			new CompositeGrade(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldHaveNoGradesWhenCreated() {
		CompositeGrade grade = new CompositeGrade(new SumOfGradesStrategy());
		assertTrue(grade.getGrades().isEmpty());
	}
}
