module com.wehatejavafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.wehatejavafx to javafx.fxml;
    exports com.wehatejavafx;
}
