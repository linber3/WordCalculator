
public class Calculator {
	
	String str;
	int value = 0;
	
	public Calculator(String word) {
		this.str = word.toLowerCase(); 
		
		char[] charArray = str.toCharArray();
		calculate(charArray);
	}
	
	
	public void calculate(char[] charArray) {
		
		for (int i = 0; i < charArray.length; i++) { 
            charArray[i] = str.charAt(i); 
            
			switch (str.charAt(i)) {	
			
			case ' ': value += 0;
				break;
			case 'a': value += 1;
				break;
			case 'b': value += 2;
				break;
			case 'c': value += 3;
				break;
			case 'd': value += 4;
				break;
			case 'e': value += 5;
				break;
			case 'f': value += 6;
				break;
			case 'g': value += 7;
				break;
			case 'h': value += 8;
				break;
			case 'i': value += 9;
				break;
			case 'j': value += 10;
				break;
			case 'k': value += 11;
				break;
			case 'l': value += 12;
				break;
			case 'm': value += 13;
				break;
			case 'n': value += 14;
				break;
			case 'o': value += 15;
				break;
			case 'p': value += 16;
				break;
			case 'q': value += 17;
				break;
			case 'r': value += 18;
				break;
			case 's': value += 19;
				break;
			case 't': value += 20;
				break;
			case 'u': value += 21;
				break;
			case 'v': value += 22;
				break;
			case 'w': value += 23;
				break;
			case 'x': value += 24;
				break;
			case 'y': value += 25;
				break;
			case 'z': value += 26;
				break;
			default: System.out.println("\nError\n"); 
			} 			
		} 
		System.out.println("\nNumber = " + value); 		
		
	}   
	
	public int getValue() {
		return value;
	}

}
