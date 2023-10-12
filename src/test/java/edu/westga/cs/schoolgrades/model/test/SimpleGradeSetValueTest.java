package edu.westga.cs.schoolgrades.model.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import edu.westga.cs.schoolgrades.model.SimpleGrade;

/**
 * Test class for SimpleGrade's setValue(double value) method.
 * 
 * @author Deeksha Namani
 * @version 10/12/2023
 */
public class SimpleGradeSetValueTest {
	private SimpleGrade grade;

	@BeforeEach
	public void setUp() throws Exception {
		this.grade = new SimpleGrade();
	}

	@Test
	public void testSetValueToZero() {
		this.grade.setValue(0.0);
		assertEquals(0.0, this.grade.getValue(), 0.01);
	}

	@Test
	public void testSetValueTo10() {
		this.grade.setValue(10.0);
		assertEquals(10.0, this.grade.getValue(), 0.01);
	}

	@Test
	public void testSetValueTo20Point5() {
		this.grade.setValue(20.5);
		assertEquals(20.5, this.grade.getValue(), 0.01);
	}

}
