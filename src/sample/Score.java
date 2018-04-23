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

/**
 * Created by raphi on 20/04/2018.
 */
public class Score {

    @FXML
    private Label numberScore;
    @FXML
    private Label conseilleScore;

    public void initialize(){
        numberScore.setText(String.valueOf(score)+" / "+ String.valueOf(numberQuestion-1));
        if(score >= 0 && score <=4){
            conseilleScore.setText("On vous conseille de faire un BTS");
        }
        if (score >=5 && score <= 7){
            conseilleScore.setText("On vous conseille de faire une fac");
        }
        if (score >= 8){
            conseilleScore.setText("On vous conseille d'intégrer les grandes écoles");
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
