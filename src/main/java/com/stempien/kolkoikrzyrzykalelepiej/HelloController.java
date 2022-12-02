package com.stempien.kolkoikrzyrzykalelepiej;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class HelloController {

    public Button button;
    public Label label;

    public Pane pPain;

    @FXML
    public void initialize() {
        addButtons();
    }

    boolean udaloSie = false;
    int tura = 0;
    ArrayList<Button> lista;

    private void addButtons() {
        label = new Label();
        label.setPrefSize(300, 100);
        label.setLayoutX(400);
        label.setLayoutY(100);
        pPain.getChildren().add(label);
        button = new Button();
        int y = 0;
        lista = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            int x = 0;

            for (int i = 0; i < 3; i++) {
                button = new Button();
                button.setPrefSize(100, 100);
                button.setLayoutX(x);
                button.setLayoutY(y);
                pPain.getChildren().add(button);
                x += 100;
                button.setDisable(true);
                lista.add(button);
            }
            y += 100;
        }
        button = new Button();
        button.setPrefSize(300, 100);
        button.setLayoutX(400);
        button.setLayoutY(200);
        button.setText("Graj");
        pPain.getChildren().add(button);
        Random random = new Random();
        button.setOnAction(event -> {
            String znak;
            do {
                udaloSie = false;
                tura++;
                if (tura % 2 == 1)
                    znak = "X";
                else
                    znak = "O";
                int losowyPrzycisk = random.nextInt(9);
                if (lista.get(losowyPrzycisk).getText().equals("")) {
                    lista.get(losowyPrzycisk).setText(znak);
                    udaloSie = true;
                } else
                    tura--;
                czyWygral();
            } while (!udaloSie);
        });
    }

    public void czyWygral() {
        if (lista.get(0).getText().equals("O") && lista.get(1).getText().equals("O") && lista.get(2).getText().equals("O") || lista.get(3).getText().equals("O") && lista.get(4).getText().equals("O") && lista.get(5).getText().equals("O") || lista.get(6).getText().equals("O") && lista.get(7).getText().equals("O") && lista.get(8).getText().equals("O") ||
                lista.get(0).getText().equals("O") && lista.get(4).getText().equals("O") && lista.get(8).getText().equals("O") || lista.get(2).getText().equals("O") && lista.get(4).getText().equals("O") && lista.get(6).getText().equals("O") ||
                lista.get(0).getText().equals("O") && lista.get(3).getText().equals("O") && lista.get(6).getText().equals("O") || lista.get(1).getText().equals("O") && lista.get(4).getText().equals("O") && lista.get(7).getText().equals("O") || lista.get(2).getText().equals("O") && lista.get(5).getText().equals("O") && lista.get(8).getText().equals("O")) {
            tura = 0;
            Stream.of(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), lista.get(6), lista.get(7), lista.get(8)).forEach(btn -> {
                btn.setText("");
            });
            label.setText("Wygrywają kółka");

        } else if (lista.get(0).getText().equals("X") && lista.get(1).getText().equals("X") && lista.get(2).getText().equals("X") || lista.get(3).getText().equals("X") && lista.get(4).getText().equals("X") && lista.get(5).getText().equals("X") || lista.get(6).getText().equals("X") && lista.get(7).getText().equals("X") && lista.get(8).getText().equals("X") ||
                lista.get(0).getText().equals("X") && lista.get(4).getText().equals("X") && lista.get(8).getText().equals("X") || lista.get(2).getText().equals("X") && lista.get(4).getText().equals("X") && lista.get(6).getText().equals("X") ||
                lista.get(0).getText().equals("X") && lista.get(3).getText().equals("X") && lista.get(6).getText().equals("X") || lista.get(1).getText().equals("X") && lista.get(4).getText().equals("X") && lista.get(7).getText().equals("X") || lista.get(2).getText().equals("X") && lista.get(5).getText().equals("X") && lista.get(8).getText().equals("X")) {
            tura = 0;
            Stream.of(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), lista.get(6), lista.get(7), lista.get(8)).forEach(btn -> {
                btn.setText("");
            });
            label.setText("Wygrywają krzyżyki");
        }
        else if(tura == 9){
            Stream.of(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), lista.get(6), lista.get(7), lista.get(8)).forEach(btn -> {
                btn.setText("");
            });
            label.setText("Remis");
        }
    }
}