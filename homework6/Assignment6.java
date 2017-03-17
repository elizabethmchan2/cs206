//Elizabeth Chan 
//Introduction to Data Structures 
//Professor Deepak Kumar 
//Assignment 6 (extra credit) 
//Worked with 

import java.io.BufferedReader;
import java.io.File ;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.URL; 
import java.util.ArrayList; 
import java.lang.ArrayIndexOutOfBoundsException; 
import java.util.Hashtable; 

public class Assignment6 {


	//create Place BST called places
	public static Hashtable<String, Place> places = new Hashtable<String, Place>();
	static BufferedReader con; 
	private static Place answer; 

	public static void readData() { 

		String line; 


		try {
			//open access to webfile 
			URL webFile = new URL("http://cs.brynmawr.edu/cs206/DataFiles/uszipcodes.csv");
			//Create a new Scanner for the input file 
			Scanner input = new Scanner(webFile.openStream());
			Place p; 
	
			//ignore first line 
			String first = input.nextLine(); 

			while (input.hasNextLine()) { // test if there is a line to read
				line = input.nextLine();
				String[] parts = line.split(","); //array to split lines of data 
				
				
				if(parts.length == 6) {
					Place np = new Place(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),Integer.parseInt(parts[5])); 
					String ts = parts[1] + parts[2];
					if(places.get(ts) != null) { 
						places.get(ts).update(np.getZip().get(0), np.getTotal(), np.getFemales(), np.getMales());
					}else {
						places.put(ts, np);
					}

				}else {
					Place np = new Place(parts[0], parts[1], parts[2], 0, 0,0);
					String ts = parts[1] + parts[2];
					if(places.get(ts) != null) { 
						places.get(ts).update(np.getZip().get(0), np.getTotal(), np.getFemales(), np.getMales());
					}else {
						places.put(ts, np);
					}					
				}
			}

			//Close the input stream
			input.close();

		} catch( IOException e) {
			e.printStackTrace();
			System.exit(1);
		} 

	}


	//equals method to test whether user's input if equal to data in the places array
	public static int search(Hashtable <String, Place> places, String townstate) { 
		answer = places.get(townstate); 
		if(answer != null) { 
			return 1;
		}else {
			return -1; 
		}

	}//end of equal method 


	//main method 
	public static void main(String[] args) throws IOException {

		//reads data within the main
		readData(); 

		int response = 0;
		System.out.println("Size of hashtable: " + places.size()); 
		//user interaction with a try/catch and a if/while
		do { 
			try{
				BufferedReader con = new BufferedReader(new InputStreamReader(System.in)); 
				String userInput = con.readLine();

			
				System.out.println("Query: " + userInput);

				String[] pp = userInput.split(", ");
				String atown = pp[0];
				String astate = pp[1]; 
				String newts = atown + astate; 

	
				int searchResult = search(places, newts); 


				if(searchResult !=-1) {
					System.out.println("Found...");
					System.out.println("Town: " + userInput + ", " + answer); 

				}else {
					System.out.println("Not found...");
					System.out.println("Your input: '" + userInput + "' was not found.");
					
				}

				System.out.println("\n\nDo you want to search again?(yes/no)");
				userInput = con.readLine(); 
				if (userInput.toLowerCase().equals("no")) {
					response = 1; 
					System.out.println("Goodbye!!!!!!!!!!!!!!!!!!!! Come back soon");
				}

				else if (userInput.toLowerCase().equals("yes")){
					System.out.println("Enter town and state");
				}

			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Must input 'Town,State' i.e. 'New York, NY' (with the space). Try again!");
			}
		} while (response == 0);
	}//end of main 
}//end of Assignment3 



