package edu.westga.cs.schoolgrades.model;

import java.util.List;

/**
 * Implements the CalculationStrategy interface to calculate the sum of a list
 * of grades.
 * 
 * This strategy will sum up the values of all the grades in the list provided
 * to it.
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class SumOfGradesStrategy implements GradeCalculationStrategy {

	/**
	 * Calculates the sum of all the grades in the provided list.
	 * 
	 * @param studentGrades The list of grades to be summed up.
	 * @return The sum of all the grade values in the list.
	 * @throws IllegalArgumentException if the provided list of grades is null.
	 */
	@Override
	public double calculate(List<Grade> studentGrades) {
		if (studentGrades == null) {
			throw new IllegalArgumentException("grades cannot be null");
		}
		double sum = 0;
		for (Grade grade: studentGrades) {
			sum += grade.getValue();
		}
		return sum;
	}

}
