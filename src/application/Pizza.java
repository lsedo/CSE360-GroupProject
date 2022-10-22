package application;

//I figure this will make it easier to store all of the pizzas ordered later

public class Pizza {

	//************ Pizza Information *************
	private enum PizzaType {Pepperoni, Vegetable, Meat};
	private PizzaType pizzaType;
	private boolean extraCheese;
	private boolean onions;
	private boolean mushrooms;
	private boolean olives;
	
	int quantity;
	//********************************************
	
	public Pizza(String type, boolean extraCheese, boolean onions, boolean mushrooms, boolean olives, int quantity) {
		switch(type) {
			case "Pepperoni":
				this.pizzaType = PizzaType.Pepperoni;
				break;
				
			case "Vegetable":
				this.pizzaType = PizzaType.Vegetable;
				break;
				
			case "Meat":
				this.pizzaType = PizzaType.Meat;
				break;
				
			default:
				this.pizzaType = PizzaType.Pepperoni;
				break;
		}
		
		this.extraCheese = extraCheese;
		this.onions = onions;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.quantity = quantity;
	}
	
	public double getPrice() {
		double price = 0;
		
		switch(pizzaType) {
			case Pepperoni:
				price += 9.99;
			break;
			
			case Vegetable:
				price += 9.99;
			break;
			
			case Meat:
				price += 11.99;
			break;
			
			
		}
		
		price += extraCheese ? 1.99 : 0;
		price += onions ? 0.99 : 0;
		price += mushrooms ? 0.99 : 0;
		price += olives ? 0.99 : 0;
		
		return (price * quantity);
	}
}
