package edu.westga.cs.schoolgrades.model;

/**
 * Represents a simple numerical grade.
 * 
 * @author Deeksha Namani
 * @version 10/12/2023
 */
public class SimpleGrade implements Grade {
	private double value;

	/**
	 * Constructor
	 * 
	 * @param value d
	 */
	public SimpleGrade(double value) {
		this.setValue(value);
	}

	/**
	 * Retrieves the value of the grade.
	 * 
	 * @return the numerical value of the grade
	 */
	@Override
	public double getValue() {
		return this.value;
	}

	/**
	 * Sets the value of the grade.
	 * 
	 * @param value the new numerical value for the grade
	 * @throws IllegalArgumentException if the value is negative
	 */
	public void setValue(double value) {
		if (value < 0.0D) {
			throw new IllegalArgumentException("value cannot be negative");
		}
		this.value = value;
	}

}
