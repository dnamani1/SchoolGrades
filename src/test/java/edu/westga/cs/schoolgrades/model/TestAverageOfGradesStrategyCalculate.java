package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Test class for average of grades strategy calculate
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestAverageOfGradesStrategyCalculate {

	private static final double DELTA = 0.001;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;

	private List<Grade> grades;

	private AverageOfGradesStrategy strategy;

	/**
	 * setup
	 */
	@BeforeEach
	public void setup() {
		this.mockGrade0 = mock(Grade.class);
		this.mockGrade1 = mock(Grade.class);
		this.mockGrade2 = mock(Grade.class);

		when(this.mockGrade0.getValue()).thenReturn(10.0);
        when(this.mockGrade1.getValue()).thenReturn(20.0);
        when(this.mockGrade2.getValue()).thenReturn(30.0);

		this.grades = new ArrayList<Grade>();

		this.strategy = new AverageOfGradesStrategy();
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.strategy.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldGiveZeroIfNoGrades() {
		assertEquals(0, this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldCalculateAverageOfOneGrades() {
		this.grades.add(this.mockGrade0);
		assertEquals(this.mockGrade0.getValue(), this.strategy.calculate(this.grades), DELTA);
	}

	/**
	 * Test4
	 */
	@Test
	public void shouldCalculateSumOManyGrades() {
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade2);
		assertEquals(20, this.strategy.calculate(this.grades), DELTA);
	}

}
