package com.stempien.kolkoikrzyrzykalelepiej;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {

    public Button button;

    public Pane pPain;

    @FXML
    public void initialize() {
        addButtons();
    }

    private void addButtons() {
        //int x = 0;
        button = new Button();
        int y = 0;
        for (int j = 0; j < 3; j++) {
            int x=0;

            for (int i = 0; i < 3; i++) {
                button = new Button();
                button.setPrefSize(100, 100);
                button.setLayoutX(x);
                button.setLayoutY(y);
                pPain.getChildren().add(button);
                System.out.println("x" + i + x);
                x += 100;
                button.setDisable(true);

            }
            System.out.println("y" + j + y);
            y += 100;
        }
        button = new Button();
        button.setPrefSize(300, 100);
        button.setLayoutX(400);
        button.setLayoutY(200);
        button.setText("Graj");
        pPain.getChildren().add(button);
    }
}
