package ru.shatsckij.forms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ru.shatsckij.mainFrame.IVariant;

public class Form_8_23 extends Application implements IVariant{

    public String toString() {
        return "Вариант 23";
    }

    @Override
    public void Run() {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Task_8");
        GridPane rootNode = new GridPane();
        Scene scene = new Scene(rootNode,500,500);
        stage.setScene(scene);
        stage.centerOnScreen();
        TableView<Integer> table = new TableView<Integer>();
        table.setPrefWidth(250);
        table.setPrefHeight(200);
        rootNode.getChildren().add(table);
        stage.show();

    }
}
