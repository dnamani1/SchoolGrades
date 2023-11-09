package edu.westga.cs.schoolgrades.model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test class
 * 
 * @author lewis
 * @version 11/5/2023
 */
public class TestDropLowestStrategyCalculate {

	private static final double DELTA = 0.001;
	private DropLowestStrategy dropLowestStrategy;
	private GradeCalculationStrategy mockChildStrategy;

	private Grade mockGrade0;
	private Grade mockGrade1;
	private Grade mockGrade2;

	private List<Grade> grades;

	/**
	 * setup
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	public void setUp() throws Exception {
	    this.mockGrade0 = mock(Grade.class);
	    when(this.mockGrade0.getValue()).thenReturn(10.0);
	    this.mockGrade1 = mock(Grade.class);
	    when(this.mockGrade1.getValue()).thenReturn(20.0);
	    this.mockGrade2 = mock(Grade.class);
	    when(this.mockGrade2.getValue()).thenReturn(30.0);

	    this.grades = new ArrayList<>();
	    this.grades.add(this.mockGrade0);
	    this.grades.add(this.mockGrade1);
	    this.grades.add(this.mockGrade2);

	    this.mockChildStrategy = mock(GradeCalculationStrategy.class);
	    this.dropLowestStrategy = new DropLowestStrategy(this.mockChildStrategy);
	}


	/**
	 * Test1
	 */
	@Test
	public void shouldNotAllowNullGradesList() {
		assertThrows(IllegalArgumentException.class, () -> {
			this.dropLowestStrategy.calculate(null);
		});
	}

	/**
	 * Test2
	 */
	@Test
	public void shouldNotDropLowestIfGradesListIsEmpty() {
		this.grades.clear();
	    this.dropLowestStrategy.calculate(this.grades);
	    
	    verify(this.mockChildStrategy).calculate(this.grades);
	}

	/**
	 * Test3
	 */
	@Test
	public void shouldNotDropLowestIfGradesListHasOneElement() {
	    this.grades.clear();
	    this.grades.add(this.mockGrade0);

	    when(this.mockChildStrategy.calculate(this.grades)).thenReturn(10.0);

	    this.dropLowestStrategy.calculate(this.grades);

	    verify(this.mockChildStrategy).calculate(this.grades);
	}


	/**
	 * Test4
	 */
	@Test
	public void canDropWhenLowestIsFirst() {
		this.grades.clear();
		this.grades.add(this.mockGrade0);
	    this.grades.add(this.mockGrade1);
	    this.grades.add(this.mockGrade2);
		List<Grade> gradesMinusFirst = new ArrayList<>(this.grades);
		gradesMinusFirst.remove(this.mockGrade0);
		
		this.dropLowestStrategy.calculate(this.grades);

        verify(this.mockChildStrategy).calculate(gradesMinusFirst);
	}

	/**
	 * Test5
	 */
	@Test
	public void canDropWhenLowestIsLast() {
		this.grades.clear();
		this.grades.add(this.mockGrade2);
	    this.grades.add(this.mockGrade1);
	    this.grades.add(this.mockGrade0);
	    List<Grade> gradesMinusLowest = new ArrayList<>(this.grades);
	    gradesMinusLowest.remove(this.mockGrade0);

	    this.dropLowestStrategy.calculate(this.grades);

        verify(this.mockChildStrategy).calculate(gradesMinusLowest);
	}


	/**
	 * Test6
	 */
	@Test
	public void canDropWhenLowestIsInMiddle() {
		this.grades.clear();
		this.grades.add(this.mockGrade1);
	    this.grades.add(this.mockGrade0);
	    this.grades.add(this.mockGrade2);
		List<Grade> gradesMinusMiddle = new ArrayList<>(this.grades);
		gradesMinusMiddle.remove(this.mockGrade0);
		
		this.dropLowestStrategy.calculate(this.grades);
		
        verify(this.mockChildStrategy).calculate(gradesMinusMiddle);
	}

	/**
	 * Test7
	 */
	@Test
	public void dropsOnlyOneIfThereAreMultipleLowestGrades() {
		this.grades.clear();
		this.grades.add(this.mockGrade1);
		this.grades.add(this.mockGrade0);
		this.grades.add(this.mockGrade2);
		this.grades.add(this.mockGrade0);
		
		List<Grade> expectedGradesAfterDrop = new ArrayList<>(this.grades);
	    expectedGradesAfterDrop.remove(this.mockGrade0);
	    
	    this.dropLowestStrategy.calculate(this.grades);
	    
        verify(this.mockChildStrategy).calculate(expectedGradesAfterDrop);
	}
}
