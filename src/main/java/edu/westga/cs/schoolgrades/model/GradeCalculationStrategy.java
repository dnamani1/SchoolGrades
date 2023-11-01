package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * An interface to define a strategy for calculating grades.
 * 
 * @author Deeksha Namani
 * @version 10/13/2023
 */
public interface GradeCalculationStrategy {

	/**
	 * Calculate the result based on a list of grades.
	 *
	 * @param grades List of grades to calculate the result from.
	 * @return Calculated result.
	 */
	double calculate(List<Grade> grades);

}
