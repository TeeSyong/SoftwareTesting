package PrintingKioskSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Order {

	public static ArrayList<Charge> chargeArr = new ArrayList<Charge>();
	private static Scanner scanner;
	
	
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		boolean error;
		String order;
				
		do {
			error = false;
			System.out.print("Enter type of order(D-Document/P-Photo)(E-exit): ");
			order = scanner.next().toUpperCase();
			switch(order) {
			case "D": document(); error = false; break;
			case "P": photo(); error = false; break;
			case "E": error = false;break;
			default: error = true; break;
			}
			
			if(error) {
				System.out.println("Invalid choice. Please enter again");
			}
			
		}while(error);
		
	}
	
	public static void document() {
		String opt,choice;
		int bwQtt = 0,colorQtt = 0,ttlQtt=0;
		double totalCharge= 0;
		Charge bwCharge = null, colorCharge= null;
		boolean error,er;
		
		do {
			error=false;
			System.out.print("Enter option(A-Black & White/B-Colour): ");
			opt = scanner.next().toUpperCase();
			if(opt.equals("A")) {
				System.out.print("Enter quantity in black and white: ");
				bwQtt = scanner.nextInt();
				bwCharge = new Charge(opt,bwQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
						chargeArr.add(bwCharge);
						System.out.println("Proceeding to billing...");
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
				colorCharge = new Charge(opt,colorQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
						chargeArr.add(colorCharge);
						System.out.println("Proceeding to billing...");
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

		//Calculate total quantity for documents
		for(int i=0;i<chargeArr.size();i++)
		{
			ttlQtt+=chargeArr.get(i).getQuantity();
		}
		//ttlQtt = bwQtt + colorQtt;
		
		// this part to check the combination of billing
		// exp: some buy normal and passport without surcharge, some buy normal with surcharge
				
		// != null --> inside particular object got something == people buy the option(normal/passport/addOpt)
		for(int i=0;i<chargeArr.size();i++)
		{
			if(bwCharge != null && colorCharge == null) {
				//if(chargeArr.get(i) instanceof bwCharge)
				{
					totalCharge +=bwCharge.calNormalCharge();
				}
				
			}
			else if (bwCharge == null && colorCharge != null) {
				totalCharge = colorCharge.calNormalCharge();
			}
			else if(bwCharge != null && colorCharge != null) {
				totalCharge = bwCharge.calNormalCharge() + colorCharge.calNormalCharge();
			}
		}

		
		System.out.println("Total charges: "+ totalCharge);
	
	}
	
	public static void photo() {
		
		String opt, choice;
		int ttlQtt, normalQtt = 0, passportQtt = 0, addOpt;
		double totalCharge = 0;
		Charge normalCharge = null, passportCharge= null, surcharge = null;
		boolean error, er;
		
		do {
			error=false;
			System.out.print("Enter option(C-Normal(4R)/D-Passport): ");
			opt = scanner.next().toUpperCase();
			if(opt.equals("C")) {
				System.out.print("Enter quantity in normal(4R): ");
				normalQtt = scanner.nextInt();
				normalCharge = new Charge(opt,normalQtt);
				
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
			else if(opt.equals("D"))
			{
				System.out.print("Enter quantity in passport: ");
				passportQtt = scanner.nextInt();
				passportCharge = new Charge(opt,passportQtt);
				
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
		
		//Calculate total quantity for photos
		ttlQtt = normalQtt + passportQtt;
		
		do {
			error=false;
			System.out.println("Additional Option");
			System.out.println("1. High quality paper");
			System.out.println("2. Design effect");
			System.out.println("3. Exit and bill");
			System.out.print("Enter Option: ");
			addOpt = scanner.nextInt();
			
			if(addOpt==1||addOpt==2) {
				surcharge = new Charge(addOpt,ttlQtt);
				error=false;
			}
			else if(addOpt==3) {
				System.out.println("Proceeding to billing...");
				error=false;
			}
			else {
				System.out.println("Invalid choice. Please enter again.");
				error=true;
			}
		}while(error);
		
		// this part to check the combination of billing
		// exp: some buy normal and passport without surcharge, some buy normal with surcharge
		
		// != null --> inside particular object got something == people buy the option(normal/passport/addOpt)
		
		if(normalCharge != null && passportCharge == null && surcharge == null) {
			totalCharge = normalCharge.calNormalCharge();
		}
		else if (normalCharge == null && passportCharge != null && surcharge == null) {
			totalCharge = passportCharge.calNormalCharge();
		}
		else if (normalCharge != null && passportCharge != null && surcharge == null) {
			totalCharge = normalCharge.calNormalCharge() + passportCharge.calNormalCharge();
		}
		else if (normalCharge != null && passportCharge == null && surcharge != null) {
			totalCharge = normalCharge.calNormalCharge() + surcharge.calSurcharge();
		}
		else if (normalCharge == null && passportCharge != null && surcharge != null) {
			totalCharge = passportCharge.calNormalCharge() + surcharge.calSurcharge();
		}
		else if(normalCharge != null && passportCharge != null && surcharge != null) {
			totalCharge = normalCharge.calNormalCharge() + passportCharge.calNormalCharge() + surcharge.calSurcharge();
		}
		
		
		System.out.println("Total charges: "+ totalCharge);
	}
	
}
