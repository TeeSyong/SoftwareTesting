package PrintingKioskSystem;

import java.util.Scanner;

public class Printing {
private static Scanner scanner;
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		int choice;
		boolean error;
		String order,opt;
		int qtt,addOpt;
		
		
		do {
			System.out.print("Enter type of order(D-Document/P-Photo): ");
			order = scanner.nextLine();
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
		
		
		
		
	}
}
