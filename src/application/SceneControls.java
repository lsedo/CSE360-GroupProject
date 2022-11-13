package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SceneControls implements Initializable {

	private Stage stage;
	private Scene newScene;
	private Parent root;

	// user information
	private String id;
	private String password;

	// Costs for the pizza
	private double baseCost = 9.99, toppingsCost = 0, totalCost = 0;

	// ******************* Home Scene Items ***************************

	// ****************************************************************

	// ******************* Login Scene Items **************************
	@FXML
	private TextField usernameTextField = new TextField();
	@FXML
	private TextField passwordTextField = new TextField();
	// ****************************************************************

	// ******************* Pizza Scene Items **************************
	private ToggleGroup basePizzaToggleGroup = new ToggleGroup();
	@FXML
	private RadioButton pepperoniButton = new RadioButton();
	@FXML
	private RadioButton vegetableButton = new RadioButton();
	@FXML
	private RadioButton meatButton = new RadioButton();

	@FXML
	private CheckBox cheeseCheckbox = new CheckBox();
	@FXML
	private CheckBox mushroomsCheckbox = new CheckBox();
	@FXML
	private CheckBox onionsCheckbox = new CheckBox();
	@FXML
	private CheckBox olivesCheckbox = new CheckBox();

	@FXML
	private Label nameLabel = new Label();

	@FXML
	private Label costLabel = new Label();
	@FXML
	private Spinner<Integer> pizzaCount = new Spinner<Integer>();
	// *****************************************************************

	// ****************** Checkout Scene Items *************************
	@FXML
	private ListView<String> customerCart = new ListView<String>();
	// *****************************************************************

	// ****************** Checkout Scene Items *************************
	@FXML
	private ListView<String> customerNameList = new ListView<String>();
	@FXML
	private ListView<String> customerItems = new ListView<String>();
	// *****************************************************************

	public void switchToHomeScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}

	public void switchToPizzaScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("PizzaPage.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}

	public void switchToCheckout(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Checkout.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}

	public void createPizza(ActionEvent e) throws IOException {
		if (pepperoniButton.isSelected()) {
			Pizza pizza = new Pizza("Pepperoni", cheeseCheckbox.isSelected(), onionsCheckbox.isSelected(),
					mushroomsCheckbox.isSelected(), olivesCheckbox.isSelected(), pizzaCount.getValue());
			Main.currentUser.addPizza(pizza);
		} else if (vegetableButton.isSelected()) {
			Pizza pizza = new Pizza("Vegetable", cheeseCheckbox.isSelected(), onionsCheckbox.isSelected(),
					mushroomsCheckbox.isSelected(), olivesCheckbox.isSelected(), pizzaCount.getValue());
			Main.currentUser.addPizza(pizza);
		} else if (meatButton.isSelected()) {
			Pizza pizza = new Pizza("Meat", cheeseCheckbox.isSelected(), onionsCheckbox.isSelected(),
					mushroomsCheckbox.isSelected(), olivesCheckbox.isSelected(), pizzaCount.getValue());
			Main.currentUser.addPizza(pizza);
		}

		// REFRESH OPTIONS AFTER ORDERING
		pepperoniButton.setSelected(true);
		costLabel.setText(String.format("%.2f", 9.99));
		pizzaCount.getValueFactory().setValue(1);
		cheeseCheckbox.setSelected(false);
		mushroomsCheckbox.setSelected(false);
		onionsCheckbox.setSelected(false);
		olivesCheckbox.setSelected(false);
	}

	public void switchToLoginScene(ActionEvent e) throws IOException {
		root = FXMLLoader.load(getClass().getResource("EmployeeLoginPage.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}

	public void switchToCustomerLoginScene(ActionEvent e) throws IOException {
			root = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			newScene = new Scene(root);
			stage.setScene(newScene);
			stage.show();
	}
	
	public void employeeReturn(ActionEvent e) throws IOException {
		Main.isLoggedIn = false;
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
}

	public void switchToEmployeeHome(ActionEvent e) throws IOException {
		if(employeeLogin(e))
		{
			root = FXMLLoader.load(getClass().getResource("EmployeeHomePage.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			newScene = new Scene(root);
			stage.setScene(newScene);
			stage.show();
		}
	}
	
	public void tryPay(ActionEvent e) throws IOException {
	
		if(Main.isLoggedIn)
		{
			Main.openOrders.add(Main.currentUser);
			Main.currentUser = new Customer(); // reset order
			
			//TODO: add "purchased" message AND io output for LRC
			
			root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			newScene = new Scene(root);
			stage.setScene(newScene);
			stage.show();
			
			Main.isLoggedIn = false;
		}
		else {
			Main.isPaying = true;
			root = FXMLLoader.load(getClass().getResource("CustomerLogin.fxml"));
			stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			newScene = new Scene(root);
			stage.setScene(newScene);
			stage.show();
		}
	}

	// FOR CUSTOMER LOGIN PAGE
	public boolean login(ActionEvent e) throws IOException {
		id = usernameTextField.getText().toString();
		password = passwordTextField.getText().toString();
		
		// Scanning to see if the login is valid
		try {
			File file = new File("login.txt");
			Scanner scanner = new Scanner(file);
			
			String loginInfo = "";
			char deliminiter = ':';
			
			while(scanner.hasNextLine())
			{
				loginInfo = scanner.nextLine();
				
				// If name and password are correct
				// I hate Java string equivalence
				if(loginInfo.substring(0, loginInfo.indexOf(deliminiter)).equals(id) 
				&& loginInfo.substring(loginInfo.indexOf(deliminiter)+1, loginInfo.length()).equals(password))
				{
					Main.currentUser.setName(id);
					
					if(Main.isPaying) {
						 // TEMP NAME FOR TESTING
						Main.openOrders.add(Main.currentUser);
						Main.currentUser = new Customer(); // reset order
						Main.isPaying = false;
					}
					
					root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
					stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
					newScene = new Scene(root);
					stage.setScene(newScene);
					stage.show();
					
					scanner.close();
					System.out.println("User: " + id + " has logged in successfully.");
					Main.isLoggedIn = true;
					return true;
				}
			}
			
			// Ask for valid login details
			scanner.close();
			System.out.println("Enter in a valid username and password.");
			return false;
			
		} catch(FileNotFoundException fileException) {
			System.out.println("The login file does not exist. Check the name and path of the file");
			return false;
		}
	}
	
	public boolean employeeLogin(ActionEvent e) throws IOException {
		id = usernameTextField.getText().toString();
		password = passwordTextField.getText().toString();
		
		// Scanning to see if the login is valid
		try {
			File file = new File("login.txt");
			Scanner scanner = new Scanner(file);
			
			String loginInfo = "";
			char deliminiter = ':';
			
			while(scanner.hasNextLine())
			{
				loginInfo = scanner.nextLine();
				
				// If name and password are correct
				// I hate Java string equivalence
				if(loginInfo.substring(0, loginInfo.indexOf(deliminiter)).equals(id) 
				&& loginInfo.substring(loginInfo.indexOf(deliminiter)+1, loginInfo.length()).equals(password))
				{
					scanner.close();
					System.out.println("User: " + id + " has logged in successfully.");
					Main.isLoggedIn = true;
					return true;
				}
			}
			
			// Ask for valid login details
			scanner.close();
			System.out.println("Enter in a valid username and password.");
			return false;
			
		} catch(FileNotFoundException fileException) {
			System.out.println("The login file does not exist. Check the name and path of the file");
			return false;
		}
	}

	public void deleteSelectedPizza(ActionEvent e) throws IOException {
		if (!customerCart.getSelectionModel().isEmpty()) { // make sure an item is actually selected
			int selectedItem = customerCart.getSelectionModel().getSelectedIndex(); // get current
			if (selectedItem != Main.currentUser.getCart().getPizzaList().size()) { // making sure it's not deleting the
																					// total cost
				Main.currentUser.getCart().removePizza(selectedItem); // delete pizza
				customerCart.getItems().clear(); // remove all items
				updatePizzaTable(); //
			}
		} else {
			// TODO: return error message?
		}
	}

	public void selectPizzaBase() {
		if (basePizzaToggleGroup.getSelectedToggle().equals(pepperoniButton))
			baseCost = 9.99;

		if (basePizzaToggleGroup.getSelectedToggle().equals(vegetableButton))
			baseCost = 9.99;

		if (basePizzaToggleGroup.getSelectedToggle().equals(meatButton))
			baseCost = 11.99;

		pizzaCostUpdated();
	}

	public void addToppings() {
		double newPrice = 0;

		if (cheeseCheckbox.isSelected())
			newPrice += 1.99;

		if (mushroomsCheckbox.isSelected())
			newPrice += 0.99;

		if (onionsCheckbox.isSelected())
			newPrice += 0.99;

		if (olivesCheckbox.isSelected())
			newPrice += 0.99;

		toppingsCost = newPrice;
		pizzaCostUpdated();
	}

	public void pizzaCostUpdated() {
		totalCost = (baseCost + toppingsCost) * pizzaCount.getValue();
		costLabel.setText(String.format("%.2f", totalCost));
	}

	public void updatePizzaTable() {
		// Adds pizzas to listview
		int n = Main.currentUser.getCart().getPizzaList().size();
		double totalCost = Main.currentUser.getCart().getTotalPrice();

		for (int i = 0; i < n; i++) {
			customerCart.getItems().add(Main.currentUser.getCart().getPizzaList().get(i).toString());
		}

		customerCart.getItems().add("TOTAL COST: " + new DecimalFormat("$#.00").format(totalCost));
	}

	public void updatePizzaButton(ActionEvent e) throws IOException {

		if (!customerNameList.getSelectionModel().isEmpty()) {
			int selectedUserIndex = customerNameList.getSelectionModel().getSelectedIndex(); // get user selected

			if (Main.openOrders.get(selectedUserIndex).updateCookingStage()) { //IF TRUE THEN ORDER IS FINISHED
				customerNameList.getSelectionModel().clearSelection();
				customerItems.getSelectionModel().clearSelection(); // REMOVE SELECTION FROM BOTH
				Main.openOrders.remove(selectedUserIndex); //REMOVED CUSTOMER FROM OPEN ORDERS
			}

			customerItems.getItems().clear();

			if (Main.openOrders.size() != 0) { //IF ORDER IS NOT DELETED THEN PUT THE ITEMS BACK
				for (int i = 0; i < Main.openOrders.get(selectedUserIndex).getCart().getPizzaList().size(); i++) {
					customerItems.getItems()
							.add(Main.openOrders.get(selectedUserIndex).getCart().getPizzaList().get(i).toString() + "("
									+ Main.openOrders.get(selectedUserIndex).getCookingStage() + ")");
				}
			}
			else { //ORDER IS DELETED
				customerNameList.getItems().clear();
			}
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		id = "";

		// Set the base pizza options and put into a toggle group
		pepperoniButton.setToggleGroup(basePizzaToggleGroup);
		vegetableButton.setToggleGroup(basePizzaToggleGroup);
		meatButton.setToggleGroup(basePizzaToggleGroup);

		// Set the default pizza selection and price
		pepperoniButton.setSelected(true);
		costLabel.setText(String.format("%.2f", 9.99));

		// Set the pizza spinner min-max values
		SpinnerValueFactory<Integer> pizzaCountFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
		pizzaCount.setValueFactory(pizzaCountFactory);

		// Adding Items To Cart
		updatePizzaTable();

		// Employee Page ___________________________________________
		customerItems.getItems().clear();
		customerNameList.getItems().clear();

		for (int i = 0; i < Main.openOrders.size(); i++) {
			customerNameList.getItems().add(Main.openOrders.get(i).getName());
		}

		// set listener for ListView
		customerNameList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				if (!customerNameList.getSelectionModel().isEmpty()) {
					int selectedIndex = customerNameList.getSelectionModel().getSelectedIndex();
					customerItems.getItems().clear(); // clear items

					for (int i = 0; i < Main.openOrders.get(selectedIndex).getCart().getPizzaList().size(); i++) {
						customerItems.getItems()
								.add(Main.openOrders.get(selectedIndex).getCart().getPizzaList().get(i).toString() + "("
										+ Main.openOrders.get(selectedIndex).getCookingStage() + ")");
					}
				}
			}
		});

	}
}
