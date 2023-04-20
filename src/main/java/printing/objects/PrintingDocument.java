package printing.objects;

public class PrintingDocument extends IPrintingOrder {

	
	public PrintingDocument(PrintingOption pOpt,int qtt)
	{
		super(PrintingType.Document,pOpt,qtt);
	}
	
	@Override
	public double getTotal()
	{
		double charge=0;
		if(printingOpt==PrintingOption.BlackWhite)
		{
			charge=getBlackAndWhiteCharge();
		}
		else if(printingOpt==PrintingOption.Colour)
		{
			charge=getColourCharge();
		}
		sum=quantity*charge;
		return sum;
	}
	
	public double getBlackAndWhiteCharge(){
		if(quantity <=0)
			throw new IllegalArgumentException("Invalid Quantity, quantity cannot be negative");
		else if(quantity >50)
			throw new IllegalArgumentException("Invalid Quantity, Maximum 50 copies per printing");
		if(quantity < 5)
			return 0.5;
		else if (quantity >= 5 && quantity <= 10)
			return 0.4;
		else if(quantity >= 11 && quantity <= 20)
			return 0.3;
		else
			return 0.2;
	}
	
	public double getColourCharge() {
		if(quantity <=0)
			throw new IllegalArgumentException("Invalid Quantity, quantity cannot be negative");
		else if(quantity >50)
			throw new IllegalArgumentException("Invalid Quantity, Maximum 50 copies per printing");
		if(quantity < 5)
			return 1;
		else if (quantity >= 5 && quantity <= 10)
			return 0.9;
		else if(quantity >= 11 && quantity <= 20)
			return 0.8;
		else
			return 0.7;
	}
}
