/*************************************************
 * Battleship.java                               *
 *************************************************/
 
package Battleship;

public class Battleship 
{
	static int boardSize = 10;
	
    public static void main(String[] args) 
    {
    	// create players and set up the boards
    	Player p1 = new Player("Player one", boardSize);
    	p1.randomizeBoats();
    	
    	Player p2 = new Player("Player two", boardSize);
    	p2.randomizeBoats();

		showBoards(p1, p2);
    	
    	// start a new game
    	Game game = new Game(p1, p2, boardSize);
    	
    	// keep calling game.nextTurn() until the game is over
    	do
    	{
    		game.nextTurn();
    	} while (!game.gameOver());
    	
    	// display both boards again
    	showBoards(p1, p2);
    	
    	// display the winner
    	System.out.println(game.getWinner().getName() + " won the game!");
    }
    
    static void showBoards(Player p1, Player p2)
    {
    	System.out.println(p1.getName() + "'s board:");
    	p1.displayBoard();
    	
    	System.out.println(p2.getName() + "'s board:");
    	p2.displayBoard();
    }
}
