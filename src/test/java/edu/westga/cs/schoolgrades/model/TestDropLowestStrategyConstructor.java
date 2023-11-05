package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test class for drop lowest strategy constructor
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestDropLowestStrategyConstructor {

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullChildStrategy() {
		assertThrows(IllegalArgumentException.class, () -> {
			new DropLowestStrategy(null);
		});
	}
}
