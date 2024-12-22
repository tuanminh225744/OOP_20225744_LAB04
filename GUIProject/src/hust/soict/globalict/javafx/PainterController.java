package hust.soict.globalict.javafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {
	    @FXML
	    private Pane drawingAreaPane;
	    boolean isPenActive = true;

	    @FXML
	    void clearButtonPressed(ActionEvent event) {
	        drawingAreaPane.getChildren().clear();
	    }

	    @FXML
	    void drawingAreaMouseDragged(MouseEvent event) {
	        Color drawColor = isPenActive ? Color.BLACK : Color.WHITE;
	        Circle newCircle = new Circle(event.getX(), event.getY(), 4, drawColor);
	        drawingAreaPane.getChildren().add(newCircle);
	    }

	    @FXML
	    void onPenButtonClicked() {
	        isPenActive = true; // Chọn pen
	    }
	    @FXML
	    void onEraserButtonClicked() {
	        isPenActive = false; // Chọn eraser
	    }
	    
	    

	

}
