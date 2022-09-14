package application;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class Main extends Application {
	Text message;
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("FX Demo");
		
		message = new Text("Hello World");
		message.setFont(Font.font("Impact", 36));
		
		StackPane stackPane = new StackPane();
		stackPane.getChildren().add(message);;
		
		Scene scene = new Scene(stackPane, 300, 200);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
