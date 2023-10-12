package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

/**
 * Test class for SimpleGrade's getValue() method.
 * 
 * @author Deeksha Namani
 * @version 10/12/2023
 */
public class SimpleGradeGetValueTest {
	private SimpleGrade grade;

	@BeforeEach
	public void setUp() throws Exception {
		this.grade = new SimpleGrade();
	}

	@Test
	public void testGetValueForDefaultValue() {
		assertEquals(0.0, this.grade.getValue(), 0.01);
	}

	@Test
	public void testGetValueForSetValue10() {
		this.grade.setValue(10.0);
		assertEquals(10.0, this.grade.getValue(), 0.01);
	}

	@Test
	public void testGetValueForSetValue20Point5() {
		this.grade.setValue(20.5);
		assertEquals(20.5, this.grade.getValue(), 0.01);
	}

}
