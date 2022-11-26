module com.stempien.kolkoikrzyrzykalelepiej {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.stempien.kolkoikrzyrzykalelepiej to javafx.fxml;
    exports com.stempien.kolkoikrzyrzykalelepiej;
}