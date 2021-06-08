// TODO: explain this class with comments

public class Game {
    private int totalPoints; // the totalPoints per game, gets incremented round on round
    Round currentRound; // the round object that updates every round
    int roundNumber; // the number of the round we are on

    //these get used to hold the dimensions of a shape in round
    int height; 
    int width;
    int radius;

    //constructor
    public Game() {
        nextRound(); 
    }

     //simple getter to get information from the round
    public void getDimensions(){
        height = currentRound.getHeight();
        width = currentRound.getWidth();
        radius = currentRound.getRadius();
    }

    //more simple getters
    public int getRoundNumber() {
        return roundNumber;
    }

    public int getScore() {
        return totalPoints;
    }

    public void guess(int guess){ 
        currentRound.setGuess(guess); // call to the Round class - used by GameController
    }

    //adds the points from a round to totalPoints
    public void updatePoints(){ 
        totalPoints += currentRound.getPoints();
    }

    //increases roundNumber and resets currentRound to a new round
    public void nextRound() {
        roundNumber++;
        currentRound = new Round();
    }


}
