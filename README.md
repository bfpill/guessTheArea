# guessTheArea
Math game - APCSA final project

Communications with Client Log

June 8 2021 Project Completed
May 28 2021 Email thread about project
May 10 2021 --- Interview with Alison about more potential project ideas, settled on making an interactive program to help student understand area better. 
---
darkness
---
Feb 16 2021 --- First email with Alison, discussed potential project ideas


OBJECT ORIENTATION STRUCTURE 
The project is made up of 11 classes, 6 being GUI user side classes, 3 handle the logic of the game, and the last 2 and link everything together. 

GUI SIDE EXTENSION DIAGRAM
                                  
                                    WINDOW 
                                       |------------------------------ extends--|
                                    extends                                     |
                                       |                                   STARTWINDOW
                                  GAMEWINDOW 
                                       |
                                    extends
                                       |
                                 ------------------------------
                                 |           |                |
                        PRACTICEWINDOW     SCORESCREEN
                                 |
                              extends
                                 |
                          TIMEDWINDOW
                         
GAME SIDE LOGIC

The program is run through GuessTheArea.java, which on run makes a new GameController, and calls it's start().

When GameController.start() is called, gameController makes a new StartWindow object. StartWindow buils the basic JFrame and slaps a few panels on for good looks, but mainly to hold the buttons that the user can interact with.

The GameController class implements ActionListener, and its main purpose is to handle all of the programs logic. Whenever a button is clicked on the GUI side, an event with a specific 'identity' command is triggered, and this trigger is wired directly to the GameController. GameController listens for these actions, and when dinged, triggers the respective code. For example, when the practice mode button is clicked, an event is triggered with the action command of "PRACTICE". When GameController gets the "PRACTICE" command, it runs handleStartPractice(), the method containing the code for practiceMode. 

The events are as such:

PRACTICE - triggered by a button on the homescreen, tells the controller to run handleStartPractice();
TIMED -  triggered by a button on the homescreen, tells the controller to run handleStartTimed();
HOMESCREEN - triggered by a button on scorescreen and practicemode, tells the controller to run handleHomeScreen();
GUESS - triggered when the user hits enter on the guess field, and runs handleGuess();
TIMER - triggered when our timer goes off (every second), tells timedWindow to update the timer Label

When handleStartPractice() or handleStartTimed() are called, they both: 

Close the startWindow
Set local boolean flags appropriatly
Update the local game object to be a new game object
Make a new gameWindow - (practiceWindow or timedWindow)
Reset the local gameWindow variable to the respective type

TimedWindow has one more step, where it sets timedWindow.seconds to a passed in integer via a setter method in timedWindow. It calls startCountdown(), which basically starts the timer. 

When handleHomeScreen() is called, the program will close any previously open windows and run startScreen(), which is essentially a homescreen builder. 

When handleGuess() is called, the users guess is passed through both the game class and the round class, and a score for that round is returned. If the current gameWindow is a TimedWindow, GameController first checks to see if the game has already played out all of its rounds. If so, it calls finish(), and then scoreScreen().
If the rounds have not all been played out, the game will advance to the next round via game.nextRound(). The timer is restarted aswell.



BIBLIOGRAPHY:

no external code used. 




