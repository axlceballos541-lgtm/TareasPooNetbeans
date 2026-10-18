package com.axl.edad;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private Label lbl1;
    @FXML private Label lbl2;
    @FXML private Label lbl3;
    @FXML private TextField txt1;
    @FXML private Button btn_erase;
    @FXML private Button btn_acep;

    @FXML
    private void btn_erase() {
        if (lbl2 != null) {
            lbl2.setText("");
        }
        if (lbl3 != null) {
            lbl3.setText("DD/MM/AAAA");
        }
        if (txt1 != null) {
            txt1.setText("");
        }
    }

    @FXML
    private void btn_acep() {
        int wa, anio, mes, dia, edadanio, edadmes = 0;
        
        if (txt1 != null && !txt1.getText().trim().isEmpty()) {
            try {
                wa = Integer.parseInt(txt1.getText().trim());

                // Extracción correcta para formato DDMMAAAA (ej. 19042000)
                dia = wa / 1000000;              // Primeros 2 dígitos (Día)
                mes = (wa / 10000) % 100;        // Dos dígitos del centro (Mes)
                anio = wa % 10000;               // Últimos 4 dígitos (Año)
                
                edadanio = 2026 - anio;

                // Fecha de referencia 19/10/2026
                if (10 - mes < 0) {
                    edadanio--;
                    int x = 10 - mes;
                    edadmes = 12 - Math.abs(x);
                    if (dia > 19) {
                        edadmes--;
                    }
                } else if (10 - mes == 0) {
                    edadmes = (dia > 19) ? 11 : 0;
                }

                if (lbl2 != null) {
                    lbl2.setText("Edad: " + edadanio + " años, " + edadmes + " meses");
                }
            } catch (NumberFormatException e) {
                if (lbl2 != null) {
                    lbl2.setText("Por favor ingresa un número válido (ej. 19042000)");
                }
            }
        }
    }
}