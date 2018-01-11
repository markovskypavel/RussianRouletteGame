package by.markovsky.roulette.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by Pavel Markovsky on 11.01.2018.
 */
public class Main extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage=primaryStage;

        Parent root = FXMLLoader.load(getClass().getResource("/fxml/roulette.fxml"));
        primaryStage.setTitle("Russian Roulette");
        primaryStage.setWidth(600);
        primaryStage.setHeight(600);
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    public static void setNewScene (Scene scene, String name){
        mainStage.setTitle(name);
        mainStage.setScene(scene);
    }
    public static Stage getStage(){
        return mainStage;
    }

}
