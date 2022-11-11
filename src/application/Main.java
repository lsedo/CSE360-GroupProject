package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	
	//I CAN'T BELIEVE THIS WORKS but we can use this to keep track of the current customer and their cart
	public static boolean isCurrentlyLoggedIn = false;
	public static Customer currentUser = new Customer();
	
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
