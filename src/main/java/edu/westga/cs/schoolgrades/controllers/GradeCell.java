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
		TextFieldListCell<SimpleGrade> cell = new TextFieldListCell<>();
        cell.setEditable(true);

        StringConverter<SimpleGrade> converter = this.createStringConverter(cell);
        cell.setConverter(converter);

        return cell;
	}

	private StringConverter<SimpleGrade> createStringConverter(TextFieldListCell<SimpleGrade> cell) {
		return new StringConverter<SimpleGrade>() {

			@Override
			public String toString(SimpleGrade grade) {
				String value;
				if (grade == null) {
				    value = "";
				} else {
				    value = String.format("%.2f", grade.getValue());
				}

				return value;
			}

			@Override
			public SimpleGrade fromString(String text) {
				try {
					SimpleGrade grade = cell.getItem();
					grade.setValue(Double.parseDouble(text));
					return grade;

				} catch (NumberFormatException exp) {
					throw new IllegalArgumentException("Text could not be parsed to a double", exp);
				}
			}
		};
	}
}
