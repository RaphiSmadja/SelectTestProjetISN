package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class Main extends Application {
    public static Parent root;
    public static Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        root.getStylesheets().add(Main.class.getResource("../style/style.css").toExternalForm());
        primaryStage.setTitle("Select Test");
        primaryStage.setScene(new Scene(root, 1024, 768));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public void pressButtonLeave(ActionEvent actionEvent) {
        exit();
    }

    public void pressButtonPlay(ActionEvent actionEvent) throws IOException {
        Main.root = FXMLLoader.load(getClass().getResource("../views/categories.fxml"));
        Main.root.getStylesheets().add(Categories.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }


    public static void main(String[] args) {
        launch(args);
    }
}
