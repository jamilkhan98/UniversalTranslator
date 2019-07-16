//Partners: Jamil Khan, Brandon Walker
//10/24/2018
//Universal Translator which allows alien messages sent by Earth to be read by aliens
//Inputs required - names of files to read/save messages
//outputs - contents of message/file that is being read

package FileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class UniversalTranslator implements EarthCellPhone{
	private AlienCellPhone alienphone;
	
	/*
	 * overloaded constructor of UniversalTranslator which takes in AlienCellPhone Object
	 */
	public UniversalTranslator(AlienCellPhone acp) {
		alienphone = acp;
	}
	
	/*
	 * takes in LanguageType to send message and file to be read
	 * @param languageType - language that message will be sent in
	 * @param fileName - file that is to be read
	 * @throws FileNotFoundException if file does not exist or not found
	 * @throws InvalidLanguageException if language type is not supported
	 */
	public void sendMessage(String languageType, String fileName) throws InvalidLanguageException{
		String dir = System.getProperty("user.dir");
		
		if(!languageType.equals("Earth") && !languageType.equals("Klingon") && !languageType.equals("Vulcan")) {
			throw new InvalidLanguageException("Language Type " + languageType + " is not supported.");
		}
		
		try {
			File newFile = new File(dir + "//" + fileName); //file that is being read
			Scanner userin = new Scanner(System.in);
			System.out.println("Enter file name: ");
			String outputFile = userin.nextLine();
			PrintWriter printWriter = new PrintWriter(outputFile + ".txt"); //output file of where message is stored
			
			Scanner fileReader = new Scanner(newFile);// scanner for file
			
			//reads the file and saves to new file
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
	 * reads file and translates message to be read by recipient
	 * @param fileName - file that is passed in for reading
	 * @throws FileNotFoundException if file does not exist or not found
	 */
	public void readMessage(String fileName) {
		String dir = System.getProperty("user.dir");
		
		try {
			File newFile = new File(dir + "//" + fileName);// file to be read
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
		System.out.print("Earth Translation of above message: ");
		alienphone.alienReadText(alienphone.translateText(fileName));//reads translated alien file
	}
	
	public String toString() {
		return "Universal Translator translates different languages.";
	}

}
