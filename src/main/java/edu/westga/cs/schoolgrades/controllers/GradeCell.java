package edu.westga.cs.schoolgrades.controllers;

import edu.westga.cs.schoolgrades.model.SimpleGrade;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.util.Callback;
import javafx.util.StringConverter;

/**
 * This class is responsible for providing a cell factory to the ListView for
 * rendering SimpleGrade objects.
 * 
 * @author Deeksha Namani
 * @version 11/4/2023
 */
public class GradeCell implements Callback<ListView<SimpleGrade>, ListCell<SimpleGrade>> {

	/**
	 * Called when the ListView requires a new ListCell.
	 * 
	 * @param listView instance
	 * @return A ListCell that displays a SimpleGrade object.
	 */
	@Override
	public ListCell<SimpleGrade> call(ListView<SimpleGrade> listView) {
		TextFieldListCell<SimpleGrade> value = new TextFieldListCell<>(new StringConverter<SimpleGrade>() {

			@Override
			public String toString(SimpleGrade object) {
				return object == null ? "" : String.format("%.2f", object.getValue());
			}

			@Override
			public SimpleGrade fromString(String string) {
				try {
					return new SimpleGrade(Double.parseDouble(string));
				} catch (NumberFormatException exp) {
					throw new IllegalArgumentException("text can not be converted");
				}
			}
		});

		return value;
	}

}
