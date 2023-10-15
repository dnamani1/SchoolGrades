package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * A decorator class to drop the lowest grade before performing a calculation.
 * 
 * @author Deeksha Namani
 * @version 10/15/2023
 */
public class DropLowestGrade implements CalculationStrategy {
	private CalculationStrategy baseStrategy;

	/**
	 * Constructs a new DropLowestGradeDecorator with a specified base calculation
	 * strategy.
	 * 
	 * @param baseStrategy The base strategy that will be used for calculation after
	 *                     dropping the lowest grade.
	 * @throws IllegalArgumentException if the baseStrategy is null.
	 */
	public DropLowestGrade(CalculationStrategy baseStrategy) {
		if (baseStrategy == null) {
			throw new IllegalArgumentException("baseStrategy can not be null");
		}
		this.baseStrategy = baseStrategy;
	}

	/**
	 * Calculates the result by first dropping the lowest grade (if possible) and
	 * then delegating the calculation to the baseStrategy.
	 * 
	 * @param grades List of grades from which the lowest will be dropped before
	 *               calculation.
	 * @return The result after dropping the lowest grade and performing the
	 *         calculation using baseStrategy.
	 * @throws IllegalArgumentException if the grades list is null.
	 */
	@Override
	public double calculate(List<Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades may not be null");
		}

		if (grades.isEmpty() || grades.size() < 1) {
			return this.baseStrategy.calculate(grades);
		}

		double lowestValue = grades.get(0).getValue();
		int lowestIndex = 0;
		for (int index = 1; index < grades.size(); index++) {
			if (grades.get(index).getValue() < lowestValue) {
				lowestValue = grades.get(index).getValue();
				lowestIndex = index;
			}
		}

		List<Grade> result = new ArrayList<>(grades);
		result.remove(lowestIndex);

		return this.baseStrategy.calculate(result);

	}

}
