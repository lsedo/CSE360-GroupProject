package application;

public class Customer {

	private String name;
	private int id;
	private Cart cart;
	private int phoneNumber;
	private String address;
	private double funds;
	private int cookingStage = 0;
	
	public Customer(String name, int id, Cart cart, int phone, String address, double funds) {
		this.name = name;
		this.id = id;
		this.cart = cart;
		this.phoneNumber = phone;
		this.address = address;
		this.funds = funds;
	}
	
	public Customer() {
		cart = new Cart();
	}

	public void addPizza(Pizza pizza) {
		cart.addPizza(pizza);
	}
	
	public void removePizza(Pizza pizza) {
		cart.removePizza(pizza);
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public int getID() {
		return id;
	}
	
	public int getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getName() {
		return name;
	}
	
	public double getFunds() {
		return funds;
	}
	
	public String getCookingStage() {
		if(cookingStage == 0) {
			return "Ready to cook";
		}
		else if(cookingStage == 1) {
			return "Cooking";
		}
		
		return "Ready";
	}
	
	public boolean updateCookingStage() {
		cookingStage++; //update cooking stage
		
		if(cookingStage == 3) {
			return true; //if the cooking stage is finished, return 1
		}
		
		return false; //else return zero
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
