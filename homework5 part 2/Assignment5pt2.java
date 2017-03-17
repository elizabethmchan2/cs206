//Elizabeth Chan 
//Introduction to Data Structures 
//Professor Deepak Kumar 
//Assignment 5 Part 2 
//Worked with Hannah Kim,  Ju Han Tarn, Jocelyn Dunkley,  Kennedy Ellison 

import java.io.BufferedReader;
import java.io.File,n ;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.URL; 
import java.util.ArrayList; 
import java.lang.ArrayIndexOutOfBoundsException; 

public class Assignment5pt2 {


	//create Place BST called places
	public static BST<Place> places = new BST<Place>();
	static BufferedReader con; 

	//comparisons 
	private static int nQueries = 0; //variable for total counter 
	private static int totComps = 0;
	private static int nSuccQueries = 0, succComps = 0;
	private static int nFailQueries = 0, failComps =0; 
	private static Place answer; 

	public static void readData() { 

		String line; 


		try {
			//open access to webfile 
			URL webFile = new URL("http://cs.brynmawr.edu/cs206/DataFiles/uszipcodes.csv");
			//Create a new Scanner for the input file 
			Scanner input = new Scanner(webFile.openStream());
			Place p; 
			String townST = null; 
			//ignore first line 
			String first = input.nextLine(); 

			while (input.hasNextLine()) { // test if there is a line to read
				line = input.nextLine();
				String[] parts = line.split(","); //array to split lines of data 

				if(parts.length == 6) {
					Place np = new Place(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]),Integer.parseInt(parts[5])); 

					if(places.find(np) != null) { 
						places.find(np).update(np.getZip().get(0));
					}else {
						places.add(np);
					}

				}else {
					places.add(new Place(parts[0], parts[1], parts[2], 0, 0, 0));
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
	public static int search(BST <Place> places, String town, String state) { 
		Place t = new Place("0", town, state, 0, 0, 0); 
		answer = places.find(t); 
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
		System.out.println("Height of tree: " + places.height() + ". Size of tree: " + places.size()); 
		//user interaction with a try/catch and a if/while
		do { 
			try{
				BufferedReader con = new BufferedReader(new InputStreamReader(System.in)); 
				String userInput = con.readLine();

			
				System.out.println("Query: " + userInput);
				nQueries++;
				CharSequence comma = ",";

				String[] pp = userInput.split(", ");
				String atown;
				String astate; 
				atown = pp[0];
				astate = pp[1];

	
				int searchResult = search(places, atown, astate); 
				totComps += places.getComparison(); 

				if(searchResult !=-1) {
					System.out.println("The town " + userInput + " belongs to " + places.find(answer)); 
					nSuccQueries++; 
					succComps +=places.getComparison(); 

				}else {
					System.out.println("Your input: " + userInput + " was not found.");
					nFailQueries++;
					failComps+=places.getComparison(); 
				}

				System.out.println("\n\nDo you want to search again?");
				userInput = con.readLine(); 
				if (userInput.toLowerCase().equals("no")) {
					response = 1; 
					System.out.println("Goodbye!!!!!!!!!!!!!!!!!!!! Come back soon");
				}

				else {
					System.out.println("Enter town and state");
				}
				System.out.println("\n\nResults...");
				System.out.println("Total number of queries: " + nQueries);
				System.out.println("Average comparisons/query: " + ((float)totComps/(float)nQueries));
				System.out.println("Total number of successful queries: " + nSuccQueries);
				if(nSuccQueries == 0) {
					System.out.println("Average comparisons/successful query: undefined b/c no succesful queries exist");
				} else
					System.out.println("Average comparisons/successful query:" + ((float)succComps)/nSuccQueries);
				System.out.println("Total number of failed queries: " + nFailQueries);
				if(nFailQueries == 0) {
					System.out.println("Average unsuccessful comparisons/failed query: undefined b/c no failed queries exist");
				} else
					System.out.println("Average unsuccessful comparisons/failed query: " + (((float)failComps)/nFailQueries));


			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Must input 'Town,State' i.e. 'New York, NY' (with the space). Try again!");
			}
		} while (response == 0);
	}//end of main 
}//end of Assignment3 



