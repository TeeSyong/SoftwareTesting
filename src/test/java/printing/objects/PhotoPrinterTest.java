package printing.objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import printing.app.PhotoPrinter;

public class PhotoPrinterTest {

	@Test
	public void testQueueRequest() {
		// Mock the class that contain method of getRequest that will return the array
		// of orders
		IPrintingOrder orderMock = mock(IPrintingOrder.class);
		// Mock the class that contain array of orders
		IPrintingOrder getOrderMock = mock(IPrintingOrder.class);
		// When getRequest is called, always return the fixed array of orders
		when(orderMock.getRequest()).thenReturn(orderMock.printingOrders);
		// Pass the mock to the printer class the contains the queueRequest method
		PhotoPrinter print = new PhotoPrinter(orderMock);
		InOrder inOrder = Mockito.inOrder(orderMock);

		print.queueRequest();
		// Assert equals the array of orders return from getRequest with Actual array of
		// orders
		assertEquals(orderMock.getRequest(), getOrderMock.printingOrders);
		// Verify array of orders used for updateRequest method with actual array of
		// orders
		inOrder.verify(orderMock).updateRequest(getOrderMock.printingOrders);

	}

}
