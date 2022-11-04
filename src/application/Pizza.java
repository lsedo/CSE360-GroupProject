package application;

//I figure this will make it easier to store all of the pizzas ordered later

public class Pizza {

	//************ Pizza Information *************
	private enum PizzaType {Pepperoni, Vegetable, Meat};
	private PizzaType pizzaType;
	private double timeToCook;
	private boolean extraCheese;
	private boolean onions;
	private boolean mushrooms;
	private boolean olives;
	
	int quantity;
	//********************************************
	
	public Pizza(String type, double cookTime, boolean extraCheese, boolean onions, boolean mushrooms, boolean olives, int quantity) {
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
		
		this.timeToCook = cookTime;
		this.extraCheese = extraCheese;
		this.onions = onions;
		this.mushrooms = mushrooms;
		this.olives = olives;
		this.quantity = quantity;
	}
	
	public PizzaType getPizzaType() {
		return pizzaType;
	}
	
	public double getPriceOfPizza() {
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
	
	public double getCookTimeOfPizza() {
		return timeToCook;
	}
	
	public boolean hasOnions() {
		return onions;
	}
	
	public boolean hasMushrooms() {
		return mushrooms;
	}
	
	public boolean hasExtraCheese() {
		return extraCheese;
	}
	
	public boolean hasOlives() {
		return olives;
	}
}
