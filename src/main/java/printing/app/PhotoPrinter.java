package printing.app;

import java.util.ArrayList;

import printing.objects.IPrintingOrder;

public class PhotoPrinter {

	IPrintingOrder order;
	ArrayList<IPrintingOrder> orderArr;

	public PhotoPrinter(IPrintingOrder order) {
		this.order = order;
	}

	public void queueRequest() {
		orderArr = order.getRequest();
		order.updateRequest(orderArr);
	}
}
