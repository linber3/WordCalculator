import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		menu();
	}
	
	public static void menu() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		Scanner scan3 = new Scanner(System.in);
		
		int choice = 9;
		String word;
		String key;
		String stringValue;
		
		do {
			System.out.println("\n\n---------------------------------------");
			System.out.println("\nMenu:");
			System.out.println();
			System.out.println("1. Calculate value of word");
			System.out.println("2. Search for number and get words with this value");
			System.out.println("0. Exit\n");
			System.out.println("Choose command:");
			
			boolean validInput = false;
		    while(!validInput){
		    	try {
		    		choice = scan.nextInt();
		    		validInput = true;
		    	} catch (InputMismatchException e) {
		    		System.out.println("Enter an integer please!");
		    		scan.nextLine();
		    		continue;
		    	}				
		    }
			
		    System.out.println();							
			
			switch (choice) {
			
				case 1: 
					System.out.println("\nType the word:");
					word = scan2.nextLine();
					Calculator calc = new Calculator(word);
					stringValue = ""+calc.getValue();				
					readFile(stringValue, word);
					System.out.println("\nDo you want a list of words with the same value?\n"
							+ "y or n:\n");
					key = scan3.nextLine();
					if(key.equals("y")) {
						listWords(stringValue);					
					} else if(key.equals("n")) {
						
					} else {
					System.out.println("Error");
				}								
				break;
				
				case 2: System.out.println("Type the number you will search for:\n");
					stringValue = scan2.nextLine();
					listWords(stringValue);
					break;
				
				case 0: System.out.println("Ending...");
					break;
				
				default: System.out.println("\nNot a valid number\n"); 
			}			 
		} while(choice !=0);
		
		scan.close();
		scan2.close();
		scan3.close();	
	}


	public static void readFile(String value, String word) {
		String filename = "*/Java/GithubProject/WordCalculator/wordAndValue.txt";
		File file = new File(filename);
		Scanner sc = new Scanner(System.in);

		String line;
		String text;
		boolean found = false;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((line = br.readLine()) != null) {					 
				String[] data = line.split(":");  
				//String number = data[0];
				text = data[1];  
				
				if(text.toLowerCase().contentEquals(word.toLowerCase())) {
					found = true;
					break;
				} else {
					continue;
				} 
			}
			br.close();
			
			if(found == false) {
				System.out.println("\nDo you want to save this word?\ny or n:");				
				String key = sc.next();
				if(key.equals("y")) {
					saveToFile(value, word);
				} 
			}	
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: file not found: " + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: could not read the data: " + filename);
			e.printStackTrace();
		} 
	}
	
		
	public static void saveToFile(String number, String text) {
		
		String filename = "*/Java/GithubProject/WordCalculator/wordAndValue.txt";
		File file = new File(filename);
		String capText = text.substring(0, 1).toUpperCase() + text.substring(1);
		
        try {
            FileWriter fw = new FileWriter(file, true);
            fw.write("\n" + number + ":" + capText);
            System.out.println("\nThe word is stored!");
            fw.close();           
        }
        catch(IOException e) {
        	System.out.println("ERROR: could not read file: " + filename);
			e.printStackTrace();
        }
	}
	
	
	public static void listWords(String value) {
		String filename = "*/Java/GithubProject/WordCalculator/wordAndValue.txt";
		File file = new File(filename);		
		
		String line;
		String number = null;
		String text;
		boolean found = false;
		System.out.println("\nWords with value " + value + ":\n");
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((line = br.readLine()) != null) {					 
				String[] data = line.split(":");
				number = data[0];
				text = data[1];
				
				if(number.equals(value)) {
					System.out.println(text);
					found = true;
				} else {
					continue;
				} 
			}
			br.close();
			
			if(found == false) {
				System.out.println("No words found!");				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: file not found: " + filename);
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: could not read the data: " + filename);
			e.printStackTrace();
		} 
	}
	
}
