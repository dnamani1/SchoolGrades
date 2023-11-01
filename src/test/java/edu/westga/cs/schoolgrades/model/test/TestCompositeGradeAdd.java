package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * This test class test the addGrade method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public class TestCompositeGradeAdd {
	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;

	/**
	 * Setup
	 */
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(new SumOfGradesStrategy());
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);
	}

	/**
	 * Test1
	 */
	@Test
	public void canAddOneGrade() {
		this.composite.add(this.grade0);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(1, grades.size());
		assertEquals(this.grade0, grades.get(0));
	}

	/**
	 * Test1
	 */
	@Test
	public void canAddManyGrades() {
		this.composite.add(this.grade0);
		this.composite.add(this.grade1);
		this.composite.add(this.grade2);
		List<Grade> grades = this.composite.getGrades();
		assertEquals(3, grades.size());
		assertEquals(this.grade0, grades.get(0));
		assertEquals(this.grade1, grades.get(1));
		assertEquals(this.grade2, grades.get(2));
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAddNullGrade() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.composite.add(null);
		});
	}
}