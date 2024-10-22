module de.szut.dqi21.diagrams {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.sql;

    opens de.szut.dqi21.diagrams to javafx.fxml;
    exports de.szut.dqi21.diagrams;
}