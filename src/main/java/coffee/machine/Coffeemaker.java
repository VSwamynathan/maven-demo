package coffee.machine;

import java.util.Scanner;

public class Coffeemaker {

	private static Scanner moneyInput;
	private static Scanner coffeeTypeInput;
	
	// Created 3 different types of drinks.
	private static final int COFFEE = 0;
	private static final int CHOCOLATE = 1;
	private static final int ESPRESSO = 2;
	public static Drink[] drinkList = new Drink[3];
	
	// main method
	/*public static void main(String[] args) {
		
		 double money = 0.0;
		 int typeOfCoffee = 0;
		 double coffeePrice=0.0;
		 
	     //populate the array with drink objects.
		 drinkList[COFFEE] = new Drink("Coffee", 10);
		 drinkList[CHOCOLATE] = new Drink("Chocolate", 20);
		 drinkList[ESPRESSO] = new Drink("Espresso", 30);

		
		 //trying to get the product number from the enduser
		 typeOfCoffee= selectCoffee();
		
		 //Based on the product number, name and price are noted down for that product.
		 String coffeeName=drinkList[typeOfCoffee].getName();
		 coffeePrice=drinkList[typeOfCoffee].getPrice();

		 // Now trying to get the money . Denominations is omitted as of now. If needed , calculation can be done and submitted
		 money=acceptMoney();	 
		 
		 // Amount paid is checked
		 if(isMoneyEnough(money,coffeePrice)) { 
			 dispenseCoffee(drinkList[typeOfCoffee]);
			 // if money is paid more, balance is settled down.
			 if(money>coffeePrice) {
				 System.out.println("Your Change is" + issueBalance(money,coffeePrice) + "Kroner");
			 }
		 }
		 else { // if no sufficient money paid, returned back.
			 notify("Insufficient amount- "+ money +" NOK Money returned back ");
		 }
		
	 }*/
	 
	public String makeCoffee(int typeOfCoffee, double money, Drink drinkObj) {
		
		String message=null;
	//	int typeOfCoffee = 0;
	//	double money=0.0;
		
		  //populate the array with drink objects.
		 drinkList[COFFEE] = new Drink("Coffee", 10);
		 drinkList[CHOCOLATE] = new Drink("Chocolate", 20);
		 drinkList[ESPRESSO] = new Drink("Espresso", 30);

		
		 //trying to get the product number from the enduser
    //    typeOfCoffee= selectCoffee();
		
		 //Based on the product number, name and price are noted down for that product.
		 String coffeeName=drinkList[typeOfCoffee].getName();
		 double coffeePrice=drinkList[typeOfCoffee].getPrice();

		 // Now trying to get the money . Denominations is omitted as of now. If needed , calculation can be done and submitted
	//	 money=acceptMoney();	 
		 
		 // Amount paid is checked
		 if(isMoneyEnough(money,coffeePrice)) { 
			 message=new String(dispenseCoffee(drinkList[typeOfCoffee]));
			 // if money is paid more, balance is settled down.
			 if(money>coffeePrice) {
				 message= message+ " Your Change is " + issueBalance(money,coffeePrice) + " Kroner";
				 System.out.println(message);
			 }
		 }
		 else { // if no sufficient money paid, returned back.
			
			 message=notify(money);
			 System.out.println(message);
			 
		 }
		return message;
	}
	
	
	//Select the coffee Product based on the product number chosen by the user.
	public int selectCoffee(){
		coffeeTypeInput = new Scanner(System.in);
		int coffeeSelected=0; //value for the selected drink
		
		System.out.println("Enter Coffee Number");
		coffeeSelected=coffeeTypeInput.nextInt();
		
		// throw exception if no such product number exist
		 if(coffeeSelected>=3) {
				throw new NoSuchProductException("Select a valid Product");
		}
	 
		 
		return coffeeSelected;

	}
	
	// Accepting the money from the user.
	 public double acceptMoney() {
		 
		 moneyInput = new Scanner(System.in);
		 double payAmount= 0.0;
		 
		 System.out.println("Enter Money");
		 payAmount=moneyInput.nextDouble();
		 
		 return payAmount;
	 }
	 
	
	 // returns boolean value if total money is paid 
	 public static boolean isMoneyEnough(double money, double drinkPrice) { 
	      if(money >= drinkPrice){ 
	         return true; 
	      } 
	      return false; 
	   } 
	 
	 // Notify the user with "NO" message
	 public String notify(double money) {
		 String message=new String("Insufficient amount- "+ money +" NOK Money returned back ");
		 return(message);
	 }
	 
	 // Calculation to the money paid.
	 public double issueBalance(double payment, double coffeePrice) {
		 double change=0.0;
		 change=payment-coffeePrice;
		 return change;
	 }
	 
	 //Adding Sugar to the drink based on the type. - Different recipes.
	 public Drink prepareCoffeeDrink(Drink coffeeDrink) {
		
		 int numberOfSugarCubes=0;
		 
		if (coffeeDrink.getName().matches("Coffee")) {
			numberOfSugarCubes = 1;
		} else if (coffeeDrink.getName().matches("Chocolate")) {
			numberOfSugarCubes = 4;
		} else if (coffeeDrink.getName().matches("Espresso")) {
			numberOfSugarCubes = 2;
		} else {
			numberOfSugarCubes = 0;
		}
		 
		// populating the sugar object with sugarcubes 
		 Sugar s=new Sugar(numberOfSugarCubes);
		 
		 // setting the sugar in drink
		 coffeeDrink.setSugar(s);
		 return coffeeDrink;
 	 }
	 
	 // Confirm the dispense of the product through the message
	 public String dispenseCoffee(Drink coffeeDrink) {
		 prepareCoffeeDrink(coffeeDrink);
		 String confirmMessage=coffeeDrink.getName() + " is served " + coffeeDrink.getSugar().getSugarMessage();
		 System.out.println(confirmMessage);
		 return confirmMessage;
	 }
	 
	 
	 
}
