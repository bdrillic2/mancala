package mancala;

/**
 * The Player class stores the a player's name, Pits, Store, and a player's name as an array for display purposes
 */

public class Player {
	private Pit[] pits;
	private Store store;
	private String name;
	private char[] nameArray;
	
	/**
	 * Constructor initializes player object with inputted name
	 * @param name Player's name to be displayed
	 */
	
	public Player(String name) {
		//input validation - throw exception if name too long
		if(name.length() > 10) {
			throw new NameLengthOutOfBoundsException();
		}
		
		//create and populate array of 6 Pit objects
		pits = new Pit[6];
		for(int i = 0; i < pits.length; i++) {
			pits[i] = new Pit();
		}
		
		store = new Store();
		this.name = name;
		
		//read player's name into correct positions in char array of 10 for display purposes
		nameArray = new char[10];
		char[] tempCharArray = name.toCharArray();
		int index;
		for(index = 0 ;index < tempCharArray.length; index++) {
			nameArray[index] = tempCharArray[index];
		}
		for(int contIndex = index; contIndex < nameArray.length; contIndex++) {
			nameArray[contIndex] = ' ';
		}
	}
	
	/**
	 * The getPitIndex method takes in an index and returns the Pit stored in the array at that place
	 * @param index Index in Pit array
	 * @return Pit object at index value
	 */
	
	public Pit getPitIndex(int index) {
		return pits[index];
	}
	
	/**
	 * The getStore method returns a player's Store object
	 * @return player's Store
	 */

	public Store getStore() {
		return store;
	}
	
	/**
	 * The getName method returns a player's name
	 * @return player's name
	 */

	public String getName() {
		return name;
	}
	
	/**
	 * The getNameArrayIndex method returns a specific character at given index of nameArray
	 * @return character at inputted index
	 */

	public char getNameArrayIndex(int index) {
		return nameArray[index];
	}

}