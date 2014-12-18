package Week07.LiaBraatens;

import javax.swing.*;

/**
 * 1011-071_Labs, Purpose: to use the die class to play a game
 * Class: 1011-071 Thomas Lab:7
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/20/2014 at 1:45 PM.
 */
public class DiceGames
{
    private boolean pig;
    private JFrame frame = new JFrame();

    public static void main(String[] args)
    {
        DiceGames game = new DiceGames();
        game.initFrame();
        game.pig = game.playPig();
    }

    /**
     * a method that plays the game of pig
     * @return whether or not the method has been run
     */
    public boolean playPig()
    {
        Pig pig = new Pig();
        pig.playGame();
        return true;
    }

    /**
     * a class that initialize the settings of the JFrame used in the class
     */
    private void initFrame()
    {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(500,200);
        frame.setVisible(false);
        frame.setLocation(960,540);
    }
}
