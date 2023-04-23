package printing.objects;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class IntegrationTest {
	ArrayList<String[]> linesRead= readER();
	PrintingDocument orderDocumentBW = new PrintingDocument(PrintingOption.BlackWhite,30 );
	PrintingDocument orderDocumentColour = new PrintingDocument(PrintingOption.Colour,30 );
	PrintingPhoto orderNormalHighQuality = new PrintingPhoto(PrintingOption.Normal,20 );
	PrintingPhoto orderNormalDesign = new PrintingPhoto(PrintingOption.Normal,20 );
	PrintingPhoto orderNormal = new PrintingPhoto(PrintingOption.Normal,20 );
	PrintingPhoto orderPassportHighQuality = new PrintingPhoto(PrintingOption.Passport,20 );
	PrintingPhoto orderPassportDesign = new PrintingPhoto(PrintingOption.Passport,20 );
	PrintingPhoto orderPassport = new PrintingPhoto(PrintingOption.Passport,20 );
	
	
	@Test
	public void testDocumentBW() 
	{
		double totalER = Double.parseDouble(linesRead.get(0)[0]);
		double chargeER= Double.parseDouble(linesRead.get(0)[1]);
		double totalAR = orderDocumentBW.getTotal();
		double chargeAR = ((PrintingDocument) orderDocumentBW).getBlackAndWhiteCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testDocumentColour() 
	{
		double totalER = Double.parseDouble(linesRead.get(1)[0]);
		double chargeER= Double.parseDouble(linesRead.get(1)[1]);
		double totalAR = orderDocumentColour.getTotal();
		double chargeAR = ((PrintingDocument) orderDocumentColour).getColourCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testNormalHighQuality() 
	{
		double totalER = Double.parseDouble(linesRead.get(2)[0]);
		double chargeER= Double.parseDouble(linesRead.get(2)[1]);
		orderNormalHighQuality.setIsHighQualityEffect(true);
		double totalAR = orderNormalHighQuality.getTotal();
		double chargeAR = orderNormalHighQuality.getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testNormalDesign() 
	{
		double totalER = Double.parseDouble(linesRead.get(3)[0]);
		double chargeER= Double.parseDouble(linesRead.get(3)[1]);
		((PrintingPhoto)orderNormalDesign).setIsDesignEffect(true);
		double totalAR = orderNormalDesign.getTotal();
		double chargeAR = ((PrintingPhoto) orderNormalDesign).getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testNormal() 
	{
		double totalER = Double.parseDouble(linesRead.get(4)[0]);
		double chargeER= Double.parseDouble(linesRead.get(4)[1]);
		double totalAR = orderNormal.getTotal();
		double chargeAR = ((PrintingPhoto) orderNormal).getNormalCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	@Test
	public void testPassportHighQuality() 
	{
		double totalER = Double.parseDouble(linesRead.get(5)[0]);
		double chargeER= Double.parseDouble(linesRead.get(5)[1]);
		((PrintingPhoto)orderPassportHighQuality).setIsHighQualityEffect(true);
		double totalAR = orderPassportHighQuality.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassportHighQuality).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testPassportDesign() 
	{
		double totalER = Double.parseDouble(linesRead.get(6)[0]);
		double chargeER= Double.parseDouble(linesRead.get(6)[1]);
		((PrintingPhoto)orderPassportDesign).setIsDesignEffect(true);
		double totalAR = orderPassportDesign.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassportDesign).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	@Test
	public void testPassport() 
	{
		double totalER = Double.parseDouble(linesRead.get(7)[0]);
		double chargeER= Double.parseDouble(linesRead.get(7)[1]);
		double totalAR = orderPassport.getTotal();
		double chargeAR = ((PrintingPhoto) orderPassport).getPassportCharge();
		assertEquals(totalER,totalAR,0);
		assertEquals(chargeER,chargeAR,0);
	}
	
	public ArrayList<String[]> readER() {
		ArrayList<String[]> linesRead = new ArrayList<String[]>();
		String fileName = "IntegrationER.txt";
		Scanner inputStream = null;
		try {
			inputStream = new Scanner(new File(fileName));
		}

		catch (FileNotFoundException e) {
			System.out.println("Error opening the file " + fileName);
			System.exit(0);
		}

		while (inputStream.hasNextLine()) {
			String singleLine = inputStream.nextLine();
			String[] tokens = singleLine.split(",");
			linesRead.add(tokens);
		}
		
		inputStream.close();
		return linesRead;
	}
	
}
