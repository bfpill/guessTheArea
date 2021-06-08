import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;

import javax.swing.Timer;

// TODO: explain this class with comments

public class GameController implements ActionListener {

    private static final int MAX_ROUNDS_TIMED_MODE = 5;

    Game game;
    StartWindow startWindow; // extends GameWindow
    PracticeWindow practiceWindow; // extends GameWindow
    TimedWindow timedWindow; // extends Window
    ScoreScreen scoreScreen; // extends GameWindow
    GameWindow window; // we update this based on mode

    // flags
    boolean isTimedMode;
    boolean isPracticeMode;
    boolean isGameInProgress;
    boolean isStartWindow;
    boolean isScoreScreen;

    Timer timer; // timer used in timedMode

    int seconds = 7; // the time you have per round

    public GameController() {
        // empty constructor
    }

    // the heart of this program
    // everything here is event based
    // the logic behind all of the windows resides in the following
    // handle<activity> methods
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();

        if (command.equals("PRACTICE")) { // triggered by a button on the homescreen
            handleStartPractice();
        } else if (command.equals("TIMED")) { // triggered by a button
            handleStartTimed();
        } else if (command.equals("HOMESCREEN")) { // triggered by a button on scorescreen and practicemode
            handleHomeScreen();
        } else if (command.equals("GUESS")) { // whenever they hit enter on the guess field
            handleGuess(event);
        } else if (command.equals("TIMER")) {  // when our timer goes off (every second)
            handleTimer();
        }
    }

    // when someone clicks the practice button, close the startwindow
    // and initiate practice mode
    private void handleStartPractice() {
        startWindow.close();
        isStartWindow = false; // boolean flags
        isPracticeMode = true;
        game = new Game(); // create a game
        practiceWindow = new PracticeWindow(game, this); // then open the practice window, passing in the game and the
                                                         // gameController (this)
        // so now our window is a practice window
        window = practiceWindow;
    }

    // same procces as when practice button is hit, just for timedMode
    private void handleStartTimed() {
        startWindow.close();
        isStartWindow = false;
        isTimedMode = true;
        game = new Game();
        timedWindow = new TimedWindow(game, this);
        // so now our window is a timed window
        window = timedWindow;
        timedWindow.setSeconds(7); // tell timedWindow how many seconds we using here, also resets the seconds
                                   // variable in timedWindow
        startCountdown(); // the moment the window is opened, start the timer
    }

    // check their guess and update their points
    private void handleGuess(ActionEvent event) {
        JTextField guessField = (JTextField) event.getSource();

        // this next line throws a NumberFormatException and the event is ignored
        // which is kinda what we want anyhow...
        int guess = 0;
        try {
            guess = Integer.parseInt(guessField.getText());
        } catch (NumberFormatException ne) {
            guessField.setText(""); // not today, clear the textbox
            return;
        }

        // recompute their points using the new guess
        game.guess(guess);
        game.updatePoints();

        // clear the last guess from the UI
        guessField.setText("");
        if (isTimedMode) {
            if (game.getRoundNumber() == MAX_ROUNDS_TIMED_MODE) {
                // game over. show score and exit
                finish();
                scoreScreen = new ScoreScreen(game, this);
                return; // bail out now
            }
            restartCountdown();
        }
        // advance to the next round
        game.nextRound();
        // tell our window to update itself (either kind)
        window.updateWindow();
    }

    private void handleTimer() {
        countdown(); // start the countdown
        if (seconds == 0) {
            if (game.getRoundNumber() == MAX_ROUNDS_TIMED_MODE) {
                // game over. show score and exit
                finish();
                scoreScreen = new ScoreScreen(game, this);
            } else {
                game.nextRound(); // if its not the last round, go to the next round
                restartCountdown(); // restart the timer
            }
        }
    }

    private void handleHomeScreen() {
        if (isPracticeMode) { // what to do if is practice mode
            window.close(); // close the game window that was open (practice mode)
            isPracticeMode = false;
            startWindow.startWindow(); // open startWindow
            isStartWindow = true;
            // we are not in practice mode anymore
        } else if (isTimedMode) { // what to do if is timedMode
            scoreScreen.close(); // close the score screem
            isTimedMode = false;
            isScoreScreen = false; // switch the flag
            startWindow.startWindow(); // open startWindow
            isStartWindow = true;
        }
    }

    // make a timer and start ticking down
    private void startCountdown() {
        timer = new Timer(1000, this);
        timer.setActionCommand("TIMER"); // TELL THE LOGIC ABOVE THAT THE TIMER IS RUNNING
        timer.start();
        seconds = 7;
        timedWindow.setSeconds(7); // tell timed window how many seconds we working with here
    }

    // called when the game needs to end
    public void finish() {
        window.close();
        isScoreScreen = true;
        timer.stop();
        timer = null;
    }

    // homescreen basically
    public void start() {
        isStartWindow = true;
        startWindow = new StartWindow(this);
    }

    // decriments seconds and sends the new seconds var to timedWindow
    public void countdown() {
        seconds--;
        timedWindow.setSeconds(seconds);
    }

    // resets local seconds var and resets timedWindows seconds
    public void restartCountdown() {
        seconds = 7;
        timedWindow.setSeconds(seconds);
        timer.restart();
    }
}
