package Week07.LiaBraatens;

/**
 * 1011-071_Labs, Purpose: to hold the attributes of a player
 * Class: SE1011-071 Thomas  Lab: 7
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/20/2014 at 2:09 PM.
 */
public class Player
{
    private double score;
    private String name;

    /**
     * default constructor for player
     * sets score to 0
     */
    public Player()
    {
        this.name = "player";
        this.score = 0.0;
    }

    /**
     *
     * @param name the name of the player
     */
    public Player(String name)
    {
        this.name = name;
        score =  0.0;
    }

    /**
     * sets the value of the player's score
     * @param score sets the current value of the score
     */
    public void setScore(double score)
    {
        this.score = score;
    }

    /**
     * sets the name value for the player
     * @param name the name of the player
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * adds to the value of the player's score
     * @param score the difference in the player's score
     */
    public void addToScore(double score)
    {
        this.score += score;
    }

    /**
     * gets the current score of the player
     * @return current score
     */
    public double getScore()
    {
        return score;
    }

    /**
     * gets the name of the player
     * @return player name
     */
    public String getName()
    {
        return name;
    }

    /**
     * override of the toString method to something useful
     * @return the name and the score of the player
     */
    public String toString()
    {
        return "\nName: " + this.getName() + " Score: " + this.getScore();
    }

}
