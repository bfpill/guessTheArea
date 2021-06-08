import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;

public class TimedWindow extends PracticeWindow{
 
    static JPanel timerPanel;
    static JLabel timerLabel;

    int secondsRemaining; //this variable gets changed via other classes

    public TimedWindow(Game g, GameController gc){
        super(g, gc);
    }

    // override createGameScreen to add a timer display
    @Override public void createGameScreen(){
        super.createGameScreen();
        timerPanel = makePanel(100, 50, 50, 50, Color.white);
        timerLabel = makeLabel(secondsRemaining + "", gameFontUpper, Color.black, timerPanel);
    }

    //overide the updateWindow method, because we want to add a timer in the corner
    @Override public void updateWindow(){
        super.updateWindow();
        if(secondsRemaining >= 4){
            timerLabel.setForeground(Color.black);
            timerLabel.setText(secondsRemaining + "");
        } else if(secondsRemaining < 4 && secondsRemaining > 0){
            timerLabel.setForeground(Color.red);
            timerLabel.setText(secondsRemaining + "");
        }
    }

    @Override public void updateEquation(){
        //hide the equation, do nothing
    }

    @Override public void homeButton(){
        //hehe do nothing
    }
    //every time we change the seconds left, we need to repaint
    public void setSeconds(int seconds){
        secondsRemaining = seconds;
        updateWindow();
    }

}
