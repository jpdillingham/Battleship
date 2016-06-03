/*************************************************
 * Board.java                                    *
 *************************************************/

package Battleship;

import java.util.Random;

public class Board
{
	private int boardSize;
	private Random random = new Random();

	private Cruiser cruiser = new Cruiser();
	private Destroyer destroyer = new Destroyer();
	private Dinghy dinghy = new Dinghy();
	private UBoat uboat = new UBoat();
	private Flagship flagship = new Flagship();

	private Boat[] boats = {cruiser, destroyer, dinghy, uboat, flagship};

	private Coordinate[][] coordinates;
	
	Board(int size)
	{
		boardSize = size;
		coordinates = new Coordinate[size][size];
		
		// fill coordinate array with the proper objects
		for (int i = 0; i < coordinates.length; i++)
		{
			for (int ii = 0; ii < coordinates.length; ii++)
			{
				coordinates[i][ii] = new Coordinate(i, ii);
			}
		}
	}
	
	// returns the size of the board
	int getSize() 
	{
		return boardSize;
	}
	
	// returns the Nth boat in boats[]
	Boat getBoat(int index) 
	{
		return boats[index];
	} 
	
	// returns the total number of boats in boats[]
	int getBoatCount()
	{
		return boats.length;
	}
	
	// returns the coordinate matching the specified coordinates' X,Y
	Coordinate getCoordinate(Coordinate coord)
	{
		return coordinates[coord.getX()][coord.getY()];
	}
	// overloads getCoordinate(); allows X,Y input
	Coordinate getCoordinate(int X, int Y)
	{
		return coordinates[X][Y];
	}
	
	// checks the coordinate array to see if a boat occupies the specified cells
	boolean isSpotAvailable(Coordinate coord, int length, int orientation)
	{
		int x = coord.getX();
		int y = coord.getY();
		
		// direction horizontal (right/x axis)
		if (orientation == 1)
		{
			// return false if the boat will be out of bounds
			if (length + x > boardSize)
			{
				return false;
			}
			
			// check each Coordinate to see if it contains a boat
			for (int i = x; i < length + x; i++)
			{
				if ((coordinates[i][y].getBoat() != null) || (y > boardSize))
				{
					return false;	
				}
			}
			return true;
		}
		
		// direction vertical (down/y axis)
		else
		{
			if (length + y > boardSize)
			{
				return false;
			}
			for (int i = y; i < length + y; i++)
			{
				if ((coordinates[x][i].getBoat() != null) || (x > boardSize))
				{
					return false;
				}
			}
			return true;
		}
    }
    
    // loop through boats[] and randomly place each boat
	void randomizeBoats()
	{
		int orientation;
		Coordinate coord;

		// loop through the boats
		for (int i = 0; i < getBoatCount(); i++)
		{
			// keep looping until we find a spot for the boat
			do
			{
				coord = new Coordinate(random.nextInt(boardSize), random.nextInt(boardSize));
				orientation = random.nextInt(2);
			} while (!isSpotAvailable(coord, getBoat(i).getSize(), orientation));
			
			// X,Y is a legal starting point, place the boat
			placeBoat(getBoat(i), coord, orientation);
		}
	}
	
	// "place" the specified boat at the specified coordinate
	void placeBoat(Boat boat, Coordinate coord, int orientation)
	{
		int size = boat.getSize();
		int y = coord.getY();
		int x = coord.getX();
		
		// vertical
		if (orientation == 0)
		{
			// loop through the coordinate array, setting each coordinate's 
			// boat object to the one specified
			for (int i = y; i < size + y; i++)
			{
				coordinates[x][i].setBoat(boat);
			}
		}
		
		// horizontal
		else
		{
			for (int i = x; i < size + x; i++)
			{
				coordinates[i][y].setBoat(boat);
			}
		}
	}
}