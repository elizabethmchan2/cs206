import java.util.LinkedList;
import java.util.Queue; 
import java.util.ArrayList; 
import java.io.IOException; 

public class PQSim {
	
 public static void main(String[] args) {
     //choose either option 
 //  simulate(3600, 10); //black and white printer 
   simulate(3600, 5); //color printer
   
 }
   
   // Simulate for time (Seconds) for a printer speed (ppm)
   public static void simulate(int seconds, int ppm) {
	   
	   	int totalWait = 0; 
	   	int total = 0;
		Printer p = new Printer(ppm);
		Queue<Task> printerQueue = new LinkedList<Task>(); 
		ArrayList<Integer> recordWaitTimes = new ArrayList<Integer>();
		for (int i=0; i<seconds; i++) {
			if (newPrintTask()) {
				Task t = new Task(i); 
				printerQueue.add(t);
				total++; 
//				System.out.println(t);
				
			}
			if (!p.busy() && !printerQueue.isEmpty()) {
				Task lastTask = printerQueue.remove();
				recordWaitTimes.add(lastTask.waitTime(i));
				p.startNext(lastTask); 
				
			}	
			
			System.out.println("At time " + i +":");
			printQueue(printerQueue);
				p.tick();
			

		} // End for loop
		
		

		System.out.println("End:");
		System.out.println(total + " tasks"); 
		System.out.println(recordWaitTimes.size() + " tasks finished");
		for (int i = 0; i<recordWaitTimes.size(); i++) {
			totalWait+=recordWaitTimes.get(i); 
		}
		System.out.println("Average wait time: " + totalWait/recordWaitTimes.size() + " seconds.");
	
   }
   //from lab
   public static void printQueue(Queue<Task> _t) {
		System.out.print("[ ");
		for (Task t : _t) {
			System.out.println(t+" ");
		}
		System.out.println("]");
	}
   
   public static boolean newPrintTask() {
	   return (180 == ((int) (1 + 180 * Math.random())));	
   }
}
 