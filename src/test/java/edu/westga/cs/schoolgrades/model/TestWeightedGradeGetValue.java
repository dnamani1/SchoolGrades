package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestWeightedGradeGetValue {

	private static final double DELTA = 0.001;
	private WeightedGrade weightedGrade;
	private SimpleGrade simpleGrade;

	/**
	 * Setup
	 */
	@BeforeEach
	public void setup() {
		this.simpleGrade = new SimpleGrade(100);
	}

	/**
	 * Test1
	 */
	@Test
	public void shouldApplyZeroWeight() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0);
		assertEquals(0, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldApplyWeightOfOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 1);
		assertEquals(100, this.weightedGrade.getValue(), DELTA);
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldApplyWeightBetweenZeroAndOne() {
		this.weightedGrade = new WeightedGrade(this.simpleGrade, 0.5);
		assertEquals(50, this.weightedGrade.getValue(), DELTA);
	}

}
