package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.DropLowestStrategy;

/**
 * This is the test class for DropLowestGradeDecorator class constructor
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class TestDropLowestGradeConstructor {

	/**
	 * Test
	 */
	@Test
	public void shouldNotAllowNullChildStrategy() {
		assertThrows(IllegalArgumentException.class, () -> { 
			new DropLowestStrategy(null);
		});
	}

}
