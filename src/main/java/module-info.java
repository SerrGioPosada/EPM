module co.edu.uniquindio.poo.epm {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.epm to javafx.fxml;
    opens co.edu.uniquindio.poo.epm.model to javafx.base;
    exports co.edu.uniquindio.poo.epm;
}