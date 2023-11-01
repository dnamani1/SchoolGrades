package edu.westga.cs.schoolgrades.model.test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;

/**
 * Test class for addAll method in CompositeGrade class
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class TestCompositeGradeAddAll {
	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	private List<Grade> list;

	/**
	 * Setup
	 */
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(new SumOfGradesStrategy());
		this.grade0 = new SimpleGrade(10);
		this.grade1 = new SimpleGrade(20);
		this.grade2 = new SimpleGrade(30);
		this.list = new ArrayList<Grade>();
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldNotAddNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.composite.addAll(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldAddEmptyList() {
		this.composite.addAll(new ArrayList<Grade>());
		assertTrue(this.composite.getGrades().isEmpty());
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldAddOneElementList() {
		this.list.add(this.grade0);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(1, actual.size());
		assertEquals(this.grade0, actual.get(0));
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldAddManyElementsList() {
		this.list.add(this.grade0);
		this.list.add(this.grade1);
		this.list.add(this.grade2);
		this.composite.addAll(this.list);
		List<Grade> actual = this.composite.getGrades();
		assertEquals(3, actual.size());
		assertEquals(this.grade0, actual.get(0));
		assertEquals(this.grade1, actual.get(1));
		assertEquals(this.grade2, actual.get(2));
	}
}
