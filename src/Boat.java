/*************************************************
 * Boat.java                                     *
 *************************************************/

package Battleship;

public class Boat
{
	private String name;
	private int size;
	private int damage = 0;
	
	Boat(String name, int size)
	{
		this.name = name;
		this.size = size;
	}
	
	// returns name of boat
	String getName()
	{
		return name;
	}
	
	// returns size of boat
	int getSize()
	{
		return size;
	}
	
	// returns whether or not damage = size (boat is sunk)
	boolean isSunk()
	{
		return damage == size;
	}
	
	// increases damage unless the boat is already sunk
	void takeDamage()
	{
		if (!isSunk())
		{
			damage++;
		}
	}
}