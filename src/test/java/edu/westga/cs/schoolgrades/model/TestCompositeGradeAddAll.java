package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestCompositeGradeAddAll {

	private CompositeGrade composite;
	private Grade grade0;
	private Grade grade1;
	private Grade grade2;
	private List<Grade> list;

	/**
	 * setup
	 */
	@BeforeEach
	public void setup() {
		this.composite = new CompositeGrade(mock(GradeCalculationStrategy.class));
		this.grade0 = mock(Grade.class);
		this.grade1 = mock(Grade.class);
		this.grade2 = mock(Grade.class);
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
	 * Test4
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
