package admin.view.grading;

import admin.model.Examinee;
import admin.model.exam_entries.QuestionPart;
import common.NumberedEditor;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class QuestionPartTabController
{
	private Examinee examinee;
	@FXML
	private Label maxPointLabel;
	@FXML
	private Tab questionPart;
	@FXML
	private NumberedEditor editor;
	@FXML
	private TextField grade;
	@FXML
	private TextArea notes;

	public void initialize()
	{
		notes.textProperty().addListener( ( o, oldVal, newVal) -> {
			examinee.setNotes( newVal);
		});
		editor.disableEditor();
	}

	public void setExamineeAndPart( Examinee e, QuestionPart part)
	{
		examinee = e;
		notes.textProperty().bindBidirectional( e.notesProperty());
		maxPointLabel.setText("Maximum points: " + part.getMaxPoints() + " points");
		editor.setText( e.getSolutions().get( part));
		questionPart.setText(part.getTitle());
	}
}
