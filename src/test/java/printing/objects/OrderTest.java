package printing.objects;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;


@RunWith(JUnitParamsRunner.class)
public class OrderTest {
	
	
	
	private Object [] paramForDocumentGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Colour,1,1.00},
			new Object [] {PrintingOption.Colour,4,4.00},
			new Object [] {PrintingOption.Colour,5,4.50},
			new Object [] {PrintingOption.Colour,10,9.00},
			new Object [] {PrintingOption.Colour,11,8.80},
			new Object [] {PrintingOption.Colour,20,16.00},
			new Object [] {PrintingOption.Colour,21,14.70},
			new Object [] {PrintingOption.Colour,50,35.00},
		};
	}
	//Valid Test for Document Colour
	@Test
	@Parameters(method="paramForDocumentGetTotalBVA")
	public void DocumentColourValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
	{
		IPrintingOrder testDocument = new PrintingDocument(pOpt,qtt);
		double AR=testDocument.getTotal();
		assertEquals(ER, AR, 0);
		
	}
	
	//Invalid Test For Document Colour
		private Object [] InvalidParamForDocumentColourGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Colour,0},
				new Object [] {PrintingOption.Colour,51},
			};
		}
		
		@Test(expected=IllegalArgumentException.class)	
		@Parameters(method="InvalidParamForDocumentColourGetTotalBVA")
		public void DocumentColourInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
			IPrintingOrder testDocument = new PrintingDocument(pOpt,qtt);
			double AR=testDocument.getTotal();
		}
	
	//Valid Test for Document Black and White
	private Object [] paramForDocumentBWGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.BlackWhite,1,0.50},
			new Object [] {PrintingOption.BlackWhite,4,2.00},
			new Object [] {PrintingOption.BlackWhite,5,2.00},
			new Object [] {PrintingOption.BlackWhite,10,4.00},
			new Object [] {PrintingOption.BlackWhite,11,3.30},
			new Object [] {PrintingOption.BlackWhite,20,6.00},
			new Object [] {PrintingOption.BlackWhite,21,4.20},
			new Object [] {PrintingOption.BlackWhite,50,10.00},
		};
	}
	
	@Test
	@Parameters(method="paramForDocumentBWGetTotalBVA")
	public void DocumentBWValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
	{
		IPrintingOrder testDocument = new PrintingDocument(pOpt,qtt);
		double AR=testDocument.getTotal();
		assertEquals(ER, AR, 0);
		
	}
	//Invalid Test For Document Black and White
	private Object [] InvalidParamForDocumenBWtGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.BlackWhite,0},
			new Object [] {PrintingOption.BlackWhite,51},
		};
	}
	
	@Test(expected=IllegalArgumentException.class)	
	@Parameters(method="InvalidParamForDocumenBWtGetTotalBVA")
	public void DocumentBWInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
		IPrintingOrder testDocument = new PrintingDocument(pOpt,qtt);
		double AR=testDocument.getTotal();
	}
	
	//Valid Test For Photo High Quality
	private Object [] paramForPhotoNormalHighQualityGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,1,1.10},
			new Object [] {PrintingOption.Normal,4,4.40},
			new Object [] {PrintingOption.Normal,5,5.00},
			new Object [] {PrintingOption.Normal,10,10.00},
			new Object [] {PrintingOption.Normal,11,9.35},
			new Object [] {PrintingOption.Normal,20,17.00},
			new Object [] {PrintingOption.Normal,21,12.60},
			new Object [] {PrintingOption.Normal,50,30.00},
		};
	}
	
	@Test
	@Parameters(method="paramForPhotoNormalHighQualityGetTotalBVA")
	public void PhotoNormalHighQualityValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
	{	
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		((PrintingPhoto) testPhoto).setIsHighQualityEffect(true);
		double AR=testPhoto.getTotal();
		assertEquals(ER, AR, 0);	
	}
	
	
	//Invalid Test For Photo Normal High Quality	
	private Object [] InvalidParamForPhotoNormalHighQualityGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,0},
			new Object [] {PrintingOption.Normal,51},
		};
	}
	
	@Test(expected=IllegalArgumentException.class)	
	@Parameters(method="InvalidParamForPhotoNormalHighQualityGetTotalBVA")
	public void PhotoNormalHighQualityInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		((PrintingPhoto) testPhoto).setIsHighQualityEffect(true);
		double AR=testPhoto.getTotal();
	}
	
	//Valid Test For Photo Normal Design
	private Object [] paramForPhotoNormalDesignGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,1,1.15},
			new Object [] {PrintingOption.Normal,4,4.60},
			new Object [] {PrintingOption.Normal,5,5.25},
			new Object [] {PrintingOption.Normal,10,10.50},
			new Object [] {PrintingOption.Normal,11,9.90},
			new Object [] {PrintingOption.Normal,20,18.00},
			new Object [] {PrintingOption.Normal,21,13.65},
			new Object [] {PrintingOption.Normal,50,32.50},
		};
	}
	
	@Test
	@Parameters(method="paramForPhotoNormalDesignGetTotalBVA")
	public void PhotoNormalDesignValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
	{	
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		((PrintingPhoto) testPhoto).setIsDesignEffect(true);
		double AR=testPhoto.getTotal();
		assertEquals(ER, AR, 0);
		
	}
	
	//Invalid Test For Photo Normal Design	
	private Object [] InvalidParamForPhotoNormalDesignGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,0},
			new Object [] {PrintingOption.Normal,51},
		};
	}
	
	@Test(expected=IllegalArgumentException.class)	
	@Parameters(method="InvalidParamForPhotoNormalDesignGetTotalBVA")
	public void PhotoNormalDesignInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		((PrintingPhoto) testPhoto).setIsDesignEffect(true);
		double AR=testPhoto.getTotal();
	}
	
	//Valid Test For Photo Normal 
	private Object [] paramForPhotoNormalGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,1,1.00},
			new Object [] {PrintingOption.Normal,4,4.00},
			new Object [] {PrintingOption.Normal,5,4.50},
			new Object [] {PrintingOption.Normal,10,9.00},
			new Object [] {PrintingOption.Normal,11,8.25},
			new Object [] {PrintingOption.Normal,20,15.00},
			new Object [] {PrintingOption.Normal,21,10.50},
			new Object [] {PrintingOption.Normal,50,25.0},
		};
	}
	
	@Test
	@Parameters(method="paramForPhotoNormalGetTotalBVA")
	public void PhotoNormalValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
	{	
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		double AR=testPhoto.getTotal();
		assertEquals(ER, AR, 0);
		
	}
	
	//Invalid Test For Photo Normal 
	private Object [] InvalidParamForPhotoNormalGetTotalBVA()
	{
		return new Object [] {
			new Object [] {PrintingOption.Normal,0},
			new Object [] {PrintingOption.Normal,51},
		};
	}
	
	@Test(expected=IllegalArgumentException.class)	
	@Parameters(method="InvalidParamForPhotoNormalGetTotalBVA")
	public void PhotoNormalInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
		IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
		double AR=testPhoto.getTotal();
	}
	
	//Valid Test For Photo Passport High Quality 
		private Object [] paramForPhotoPassportHighQualityGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,1,1.30},
				new Object [] {PrintingOption.Passport,4,5.20},
				new Object [] {PrintingOption.Passport,5,5.25},
				new Object [] {PrintingOption.Passport,10,10.50},
				new Object [] {PrintingOption.Passport,11,10.45},
				new Object [] {PrintingOption.Passport,20,19.00},
				new Object [] {PrintingOption.Passport,21,17.85},
				new Object [] {PrintingOption.Passport,50,42.50},
			};
		}
		
		@Test
		@Parameters(method="paramForPhotoPassportHighQualityGetTotalBVA")
		public void PhotoPassportHighQualityValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
		{	
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			((PrintingPhoto) testPhoto).setIsHighQualityEffect(true);
			double AR=testPhoto.getTotal();
			assertEquals(ER, AR, 0.0005);
			
		}
		
		//Invalid Test For Photo Passport High Quality
		private Object [] InvalidParamForPhotoPassportHighQualityGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,0},
				new Object [] {PrintingOption.Passport,51},
			};
		}
		
		@Test(expected=IllegalArgumentException.class)	
		@Parameters(method="InvalidParamForPhotoPassportHighQualityGetTotalBVA")
		public void PhotoPassportHighQualityInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			((PrintingPhoto) testPhoto).setIsHighQualityEffect(true);
			double AR=testPhoto.getTotal();
		}
		
		
		//Valid Test For Photo Passport Design 
		private Object [] paramForPhotoPassportDesignGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,1,1.35},
				new Object [] {PrintingOption.Passport,4,5.40},
				new Object [] {PrintingOption.Passport,5,5.50},
				new Object [] {PrintingOption.Passport,10,11.00},
				new Object [] {PrintingOption.Passport,11,11.00},
				new Object [] {PrintingOption.Passport,20,20.00},
				new Object [] {PrintingOption.Passport,21,18.90},
				new Object [] {PrintingOption.Passport,50,45.00},
			};
		}
		
		@Test
		@Parameters(method="paramForPhotoPassportDesignGetTotalBVA")
		public void PhotoPassportDesignValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
		{	
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			((PrintingPhoto) testPhoto).setIsDesignEffect(true);
			double AR=testPhoto.getTotal();
			assertEquals(ER, AR, 0.0005);
			
		}
		
		//Invalid Test For Photo Passport Design
		private Object [] InvalidParamForPhotoPassportDesignGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,0},
				new Object [] {PrintingOption.Passport,51},
			};
		}
		
		@Test(expected=IllegalArgumentException.class)	
		@Parameters(method="InvalidParamForPhotoPassportDesignGetTotalBVA")
		public void PhotoPassportDesignInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			((PrintingPhoto) testPhoto).setIsDesignEffect(true);
			double AR=testPhoto.getTotal();
		}
		
		//Valid Test For Photo Passport
		private Object [] paramForPhotoPassportGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,1,1.20},
				new Object [] {PrintingOption.Passport,4,4.80},
				new Object [] {PrintingOption.Passport,5,4.75},
				new Object [] {PrintingOption.Passport,10,9.50},
				new Object [] {PrintingOption.Passport,11,9.35},
				new Object [] {PrintingOption.Passport,20,17.00},
				new Object [] {PrintingOption.Passport,21,15.75},
				new Object [] {PrintingOption.Passport,50,37.50},
			};
		}
		
		@Test
		@Parameters(method="paramForPhotoPassportGetTotalBVA")
		public void PhotoPassportValidTestGetTotalBVA(PrintingOption pOpt,int qtt, double ER)
		{	
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			double AR=testPhoto.getTotal();
			assertEquals(ER, AR, 0);
			
		}
		
		//Invalid Test For Photo Passport
		private Object [] InvalidParamForPhotoPassportGetTotalBVA()
		{
			return new Object [] {
				new Object [] {PrintingOption.Passport,0},
				new Object [] {PrintingOption.Passport,51},
			};
		}
		
		@Test(expected=IllegalArgumentException.class)	
		@Parameters(method="InvalidParamForPhotoPassportGetTotalBVA")
		public void PhotoPassportInvalidTestGetTotalBVA(PrintingOption pOpt,int qtt) {
			IPrintingOrder testPhoto = new PrintingPhoto(pOpt,qtt);
			double AR=testPhoto.getTotal();
		}

	
	
}
