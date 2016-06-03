/*************************************************
 * Player.java                                   *
 *************************************************/

package Battleship;

public class Player
{
	private String name;
	private Board board;
	private int boardSize;
	
	Player(String name, int boardSize)
	{
		this.name = name;
		this.boardSize = boardSize;
		
		board = new Board(boardSize);
	}	
	
	// returns the player's name
	String getName()
	{
		return name;
	}
	
	// returns 'true' if all of the player's boats are sunk
	boolean isDead()
	{
		for (int i = 0; i < board.getBoatCount(); i++)
		{
			if (!board.getBoat(i).isSunk())
			{
				return false;
			}
		}
		return true;
	}
	
	// displays the player's board
	void displayBoard()
	{
		String line = "";
		
		// loop through the X coordinates
		for (int i = 0; i < boardSize; i++)
		{
			// loop through the Y coordinates
			for (int ii = 0; ii < boardSize; ii++)
			{
				// get the display character for each Coordinate and add it to line
				line += board.getCoordinate(i,ii).getDisplayChar() + " ";
			}
			// add newline character(s)
			line += "\n";
		}
		// print each line
		System.out.println(line);
	}
	
	// calls the Board's randomizeBoats()
	void randomizeBoats()
	{
		board.randomizeBoats();
	}

	// calls the specified player's takeShot()
	void fireAt(Player player, Coordinate coord)
	{
		player.takeShot(coord);
	}
	
	// finds the matching Coordinate and calls its takeHit()
	void takeShot(Coordinate c)
	{
		Coordinate coord = board.getCoordinate(c);
		coord.takeHit();
	}
}
