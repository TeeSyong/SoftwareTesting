package PrintingKioskSystem;

import java.util.*;

public class Printing {
private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		boolean error;
		String order;
				
		do {
			System.out.print("Enter type of order(D-Document/P-Photo)(E-exit): ");
			order = scanner.nextLine().toUpperCase();
			error = false;
			switch(order) {
			case "D": document(); break;
			case "P": photo(); break;
			case "E": break;
			default: error = true; break;
			}
			
			if(error) {
				System.out.println("Invalid choice. Please enter again");
			}
			
		}while(!order.equals("E"));
		
	}
	
	public static void document() {
		
		
		if(order.equals("D")){
			System.out.print("Enter option(A-Black & White/B-Colour): ");
			opt = scanner.nextLine();
		}
		else {
			System.out.print("Enter option(C-Normal/D-Passport): ");
			opt = scanner.nextLine();
		}
		System.out.print("Enter quantity: ");
		qtt = scanner.nextInt();
		System.out.println("Additional Option");
		System.out.println("1. High quality paper");
		System.out.println("2. Design effect");
		addOpt = scanner.nextInt();
	}
	
	public static void photo() {
		
	}
}
