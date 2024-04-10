module mvc {
    requires javafx.controls;
    requires javafx.fxml;

    opens mvc to javafx.fxml;
    exports mvc;
}
