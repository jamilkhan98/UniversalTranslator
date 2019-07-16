//Partners: Jamil Khan, Brandon Walker
//10/24/2018
//KlingonPhone class which allows Klingon messages sent from Earth to be read
//Inputs required - names of files to read/save messages
//outputs - contents of message/file that is being read

package FileIO;

import java.util.*;
import java.io.*;

public class KlingonPhone implements AlienCellPhone{
	
	/*
	 * null constructor of KlingonPhone object
	 */
	public KlingonPhone() {}

	/*
	 * sends message from fileName
	 * @param fileName - file that will be read to send message
	 * @throws FileNotFoundException if file does not exist or not found
	 */
	public void alienSendText(String fileName) {
		String dir = System.getProperty("user.dir");
		
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
	public void alienReadText(String fileName) {	
		String dir = System.getProperty("user.dir");
		
		try {
			File newFile = new File(dir + "//" + fileName);//file that is being read
			Scanner fileReader = new Scanner(newFile);
			
			//reads from file and prints to console
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
	
	/*
	 * returns name of output file with translated message
	 * @param fileName - name of file to be translated
	 * @return - returns translated file name
	 */
	public String translateText(String fileName) {
		String translated = "Translated" + fileName;
		return translated;
	}

}
