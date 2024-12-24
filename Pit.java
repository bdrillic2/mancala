package mancala;

/**
 * The Pit class stores and updates the number of marbles in a given pit on a mancala game board
 */

public class Pit {
	private int marbles;
	
	/**
	 * Constructor initializes default number of marbles to 4 according to game rules
	 */
	
	public Pit() {
		marbles = 4;
	}
	
	/**
	 * The overloaded add methods allow user to add either a specified number of marbles to a pit or a default of 1 if no number is given
	 * @param marbles The number of marbles to add to the pit
	 */
	
	public void add(int marbles) {
		if(marbles <= 0) {
			throw new IllegalArgumentException("Marbles must be value greater than zero");
		}
		this.marbles += marbles;
	}
	
	public void add() {
		add(1);
	}
	
	/**
	 * The emptyPit method sets the marbles field to 0
	 */
	
	public void emptyPit() {
		marbles = 0;
	}
	
	/**
	 * The pickupMarbles method sets the marbles field to 0 and returns the original amount of marbles
	 * @return The number of marbles in the pit
	 */
	
	public int pickupMarbles() {
		int storeMarbles = marbles;
		emptyPit();
		return storeMarbles;
	}
	
	/**
	 * The getMarbles method returns the number of marbles in a Pit
	 * @return The number of marbles in a pit
	 */
	
	public int getMarbles() {
		return marbles;
	}
	
	/**
	 * The specified toString method returns a string representation of a Pit containing just the number of marbles it holds
	 */
	
	@Override
	public String toString() {
		return Integer.toString(marbles);
	}
}