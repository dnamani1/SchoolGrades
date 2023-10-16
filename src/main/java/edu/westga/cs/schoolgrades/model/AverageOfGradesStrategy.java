package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Implements the CalculationStrategy interface to calculate the average of
 * grades.
 * 
 * This strategy will get average values of all the grades in the list provided
 * to it.
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class AverageOfGradesStrategy extends SumOfGradesStrategy {

	/**
	 * Calculates the average of all the grades.
	 * 
	 * @param studentGrades list of grade.
	 * @return average of all the grade.
	 * @throws IllegalArgumentException if the provided list of grades is null.
	 */
	@Override
	public double calculate(List<Grade> studentGrades) {
		if (studentGrades == null) {
			throw new IllegalArgumentException("grades cannot be null");
		}
		double sum = 0.0D;
		for (int index = 0; index < studentGrades.size(); index++) {
			sum += studentGrades.get(index).getValue();
		}
		return sum / studentGrades.size();
	}

}
