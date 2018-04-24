package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;

import java.io.IOException;

import static javafx.application.Platform.exit;
import static sample.QuestionQCM.numberQuestion;
import static sample.QuestionQCM.score;

public class Score {

    @FXML
    private Label numberScore;
    @FXML
    private Label conseilleScore;

    public void initialize(){
        numberScore.setText(String.valueOf(score)+" / "+ String.valueOf(numberQuestion-1));
        if(score >= 0 && score <=4){
            conseilleScore.setText("Vous pouvez mieux faire !");
        }
        if (score >=5 && score <= 7){
            conseilleScore.setText("Pas mal il manque encore un peu d'entrainement");
        }
        if (score >= 8){
            conseilleScore.setText("Excellent !");
        }
    }
    public void pressButtonMenu(ActionEvent actionEvent) throws IOException {
        Main.root = FXMLLoader.load(getClass().getResource("../views/main.fxml"));
        Main.root.getStylesheets().add(Main.class.getResource("../style/style.css").toExternalForm());
        Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
    }

    public void pressButtonQuitter(ActionEvent actionEvent) {
        exit();
    }
}
