import java.util.List;
import java.util.Arrays;
import java.util.function.Predicate;

/**
*
*Important Points/Observations:
* A functional interface has only one abstract method but it can have multiple default methods.
* @FunctionalInterface annotation is used to ensure an interface can’t have more than one abstract method. The use of this annotation is optional.
* The java.util.function package contains many builtin functional interfaces in Java 8.
* Examples: Predicate, BinaryOperator, Function, etc.
**/

@FunctionalInterface
interface Square 
{ 
    int calculate(int x); 
} 
public class Java8Features{
	
	public static void main(String[] args){
		functionalInterfaceExamples();
	}

	private static void functionalInterfaceExamples(){
		functionalThread();
		functionalWithAnnotation();
		functionalBuiltin();
	}

	private static void functionalThread(){
		// lambda expression to create the object 
		new Thread(()->{System.out.println("New Thread created.");}).start();
	}

	private static void functionalWithAnnotation(){
		int value = 3;
	
		// lambda expression to define the calculate method 
	        Square s = (int x)->x*x; 
		 // parameter passed and return type must be same as defined in the prototype 
	        int result = s.calculate(value); 
        	System.out.printf("Square of %d is %d \n",value, result); 
	}

	private static void functionalBuiltin(){
		List<String> words = Arrays.asList("redivider", "deified", "civic", "radar", "level", "rotor", "kayak", "reviver","madam", "refer","scream");
		Predicate<String> palindromeWord = (s)->{
			StringBuilder sb = new StringBuilder(s);
			return sb.reverse().toString().equals(s);
		};
		
		for(String word: words){
			System.out.printf("The word %s %s Palindrome\n",word,palindromeWord.test(word)?"is":"is not ");
		}
	}

}
