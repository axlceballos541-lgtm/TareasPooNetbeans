package com.axl.tabla;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private TextField txt1;
    @FXML private TextArea txt2;
    @FXML private Button btn1;
    @FXML private Button btn2;

    @FXML
    private void calcular() {
        if (txt1 != null && !txt1.getText().trim().isEmpty()) {
            try {
                int numero = Integer.parseInt(txt1.getText().trim());
                StringBuilder tabla = new StringBuilder();

                for (int i = 1; i <= 10; i++) {
                    tabla.append(numero)
                         .append(" x ")
                         .append(i)
                         .append(" = ")
                         .append(numero * i)
                         .append("\n");
                }

                txt2.setText(tabla.toString());
            } catch (NumberFormatException e) {
                txt2.setText("Por favor ingresa un número entero válido.");
            }
        }
    }

    @FXML
    private void limpiar() {
        if (txt1 != null) {
            txt1.setText("");
        }
        if (txt2 != null) {
            txt2.setText("");
        }
    }
}