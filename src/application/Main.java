package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	//I CAN'T BELIEVE THIS WORKS but we can use this to keep track of the current customer and their cart
	public static Customer currentUser = new Customer();
	public static List<Customer> openOrders = new ArrayList<Customer>(); //This can add customer orders
	public static boolean isLoggedIn = false; //default NOT logged in
	public static boolean isPaying = false;
	
	public static void main(String[] args) 
	{
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException
	{	
		Parent parent = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene home = new Scene(parent);
		stage.setScene(home);
		stage.setTitle("SunDevil Pizza");
		stage.show();
	}
}
