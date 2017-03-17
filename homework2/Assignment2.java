//Elizabeth Chan 
//Introduction to Data Structures 
//Professor Deepak Kumar 
//Assignment 2 
//September 21, 2016
//worked with Hannah Kim and Ju Han Tarn 

import java.io.File;
import java.io.IOException; 
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.net.URL; 

public class Assignment2 {
	
	//create Place array called places
	public static Place[] places; 
	
	//create String array called Options for user interaction buttons 
	static String[] options = { "Search another zipcode", "Exit" };


	//equals method to test whether user's input if equal to data in the places array
	public static int equal(Place[] p, String zip) {
		for (int i=0; i<places.length; i++) {
			if(zip.equals(places[i].getZip())) {
				return i; 
			}
		}	
		int other;
		other = Integer.parseInt("This zip code, " + zip + ", is invalid"); 
		return other; 
	}//end of equal method 

	public static void readData() { 

		String line; 

		try {
			//open access to webfile 
			URL webFile = new URL("http://cs.brynmawr.edu/cs206/DataFiles/uszipcodes.csv");
			//Create a new Scanner for the input file 
			Scanner input = new Scanner(webFile.openStream());

			//read the next line and extract it 
			line = input.nextLine();

			//Parse each line into pieces 
			String[] parts = line.split(","); 
			int n = Integer.parseInt(parts[0]);
			places = new Place[n];


			Place p; 
			int x=0; 

			while (input.hasNextLine()) { // test if there is a line to read
				line = input.nextLine();
				parts = line.split(",");
				p = new Place(parts[0], parts[1],parts[2]); 
				places[x] = p; 
				x++;
			}

			//Close the input stream
			input.close();

		} catch( IOException e) {
			e.printStackTrace();
		} 

	}

	//main method 
	public static void main(String[] args) {

		//reads data within the main 
		readData(); 

		int response = 0;
		//user interaction with a try/catch and a if/while
		do { 
			try { 

				String userInput = JOptionPane.showInputDialog("Enter a zipcode.");

				if (userInput != null) {
					response = JOptionPane.showOptionDialog(null,
							"The zip code " + userInput + " belongs to " + places[equal(places, userInput)], 
							"Results...",
							JOptionPane.YES_NO_OPTION, 
							JOptionPane.QUESTION_MESSAGE,
							null, 
							options, // the titles of the buttons 
							options[0]); 
					System.out.println("The zip code " + userInput + " belongs to " + places[equal(places, userInput)]);
					System.out.println("Do you want to search again?");
				}

			}catch (NumberFormatException e) { //exceptions if user does not into valid number string
				JOptionPane.showMessageDialog(null,
						"Bad Numberic String - try again.",
						"Input Error",
						JOptionPane.ERROR_MESSAGE);
				System.out.println("Bad Numberic String - try again.");
			}
		} while (response == 0);
	}//end of main 
}//end of Assignment2

