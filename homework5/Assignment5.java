import java.util.Arrays; 

public class Assignment5 {
//add NEW YORK BACK 
	public static void main(String[] args) {
		String[] items = {"Cambridge", "Crapo", "New York", "Bryn Mawr", "Boring", "Hell", "Walla Walla", "Surprise",
				"Joseph", "Romance", "Mars", "Nuttsville", "Rough and Ready", "Dynamite", "Good Grief"};
		BST<String> data = new BST<String>();
		for (String item : items)
			data.add(item);
		System.out.println("The tree has " + data.size() +  " items.");
		System.out.println("Height: " + data.height());
		System.out.println("Pre order: " + data.preOrder());
		System.out.println("Post order: " + data.postOrder());
		System.out.println("In order: " + data.inOrder());
		data.clear();
		System.out.println("The tree is cleared.");
		System.out.println("The tree has " + data.size() +  " items.");
		System.out.println("Height: " + data.height());
		Arrays.sort(items); 
		show(items, "After sorting:");
		for (String item : items)
			data.add(item);
		System.out.println("The tree has " + data.size() +  " items.");
		System.out.println("Height: " + data.height());
		System.out.println("Pre order: " + data.preOrder());
		System.out.println("Post order: " + data.postOrder());
		System.out.println("In order: " + data.inOrder());

	}


	public static void show (String [] a, String msg) {
		System.out.println("\n" + msg);
		for (String item : a)
			System.out.println(item);
		System.out.println("\n");
	}
}




//Cambridge
//Crapo 
//Your birth place (New York)
//Bryn Mawr
//Boring
//Hell
//Walla Walla
//Surprise
//Joseph
//Romance
//Mars
//Nuttsville
//Rough and Ready
//Dynamite
//Good Grief