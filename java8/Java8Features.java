import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.Comparator;
import java.util.Collections;
import java.util.stream.Collectors;

/**
*
*Important Points/Observations:
* A functional interface has only one abstract method but it can have multiple default methods.
* @FunctionalInterface annotation is used to ensure an interface can’t have more than one abstract method. The use of this annotation is optional.
* The java.util.function package contains many builtin functional interfaces in Java 8.
* Examples: Predicate, BinaryOperator, Function, etc.
**/


public class Java8Features{
	
	public static void main(String[] args){
		functionalInterfaceExamples();
		streamList();
	}

	private static void functionalInterfaceExamples(){
		functionalThread();
		functionalWithAnnotation();
		functionalBuiltin();
	}

	private static void streamList(){
		filterStream();
		distinctStream();
		sortedStream();
		limitStream();
		averageMethodStream();
		terminateMethodStream();
		allMatchStream();
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

	private static Stream<String> createStream(){
		List<String> items = new ArrayList<String>();
			items.add("AA");
			items.add("BBA");
			items.add("CCCBB");

		return items.stream();
	}

	private static IntStream createStreamInt(){
		List<Person> items = new ArrayList<Person>();
		Person p1 = new Person(1,"EEEE");
		Person p2 = new Person(2,"VVVV");
		Person p3 = new Person(3,"2ssss");
		Person p4 = new Person(3,"2ssss");
			items.add(p1);
			items.add(p2);
			items.add(p3);
			items.add(p4);

		//Avoid Outboxing overhead
		IntStream intStram = items.stream().mapToInt(Person::getAge);
		return intStram;
	}

	private static void filterStream(){
		System.out.printf("How many elements have in the list?: %d \n", createStream().count());
		System.out.printf("How many elements have left: %d \n", createStream().filter(e->e.contains("A")).count());
	}

	private static void distinctStream(){
		System.out.printf("DISTINCT::How many elements have in the list?: %d \n", createStreamInt().count());
		System.out.printf("DISTINCT::How many elements have left: %d \n", createStreamInt().distinct().count());
	}

	private static void sortedStream(){
		createStreamInt().boxed().sorted(Collections.reverseOrder()).distinct().forEach(e->System.out.printf("Element:: %d \n",e));
	}

	private static void limitStream(){
		createStream().sorted(Collections.reverseOrder()).limit(1).forEach(e-> System.out.printf("Limit: %s \n",e));
	}

	private static void averageMethodStream(){

		System.out.printf("Average : %.2f \n",createStreamInt().average().getAsDouble());
	}

	private static void terminateMethodStream(){

		List<String> list = createStream().filter(e->e.contains("A")).collect(Collectors.toList());
		list.stream().forEach(e-> System.out.println(e));
	}

	private static void allMatchStream(){
		System.out.printf("All element is great than zero: %s \n", createStreamInt().allMatch(e->e > 0));
		System.out.printf("All element constains A in the name: %s \n", createStream().allMatch(e->e.contains("A")));
	}

}
@FunctionalInterface
interface Square 
{ 
    int calculate(int x); 
} 

class Person{
	int age;
	String name;

	public Person(int age, String name){
		super();
		this.age = age;
		this.name = name;
	}

	public void setAge(int age){
		this.age = age;
	}

	public int getAge(){
		return age;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}
}
