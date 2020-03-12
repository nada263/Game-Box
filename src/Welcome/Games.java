
package Welcome;

import Sokoban.Sokoban_Main;
import Tetris.Tetris_Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Games 
{
    private Group gamesGroup= new Group();
    private final HBox gamesHBox= new HBox();
    private Scene gamesScene = new Scene(gamesGroup, 1400, 780);

    public Games(Stage gamesStage) 
    {  
        gamesStage.setMaximized(true);
        gamesStage.setResizable(false);
        gamesStage.setScene(gamesScene);
        gamesStage.setTitle("Game Box");
        createBackground();
        createButtons(gamesStage);
        textChooseYourGame();
        gamesStage.show();
    }
      
      private void createBackground()
    {
        Image Imageback = new Image("Resources/gamesPage/d.jpg", 1370, 780, true, false);
        
        ImageView ImagbackIV = new ImageView(Imageback);
       gamesGroup.getChildren().add(ImagbackIV);
    }
    
     private void createButtons(Stage MainStage)
    {
        Button SokobanBtn = new Button();
        SokobanBtn.setLayoutX(300);
        SokobanBtn.setLayoutY(250);
        Image sokobanImage =new Image("Resources/gamesPage/socopan.png",200,300,true, false);
        ImageView sokobanImageIV =new ImageView(sokobanImage);
        SokobanBtn.setGraphic(sokobanImageIV);
        SokobanBtn.setOnMousePressed(event ->  {
            try
            {
              Sokoban_Main.getInstanceFromSokoban().Sokoban_Main(MainStage);
            } 
            catch (IOException ex)
            {
                Logger.getLogger(Games.class.getName()).log(Level.SEVERE, null, ex);
            }} ); 
        gamesGroup.getChildren().add(SokobanBtn);
        
        
        Button TetrisBtn = new Button();
        TetrisBtn.setLayoutX(550);
        TetrisBtn.setLayoutY(250);
        Image tetrisImage = new Image("Resources/gamesPage/tetris.png", 300, 300, true, false);
        ImageView tetrisImageIV = new ImageView(tetrisImage);
        TetrisBtn.setGraphic(tetrisImageIV);
        TetrisBtn.setOnMousePressed(event ->  { Tetris_Main.getInstanceFromTetris().Tetris_Main(MainStage); } ); 
        gamesGroup.getChildren().add(TetrisBtn);
        
        
        
        Button ArkanoidBtn = new Button();
        ArkanoidBtn.setLayoutX(900);
        ArkanoidBtn.setLayoutY(250);
        Image arkanoidImage = new Image("Resources/gamesPage/arkanoid.jpg", 200, 200, true, false);
        ImageView arkanoidImageIV = new ImageView(arkanoidImage);
        ArkanoidBtn.setGraphic(arkanoidImageIV);
        gamesGroup.getChildren().add(ArkanoidBtn);
        
        
        AnimationOfPage(SokobanBtn, TetrisBtn, ArkanoidBtn);
        buttonsShadow(SokobanBtn, TetrisBtn, ArkanoidBtn);
        
    }
  
 private void textChooseYourGame()
 {
     Text choose = new Text();
     choose.setText("Choose Your Game...");
     choose.setFont((Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 80)));
     choose.setFill(Color.GOLD);
     choose.setX(170);
     choose.setY(200);
     gamesGroup.getChildren().add(choose);

     AnimationOfPage(choose);
     
     DropShadow shadow = new DropShadow();
     shadow.setBlurType(BlurType.GAUSSIAN);
     shadow.setColor(Color.ROSYBROWN);
     shadow.setHeight(5);
     shadow.setWidth(5);
     shadow.setRadius(5);
     shadow.setOffsetX(3);
     shadow.setOffsetY(2);
     shadow.setSpread(12);
     choose.setEffect(shadow);
 }
    
    private void AnimationOfPage(Button soko, Button tetris, Button arkanoid) 
    {
        FadeTransition sokoFade = new FadeTransition(Duration.millis(5000));
        sokoFade.setNode(soko);
        sokoFade.setFromValue(0);
        sokoFade.setToValue(1);
        sokoFade.setCycleCount(1);
        sokoFade.play();
        FadeTransition tetrisFade = new FadeTransition(Duration.millis(5000));
        tetrisFade.setNode(tetris);
        tetrisFade.setFromValue(0);
        tetrisFade.setToValue(1);
        tetrisFade.setCycleCount(1);
        tetrisFade.play();
        FadeTransition arkanoidFade = new FadeTransition(Duration.millis(5000));
        arkanoidFade.setNode(arkanoid);
        arkanoidFade.setFromValue(0);
        arkanoidFade.setToValue(1);
        arkanoidFade.setCycleCount(1);
        arkanoidFade.play();
    }
  private void AnimationOfPage(Text text)
 { 
       FadeTransition textFade = new FadeTransition(Duration.millis(5000));
        textFade.setNode(text);
        textFade.setFromValue(0);
        textFade.setToValue(1);
        textFade.setCycleCount(1);
        textFade.play();
     
 }
    private void buttonsShadow(Button soko, Button tetris, Button arkanoid) 
    {
        DropShadow sokoShadow = new DropShadow();
        sokoShadow.setBlurType(BlurType.THREE_PASS_BOX);
        sokoShadow.setHeight(10);
        sokoShadow.setWidth(10);
        sokoShadow.setSpread(12);
        soko.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            soko.setEffect(sokoShadow);
        });
        DropShadow tetrisShadow = new DropShadow();
        tetrisShadow.setBlurType(BlurType.THREE_PASS_BOX);
        tetrisShadow.setHeight(10);
        tetrisShadow.setWidth(10);
        tetrisShadow.setSpread(12);
        tetris.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            tetris.setEffect(tetrisShadow);
        });
        DropShadow arkanoidShadow = new DropShadow();
        arkanoidShadow.setBlurType(BlurType.THREE_PASS_BOX);
        arkanoidShadow.setHeight(10);
        arkanoidShadow.setWidth(10);
        arkanoidShadow.setSpread(12);
        arkanoid.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent e) -> {
            arkanoid.setEffect(arkanoidShadow);
        });

    }
 
}
