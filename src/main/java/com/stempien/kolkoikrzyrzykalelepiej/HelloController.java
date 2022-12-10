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
    private boolean udaloSie = false;
    private int tura = 0;
    private ArrayList<Button> lista;
   private Random random = new Random();
    @FXML
    public void initialize() {
        addButtons();
    }
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
        button.setOnAction(event -> {
            grajZawartosc();
        });
    }

    private void grajZawartosc() {
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
    }

    public void czyWygral() {
        String znak = "O";
        for (int i = 0; i < 2; i++) {
            if (lista.get(0).getText().equals(znak) && lista.get(1).getText().equals(znak) && lista.get(2).getText().equals(znak) || lista.get(3).getText().equals(znak) && lista.get(4).getText().equals(znak) && lista.get(5).getText().equals(znak) || lista.get(6).getText().equals(znak) && lista.get(7).getText().equals(znak) && lista.get(8).getText().equals(znak) ||
                    lista.get(0).getText().equals(znak) && lista.get(4).getText().equals(znak) && lista.get(8).getText().equals(znak) || lista.get(2).getText().equals(znak) && lista.get(4).getText().equals(znak) && lista.get(6).getText().equals(znak) ||
                    lista.get(0).getText().equals(znak) && lista.get(3).getText().equals(znak) && lista.get(6).getText().equals(znak) || lista.get(1).getText().equals(znak) && lista.get(4).getText().equals(znak) && lista.get(7).getText().equals(znak) || lista.get(2).getText().equals(znak) && lista.get(5).getText().equals(znak) && lista.get(8).getText().equals(znak)) {
                poKoncu();
                label.setText("Wygrywają " + znak);
            }
            znak = "X";
            }
        if (tura == 9){
                poKoncu();
                label.setText("Remis");
            }
    }
    private void poKoncu() {
        tura = 0;
        Stream.of(lista.get(0), lista.get(1), lista.get(2), lista.get(3), lista.get(4), lista.get(5), lista.get(6), lista.get(7), lista.get(8)).forEach(btn -> {
            btn.setText("");
        });
    }
}
