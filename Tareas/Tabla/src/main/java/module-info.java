module com.axl.tabla {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.axl.tabla to javafx.fxml;
    exports com.axl.tabla;
}
