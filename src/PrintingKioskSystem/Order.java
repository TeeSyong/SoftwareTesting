package PrintingKioskSystem;

public class Order {

	private String type;
	private String option;
	private int quantity;
	private String addOpt;
	
	public Order(String type, String option, int quantity, String addOpt) {
		this.type = type;
		this.option = option;
		this.quantity = quantity;
		this.addOpt = addOpt;
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public String getOption()
	{
		return option;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public String getAddOpt()
	{
		return addOpt;
	}
	
}
