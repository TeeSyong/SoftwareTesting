package PrintingKioskSystem;

import java.util.ArrayList;
import java.util.Scanner;

import PrintingKioskSystem.Objects.*;

public class Order {

	public static ArrayList<IPrintingOrder> printingOrders = new ArrayList<IPrintingOrder>();
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		boolean error = true, isInvalidInput = false;
		String order;

		do {
			System.out.print("Enter type of order(D-Document/P-Photo)(E-exit): ");
			order = scanner.next().toUpperCase();
			switch (order) {
			case "D":
				document();
				break;
			case "P":
				photo();
				break;
			case "E":
				error = false;
				break;
			default:
				isInvalidInput = true;
				break;
			}

			if (isInvalidInput) {
				System.out.println("Invalid choice. Please enter again");
				isInvalidInput = false;
			} else {
				boolean er = false;
				do {
					System.out.print("Proceed to another option? (Y-yes/N-No): ");
					String choice = scanner.next().toUpperCase();
					if (choice.equals("Y")) {
						error = true;
						er = false;
					} else if (choice.equals("N")) {
						error = false;
						er = false;
					} else {
						System.out.println("Invalid input. Please enter again.");
						er = true;
					}
				} while (er);

			}

		} while (error);

		System.out.println("Proceeding to Billing...");
		double totalBill = 0;
		for (int i = 0; i < printingOrders.size(); i++) {
			double bill=printingOrders.get(i).getTotal();
			System.out.println((i+1)+": Order "+ printingOrders.get(i).printingOpt  + "Quantity= " +printingOrders.get(i).quantity+ " and bill is: " +bill);
			totalBill += bill;
		}
		System.out.print("Your billing total is " + totalBill);

	}

	public static void document() {
		String opt;
		int Qtt = 0;
		boolean isDocumentError;

		do {
			isDocumentError = false;
			System.out.print("Enter option(A-Black & White/B-Colour): ");
			opt = scanner.next().toUpperCase();
			if (opt.equals("A") || opt.equals("B")) {
				if(opt.equals("A")) {
					System.out.print("Enter quantity in black and white: ");
				}
				else if(opt.equals("B")) {
					System.out.print("Enter quantity in color: ");
				}
				
				Qtt = scanner.nextInt();
				PrintingOption pOpt = PrintingOption.Unknown;
				if (opt.equals("A")) {
					pOpt = PrintingOption.BlackWhite;
				} else if (opt.equals("B")) {
					pOpt = PrintingOption.Colour;
				}
				PrintingDocument newDoc = new PrintingDocument(pOpt, Qtt);
				printingOrders.add(newDoc);

			} else {
				System.out.println("Invalid choice. Please enter again.");
				isDocumentError = true;
			}

		} while (isDocumentError);

	}

	public static void photo() {

		String opt;
		int Qtt;
		boolean isPhotoError;

		do {
			isPhotoError = false;
			System.out.print("Enter option(C-Normal(4R)/D-Passport): ");
			opt = scanner.next().toUpperCase();
			if (opt.equals("C") || opt.equals("D")) {
				if(opt.equals("C")) {
					System.out.print("Enter quantity in normal(4R): ");
				}
				else if(opt.equals("D")) {
					System.out.print("Enter quantity in passport: ");
				}
				
				
				Qtt = scanner.nextInt();

				PrintingOption pOpt = PrintingOption.Unknown;
				if (opt.equals("C")) {
					pOpt = PrintingOption.Normal;
				} else if (opt.equals("D")) {
					pOpt = PrintingOption.Passport;
				}
				PrintingPhoto newPhoto = new PrintingPhoto(pOpt, Qtt);

				System.out.println("Additional Option");
				System.out.println("1. High quality paper");
				System.out.println("2. Design effect");
				System.out.println("None (Enter any key to skip)");
				System.out.print("Enter Option: ");
				String addOpt = scanner.nextLine();
				scanner.nextLine();
				if (addOpt.equals("1")) {
					newPhoto.isHighQualityPaper = true;
				} else if (addOpt.equals("2")) {
					newPhoto.isDesignEffect = true;
				}

				printingOrders.add(newPhoto);

			} else {
				System.out.println("Invalid choice. Please enter again.");
				isPhotoError = true;
			}

		} while (isPhotoError);

	}

}
