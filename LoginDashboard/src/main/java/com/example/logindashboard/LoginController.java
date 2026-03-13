package com.example.logindashboard;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

    @FXML
    private AnchorPane root;

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML
    public void initialize() {
        // Allow dragging the window by pressing and dragging on the root pane
        root.setOnMousePressed((MouseEvent event) -> {
            Stage stage = getStageFromEvent(event);
            if (stage != null) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        root.setOnMouseDragged((MouseEvent event) -> {
            Stage stage = getStageFromEvent(event);
            if (stage != null) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
    }

    private Stage getStageFromEvent(MouseEvent event) {
        if (event == null || event.getSource() == null) return null;
        Object src = event.getSource();
        if (src instanceof AnchorPane) {
            return (Stage) ((AnchorPane) src).getScene().getWindow();
        }
        return null;
    }
}
