package printing.objects;

public class IPrintingOrder {
	
	public PrintingType printingType;
	public PrintingOption printingOpt;
	public int quantity;
	public double sum;
	public boolean isHighQualityPaper=false;
	public boolean isDesignEffect=false;
	
	public double getTotal() {
		return 0;
	}
	public IPrintingOrder(PrintingType pType, PrintingOption pOpt, int qtt)
	{
		this.printingType=pType;
		this.printingOpt=pOpt;
		this.quantity=qtt;
	}


	
}

