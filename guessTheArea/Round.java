// TODO: explain this class with comments

public class Round {
    // basic stuff that changes each round
    int height = 3;
    int width = 3;

    int radius = 3;

    int points = 100;
    int guess = 0;

    private Shape shape; // nice lil enum for global use

    public Round() {
        setupShapes(); // do this when a round is contstructed
    }

    // getters and setters over here
    public int getRadius() {
        return radius;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    // the guess here gets passed in from the game class
    public void setGuess(int g) { 
        guess = g;
        guessPoints();
    }

    public Shape getShape() {
        return shape;
    }

    public int getPoints() {
        return points;
    }

    public int getRandNum(int max) {
        return (int) (Math.random() * max) + 3;
    }

    // pseudorandom way of picking the shape for the round
    public void pickShape() {
        int rand = getRandNum(10);

        if (rand <= 5) {
            shape = Shape.RECTANGLE;
        } else if (rand < 8) {
            shape = Shape.TRIANGLE;
        } else {
            shape = Shape.CIRCLE;
        }
    }

    // method for setting the height, width, and radius variables based on the
    public void setupShapes() { 
                                // rounds shape
        pickShape();
        if (shape == Shape.RECTANGLE || shape == Shape.TRIANGLE) {
            height = getRandNum(10);
            if (getRandNum(10) > 5)
                width = height;
            else {
                width = getRandNum(10);
            }
        }
        if (shape == Shape.CIRCLE)
            radius = getRandNum(10);
    }

    // method for returning the area of the shape using the height, width, and
    public double getArea() { 
                              // radius vars
        if (shape == Shape.RECTANGLE)
            return height * width;
        if (shape == Shape.TRIANGLE)
            return height * width / 2;
        else
            return ((int) (Math.PI * (radius * radius) * 100)) / 100;
    }

    // method for calculating the points for this round based on the users guess
    //points are based off of the difference between the guess and the real answer
    //maximum points per guess is 100, and minimum is zero
    public int guessPoints() { 
        int diff = (int) Math.abs(getArea() - guess); 

        if (diff > 100) {
            points = 0;
        } else {
            points = 100 - diff;
        }
        return points;
    }

}
