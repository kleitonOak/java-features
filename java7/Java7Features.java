

public class Java7Features{
	public static void main(String[] args){
		switchString();
		multiCatch();
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
}
