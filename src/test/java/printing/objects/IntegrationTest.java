package printing.objects;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class IntegrationTest {

	IPrintingOrder orderDocumentBW = new PrintingDocument(PrintingOption.BlackWhite,30 );
	IPrintingOrder orderDocumentColour = new PrintingDocument(PrintingOption.Colour,30 );
	IPrintingOrder orderNormalHighQuality = new PrintingPhoto(PrintingOption.Normal,20 );
	IPrintingOrder orderNormalDesign = new PrintingPhoto(PrintingOption.Normal,20 );
	IPrintingOrder orderNormal = new PrintingPhoto(PrintingOption.Normal,20 );
	IPrintingOrder orderPassportHighQuality = new PrintingPhoto(PrintingOption.Passport,20 );
	IPrintingOrder orderPassportDesign = new PrintingPhoto(PrintingOption.Passport,20 );
	IPrintingOrder orderPassport = new PrintingPhoto(PrintingOption.Passport,20 );
	
	
	@Test
	public void testDocumentBW() 
	{
		double totalER = 6.00;
		double chargeER= 0.2;
		double totalAR = orderDocumentBW.getTotal();
		double chargeAR = ((PrintingDocument) orderDocumentBW).getBlackAndWhiteCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testDocumentColour() 
	{
		double totalER = 21.00;
		double chargeER= 0.7;
		double totalAR = orderDocumentColour.getTotal();
		double chargeAR = ((PrintingDocument) orderDocumentColour).getColourCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testNormalHighQuality() 
	{
		double totalER = 15.00;
		double chargeER= 0.75;
		double totalAR = orderNormalHighQuality.getTotal();
		double chargeAR = ((PrintingPhoto) orderNormalHighQuality).getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testNormalDesign() 
	{
		double totalER = 15.00;
		double chargeER= 0.75;
		double totalAR = orderNormalDesign.getTotal();
		double chargeAR = ((PrintingPhoto) orderNormalDesign).getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testNormal() 
	{
		double totalER = 15.00;
		double chargeER= 0.75;
		double totalAR = orderNormal.getTotal();
		double chargeAR = ((PrintingPhoto) orderNormal).getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testPassportHighQuality() 
	{
		double totalER = 17.00;
		double chargeER= 0.85;
		double totalAR = orderPassportHighQuality.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassportHighQuality).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testPassportDesign() 
	{
		double totalER = 17.00;
		double chargeER= 0.85;
		double totalAR = orderPassportDesign.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassportDesign).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testPassport() 
	{
		double totalER = 17.00;
		double chargeER= 0.85;
		double totalAR = orderPassport.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassport).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
}
