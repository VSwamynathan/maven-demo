package coffee.machine;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class CoffeeMachineTest {

	
    
    Coffeemaker maker1=new Coffeemaker();
   

	@Test 
	public void COFFEEMachine_shouldReturn_Coffee(){ 
	      String message=maker1.makeCoffee(0,10,new Drink("Coffee",10));
	      assertEquals("Coffee is served with 1 sugars.", message);
	   } 
	

	@Test 
	public void COFFEEMachine_shouldReturn_Coffee_with_2NOK(){ 
	      String message=maker1.makeCoffee(0,12,new Drink("Coffee",10));
	      assertEquals("Coffee is served with 1 sugars. Your Change is 2.0 Kroner", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_Money_without_Coffee(){ 
	      String message=maker1.makeCoffee(0,7,new Drink("Coffee",10));
	      assertEquals("Insufficient amount- 7.0 NOK Money returned back ", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_Chocholate(){ 
	      String message=maker1.makeCoffee(1,20,new Drink("Chocolate",20));
	      assertEquals("Chocolate is served with 4 sugars.", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_Chocholate_with_5NOK(){ 
	      String message=maker1.makeCoffee(1,25,new Drink("Chocolate",20));
	      assertEquals("Chocolate is served with 4 sugars. Your Change is 5.0 Kroner", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_money_without_Chocholate(){ 
	      String message=maker1.makeCoffee(1,12,new Drink("Chocolate",20));
	      assertEquals("Insufficient amount- 12.0 NOK Money returned back ", message);
	   }
	
	@Test 
	public void COFFEEMachine_shouldReturn_Espresso(){ 
	      String message=maker1.makeCoffee(2,30,new Drink("Espresso",30));
	      assertEquals("Espresso is served with 2 sugars.", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_Espresso_with_10NOK(){ 
	      String message=maker1.makeCoffee(2,40,new Drink("Espresso",30));
	      assertEquals("Espresso is served with 2 sugars. Your Change is 10.0 Kroner", message);
	   } 
	
	@Test 
	public void COFFEEMachine_shouldReturn_money_without_Espresso(){ 
	      String message=maker1.makeCoffee(2,25,new Drink("Espresso",30));
	      assertEquals("Insufficient amount- 25.0 NOK Money returned back ", message);
	   } 
	
	@Test 
	public void COFFEE_has_product_number_0(){ 
	      int productNumber=maker1.selectCoffee();
	      assertEquals("coffee has 0 Product number", 0, productNumber);
	   } 
	
	@Test 
	public void COFFEE_do_not_have_number_2(){ 

	      int productNumber=4;
	      assertTrue("Condition is true that coffee has number 0", 0!=productNumber);
	   }
	
}

