import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import java.awt.Color;

//this is the grandaddy class, pretty much has all the basics used everywhere
public abstract class Window {
    //some fonts used everywhere
    Font titleFont = new Font("Times new Roman", Font.PLAIN, 50);
    Font buttonFont = new Font("Times new Roman", Font.PLAIN, 30);
    Font gameFontLower = new Font("Montserrat", Font.PLAIN, 30);
    Font gameFontUpper = new Font("Montserrat", Font.PLAIN, 40);

    JPanel homeScreenPanel;
    JButton homeScreenButton;
    JFrame frame;
    Container container;

    GameController controller;

    
    protected Window(GameController gc){
        controller = gc;
    }

    //close the window
    public void close(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    //build the window
    protected JFrame makeWindow() {
        frame = new JFrame();
        frame.setSize(850, 600);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.getContentPane().setBackground(Color.white);
        frame.setLayout(null);
        frame.setVisible(true);
        container = frame.getContentPane();
        return frame;
    }

    // helper methods to make our life easier
    protected JTextField makeTextField(int numChars, Color color, Font font, String action, GameController controller, JPanel panel) {
        JTextField field = new JTextField(numChars);
        field.setForeground(color);
        field.setFont(font);
        panel.add(field);
        field.setActionCommand(action);
        field.addActionListener(controller);
        return field;
    }

    protected JButton makeButton(String text, Font font, Color bkgndColor, Color fgrndColor, String action, GameController controller, JPanel panel) {
        JButton button = new JButton(text);
        button.setBackground(bkgndColor);
        button.setForeground(fgrndColor);
        button.setFont(font);
        button.setActionCommand(action);
        button.addActionListener(controller);
        panel.add(button);
        return button;
    }

    protected JPanel makePanel(int left, int top, int width, int height, Color color){
        JPanel panel = new JPanel();
        panel.setBounds(left, top, width, height );
        panel.setBackground(color);
        container.add(panel);
        return panel;
    }

    protected JLabel makeLabel(String text, Font font, Color color, JPanel panel){
        JLabel label = new JLabel(text);
        label.setForeground(color);
        label.setFont(font);
        panel.add(label);
        return label;
    }

    //the homebutton, which is used in a few places
    public void homeButton(){
        homeScreenPanel = makePanel(50, 50, 200, 50, Color.white);
        homeScreenButton = makeButton("Home Screen", buttonFont, Color.white, Color.black, "HOMESCREEN", controller, homeScreenPanel);
    }
}
