module com.visual.casalinda {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;

    opens com.visual.casalinda to javafx.fxml;
    exports com.visual.casalinda;
}