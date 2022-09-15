package application;

import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.application.Application;

public class Main extends Application {
	
	Stage main;
	SceneObject[] sceneArray = new SceneObject[4];
	Button startButton, cartButton, orderButton, homeButton;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{	
		main = primaryStage;
		CreateScenes();
		
		// Home page
		startButton = new Button("Start Order");
		sceneArray[0].AddButton(startButton);
		startButton.setOnAction(e -> sceneArray[0].GotoNextScene());
		
		// Pizza Assembly page
		cartButton = new Button("Add to Cart");
		sceneArray[1].AddButton(cartButton);
		cartButton.setOnAction(e -> sceneArray[1].GotoNextScene());
		
		// Cart page
		orderButton = new Button("Submit Order");
		sceneArray[2].AddButton(orderButton);
		orderButton.setOnAction(e -> sceneArray[2].GotoNextScene());
		
		// Order status page
		homeButton = new Button("Go Back to Home Page");
		sceneArray[3].AddButton(homeButton);
		homeButton.setOnAction(e -> sceneArray[3].GotoNextScene());
		
		primaryStage.setTitle("SunDevil Pizza");
		primaryStage.setScene(sceneArray[0].GetScene());
		primaryStage.show();
	}
	
	/// Fills the array of SceneObjects and create the scenes
	/// Also fills the next and prev scene pointers
	public void CreateScenes()
	{	
		for(int i = 0; i < sceneArray.length; i++)
		{
			sceneArray[i] = new SceneObject();
			sceneArray[i].InitializeScene(main, 640, 480);
		}
		
		for(int i = 0; i < sceneArray.length; i++)
		{
			if(i == 0) sceneArray[i].SetNextScene(sceneArray[i+1].GetScene());
			else if(i == sceneArray.length-1)
			{
				sceneArray[i].SetNextScene(sceneArray[0].GetScene());
				sceneArray[i].SetPreviousScene(sceneArray[i-1].GetScene());
			}
			else
			{
				sceneArray[i].SetNextScene(sceneArray[i+1].GetScene());
				sceneArray[i].SetPreviousScene(sceneArray[i-1].GetScene());
			}
		}
	}
}
