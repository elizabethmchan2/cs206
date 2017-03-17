import java.util.ArrayList; 

public class Place implements Comparable<Place>{
	//Attributes
	private ArrayList<String> Azip = new ArrayList<String>();
	private String town;
	private String state;
	private int totalPopulation; 
	private int females;
	private int males; 
	//constructors 
	public Place(String _zip, String _town, String _state, int _total, int _females, int _males) {
		this.Azip.add(_zip); 
		this.town = _town; 
		this.state = _state;
		this.totalPopulation = _total; 
		this.females = _females;
		this.males = _males;
	} //place

	//accessors  

//	public String getZip() {
//		return this.zip; 
//	} //getZip()
	
	public ArrayList<String> getZip() {
		return this.Azip; 
	}
	
	//public method to update arraylist!
	public void update(String z) {
		Azip.add(z); 
	}

	public String getTown() {
		return this.town;
	}//getTown()

	public String getState() {
		return this.state; 
	}//getState() 


	public int getTotal() {
		return this.totalPopulation; 
	}//getState() 

	public int getFemales() {
		return this.females; 
	}//getState() 

	public int getMales() {
		return this.males; 
	}//getState() 

	public boolean equals (String userInput) {
		userInput.toLowerCase().equals(this.town.toLowerCase() + ", " + this.state.toLowerCase()); 
		return (town + ", " + state).toLowerCase().equals(userInput);
	}



	public int compareTo(Place p) {
		return (this.getTown() + this.getState()).compareTo(p.getTown() + p.getState()); 
	}

	//print Method
	public String toString() {
		return this.town + ", " + this.state + " " + this.Azip+ " Total Population: " + this.totalPopulation+ ". Female: " + this.females + ". Male: " + this.males+ "."; 
	} //toString() 


}
