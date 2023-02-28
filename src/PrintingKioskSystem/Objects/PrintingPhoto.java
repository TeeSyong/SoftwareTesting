package PrintingKioskSystem.Objects;

public class PrintingPhoto extends IPrintingOrder{

	public boolean isHighQualityPaper=false;
	public boolean isDesignEffect=false;
	
	public PrintingPhoto(PrintingOption pOpt,int qtt)
	{
		super(PrintingType.Photo,pOpt,qtt);
	}
	@Override
	public double getTotal()
	{
		
		double charge=0;
		if(printingOpt==PrintingOption.Normal)
		{
			charge=getNormalCharge();
		}
		else if(printingOpt==PrintingOption.Passport)
		{
			charge=getPassportCharge();
		}
		if(isHighQualityPaper)
		{
			charge+=0.10;
		}
		if(isDesignEffect)
		{
			charge+=0.15;
		}
		sum=quantity*charge;
		return sum;
	}
	
	public double getNormalCharge() {
		if(quantity < 5)
			return 1;
		else if (quantity >= 5 && quantity <= 10)
			return 0.9;
		else if(quantity >= 11 && quantity <= 20)
			return 0.75;
		else
			return 0.5;
	}
	
	public double getPassportCharge() {
		if(quantity < 5)
			return 1.2;
		else if (quantity >= 5 && quantity <= 10)
			return 0.95;
		else if(quantity >= 11 && quantity <= 20)
			return 0.85;
		else
			return 0.75;
	}
}

