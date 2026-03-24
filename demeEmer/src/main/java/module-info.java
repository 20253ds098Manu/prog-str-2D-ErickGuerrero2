module com.example.demeemer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demeemer to javafx.fxml;
    exports com.example.demeemer;
}