package sample;

import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import static javafx.application.Platform.exit;

public class Controller {

    public void pressButtonLeave(ActionEvent actionEvent) {
        exit();
    }

    public void pressButtonHelp(ActionEvent actionEvent) throws IOException {
    }

    public void pressButtonPlay(ActionEvent actionEvent) throws IOException {
        Main.root = FXMLLoader.load(getClass().getResource("../views/questionQCM.fxml"));
        Main.root.getStylesheets().add(QuestionQCM.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }
}
