package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class SceneControls implements Initializable {
	
	private Stage stage;
	private Scene newScene;
	private Parent root;
	
	// Costs for the pizza
	private double baseCost = 0,
			toppingsCost = 0,
			totalCost = 0;
	
	// ******************* Pizza Scene Items **************************
	private ToggleGroup basePizzaToggleGroup = new ToggleGroup();
	@FXML private RadioButton pepperoniButton = new RadioButton();
	@FXML private RadioButton vegetableButton = new RadioButton();
	@FXML private RadioButton meatButton = new RadioButton();
	
	@FXML private CheckBox cheeseCheckbox = new CheckBox();
	@FXML private CheckBox mushroomsCheckbox = new CheckBox();
	@FXML private CheckBox onionsCheckbox = new CheckBox();
	@FXML private CheckBox olivesCheckbox = new CheckBox();
	
	@FXML private Label costLabel;
	@FXML private Spinner<Integer> pizzaCount = new Spinner<Integer>();
	// *****************************************************************
	
	public void switchToHomeScene(ActionEvent e) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}
	
	public void switchToPizzaScene(ActionEvent e) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("PizzaPage.fxml"));
		stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		newScene = new Scene(root);
		stage.setScene(newScene);
		stage.show();
	}
	
	public void selectPizzaBase()
	{
		if(basePizzaToggleGroup.getSelectedToggle().equals(pepperoniButton)) baseCost = 9.99;
		
		if(basePizzaToggleGroup.getSelectedToggle().equals(vegetableButton)) baseCost = 9.99;
		
		if(basePizzaToggleGroup.getSelectedToggle().equals(meatButton)) baseCost = 11.99;
		
		pizzaCostUpdated();
	}
	
	public void addToppings()
	{
		double newPrice = 0;
		
		if(cheeseCheckbox.isSelected()) newPrice += 1.99;
		
		if(mushroomsCheckbox.isSelected()) newPrice += 0.99;
		
		if(onionsCheckbox.isSelected()) newPrice += 0.99;
		
		if(olivesCheckbox.isSelected()) newPrice += 0.99;
		
		toppingsCost = newPrice;
		pizzaCostUpdated();
	}
	
	public void pizzaCostUpdated()
	{
		totalCost = (baseCost + toppingsCost) * pizzaCount.getValue();
		costLabel.setText(String.format("%.2f", totalCost));
	}

	@Override
	public void initialize(URL url, ResourceBundle rb)
	{
		// Set the base pizza options and put into a toggle group
		pepperoniButton.setToggleGroup(basePizzaToggleGroup);
		vegetableButton.setToggleGroup(basePizzaToggleGroup);
		meatButton.setToggleGroup(basePizzaToggleGroup);
		
		// Set the pizza spinner min-max values
		SpinnerValueFactory<Integer> pizzaCountFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 10, 1);
		pizzaCount.setValueFactory(pizzaCountFactory);
	}
}