/*************************************************
 * Coordinate.java                               *
 *************************************************/

package Battleship;

public class Coordinate
{
	private int X;
	private int Y;
	private boolean isHit = false;
	private Boat boat;
	
	Coordinate(int X, int Y)
	{
		this.X = X;
		this.Y = Y;
	}
	
	// returns the coordinate's X value
	int getX()
	{
		return X;
	}
	
	// returns the coordinate's Y value
	int getY()
	{
		return Y;
	}
	
	// sets the X value
	void setX(int X)
	{
		this.X = X;
	}
	
	// sets the Y value
	void setY(int Y)
	{
		this.Y = Y;
	}
	
	// returns the associated boat 
	Boat getBoat()
	{
		return boat;
	}
	
	// returns the character used to display the coordinate
	char getDisplayChar()
	{
		// no boat, return an "empty" character
		if (boat == null)
		{
			return 'ú';
		}
		
		// boat was hit, return a "hit" character
		else if (isHit)
		{
				return 'x';
		}
		
		// boat was not hit, return part of the boat name
		else 
		{
			return Character.toUpperCase(boat.getName().charAt(1));
		}
	}
	
	// return whether or not the coordinate has been hit
	boolean isHit()
	{
		return isHit;
	}

	// sets the boat to the specified boat object
	void setBoat(Boat boat)
	{
		this.boat = boat;
	}

	// sets isHit to true and damages the boat if there is one
	void takeHit()
	{
		if (!isHit)
		{
			isHit = true;
			if (boat != null)
			{
				boat.takeDamage();
			}
		}
	}
	

}