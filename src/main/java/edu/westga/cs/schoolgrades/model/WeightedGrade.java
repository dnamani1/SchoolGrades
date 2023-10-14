package edu.westga.cs.schoolgrades.model;

/**
 * This class represents a grade that has been weighted
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class WeightedGrade implements Grade {
	private Grade baseGrade;
	private double weight;

	/**
	 * Initializes a new WeightedGrade with the specified base grade and weight.
	 * 
	 * @param baseGrade of student
	 * @param weight    of the grade
	 * @throws IllegalArgumentException if the baseGrade is null or if the weight is
	 *                                  not between 0.0.
	 */
	public WeightedGrade(Grade baseGrade, double weight) {
		if (baseGrade == null) {
			throw new IllegalArgumentException("baseGrade should not be null");
		}
		if (weight < 0.0D) {
			throw new IllegalArgumentException("weight should not be < 0");
		}
		this.baseGrade = baseGrade;
		this.weight = weight;
	}

	/**
	 * Computes and returns the weighted value of this grade.
	 * 
	 * @return The weighted value of the grade.
	 */
	@Override
	public double getValue() {
		return this.baseGrade.getValue() * this.weight;
	}

}
