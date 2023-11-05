package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.AverageOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.CompositeGrade;
import edu.westga.cs.schoolgrades.model.DropLowestStrategy;
import edu.westga.cs.schoolgrades.model.Grade;
import edu.westga.cs.schoolgrades.model.SimpleGrade;
import edu.westga.cs.schoolgrades.model.SumOfGradesStrategy;
import edu.westga.cs.schoolgrades.model.WeightedGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

/**
 * this is the controller for the grade workbook
 * 
 * @author Deeksha
 * @version 11/4/2023
 */
public class GradesController {
	private static final int QUIZ_GRADE_MULTIPLIER = 10;
	private static final int HOMEWORK_GRADE_MULTIPLIER = 20;
	private static final double[] EXAM_GRADES = { 100.0, 91.0, 95.0, 98.0 };

	@FXML
	private ListView<SimpleGrade> quizzesListView;
	@FXML
	private TextField quizSubtotalTextField;

	@FXML
	private ListView<SimpleGrade> homeworkListView;
	@FXML
	private TextField homeworkSubtotalTextField;

	@FXML
	private ListView<SimpleGrade> examsListView;
	@FXML
	private TextField examSubtotalTextField;

	@FXML
	private TextField finalGradeTextField;
	@FXML
	private Button recalculateButton;

	private ObservableList<SimpleGrade> quizGrades;
	private ObservableList<SimpleGrade> homeworkGrades;
	private ObservableList<SimpleGrade> examGrades;

	private DoubleProperty quizSubtotalProperty;
	private DoubleProperty homeworkSubtotalProperty;
	private DoubleProperty examSubtotalProperty;
	private DoubleProperty finalGradeProperty;

	/**
	 *  Initializes the controller class.
	 */
	@FXML
	public void initialize() {
		this.quizGrades = FXCollections.observableArrayList();
		this.homeworkGrades = FXCollections.observableArrayList();
		this.examGrades = FXCollections.observableArrayList();

		this.quizSubtotalProperty = (DoubleProperty) new SimpleDoubleProperty();
		this.homeworkSubtotalProperty = (DoubleProperty) new SimpleDoubleProperty();
		this.examSubtotalProperty = (DoubleProperty) new SimpleDoubleProperty();
		this.finalGradeProperty = (DoubleProperty) new SimpleDoubleProperty();

		this.quizzesListView.setItems(this.quizGrades);
		this.quizzesListView.setCellFactory(new GradeCell());

		this.quizSubtotalTextField.textProperty().bindBidirectional(this.quizSubtotalProperty,
				new NumberStringConverter());

		this.homeworkListView.setItems(this.homeworkGrades);
		this.homeworkListView.setCellFactory(new GradeCell());

		this.homeworkSubtotalTextField.textProperty().bindBidirectional(this.homeworkSubtotalProperty,
				new NumberStringConverter());

		this.examsListView.setItems(this.examGrades);
		this.examsListView.setCellFactory(new GradeCell());

		this.examSubtotalTextField.textProperty().bindBidirectional(this.examSubtotalProperty,
				new NumberStringConverter());

		this.finalGradeTextField.textProperty().bindBidirectional(this.finalGradeProperty, new NumberStringConverter());

		this.addDemoGrades();
	}

	private Grade calculateQuizSubtotal() {
		CompositeGrade theCompositeGrade = new CompositeGrade(new SumOfGradesStrategy());
		theCompositeGrade.addAll(this.quizGrades);

		this.quizSubtotalProperty.set(theCompositeGrade.getValue());

		return theCompositeGrade;
	}

	private Grade calculateHomeworkSubtotal() {
		CompositeGrade theCompositeGrade = new CompositeGrade(new DropLowestStrategy(new AverageOfGradesStrategy()));
		theCompositeGrade.addAll(this.homeworkGrades);

		this.homeworkSubtotalProperty.set(theCompositeGrade.getValue());

		return theCompositeGrade;
	}

	private Grade calculateExamSubtotal() {
		CompositeGrade theCompositeGrade = new CompositeGrade(new AverageOfGradesStrategy());
		theCompositeGrade.addAll(this.examGrades);

		this.examSubtotalProperty.set(theCompositeGrade.getValue());

		return theCompositeGrade;
	}

	private Grade calculateFinalGrade() {
		CompositeGrade finalGrade = new CompositeGrade(new SumOfGradesStrategy());

		finalGrade.add(new WeightedGrade(this.calculateQuizSubtotal(), 0.2));
		finalGrade.add(new WeightedGrade(this.calculateHomeworkSubtotal(), 0.3));
		finalGrade.add(new WeightedGrade(this.calculateExamSubtotal(), 0.5));

		this.finalGradeProperty.set(finalGrade.getValue());

		return finalGrade;
	}

	/**
     * Called when the 'Add Quiz' menu item is clicked
     * 
     * @param event the action event triggered by clicking the menu item
     */
	@FXML
	public void onAddQuizMenuItemClick(ActionEvent event) {
		this.quizGrades.add(new SimpleGrade(0.0));
	}

	/**
     * Called when the 'Homework' menu item is clicked
     * 
     * @param event the action event triggered by clicking the menu item
     */
	@FXML
	public void onAddHomeworkMenuItemClick(ActionEvent event) {
		this.homeworkGrades.add(new SimpleGrade(0.0));
	}

	/**
     * Called when the 'Exam' menu item is clicked
     * 
     * @param event the action event triggered by clicking the menu item
     */
	@FXML
	public void onAddExamMenuItemClick(ActionEvent event) {
		this.examGrades.add(new SimpleGrade(0.0));
	}

	/**
     * Recalculates the subtotal 
     * 
     * @param event the action event triggered by clicking the button
     */
	@FXML
	public void onRecalculateButtonClick(ActionEvent event) {
		this.calculateFinalGrade();
	}

	private void addDemoGrades() {
		for (int index = 0; index < 2; index++) {
			this.quizGrades.add(new SimpleGrade(index * QUIZ_GRADE_MULTIPLIER));
		}

		for (int index = 5; index >= 1; index--) {
			this.homeworkGrades.add(new SimpleGrade(index * HOMEWORK_GRADE_MULTIPLIER));
		}

		for (double examGrade : EXAM_GRADES) {
			this.examGrades.add(new SimpleGrade(examGrade));
		}

		this.calculateQuizSubtotal();
		this.calculateHomeworkSubtotal();
		this.calculateExamSubtotal();
		this.calculateFinalGrade();

	}

}
