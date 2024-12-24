package mancala;

/**
 * The Store class stores and updates the number of marbles in a given store on a mancala game board
 */

public class Store {
	private int marbles;
	
	/**
	 * Constructor initializes default number of marbles to 0 according to game rules
	 */
	
	public Store() {
		marbles = 0;
	}
	
	/**
	 * The overloaded add methods allow user to add either a specified number of marbles to a store or a default of 1 if no number is given
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
	 * The getMarbles method returns the number of marbles in a Store
	 * @return The number of marbles in a pit
	 */
	
	public int getMarbles() {
		return marbles;
	}
	
	/**
	 * The specified toString method returns a string representation of a Store containing just the number of marbles it holds
	 */
	
	@Override
	public String toString() {
		return Integer.toString(marbles);
	}
}