import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;


public class StartWindow extends Window {

    JPanel titleNamePanel, practiceButtonPanel, timedButtonPanel;
    JLabel titleNameLabel;

    JButton practiceModeButton, timedModeButton;

    //a window with the additives from startWindow()

    public StartWindow(GameController gc) { 
        super(gc);
        startWindow();
    }
     
    // make the content of the homescreen
    public void startWindow() {
        makeWindow();

        titleNamePanel = makePanel(100, 100, 600, 100, Color.white);
        titleNameLabel = makeLabel("Guessing The Area!", titleFont, Color.black, titleNamePanel);

        practiceButtonPanel = makePanel(150, 400, 220, 50, Color.white);
        practiceModeButton = makeButton("Practice Mode", buttonFont, Color.white, Color.black, "PRACTICE", controller, practiceButtonPanel);
        
        timedButtonPanel = makePanel(500, 400, 220, 50, Color.white);
        timedModeButton = makeButton("Timed Mode", buttonFont, Color.white, Color.black, "TIMED", controller, timedButtonPanel);
    }

}
