module com.axl.edad {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.axl.edad to javafx.fxml;
    exports com.axl.edad;
}
