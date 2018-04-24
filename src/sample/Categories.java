package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class Categories {
    public static String choix="";

    public void pressButtonMath(ActionEvent actionEvent) throws IOException {
        choix="math";
        Main.root = FXMLLoader.load(getClass().getResource("../views/questionQCM.fxml"));
        Main.root.getStylesheets().add(QuestionQCM.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }

    public void pressButtonAnglais(ActionEvent actionEvent) throws IOException {
        choix="anglais";
        Main.root = FXMLLoader.load(getClass().getResource("../views/questionQCM.fxml"));
        Main.root.getStylesheets().add(QuestionQCM.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }

    public void pressButtonHistoire(ActionEvent actionEvent) throws IOException {
        choix="histoire";
        Main.root = FXMLLoader.load(getClass().getResource("../views/questionQCM.fxml"));
        Main.root.getStylesheets().add(QuestionQCM.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }

    public void pressButtonRetour(ActionEvent actionEvent) throws IOException {
        Main.root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        Main.root.getStylesheets().add(Main.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }
}
