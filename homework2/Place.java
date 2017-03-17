
public class Place {
	//Attributes
	private String zip; String town; String state; 
	//constructors 
	public Place(String _zip, String _town, String _state) {
		this.zip = _zip; 
		this.town = _town; 
		this.state = _state;
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

	//print Method
	public String toString() {
		return this.town + ", " + this.state + " " + this.zip; 
	} //toString() 


}
