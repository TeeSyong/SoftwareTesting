package PrintingKioskSystem;

import java.util.Scanner;

public class Order {

	
	private static Scanner scanner;
	private static String mainOpt1,mainOpt2, mainOrderType, mainAddOpt;
	private static int mainQtt1, mainQtt2, mainCheckLoop;
	private static double mainTotalCharge;
	
	public String getMainOpt1(){
		return mainOpt1;
	}
	public String getMainOpt2() {
		return mainOpt2;
	}
	public String getMainOrderType() {
		return mainOrderType;
	}
	public String getMainAddOpt() {
		return mainAddOpt;
	}
	public int getMainQtt1() {
		return mainQtt1;
	}
	public int getMainQtt2() {
		return mainQtt2;
	}
	public int getMainCheckLoop() {
		return mainCheckLoop;
	}
	public double getMainTotalCharge() {
		return mainTotalCharge;
	}
	
	
	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		
		boolean error;
		String order;
				
		do {
			error = false;
			System.out.print("Enter type of order(D-Document/P-Photo)(E-exit): ");
			order = scanner.next().toUpperCase();
			switch(order) {
			case "D": document(); mainOrderType = "Document"; error = false; break;
			case "P": photo(); mainOrderType = "Photo"; error = false; break;
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
		int bwQtt = 0,colorQtt = 0,ttlQtt;
		int checkLoop = 0;
		double totalCharge= 0;
		Charge ch1 = null, ch2= null;
		boolean error,er;
		
		do {
			error=false;
			System.out.print("Enter option(A-Black & White/B-Colour): ");
			opt = scanner.next().toUpperCase();
			if(opt.equals("A")) {
				mainOpt1 = "Black & White";
				System.out.print("Enter quantity in black and white: ");
				bwQtt = scanner.nextInt();
				mainQtt1 = bwQtt;
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
				mainOpt2 = "Colour";
				System.out.print("Enter quantity in colour: ");
				colorQtt = scanner.nextInt();
				mainQtt2 = colorQtt;
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
			checkLoop++;
		}while(error);
		mainCheckLoop = checkLoop;
		//Calculate total quantity for documents
		ttlQtt = bwQtt + colorQtt;
		
		// this part to check the combination of billing
		// exp: some buy normal and passport without surcharge, some buy normal with surcharge
				
		// != null --> inside particular object got something == people buy the option(normal/passport/addOpt)
				
		if(ch1 != null && ch2 == null) {
			totalCharge = ch1.calNormalCharge();
		}
		else if (ch1 == null && ch2 != null) {
			totalCharge = ch2.calNormalCharge();
		}
		else if(ch1 != null && ch2 != null) {
			totalCharge = ch1.calNormalCharge() + ch2.calNormalCharge();
		}
		
		//System.out.println("Total charges: "+ totalCharge);
	
	}
	
	public static void photo() {
		
		String opt, choice;
		int ttlQtt, normalQtt = 0, passportQtt = 0, addOpt;
		int checkLoop = 0;
		double totalCharge = 0;
		Charge ch3 = null, ch4= null, surcharge = null;
		boolean error, er;
		
		
		do {
			error=false;
			System.out.print("Enter option(C-Normal(4R)/D-Passport): ");
			opt = scanner.next().toUpperCase();
			if(opt.equals("C")) {
				mainOpt1 = "Normal(4R)";
				System.out.print("Enter quantity in normal(4R): ");
				normalQtt = scanner.nextInt();
				mainQtt1 = normalQtt;
				ch3 = new Charge(opt,normalQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
						System.out.println("Proceeding to billing...");
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
				mainOpt2 = "Passport";
				System.out.print("Enter quantity in passport: ");
				passportQtt = scanner.nextInt();
				mainQtt2 = passportQtt;
				ch4 = new Charge(opt,passportQtt);
				
				do {
					er=false;
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					choice= scanner.next().toUpperCase();
					if(choice.equals("Y")) {
						error=true;
						er=false;
					}
					else if(choice.equals("N")) {
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
			checkLoop++;
		}while(error);
		mainCheckLoop = checkLoop;
		
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
				if(addOpt==1)
					mainAddOpt="High quality paper";
				else 
					mainAddOpt="Design effect";
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
		
		if(ch3 != null && ch4 == null && surcharge == null) {
			totalCharge = ch3.calNormalCharge();
		}
		else if (ch3 == null && ch4 != null && surcharge == null) {
			totalCharge = ch4.calNormalCharge();
		}
		else if (ch3 != null && ch4 != null && surcharge == null) {
			totalCharge = ch3.calNormalCharge() + ch4.calNormalCharge();
		}
		else if (ch3 != null && ch4 == null && surcharge != null) {
			totalCharge = ch3.calNormalCharge() + surcharge.calSurcharge();
		}
		else if (ch3 == null && ch4 != null && surcharge != null) {
			totalCharge = ch4.calNormalCharge() + surcharge.calSurcharge();
		}
		else if(ch3 != null && ch4 != null && surcharge != null) {
			totalCharge = ch3.calNormalCharge() + ch4.calNormalCharge() + surcharge.calSurcharge();
		}
		
		
		//System.out.println("Total charges: "+ totalCharge);
	}
	
	
}
