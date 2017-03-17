

//Elizabeth Chan //Elizabeth Chan 
//Introduction to Data Structures 
//Professor Deepak Kumar 
//Assignment 3 
//October 3, 2016
//Worked with Hannah Kim,  Ju Han Tarn, Jocelyn Dunkley, 

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.net.URL; 
import java.util.ArrayList;

public class Assignment3 {

	//create Place arraylist called places
	public static ArrayList<Place> places = new ArrayList<Place>();
	static BufferedReader con; 

	//comparisons 
	private static int nQueries = 0; //variable for total counter 
	private static int comparisons = 0; //variable for individual counter 
	private static int totComps = 0;
	private static int nSuccQueries = 0, succComps = 0;
	private static int nFailQueries = 0, failComps =0; 

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
					places.add(new Place(parts[0], parts[1], parts[2], Integer.parseInt(parts[3]), Integer.parseInt(parts[4]), Integer.parseInt(parts[5]))); 

				}else 
					places.add(new Place(parts[0], parts[1], parts[2], 0, 0, 0));

			}

			//Close the input stream
			input.close();

		} catch( IOException e) {
			e.printStackTrace();
			System.exit(1);
		} 

	}


	//equals method to test whether user's input if equal to data in the places array
	public static int search(ArrayList <Place> places, String town) {

		for (int i=0; i<places.size(); i++) {
			comparisons++; 
			
			if(places.get(i).equals(town)) {
				return i; 

			}

		}	

		return -1; 

	}//end of equal method 


	//main method 
	public static void main(String[] args) throws IOException {

		//reads data within the main 



		readData(); 

		int response = 0;

		//user interaction with a try/catch and a if/while
		do { 
			BufferedReader con = new BufferedReader(new InputStreamReader(System.in)); 
			String userInput = con.readLine();


			System.out.println("Query: " + userInput);
			nQueries++;
			comparisons = 0; 

			int searchResult = search(places, userInput.toLowerCase()); 
			totComps += comparisons; 
			if(searchResult != -1) {
				System.out.println("The town " + userInput + " belongs to " + places.get(searchResult)); 
				nSuccQueries++; 
				succComps +=comparisons; 

			}else {
				System.out.println("Your input: " + userInput + " was not found.");
				nFailQueries++;
				failComps+=comparisons; 
			}


			//			System.out.println("Number of Comparisons for This Particular Search: " + counter);
			//			System.out.println("Average of successful comparisons: " + (float)tCounter/(float)s); 
			//			System.out.println("To find total average and average of unsuccessful comparisons, input nonexistent town, state.");
			//			System.out.println("Do you want to search again?");
			System.out.println("\n\nDo you want to search again?");
			userInput = con.readLine(); 
			if (userInput.toLowerCase().equals("no")) {
				response = 1; 
				System.out.println("Goodbye!!!!!!!!!!!!!!!!!!!! Come back soon");


			} else {
				System.out.println("Enter town and state");

			}
			System.out.println("\n\nResults...");
			System.out.println("Total number of queries: " + nQueries);
			System.out.println("Average comparisons/query: " + (float)totComps/(float)nQueries);
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



		} while (response == 0);
	}//end of main 
}//end of Assignment3 



//attempt at the extra credit 

////equals method to test whether user's input if equal to data in the places array
//		public static int equal(ArrayList <Place> places, String town) {
//		
//					if(places.indexOf(town)!=places.lastIndexOf(town))  {
//
//						for (int i=places.indexOf(town); i<places.lastIndexOf(town); i++ ) {
//							System.out.println(places.get(i));
//						}
//						}
//						else {
//							for (int i=0; i<places.size(); i++) {
//							if(places.get(i).equals(town)) {
//								tCounter++; 
//								counter++; 
//								return i; 
//								}			
//							}
//					} return -1; 
//				}



