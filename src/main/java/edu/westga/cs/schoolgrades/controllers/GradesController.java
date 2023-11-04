package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
	
	@FXML
	public void initialize() {
		this.quizGrades = FXCollections.observableArrayList();
	    this.homeworkGrades = FXCollections.observableArrayList();
	    this.examGrades = FXCollections.observableArrayList();
	    
	    this.finalGradeProperty = (DoubleProperty)new SimpleDoubleProperty();
	    this.examSubtotalProperty = (DoubleProperty)new SimpleDoubleProperty();
	    this.homeworkSubtotalProperty = (DoubleProperty)new SimpleDoubleProperty();
	    this.quizSubtotalProperty = (DoubleProperty)new SimpleDoubleProperty();
	    
	    this.quizzesListView.setItems(this.quizGrades);
	    this.quizzesListView.setCellFactory(new GradeCell());
	    
	    this.quizSubtotalTextField.textProperty().bindBidirectional(this.quizSubtotalProperty, new NumberStringConverter());
	    
	    this.homeworkListView.setItems(this.homeworkGrades);
	    this.homeworkListView.setCellFactory(new GradeCell());
	    
	    this.homeworkSubtotalTextField.textProperty().bindBidirectional(this.homeworkSubtotalProperty, new NumberStringConverter());
	    
	    this.examsListView.setItems(this.examGrades);
	    this.examsListView.setCellFactory(new GradeCell());
	    
	    this.examSubtotalTextField.textProperty().bindBidirectional(this.examSubtotalProperty, new NumberStringConverter());
	    
	    this.finalGradeTextField.textProperty().bindBidirectional(this.finalGradeProperty, new NumberStringConverter());
	}
}
