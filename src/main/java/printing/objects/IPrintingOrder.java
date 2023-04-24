package printing.objects;

import java.util.ArrayList;

public class IPrintingOrder {

	public static ArrayList<IPrintingOrder> printingOrders = new ArrayList<IPrintingOrder>();
	public PrintingType printingType;
	public PrintingOption printingOpt;
	public int quantity;
	public double sum;
	public boolean isHighQualityPaper = false;
	public boolean isDesignEffect = false;

	public double getTotal() {
		return 0;
	}

	public IPrintingOrder(PrintingType pType, PrintingOption pOpt, int qtt) {
		this.printingType = pType;
		this.printingOpt = pOpt;
		this.quantity = qtt;
	}

	public ArrayList<IPrintingOrder> getRequest() {

		return printingOrders;
	}

	public void updateRequest(ArrayList<IPrintingOrder> orderArr) {
		// place the request into queue for printing
	}
}
