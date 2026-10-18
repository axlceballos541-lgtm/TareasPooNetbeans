package com.axl.controldegastos;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class PrimaryController {

    @FXML private Button btn1; 
    @FXML private Button btn2; 
    @FXML private TextField txtAlimentacion;
    @FXML private TextField txtRefrigerios;
    @FXML private TextField txtTransporte;
    @FXML private TextField txtTelefonia;
    @FXML private TextField txtOtros;
    @FXML private TextField txtTotal;
    @FXML private TextField txtGastoAlto;

    @FXML
    private void calcular() {
        try {
            // 1. Leemos los valores de cada TextField y los convertimos a números decimales (double)
            double alimentacion = txtAlimentacion.getText().isEmpty() ? 0.0 : Double.parseDouble(txtAlimentacion.getText());
            double refrigerios  = txtRefrigerios.getText().isEmpty() ? 0.0 : Double.parseDouble(txtRefrigerios.getText());
            double transporte   = txtTransporte.getText().isEmpty() ? 0.0 : Double.parseDouble(txtTransporte.getText());
            double telefonia    = txtTelefonia.getText().isEmpty() ? 0.0 : Double.parseDouble(txtTelefonia.getText());
            double otros        = txtOtros.getText().isEmpty() ? 0.0 : Double.parseDouble(txtOtros.getText());

            // 2. Calculamos el Total Semanal sumando todos los gastos
            double totalSemanal = alimentacion + refrigerios + transporte + telefonia + otros;

            // 3. Determinamos cuál fue el Gasto Más Alto usando condiciones (if)
            double mayor = alimentacion;
            String categoriaMayor = "Alimentación";

            if (refrigerios > mayor) {
                mayor = refrigerios;
                categoriaMayor = "Refrigerios";
            }
            if (transporte > mayor) {
                mayor = transporte;
                categoriaMayor = "Transporte";
            }
            if (telefonia > mayor) {
                mayor = telefonia;
                categoriaMayor = "Telefonía";
            }
            if (otros > mayor) {
                mayor = otros;
                categoriaMayor = "Otros";
            }

            // 4. Mostramos los resultados en la columna derecha de estadísticas
            txtTotal.setText(String.valueOf(totalSemanal));
            txtGastoAlto.setText(categoriaMayor);

        } catch (NumberFormatException e) {
            // Si el usuario escribe letras o símbolos por accidente
            txtTotal.setText("Error");
            txtGastoAlto.setText("Revise datos");
        }
    }

    @FXML
    private void limpiar() {
        // 1. Vaciamos las 5 cajas de gastos
        txtAlimentacion.setText("");
        txtRefrigerios.setText("");
        txtTransporte.setText("");
        txtTelefonia.setText("");
        txtOtros.setText("");
        
        // 2. Vaciamos las 2 cajas de estadísticas de la derecha
        txtTotal.setText("");
        txtGastoAlto.setText("");
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}