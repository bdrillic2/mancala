package mancala;

/**
 * The MancalaGameUser program takes names from users, creates a MancalaGame object, and then calls a method to play the game
 */

import java.util.Scanner;

public class MancalaGameUser {
	public static void main(String[] args) {
		System.out.println("Welcome to Mancala!\n");
		
		//prompt users for player names
		//use while loop as input validation, ensuring name is correct length
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Player 1 - Enter your name (MAX 10 CHARACTERS!) >> ");
		String player1Name = keyboard.nextLine();
		while(player1Name.length() > 10) {
			System.out.print("INVALID! Player 1 - Enter your name (MAX 10 CHARACTERS!) >> ");
			player1Name = keyboard.nextLine();
		}
		System.out.print("Player 2 - Enter your name (MAX 10 CHARACTERS!) >> ");
		String player2Name = keyboard.nextLine();
		while(player2Name.length() > 10) {
			System.out.print("INVALID! Player 2 - Enter your name (MAX 10 CHARACTERS!) >> ");
			player2Name = keyboard.nextLine();
		}
		
		//create Player objects
		Player player1 = new Player(player1Name);
		Player player2 = new Player(player2Name);
		
		//create MancalaGame object
		MancalaGame mancalaGame = new MancalaGame(player1, player2);
				
		//call MancalaGame method playGame
		mancalaGame.playMancala();
		
		System.out.println("\nGAME OVER");
		
	}
}

