module javastream.javastream {
    requires javafx.controls;
    requires javafx.fxml;


    opens javastream.javastream to javafx.fxml;
    exports javastream.javastream;
}