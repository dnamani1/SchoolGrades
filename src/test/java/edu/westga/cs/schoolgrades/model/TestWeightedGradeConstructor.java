package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

/**
 * Test
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestWeightedGradeConstructor {

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(null, 10.0);
		});
	}
	
	/**
	 * Test2
	 */
	@Test
	public void shouldNotAllowNegativeWeight() {
		Grade mockedGrade = mock(Grade.class);
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(mockedGrade, -10.0);
		});
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldNotAllowWeightGreaterThanOne() {
		Grade mockedGrade = mock(Grade.class);
		assertThrows(IllegalArgumentException.class, () -> {
			new WeightedGrade(mockedGrade, 10.0);
		});
	}
}
