import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class Java7Features{
	public static final String FILE_NAME_USED_TO_READ =  "kiiti_read.txt";
	public static final String FILE_NAME_USED_TO_WRITE =  "kiiti_write.txt";

	public static void main(String[] args)throws FileNotFoundException{
		switchString();
		multiCatch();
		tryWithMultipleResources();
		underscoreWithVariable();
		typeInferenceForGeneric();
	}

	public static void switchString(){
		String value = "b";
		String okValue = null;
		switch(value){
			case "a": 
				System.out.printf("Result = %s and OkValue = %s \n",value, "Yupi");
				break;
			case "b":
				System.out.printf("Result = %s and OkValue = %s \n",value, "Ryu");
				break;
			case "c":
				System.out.printf("Result = %s and OkValue = %s \n",value, "Ken Master");
				break;
			default: 
				System.out.printf("Default Result = %s and OkValue = %s \n","DEFAULT", "DEFAULT");
				break;
		}
	}

	public static void multiCatch(){
		try{
			int a = 0;
			int b = 12;
			int c = b/a;
		}catch(ArithmeticException | StringIndexOutOfBoundsException e){
			System.out.printf("Multi Catch Occoured - Exception Messagem: %s \n", e.getMessage());
		}
	}
	
	public static void tryWithResources() throws FileNotFoundException{
		String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int lowerSizeWord = 0;
		int upperSizeWord = 25;
		int wordSize = 7;
		try(PrintWriter writer = new PrintWriter(new File(FILE_NAME_USED_TO_READ))){
			for(int i = 0; i<21; i++){
				StringBuilder word = new StringBuilder();
				int size = 0;
				while(size < wordSize){
					int charPosition = (int)(Math.random()*(upperSizeWord - lowerSizeWord)) + lowerSizeWord;
					word.append(alphabet.charAt(charPosition));
					size++;
				}
				writer.println(word.toString());
				word.setLength(0);
			}
		}
		System.out.println("File Created!");
	}
	public static void tryWithMultipleResources()throws FileNotFoundException{
		tryWithResources();
		try(Scanner scanner = new Scanner(new File(FILE_NAME_USED_TO_READ)); 
		    PrintWriter writer = new PrintWriter(new File(FILE_NAME_USED_TO_WRITE))){
		    
		    while(scanner.hasNext()){
			writer.print(scanner.nextLine());
		    }
		}
		System.out.println("File Read!");		
	}

	public static void underscoreWithVariable(){
		long valueLong = 2345_3456_9012_9774L; 
		int valueInt = 6_345;
		
		System.out.printf("Just for better readability. Long Value = %d and Int Value = %d \n",valueLong, valueInt);		
	}

	public static void typeInferenceForGeneric(){
		Map<String,String> myMap = new HashMap<>();
		myMap.put("name","Kleiton");
		myMap.put("language","Java");

		System.out.printf("Name: %s, Language: %s \n",myMap.get("name"), myMap.get("language"));
	}
}
