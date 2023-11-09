package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Test class for composite grade constructor
 * 
 * @author lewis
 * @version 11/5/2023
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
		GradeCalculationStrategy mockStrategy = mock(GradeCalculationStrategy.class);
        CompositeGrade grade = new CompositeGrade(mockStrategy);
        assertTrue(grade.getGrades().isEmpty());
	}

}
