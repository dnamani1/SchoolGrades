package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

/**
 * This class implementation of Grade that can be composed of multiple grades.
 * 
 * @author Deeksha Namani
 * @version 10/14/2023
 */
public class CompositeGrade implements Grade {
	private List<Grade> studentGrade;
	private CalculationStrategy strategy;

	/**
	 * It initializes a new instance of the CompositeGrade class.
	 * 
	 * @param strategy The calculation strategy to be used.
	 * @throws IllegalArgumentException If the provided strategy is null.
	 */
	public CompositeGrade(CalculationStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy can't be null");
		}
		this.studentGrade = new ArrayList<>();
		this.strategy = strategy;
	}

	/**
	 * Computes and returns the value of this composite grade based on the
	 * calculation strategy.
	 * 
	 * @return The computed value of this composite grade.
	 */
	@Override
	public double getValue() {
		return this.strategy.calculate(this.studentGrade);
	}

	/**
	 * Adds a grade to the list of individual student grades.
	 * 
	 * @param theGrade The grade to be added.
	 * @throws IllegalArgumentException If the provided grade is null.
	 */
	public void addGrade(Grade theGrade) {
		if (theGrade == null) {
			throw new IllegalArgumentException("grade can't be null");
		}
		this.studentGrade.add(theGrade);
	}

	/**
	 * Removes a grade from the list of individual student grades.
	 * 
	 * @param theGrade The grade to be removed.
	 */
	public void removeGrade(Grade theGrade) {
		this.studentGrade.remove(theGrade);
	}

	/**
	 * Sets a new calculation strategy for this composite grade.
	 * 
	 * @param strategy The new calculation strategy to be set.
	 * @throws IllegalArgumentException If the provided strategy is null.
	 */
	public void setStrategy(CalculationStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy can't be null");
		}
		this.strategy = strategy;
	}

}
