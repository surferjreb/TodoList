/**
 * Created by: James R Brown
 */


package com.brownj.todolist;

import com.brownj.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TodoApplication extends Application {

    @Override
    public void init() throws IOException {
        try {
            TodoData.getInstance().loadTodoItems();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TodoApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);
        stage.setTitle("Todo List");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}