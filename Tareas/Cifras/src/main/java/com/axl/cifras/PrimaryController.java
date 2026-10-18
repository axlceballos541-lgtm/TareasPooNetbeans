package com.axl.cifras;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML private Button btn1;
    @FXML private Button btn2;
    @FXML private TextField txt1;
    @FXML private TextArea txtArea1;
    @FXML private TextArea txtArea2;
    
    
    @FXML
    private void X() {
    
    
}
    @FXML
    private void desglozar(){ 
        try {
            // Leemos el número que el usuario escribió en el TextField (txt1)
            int dinero = Integer.parseInt(txt1.getText());

            // Arreglo con las denominaciones de mayor a menor
            int[] denominaciones = {500, 200, 100, 50, 20, 10, 5, 2, 1};
            
            StringBuilder resultado = new StringBuilder();

            // Calculamos cuántos billetes/monedas van saliendo
            for (int denominacion : denominaciones) {
                int cantidad = dinero / denominacion; // División entera
                dinero = dinero % denominacion;       // Residuo que queda
                
                resultado.append(cantidad).append("\n");
            }

            // Mostramos los números resultantes en la pantallita de la derecha (txtArea2)
            txtArea2.setText(resultado.toString());

        } catch (NumberFormatException e) {
            // Si el usuario ingresa letras o deja el campo vacío
            txtArea2.setText("Error:\nIngrese un\nnúmero válido");
        }
    }

    // 3. MÉTODO PARA CAMBIAR DE PANTALLA CON EL BOTÓN "HOLA"
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
}
