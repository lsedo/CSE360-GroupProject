package application;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	
	/*Since we are not so much concerned with time I decided to use a list struct*/
	//************ Cart Info *************
	private List<Pizza> pizzaCart = new ArrayList<Pizza>();
	private double totalPrice;
	private int idOfCustomer;
	private double timeToCook;
	//************************************
	
	public void DisplayPizzaDetails(int index) {
		//TODO: Display information
	}
	
	public void addPizza(Pizza pizza) {
		pizzaCart.add(pizza); //add pizza to end of list
	}
	
	public void removePizza(Pizza pizza){
		try {
			pizzaCart.remove(pizza);
		}
		catch(NullPointerException e) {
			//TODO: throw message if not found?
		}
	}
	
	public double getTotalPrice() {
		double Total = 0;
		
		for(int i = 0; i < pizzaCart.size(); i++) {
			Total += pizzaCart.get(i).getPriceOfPizza();
		}
		
		return Total;
	}
	
	public int getIdOfCustomer() {
		return idOfCustomer;
	}
	
	public double getTimeToCook() {
		return timeToCook;
	}
}