package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.io.*;
import static sample.Categories.choix;

public class QuestionQCM {
    @FXML // annotation
    private Label questionNumber;
    @FXML
    private Label questionText;
    @FXML
    private Label scoreIncrement;
    @FXML
    private Button buttonReponse1;
    @FXML
    private Button buttonReponse2;
    @FXML
    private Button buttonReponse3;
    @FXML
    private Button buttonContinue;

    public static int numberQuestion = 1;
    public static int score = 0;
    private BufferedReader brQ;
    private BufferedReader brR;
    private String[] splitReponse;

    public void initialize() throws IOException {
        score = 0;
        numberQuestion = 1;

        // Nous déclarons nos objets en dehors du bloc try/catch
        File fileQuizz = new File("src/quizz/"+choix+".txt");
        File fileReponses = new File("src/reponses/"+choix+".txt");
        try {
            brQ = new BufferedReader(new FileReader(fileQuizz));
            brR = new BufferedReader(new FileReader(fileReponses));
            readQuizzAndReponses(brQ,brR);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void pressButtonR1(ActionEvent actionEvent) throws IOException, InterruptedException {
        checkResponse(buttonReponse1,splitReponse[3]);
    }

    public void pressButtonR2(ActionEvent actionEvent) throws IOException, InterruptedException {
        checkResponse(buttonReponse2,splitReponse[3]);
    }

    public void pressButtonR3(ActionEvent actionEvent) throws IOException, InterruptedException {
        checkResponse(buttonReponse3,splitReponse[3]);
    }

    private void checkResponse(Button btn, String answer) throws InterruptedException {
        if (btn.getText().equals(answer)){
            score++;
            scoreIncrement.setText(String.valueOf(score));
        }
        displayErrors();
    }

    private void displayErrors() throws InterruptedException {
        if(buttonReponse1.getText().equals(splitReponse[3])){
            buttonReponse1.setStyle("-fx-background-color: #098436;");
        } else {
            buttonReponse1.setStyle("-fx-background-color: #ff0000;");
            buttonReponse1.setTextFill(Color.RED);
        } if(buttonReponse2.getText().equals(splitReponse[3])){
            buttonReponse2.setStyle("-fx-background-color: #098436;");
        } else {
            buttonReponse2.setStyle("-fx-background-color: #ff0000;");
            buttonReponse2.setTextFill(Color.RED);
        } if(buttonReponse3.getText().equals(splitReponse[3])){
            buttonReponse3.setStyle("-fx-background-color: #098436;");
        } else {
            buttonReponse3.setStyle("-fx-background-color: #ff0000;");
            buttonReponse3.setTextFill(Color.RED);
        }
        // le disable désactive le click
        buttonReponse1.setDisable(true);
        buttonReponse2.setDisable(true);
        buttonReponse3.setDisable(true);
        buttonContinue.setVisible(true);
    }

    private void readQuizzAndReponses(BufferedReader brQ, BufferedReader brR) throws IOException {
        String lineQuestion;
        String lineReponse;
        if (((lineQuestion = brQ.readLine())!= null) && (lineReponse = brR.readLine()) != null){
            buttonReponse1.setStyle("-fx-background-color: #526579");
            buttonReponse2.setStyle("-fx-background-color: #febf5c");
            buttonReponse3.setStyle("-fx-background-color: #c4ccd9");
            questionNumber.setText("Question : " + numberQuestion);
            questionText.setText(lineQuestion);
            splitReponse = lineReponse.split("-");
            buttonReponse1.setText(splitReponse[0]);
            buttonReponse2.setText(splitReponse[1]);
            buttonReponse3.setText(splitReponse[2]);
            numberQuestion++;
        } else {
            Main.root = FXMLLoader.load(getClass().getResource("../views/score.fxml"));
            Main.root.getStylesheets().add(Score.class.getResource("../style/style.css").toExternalForm());
            Main.primaryStage.setScene(new Scene(Main.root, 1024, 768));
        }
    }

    public void pressButtonContinue(ActionEvent actionEvent) throws IOException {
        readQuizzAndReponses(brQ,brR);
        buttonReponse1.setDisable(false);
        buttonReponse2.setDisable(false);
        buttonReponse3.setDisable(false);
        buttonContinue.setVisible(false);
    }
}
