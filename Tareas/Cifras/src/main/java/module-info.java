module com.axl.cifras {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.axl.cifras to javafx.fxml;
    exports com.axl.cifras;
}
