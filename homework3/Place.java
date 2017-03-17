
public class Place {
	//Attributes
	private String zip;
	private String town;
	private String state;
	private int totalPopulation; 
	private int females;
	private int males; 
	//constructors 
	public Place(String _zip, String _town, String _state, int _total, int _females, int _males) {
			
		this.zip = _zip; 
		this.town = _town; 
		this.state = _state;
		this.totalPopulation = _total; 
		this.females = _females;
		this.males = _males;
	} //place

	//acessors  

	public String getZip() {
		return this.zip; 
	} //getZip()

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

	//print Method
	public String toString() {
		return this.town + ", " + this.state + " " + this.zip+ " Total Population: " + this.totalPopulation+ ". Female: " + this.females + ". Male: " + this.males+ "."; 
	} //toString() 


}
