import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class ScoreScreen extends GameWindow {

    JPanel scorePanel, memoPanel;
    JLabel scoreLabel, pointsLabel, memoLabel;

    //when we call scorescreen, we want to make the scorescreen, then update it so the numbers are right
    public ScoreScreen(Game g, GameController gc) {
        super(g, gc); //take gamewindows g and gc
        createScreen(); 

        // update ourselves as needed
        updateWindow();
    }

    public void createScreen() {
        makeWindow(); //make the frame

        scorePanel = makePanel(200, 100, 400, 100, Color.white);

        //display the score with different colors and messages 
        if(game.getScore() == 500){
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.YELLOW, scorePanel);
            congratulations("PERFECT SCORE!!! ", Color.PINK);
        }
        else if(game.getScore() > 490){
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.RED, scorePanel);
            congratulations("EPIC SCORE!!", Color.RED);
        }
        else if(game.getScore() > 450){
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.ORANGE, scorePanel);
            congratulations("Nice one!", Color.ORANGE);
        }
        else if(game.getScore() > 400){
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.GREEN, scorePanel);
            congratulations("Getting there :)", Color.GREEN);
        }
        else if(game.getScore() > 350){
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.BLUE, scorePanel);
            congratulations("Try again?", Color.BLUE);
        }
        else{
            scoreLabel = makeLabel("Score : " + game.getScore(), titleFont, Color.BLACK, scorePanel);
            congratulations("Blame the game?", Color.black);
        }
        homeButton(); //display the homebutton
    }

    public void congratulations(String text, Color color){
        memoPanel = makePanel(200, 200, 400, 70, Color.white);
        makeLabel(text, gameFontUpper, color, memoPanel);
    }

    //slighty changed homeButton that is in a different spot
    @Override public void homeButton(){ 
        homeScreenPanel = makePanel(300, 400, 200, 50, Color.white);
        homeScreenButton = makeButton("Home Screen", buttonFont, Color.white, Color.black, "HOMESCREEN", controller, homeScreenPanel);
    }

    public void updateWindow()
    {// not needed  
    }

}

