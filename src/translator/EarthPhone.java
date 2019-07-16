//Partners: Jamil Khan, Brandon Walker
//10/24/2018
//EarthPhone class which allows Earth messages to be read by or sent to other Earth or Alien users
//Inputs required - names of files to read/save messages
//outputs - contents of message/file that is being read

package FileIO;

import java.util.*;
import java.io.*;

public class EarthPhone implements EarthCellPhone{
	
	/*
	 * null constructor of EarthPhone Object
	 */
	public EarthPhone() {}
	
	/*
	 * sends message from fileName in language Type
	 * @param languageType - language in which message is sent
	 * @param fileName - file that will be read to send message
	 * @throws FileNotFoundException if file does not exist or not found
	 * @throws InvalidLanguageException if language type is not supported
	 */
	@Override
	public void sendMessage(String languageType, String fileName) throws InvalidLanguageException{
		String dir = System.getProperty("user.dir");
		
		if(!languageType.equals("Earth") && !languageType.equals("Klingon") && !languageType.equals("Vulcan")) {
			throw new InvalidLanguageException("Language Type " + languageType + " is not supported.");
		}
		
		try {
			File newFile = new File(dir + "\\" + fileName);// file that is being read
			Scanner userin = new Scanner(System.in);
			System.out.println("Enter file name: ");
			String outputFile = userin.nextLine();
			PrintWriter printWriter = new PrintWriter(outputFile + ".txt");// output file of where message is stored
			
			Scanner fileReader = new Scanner(newFile);// scanner for file
			
			//reads from file and outputs to new file
			while(fileReader.hasNextLine()) {
				String readLine = fileReader.nextLine();
				printWriter.println(readLine);
			}
			
			printWriter.close();
			fileReader.close();
			System.out.println(languageType + " Message Sent");
			
		}
		catch(FileNotFoundException exception){
			System.out.println("File: " + fileName + " currently does not exist.");
		}
	}
	

	/*
	 * reads from file that is passed in
	 * @param fileName - file that is being read
	 * @throws FileNotFoundException if file does not exist or not found
	 */
	public void readMessage(String fileName) {
		String dir = System.getProperty("user.dir");
		
		try {
			File newFile = new File(dir + "//" + fileName);//file that is being read
			Scanner fileReader = new Scanner(newFile);
			
			//reads from file and outputs to console
			while(fileReader.hasNextLine()) {
				String fileLine = fileReader.nextLine();
				System.out.println(fileLine);
			}
			
			fileReader.close();
		}
		
		catch(FileNotFoundException exception) {
			System.out.println("File " + fileName + " currently does not exist.");
		}
	}
	
	public String toString() {
		return "EarthPhone can send and receive messages to and from Earth and aliens.";
	}
}
