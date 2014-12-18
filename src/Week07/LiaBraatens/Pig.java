package Week07.LiaBraatens;

import javax.swing.*;
import java.util.ArrayList;

/**
 * 1011-071_Labs, Purpose: to use the Die class to play a game of pig
 * Class: SE1011-071 Thomas Lab: 7
 * FHT VERSION: 1.1 9/17/2014
 *
 * @author Seth
 * @version 1.0 Created on 10/20/2014 at 2:05 PM.
 */

public class Pig
{
    private Player currentPlayer;
    private ArrayList<Player> playersList = new ArrayList<Player>();

    /**
     * plays the game of pig
     */
    public void playGame()
    {
        System.out.println("---Entered playGame()---");
        ArrayList<String> optionsList = new ArrayList<String>(){{add("Single Die"); add("Two Dice"); add("Three Dice"); add("Four Dice"); add("Five Dice");}};
        String [] optionsArr = new String [optionsList.size()];
        System.out.println("created options list " + optionsList);
        optionsList.toArray(optionsArr);
        String userInput = (String)JOptionPane.showInputDialog(null,"Select the version of this game that you would like to play","Pig",JOptionPane.PLAIN_MESSAGE,null, optionsArr,"Single Die");
        switch (optionsList.indexOf(userInput))
        {
            case 0:
                System.out.println("entered case 0, single die");
                playSingleDieGame();
                break;
            case 1:
                System.out.println("entered case 1, two dice");
                playMultiDieGame(2);
                break;
            case 2:
                System.out.println("entered case 2, three dice");
                playMultiDieGame(3);
                break;
            case 3:
                System.out.println("entered case 3, four dice");
                playMultiDieGame(4);
                break;
            case 4:
                System.out.println("entered case 4, five dice");
                playMultiDieGame(5);
                break;
            default:
                System.err.println("entered default case, choice not found");
        }
    }

    /**
     * plays pig for one die
     */
    private void playSingleDieGame()
    {
        System.out.println("---Entered playSingleDieGame---");
        JOptionPane.showMessageDialog(null, "Welcome to Single Die Pig\n" +
                "RULES:\ntwo or more players attempt to obtain a score of 100\n" +
                "players take turns rolling a die to increase their score\n" +
                "a turn is ended by the player indicating that they wish to hold\n" +
                "a player can choose to hold or continue after each roll\n" +
                "the turn is also ended if the player rolls a 1\n" +
                "if a player rolls a 1 they lose the entirety of their score for that turn", "Pig", JOptionPane.PLAIN_MESSAGE);
        ArrayList<String> optionsList = new ArrayList<String>(){{add("2 Players"); add("3 Players"); add("4 Players");add("5 Players"); add("6 Players");}};
        String [] optionsArr = new String[optionsList.size()];
        optionsList.toArray(optionsArr);
        System.out.println("created option list " + optionsList);
        String userInput = (String)JOptionPane.showInputDialog(null,"Enter the number of players","Pig",JOptionPane.PLAIN_MESSAGE,null,optionsArr,"2 Players");
        int numPlayers = Integer.parseInt(userInput.substring(0,1));
        System.out.println(userInput + " parsed to :numPlayers " + numPlayers);
        initializePlayers(numPlayers);
        Die die = new Die();
        int score;
        boolean winner = false;
        while (!winner)
        {
            for (int i = 0; i < playersList.size() && !winner; i++)
            {
                boolean cont;
                score = 0;
                do {
                    System.out.println(playersList.get(i).getName());
                    winner = checkForWinner();
                    int dieValue = die.roll();
                    if (dieValue == 1)
                    {
                        JOptionPane.showMessageDialog(null, playersList.get(i).getName() + " rolled a 1, their turn total is now zero", "Pig", JOptionPane.INFORMATION_MESSAGE);
                        cont = false;
                    }
                    else
                    {
                        score += dieValue;
                        double hold = JOptionPane.showConfirmDialog(null, playersList.get(i).getName() + "'s turn, a " + dieValue + " is rolled\n" + playersList.get(i).getName() +
                                "'s current turn score is: " + score + " total score is: " + playersList.get(i).getScore() + "\ndo you choose to continue this turn?", "Pig", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                        if (hold == JOptionPane.YES_OPTION) {
                            System.out.println("user selected yes");
                            cont = true;
                        }
                        else if (hold == JOptionPane.NO_OPTION)
                        {
                            System.out.println("user selected no");
                            playersList.get(i).addToScore(score);
                            cont = false;
                        }
                        else
                            cont = false;
                    }
                    winner = checkForWinner();
                } while (cont && !winner);
                String playLst = "" + playersList;
                JOptionPane.showMessageDialog(null,"the current standings:\n" + playLst.substring(1,playLst.length()-1),"Pig",JOptionPane.PLAIN_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,currentPlayer.getName() + " won with a final score of " + currentPlayer.getScore(),"Pig",JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * plays pig with multiple dice
     * @param numDice the number of dice to be used
     */
    private void playMultiDieGame(int numDice)
    {
        System.out.println("---Entered playMultiDieGame---\nnumDice: " + numDice);
        JOptionPane.showMessageDialog(null, "Welcome to Multi Die Pig\n" +
                "RULES:\ntwo or more players attempt to obtain a score of 100\n" +
                "players take turns rolling a die to increase their score\n" +
                "a turn is ended by the player indicating that they wish to hold\n" +
                "a player can choose to hold or continue after each roll\n" +
                "the turn is also ended if the player rolls a 1\n" +
                "if a player rolls a 1 they lose the entirety of their score for that turn\n" +
                "if a player rolls more than one 1 their total score is reset back to zero", "Pig", JOptionPane.PLAIN_MESSAGE);
        ArrayList<String> optionsList = new ArrayList<String>(){{add("2 Players"); add("3 Players"); add("4 Players");add("5 Players"); add("6 Players");}};
        String [] optionsArr = new String[optionsList.size()];
        optionsList.toArray(optionsArr);
        System.out.println("created option list " + optionsList);
        String userInput = (String)JOptionPane.showInputDialog(null,"Enter the number of players","Pig",JOptionPane.PLAIN_MESSAGE,null,optionsArr,"2 Players");
        int numPlayers = Integer.parseInt(userInput.substring(0,1));
        System.out.println(userInput + " parsed to :numPlayers " + numPlayers);
        initializePlayers(numPlayers);
        ArrayList<Die> dice = new ArrayList<Die>();
        for (int i = 0; i < numDice; i++)
        {
            dice.add(new Die());
        }
        System.out.println("dice " + dice);
        int score;
        boolean winner = false;
        while (!winner)
        {
            for (int i = 0; i < playersList.size() && !winner; i++)
            //for (int i : playersList.get(i))
            {
                boolean cont;
                score = 0;
                do
                {
                    System.out.println(playersList.get(i).getName());
                    winner = checkForWinner();
                    int dieValue = 0;
                    int ones = 0;
                    for (Die ii : dice)
                    {
                        int roll = ii.roll();
                        if (roll == 1)
                            ones++;
                        dieValue += roll;
                    }

                    System.out.println(ones);

                    if (ones == 1)
                   {
                        JOptionPane.showMessageDialog(null, playersList.get(i).getName() + " rolled a 1, their turn total is now zero", "Pig", JOptionPane.INFORMATION_MESSAGE);
                        cont = false;
                    }
                    else if (ones > 1)
                    {
                        JOptionPane.showMessageDialog(null, playersList.get(i).getName() + " rolled " + ones + " 1s, their total score is now zero", "Pig", JOptionPane.INFORMATION_MESSAGE);
                        playersList.get(i).setScore(0);
                        cont = false;
                    }
                    else
                    {
                        score += dieValue;
                        double hold = JOptionPane.showConfirmDialog(null, playersList.get(i).getName() + "'s turn, a total value of: " + dieValue + " is rolled\n" + playersList.get(i).getName() +
                                "'s current turn score is: " + score + " total score is: " + playersList.get(i).getScore() + "\ndo you choose to continue this turn?", "Pig", JOptionPane.YES_NO_OPTION,JOptionPane.PLAIN_MESSAGE);
                        if (hold == JOptionPane.YES_OPTION) {
                            System.out.println("user selected yes");
                            cont = true;
                        }
                        else if (hold == JOptionPane.NO_OPTION)
                        {
                            System.out.println("user selected no");
                            playersList.get(i).addToScore(score);
                            cont = false;
                        }
                        else
                            cont = false;
                        System.out.println("winner" + winner);
                        winner = checkForWinner();
                    }
                } while (cont && !winner);
                String playLst = "" + playersList;
                JOptionPane.showMessageDialog(null,"the current standings:\n" + playLst.substring(1,playLst.length()-1),"Pig",JOptionPane.PLAIN_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(null,currentPlayer.getName() + " won with a final score of " + currentPlayer.getScore(),"Pig",JOptionPane.PLAIN_MESSAGE);
    }

    /**
     * initializes players into the players list
     * @param players number of players to add to the list
     */
    private void initializePlayers (int players)
    {
        System.out.println("---Entered initializePlayers---");
        double userInput = JOptionPane.showConfirmDialog(null,"would you like to enter names for the players?","Pig",JOptionPane.YES_NO_OPTION);
        ArrayList<String> playerNames = new ArrayList<String>();
        if (userInput == JOptionPane.NO_OPTION)
        {
            for (int i = 1; i <= players; i++)
            {
                playerNames.add("player " + i);
            }
            System.out.println("playerNames list " + playerNames);
        }
        else if (userInput == JOptionPane.YES_OPTION)
        {
            for (int i = 1; i <= players; i++)
            {
                String userNameInput = JOptionPane.showInputDialog(null,"enter the name of player " + i,"Pig",JOptionPane.PLAIN_MESSAGE);
                playerNames.add(userNameInput);
            }
            System.out.println("playerNames list " + playerNames);
        }
        for (int i = 0; i < players; i++) {
            Player temp = new Player(playerNames.get(i));
            playersList.add(temp);
        }
        System.out.println("playersList" + playersList);
    }

    /**
     * checks for the winner of a game by seeing if the players score is at or over 100
     * @return weather or not a winner exists
     */
    private boolean checkForWinner()
    {
        //for (int i = 0; i < playersList.size(); i++)
        for (Player i : playersList)
        {
            if (i.getScore() >= 100)
            {
                currentPlayer = i;
                return true;
            }
        }
        return false;
    }

    private void test()
    {
        this.playGame();
    }

    public static void main(String[] args)
    {
        Pig tester = new Pig();
        tester.test();
    }
}




