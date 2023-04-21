package printing.objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import printing.app.PhotoPrinter;

public class PhotoPrinterTest {

	@Test
	public void testQueueRequest()
	{
		IPrintingOrder orderMock = mock(IPrintingOrder.class);
		IPrintingOrder getOrderMock = mock(IPrintingOrder.class);
		
		when(orderMock.getRequest()).thenReturn(orderMock.printingOrders);
		
		PhotoPrinter print = new PhotoPrinter (orderMock);
		InOrder inOrder = Mockito.inOrder(orderMock);
		
		print.queueRequest();
		assertEquals(orderMock.getRequest(),getOrderMock.printingOrders);
		
		inOrder.verify(orderMock).updateRequest(getOrderMock.printingOrders);
		
	
	}


}
