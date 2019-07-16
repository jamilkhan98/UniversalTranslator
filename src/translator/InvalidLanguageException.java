//Partners: Jamil Khan, Brandon Walker
//10/24/2018
//InvalidLanguageException which throws exception if language type of message is unsupported
//Inputs required - none
//outputs - error message if exception is thrown

package FileIO;

public class InvalidLanguageException extends IllegalArgumentException{

	/*
	 * null constructor for InvalidLanguageException to be thrown
	 */
	public InvalidLanguageException() {}
	
	/*
	 * overloaded constructor for InvalidLanguageException which takes in error message to be displayed, as a string
	 * @param message - error message as a string
	 */
	public InvalidLanguageException(String message) {
		//outputs error message called through IllegalArgumentException class
		super(message);
	}
}
