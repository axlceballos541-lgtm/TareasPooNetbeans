module com.axl.divisores {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.axl.divisores to javafx.fxml;
    exports com.axl.divisores;
}
