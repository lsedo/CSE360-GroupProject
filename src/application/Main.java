package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class Main extends Application {
	Scene homeScene, pizzaAsm, cartScene, checkoutScene;
	
	Button startButton, cartButton, orderButton, homeButton;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		
		/// TODO: Add classes for each scene for easier code reuse
		/// This is subject to change
		/// Functional demo
		StackPane stackPane1 = new StackPane();
		StackPane stackPane2 = new StackPane();
		StackPane stackPane3 = new StackPane();
		StackPane stackPane4 = new StackPane();
		
		// Initializing each scene
		homeScene = new Scene(stackPane1, 640, 480);
		pizzaAsm = new Scene(stackPane2, 640, 480);
		cartScene = new Scene(stackPane3, 640, 480);
		checkoutScene = new Scene(stackPane4, 640, 480);
		
		// Home page
		startButton = new Button("Start Order");
		startButton.setOnAction(e -> primaryStage.setScene(pizzaAsm));
		
		// Pizza Assembly page
		cartButton = new Button("Add to Cart");
		cartButton.setOnAction(e -> primaryStage.setScene(cartScene));
		
		// Cart page
		orderButton = new Button("Submit Order");
		orderButton.setOnAction(e -> primaryStage.setScene(checkoutScene));
		
		// Order status page
		homeButton = new Button("Go Back to Home Page");
		homeButton.setOnAction(e -> primaryStage.setScene(homeScene));
		
		stackPane1.getChildren().add(startButton);
		stackPane2.getChildren().add(cartButton);;
		stackPane3.getChildren().add(orderButton);;
		stackPane4.getChildren().add(homeButton);;
		
		primaryStage.setTitle("SunDevil Pizza");
		primaryStage.setScene(homeScene);
		primaryStage.show();
	}
}
