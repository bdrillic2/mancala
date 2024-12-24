package mancala;

public class NameLengthOutOfBoundsException extends RuntimeException 
{
	private static final long serialVersionUID = 1L;
	
	/**
	 * The NameLengthOutOfBoundsException is thrown when a Player name is inputted that is more than 10 characters
	 */
	
	public NameLengthOutOfBoundsException() {
		super("Name must be 10 or fewer characters");
	}
	public NameLengthOutOfBoundsException(String message) {
		super(message);
	}
}
