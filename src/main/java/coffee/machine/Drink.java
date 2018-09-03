package coffee.machine;

public class Drink {
	private double price;
	private String name;
	private Sugar sugar; 
	 
	// Each drink has a specific name and price
	public Drink(String name, double price){	
		this.name = name;	
		this.price = price;
	}
		
	public String getName() {
		return this.name;
	}
	public double getPrice(){
		return this.price;
		
	}
	
	public Sugar getSugar() {
		return this.sugar;
	}
	//setting a sugar object here
	public void setSugar(Sugar s) {
		this.sugar = s;
	}

}
