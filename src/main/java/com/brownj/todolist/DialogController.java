package com.brownj.todolist;

import com.brownj.todolist.datamodel.TodoData;
import com.brownj.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.util.Set;

public class DialogController {

    @FXML
    private TextField shortDescriptionField;

    @FXML
    private TextArea detailArea;

    @FXML
    private DatePicker deadlinePicker;

    @FXML
    public TodoItem processResults() {
        String shortDescription = shortDescriptionField.getText();
        String details = detailArea.getText();
        LocalDate deadlineValue = deadlinePicker.getValue();

        if(shortDescription.isEmpty()){
            shortDescription = "You forgot a short Description...";
        }

        if(details.isEmpty()){
            details="You did not set any details...";
        }

        if(deadlineValue == null){
            deadlineValue = LocalDate.now();
        }

        TodoItem newItem = new TodoItem(shortDescription, details, deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

    @FXML
    public void editResults(TodoItem item) {
        String shortDescription = shortDescriptionField.getText();
        String details = detailArea.getText();
        LocalDate deadlineValue = deadlinePicker.getValue();

        if(!item.getShortDescription().equals(shortDescription)){
            item.setShortDescription(shortDescription);
        }

        if(!item.getDetails().equals(details)){
            item.setDetails(details);
        }

        if (!item.getDeadLine().isEqual(deadlineValue)){
            item.setDeadLine(deadlineValue);
        }

    }

    @FXML
    public void setItemView(TodoItem item) {
        shortDescriptionField.setText(item.getShortDescription());
        detailArea.setText(item.getDetails());
        deadlinePicker.setValue(item.getDeadLine());
    }
}
