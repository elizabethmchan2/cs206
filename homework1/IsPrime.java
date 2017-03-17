
public class IsPrime {
	
	public static boolean isPrime(int n) {
		//returns true if it is a prime, false otherwise
		for (int i=2; i<=n/2; i++) {
			if(n%i==0) {
				return false;
			}//ends loop
		}//ends "if"
			return true;
		} // boolean isPrime
		
	
	public static void main(String[] args) {
		for (int i=1; i<=100; i++) {
			if (isPrime(i)) 
				System.out.println(i);

		}//ends loop
	}//ends main
}//ends isPrime
