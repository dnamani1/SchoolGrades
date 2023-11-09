package edu.westga.cs.schoolgrades.model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class for Composite Grade Add
 * 
 * @author lewise
 * @version 11/5/2023
 */
public class TestCompositeGradeAdd {

	private CompositeGrade composite;
	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;

	/**
	 * Setup
	 */
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
        this.mockGrade0 = mock(Grade.class);
        this.mockGrade1 = mock(Grade.class);
        this.mockGrade2 = mock(Grade.class);
	}

	/**
	 * Test1
	 */
	@Test
	public void canAddOneGrade() {
		this.composite.add(this.mockGrade0);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(this.mockGrade0, grades.get(0));
	}

	/**
	 * Test2
	 */
	@Test
	public void canAddManyGrades() {
		this.composite.add(this.mockGrade0);
		this.composite.add(this.mockGrade1);
		this.composite.add(this.mockGrade2);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(this.mockGrade0, grades.get(0));
		assertEquals(this.mockGrade1, grades.get(1));
		assertEquals(this.mockGrade2, grades.get(2));
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldNotAddNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.composite.add(null);
		});
	}
}
