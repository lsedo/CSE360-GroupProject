package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SceneObject {
	private Stage mainStage;
	private Scene currScene, nextScene, prevScene;
	private StackPane layout;
	
	// Constructor
	public SceneObject()
	{
		nextScene = null;
		prevScene = null;
	}
	
	// Creates a Scene with its own layout
	public void InitializeScene(Stage stage, int width, int height)
	{
		mainStage = stage;
		layout = new StackPane();
		currScene = new Scene(layout, width, height);
	}
	
	public void AddButton(Button button) { layout.getChildren().add(button); }
	
	public void GotoNextScene() { mainStage.setScene(nextScene); }
	
	public void GotoPrevScene() { mainStage.setScene(prevScene); }
	
	public Scene GetScene() { return currScene; }
	
	public void SetNextScene(Scene scene) { nextScene = scene; }
	
	public void SetPreviousScene(Scene scene) { prevScene = scene; }
}
