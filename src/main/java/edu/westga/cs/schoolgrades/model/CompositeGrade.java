package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A {@link Grade} representing the aggregation of several other grades. Uses a
 * {@link GradeCalculationStrategy} to determine the calculation for the
 * aggregate score.
 * 
 * @author lewisb
 * @version 11/1/2023
 */
public class CompositeGrade implements Grade {

	private GradeCalculationStrategy strategy;
	private final List<Grade> childGrades;

	/**
	 * Creates a new CompositeGrade using the given strategy.
	 * 
	 * @param strategy the strategy to use for grade calculation. Must not be null.
	 */
	public CompositeGrade(GradeCalculationStrategy strategy) {
		this.setGradingStrategy(strategy);
		this.childGrades = new ArrayList<Grade>();
	}

	/**
	 * Adds a {@link Grade} to the end of this CompositeGrade.
	 * 
	 * @param grade the grade to add. Must not be null and must not already exist in
	 *              this CompositeGrade
	 */
	public void add(final Grade grade) {
		this.validateGradeNotNull(grade);
		this.childGrades.add(grade);
	}

	/**
	 * Adds a {@link Grade} to this CompositeGrade at the given index.
	 * 
	 * @param grade the grade to add
	 * @param index the index at which to add it
	 */
	public void add(final Grade grade, int index) {
		this.validateGradeNotNull(grade);
		this.childGrades.add(index, grade);
	}

	/**
	 * Removes the {@link Grade} at the given index.
	 * 
	 * @param index the index at which to remove it
	 */
	public void removeAt(int index) {
		this.childGrades.remove(index);
	}

	private void validateGradeNotNull(final Grade grade) {
		if (grade == null) {
			throw new IllegalArgumentException("grade can not be null");
		}
	}

	/**
	 * Gets the {@link Grade}s contained in this CompositeGrade
	 * 
	 * @return all contained grades
	 */
	public List<Grade> getGrades() {
		return Collections.unmodifiableList(this.childGrades);
	}

	@Override
	public double getValue() {
		return this.strategy.calculate(this.childGrades);
	}

	/**
	 * Convenience method to add all grades in the list.
	 * 
	 * @param grades the list of grades to add. Will not allow duplicates or nulls
	 *               inside the list.
	 */
	public void addAll(List<? extends Grade> grades) {
		if (grades == null) {
			throw new IllegalArgumentException("grades can not be null");
		}

		for (Grade grade : grades) {
			this.add(grade);
		}
	}

	/**
	 * SetGradingStrategy
	 * 
	 * @param strategy grade
	 */
	public void setGradingStrategy(GradeCalculationStrategy strategy) {
		if (strategy == null) {
			throw new IllegalArgumentException("strategy should not be null");
		}
		this.strategy = strategy;
	}

}
