package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class TestCompositeGradeGetValue {

	/**
	 * Test1
	 */
	@Test
	public void shouldGetValue() {
		CompositeGrade composite = new CompositeGrade(new SumOfGradesStrategy());
		composite.add(new SimpleGrade(10));
		composite.add(new SimpleGrade(20));
		composite.add(new SimpleGrade(30));
		assertEquals(60, composite.getValue(), 0.01);
	}

}
