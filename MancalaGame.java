package mancala;

/**
 * The MancalaGame class holds Player information and executes player game moves until there are no possible moves left
 */

import java.util.Scanner;

public class MancalaGame {
	private Player player1;
	private Player player2;
	private boolean emptyBoard;
	
	/**
	 * Constructor takes in Player objects and instantiates MancalaGame object
	 * @param player1 The first player
	 * @param player2 The second player
	 */
	
	public MancalaGame(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
		emptyBoard = false;
	} 
	
	/**
	 * The playMancala method calls other methods to display game board, prompt player for move, and execute move on each turn
	 * until the game is over.
	 */
	
	public void playMancala() {
		//call the displayInstructions method for preliminary rules
		displayInstructions();
		
		//initialize currentPlayer to player1 to start game play
		Player currentPlayer = player1;
		
		do{
			//display current player's board
			displayBoard(currentPlayer);
			
			//prompt player to choose move
			int move = chooseMove(currentPlayer);
			
			//execute move
			executeMove(currentPlayer, move);
			
			//switch current player to other player
			currentPlayer = switchPlayer(currentPlayer);
			
			//check if current player has available moves
			boolean hasMoves = availMoves(currentPlayer);
			
			//if not, switch current player and check if now there's available moves
			if(!hasMoves) {
				currentPlayer = switchPlayer(currentPlayer);
				hasMoves = availMoves(currentPlayer);
				//if not set emptyBoard to true
				if(!hasMoves) {
					emptyBoard = true;
				} else {
					System.out.println("\n" + currentPlayer.getName() + " goes again, since other player has no available moves.");
				}
			}
			
			
		}while(!emptyBoard);
		
		//display winner info for player with greater number of marbles in Store
		int player1Score = player1.getStore().getMarbles();
		int player2Score = player2.getStore().getMarbles();
		if(player1Score > player2Score) {
			System.out.println("\nCONGRATULATIONS, " + player1.getName() + ", YOU WON!");
		} else {
			System.out.println("\nCONGRATULATIONS, " + player2.getName().toUpperCase() + ", YOU WON!");
		}

	}
	
	/**
	 * The displayInstructions method displays several important points about interpreting the gameboard and the version of Mancala being played
	 */
	
	public void displayInstructions() {
		System.out.println();
		System.out.println("IMPORTANT POINTS:");
		System.out.println("*Board moves are counterclockwise");
		System.out.println("*The 6 pits located before a player's store belong to the player");
		System.out.println("*Moves do NOT continue EVEN IF a player lands on one's own pit");
		System.out.println("*Play safely and have fun");
	}
	
	/**
	 * The displayBoard method displays a player's view of the board
	 * @param p The current player
	 */
	
	public void displayBoard(Player p) {		
		//create Player object holding the other players information for display purposes
		Player otherP = switchPlayer(p);
		
		//display the current board from the current player's perspective
		System.out.println();
		System.out.println("\t\t~" + p.getName().toUpperCase() +"'S VIEW OF BOARD~");
		System.out.println("***********************************************************");
		System.out.println("* " + otherP.getNameArrayIndex(0) + "	PIT6\tPIT5\tPIT4\tPIT3\tPIT2\tPIT1\t" 
							+ p.getNameArrayIndex(0) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(1) + "	\t\t\t\t\t\t" 
							+ p.getNameArrayIndex(1) + " *");
		System.out.println("* "  + otherP.getNameArrayIndex(2) + " \t" + otherP.getPitIndex(5) + "\t" + otherP.getPitIndex(4)
							+ "\t" + otherP.getPitIndex(3) + "\t" + otherP.getPitIndex(2)
							+ "\t" + otherP.getPitIndex(1) + "\t" + otherP.getPitIndex(0) + "\t" + p.getNameArrayIndex(2) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(3) + "	\t\t\t\t\t\t" 
							+ p.getNameArrayIndex(3) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(4) + " " + otherP.getStore() + "\t-----M----A----N----C----A----L----A-----     " 
							+ p.getStore() + " " + p.getNameArrayIndex(4) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(5) + "	\t\t\t\t\t\t" 
							+ p.getNameArrayIndex(5) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(6) + " \t" + p.getPitIndex(0) + "\t" + p.getPitIndex(1)
							+ "\t" + p.getPitIndex(2) + "\t" + p.getPitIndex(3)
							+ "\t" + p.getPitIndex(4) + "\t" + p.getPitIndex(5) + "\t" + p.getNameArrayIndex(6)+ " *");
		System.out.println("* " + otherP.getNameArrayIndex(7) + "	\t\t\t\t\t\t" 
							+ p.getNameArrayIndex(7) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(8) + "	PIT1\tPIT2\tPIT3\tPIT4\tPIT5\tPIT6\t" 
							+ p.getNameArrayIndex(8) + " *");
		System.out.println("* " + otherP.getNameArrayIndex(9) + "	\t\t\t\t\t\t" 
							+ p.getNameArrayIndex(9) + " *");
		System.out.println("***********************************************************");
	}
	
	/**
	 * The switchPlayer method returns the other player based on inputted player
	 * @param p Current player
	 * @return Other player
	 */
	
	public Player switchPlayer(Player p) {
		if(p == player1) {
			return player2;
		}
		return player1;
	}
	
	/**
	 * The chooseMove method validates user input and returns the next move user chooses to play
	 * @param p Current player
	 * @return Chosen move
	 */
 
	public int chooseMove(Player p) {
		//instantiate Scanner object for player to input move
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println();
		System.out.print(p.getName() + ", which pit would you like to remove marbles from? (enter number of pit) >> ");
		int position = keyboard.nextInt();
		
		//input validation
		while(position < 1 || position > 6) {
			System.out.println("Invalid position. Enter a pit number between 1 and 6 >> ");
			position = keyboard.nextInt();
		}
			
		return position;
	}
	
	/**
	 * The executeMove method updates all Pit and Store values according to a player's chosen move
	 * @param p The current player
	 * @param position The Pit being played
	 */
	
	public void executeMove(Player p, int position) {
		//input validation if chosen position is empty
		if(p.getPitIndex(position - 1).getMarbles() == 0) {
			System.out.println("The position you chose is empty. Try again.");
			position = chooseMove(p);
		}
		
		//create variable with array index of position
		int posIndex = position - 1;

		//pick up marbles of given pit
		int marbles = p.getPitIndex(posIndex).pickupMarbles();
		
		//set storeIsLast flag to false for player's store
		boolean storeIsLast = false;
		
		//set playerPitIsLast to true
		boolean playerPitIsLast = true;
		
		//create reference to current pit index on player's side that will be updated each time a marble is added to another pit
		int currPitIndex = posIndex;
		
		//create reference to other player to access other player's pits
		Player otherP = switchPlayer(p);
		
		//distribute marbles
		do {
			//add one marble to each subsequent pit on current player's side while there are still remaining marbles
			for(int index = position; index < 6; index++) {
				if(marbles > 0) {
					p.getPitIndex(index).add();
					marbles--;
					currPitIndex = index;
					//update player pit flag to true
					playerPitIsLast = true;
				}
			}
			
			//if there are still marbles left add one to player's store
			if(marbles > 0) {
				p.getStore().add();
				marbles--;
				//set store flag to true and player pit flag to false
				storeIsLast = true;
				playerPitIsLast = false;
			}
			
			//add one marble to each subsequent pit on other player's side while there are still remaining marbles
			for(int index = 0; index < 6; index++) {
				if(marbles > 0) {
					//update storeIsLast flag since there are still more marbles
					storeIsLast = false;
					otherP.getPitIndex(index).add();
					marbles--;
				}
			}
			
			//set position to 0 in case there are still more marbles to put on player's side, starting from index 0
			position = 0;
		} while(marbles > 0);
		//continue to loop through adding marbles as long as there are still more marbles not distributed
		
		//check if store is last, and if so, give player another turn
		if(storeIsLast) {
			//first make sure player has more possible moves
			boolean hasMoves = availMoves(p);
			//if not, return, and other player will continue
			if(!hasMoves) {
				return;
			}
			//display current player's board
			displayBoard(p);
			//prompt player to choose move
			int move = chooseMove(p);
			//execute move
			executeMove(p, move);
		}
		//check if player's own pit was last and if so, transfer opponent's facing pit to player's store
		else if(playerPitIsLast) {
			//pick up other player's corresponding pit
			int storeMarbles = otherP.getPitIndex(5 - currPitIndex).pickupMarbles();
			//check if there are marbles in other pit and if so, add it to player's store
			if(storeMarbles > 0) {
				p.getStore().add(storeMarbles);
			}
		}
		
	}
	
	/**
	 * The availMoves method loop through the board to check if current player has available moves
	 * @param p Current player
	 * @return boolean if any available moves
	 */

	public boolean availMoves(Player p) {
		for(int index = 0; index < 6; index++) {
			if(p.getPitIndex(index).getMarbles() > 0) {
				return true;
			}
		}
		return false;
	}
}