public abstract class GameWindow extends Window {
    Game game;

    // this class holds a game and is used to reference any type of gamewindow
    protected GameWindow(Game g, GameController gc){
        super(gc);
        game = g;
    }

    //simple stuff
    public Game getGame(){
        return game;
    }

    public abstract void updateWindow();
}
