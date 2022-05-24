module com.brownj.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.brownj.todolist to javafx.fxml;
    exports com.brownj.todolist;
}