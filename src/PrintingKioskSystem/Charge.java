package PrintingKioskSystem;

import java.util.*;

public class Charge {

	
	private double charge, surcharge;
	private String option,addOption;
	private int quantity, addOpt, ttlQtt;
	
	
	public Charge(String option, int quantity) {
		this.option = option;
		this.quantity = quantity;
	}
	
	public Charge(int addOpt,int ttlQtt) {
		this.addOpt = addOpt;
		this.ttlQtt = ttlQtt;
	}
	
	public double calNormalCharge() {
		
		switch(option) {
		case "A": charge = getBlackAndWhiteCharge(quantity); break;
		case "B": charge = getColourCharge(quantity); break;
		case "C": charge = getNormalCharge(quantity); break;
		case "D": charge = getPassportCharge(quantity); break;
		}
		return charge*quantity;
	}
	
	public double calSurcharge() {
		
		surcharge = getAddOptSurcharge();
		return surcharge*ttlQtt;
	}
	
	
	public double getBlackAndWhiteCharge(int quantity){
		if(quantity < 5)
			return 0.5;
		else if (quantity >= 5 && quantity <= 10)
			return 0.4;
		else if(quantity >= 11 && quantity <= 20)
			return 0.3;
		else
			return 0.2;
	}
	
	public double getColourCharge(int quantity) {
		if(quantity < 5)
			return 1;
		else if (quantity >= 5 && quantity <= 10)
			return 0.9;
		else if(quantity >= 11 && quantity <= 20)
			return 0.8;
		else
			return 0.7;
	}
	
	public double getNormalCharge(int quantity) {
		if(quantity < 5)
			return 1;
		else if (quantity >= 5 && quantity <= 10)
			return 0.9;
		else if(quantity >= 11 && quantity <= 20)
			return 0.75;
		else
			return 0.5;
	}
	
	public double getPassportCharge(int quantity) {
		if(quantity < 5)
			return 1.2;
		else if (quantity >= 5 && quantity <= 10)
			return 0.95;
		else if(quantity >= 11 && quantity <= 20)
			return 0.85;
		else
			return 0.75;
	}
	
	public double getAddOptSurcharge() {
		if(addOpt==1)
			return 0.1;
		else
			return 0.15;
	}
}
