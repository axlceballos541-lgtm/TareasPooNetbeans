module com.axl.controldegastos {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.axl.controldegastos to javafx.fxml;
    exports com.axl.controldegastos;
}
