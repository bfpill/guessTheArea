
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;

// TODO: explain this class with comments


public class PracticeWindow extends GameWindow {
 
    //all of the panels and labels and fields and buttons pre instantiated
    JPanel titleNamePanel, practiceButtonPanel, timedButtonPanel, shapeNamePanel, infoPanel, guessPanel, guessLabelPanel, pointsPanel
    , dimensionInfoPanel, equationPanel;
    JLabel titleNameLabel, shapeNameLabel, infoLabel, guessLabel, pointsLabel, dimensionLabel, equationLabel;
    JTextField guessField;
   
    JButton practiceModeButton, timedModeButton;

    public PracticeWindow(Game g, GameController gc){
        super(g, gc); // has acc
        createGameScreen(); // the content of the Practice Window
        // update ourselves with the initial round information
        updateWindow();
    }

    public void createGameScreen() { //the homescreen maker
        makeWindow(); //sets up the frame for the panels
        //bunch of panels to hold the labels 
        shapeNamePanel = makePanel(200, 100, 400, 70, Color.white);
        shapeNameLabel = makeLabel("soupe", gameFontUpper, Color.black, shapeNamePanel);

        guessLabelPanel = makePanel(200, 400, 100, 50, Color.white);
        makeLabel("Guess:", gameFontLower, Color.black, guessLabelPanel);

        dimensionInfoPanel = makePanel(200, 200, 400, 50, Color.white);
        dimensionLabel = makeLabel("", gameFontLower, Color.black, dimensionInfoPanel);

        guessPanel = makePanel(300, 400, 300, 50, Color.white);
        makeTextField(10, Color.black, gameFontLower, "GUESS", controller, guessPanel); //this has a listener that sends a event to the controller when text is submitted

        pointsPanel = makePanel(600, 50, 200, 100, Color.white);
        pointsLabel = makeLabel("Score: 0", gameFontUpper, Color.black, pointsPanel);

        equationPanel = makePanel(200, 250, 400, 100, Color.white);
        equationLabel = makeLabel("", gameFontLower, Color.blue, equationPanel);
        homeButton();     
    }

    //called to reprint the window
    public void updateWindow() { 
        updatePoints();
        updateShape();
        updateDimensions();
        updateEquation();
    }

    // used to reprint the equation 
    public void updateEquation(){ 
        Shape shape = game.currentRound.getShape();
        if(shape == Shape.RECTANGLE){
            equationLabel.setText("Area = Base * Height");
        }
        if(shape == Shape.TRIANGLE){
            equationLabel.setText("Area = (Base * Height) / 2");
        }
        if(shape == Shape.CIRCLE){
            equationLabel.setText("Area = Pi * (Radius * Radius)");
        }
    }

    //changes what is displayed on the points label, so that the score is correctly displayed
    public void updatePoints() {
        pointsLabel.setText("Score: " + game.getScore());
    }

    //updates the shape label
    public void updateShape() {
        shapeNameLabel.setText(game.currentRound.getShape().name());
    }

    //updates the dimensionLabel
    public void updateDimensions() {
        if(game.currentRound.getShape() == Shape.RECTANGLE || game.currentRound.getShape() == Shape.TRIANGLE){
            dimensionLabel.setText("Height: " + game.currentRound.getHeight() + ", Width: " + game.currentRound.getWidth());
        }
        else if(game.currentRound.getShape() == Shape.CIRCLE){
            dimensionLabel.setText("Radius: " + game.currentRound.getRadius());
        }
    }

}
