/*************************************************
 * Game.java                                     *
 *************************************************/

package Battleship;

import java.util.Random;

public class Game
{
	private Player player1;
	private Player player2;
	private int boardSize;
	private boolean turn = true;
	
	private Random rand = new Random();

	
	Game(Player player1, Player player2, int boardSize)
	{
		this.player1 = player1;
		this.player2 = player2;
		this.boardSize = boardSize;
	}

	// returns 'true' if either of the players are "dead"
	boolean gameOver()
	{
		return (player1.isDead() || player2.isDead());
	}
	
	// returns the winning Player if the game is over, 'null' otherwise
	Player getWinner()
	{
		if (gameOver())
		{
			if (player1.isDead())
			{
				return player2;
			}
			return player1;
		}
		return null;
	}
	
	// take the next "turn"
	void nextTurn()
	{
		Coordinate coord = new Coordinate(rand.nextInt(boardSize), rand.nextInt(boardSize));
		
		if (turn)
		{
			player1.fireAt(player2, coord);
		}
		
		else 
		{
			player2.fireAt(player1, coord);
		}
		turn = !turn;
	}
}