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
			order = scanner.next().toUpperCase();
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
		String opt,choice;
		int ttlQtt,bwQtt,colorQtt;
		Charge ch1 = null, ch2= null;
		boolean error,er;
		
		System.out.print("Enter total document to print: ");
		ttlQtt=scanner.nextInt();
		
		do {
			error=false;
			System.out.print("Enter option(A-Black & White/B-Colour): ");
			opt = scanner.next().toUpperCase();
			if(opt.equals("A")) {
				System.out.print("Enter quantity in black and white: ");
				bwQtt = scanner.nextInt();
				ch1 = new Charge(opt,bwQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
						er=false;
					}
					else {
						System.out.println("Invalid input. Please enter again.");
						er=true;
					}
				}while(er);
			}
			else if(opt.equals("B"))
			{
				System.out.print("Enter quantity in colour: ");
				colorQtt = scanner.nextInt();
				ch2 = new Charge(opt,colorQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
						er=false;
					}
					else {
						System.out.println("Invalid input. Please enter again.");
						er=true;
					}
				}while(er);
			}
			else {
				System.out.println("Invalid choice. Please enter again.");
				error=true;
			}
			
		}while(error);
		
		
		
		
		
		System.out.println("Total charges: "+ (ch1.calNormalCharge()+ch2.calNormalCharge()));
		
		
		
		
		
		
		
		
		
		
		/**
		System.out.println("Additional Option");
		System.out.println("1. High quality paper");
		System.out.println("2. Design effect");
		addOpt = scanner.nextInt();
		**/
	}
	
	public static void photo() {
		
	}
}
