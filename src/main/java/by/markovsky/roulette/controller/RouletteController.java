package by.markovsky.roulette.controller;

import by.markovsky.roulette.entity.Player;
import by.markovsky.roulette.entity.Revolver;
import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 * Created by Pavel Markovsky on 11.01.2018.
 */
public class RouletteController {

    @FXML
    private JFXButton startButton, shootButton, passButton, rollButton;
    @FXML
    private Label score, scoreLabel;
    @FXML
    private ImageView revolverImg;
    @FXML
    private BorderPane pane;

    private Player player;
    private Revolver revolver;

    public void onStartButton() throws Exception{
        player = new Player();
        score.setText(String.valueOf(player.getScore()));
        scoreLabel.setText("SCORE");

        revolver = new Revolver();
        revolver.load();
        revolverImg.setImage(new Image(getClass().getResource("/images/pistload.png").toExternalForm()));

        startButton.setVisible(false);
        rollButton.setVisible(true);

        AlertBox.display("Ready", "A revolver is loaded! Press ROLL to spin a barrel!", 400, 120);
    }
    public void onShootButton() throws Exception{
        if(revolver.shoot()){
            pane.setStyle("-fx-background-color: red;");
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/roulette.fxml"));
            AlertBox.display("YOU ARE DEAD", "Unfortunately, you died :( Your score is " + player.getScore() + ".", 300, 120);
            Main.getStage().setScene(new Scene(root));
        }
        else{
            player.addScore();
            score.setText(String.valueOf(player.getScore()));
        }
    }
    public void onPassButton() throws Exception{
        rollButton.setVisible(true);
        shootButton.setVisible(false);
        passButton.setVisible(false);
    }
    public void onRollButton() throws Exception{
        revolver.roll();

        rollButton.setVisible(false);
        shootButton.setVisible(true);
        passButton.setVisible(true);

        AlertBox.display("Shoot or pass", "A barrel has been spinned. Now you are ready to shoot or pass!", 500, 120);
    }

}
