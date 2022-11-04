package application;

public class Customer {

	private String name;
	private int id;
	private Cart cart;
	private int phoneNumber;
	private String address;
	private double funds;
	
	public Customer(String name, int id, Cart cart, int phone, String address, double funds) {
		this.name = name;
		this.id = id;
		this.cart = cart;
		this.phoneNumber = phone;
		this.address = address;
		this.funds = funds;
	}
	
	public void addPizza(Pizza pizza) {
		cart.addPizza(pizza);
	}
	
	public void removePizza(Pizza pizza) {
		cart.removePizza(pizza);
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
}
