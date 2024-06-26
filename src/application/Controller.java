package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller implements Initializable {

	// calling the FXML for the scene to change back!
	@FXML
    private Button hpsBtn;

	@FXML
	private Label myLabel;

	@FXML
	private ListView<String> listView;


	String selectedPlanNumber;
	String doubleClickedId;
	
	String[] planNumbers = {"SW-0148", "FL-1044", "RO-1542", "SW-1042"};

	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				// store the selected item in variable
				selectedPlanNumber = listView.getSelectionModel().getSelectedItem();		
				// if statement for if the item is double clicked.
				myLabel.setText(selectedPlanNumber);
				
				
				
			}});
	
		listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
	    
			@Override
			public void handle(MouseEvent click) {
	        
				if (click.getClickCount() == 2) {
	            // Use ListView's getSelectedItem to get the current selected item
	            doubleClickedId = listView.getSelectionModel().getSelectedItem();
	            // Perform any action you want (e.g., open a link)
	            System.out.println("you have doubleclicked! " + doubleClickedId);
	            
		            try {

		            	// i want to load the imageviewer.fxml without creating a new stage
		            	
		            	
		            	// Load the new scene from an FXML file (replace with your own path)
		                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("imageviewer.fxml"));
		                Parent root = fxmlLoader.load();
		                
		                /*
		                 * Pass the current scene before jumping to the new scene, 
		                 * then when you want to go back to the previous scene, 
		                 * set the scene as the passed one.
		                 */
		                ViewController viewController = fxmlLoader.getController();
		                viewController.setPreScene(hpsBtn.getScene());
		                
		                // get the current stage 
		                Stage stage = (Stage) listView.getScene().getWindow();
		                
		                // Create a new scene with the root node loaded from the new FXML file
		                Scene newScene = new Scene(root);
		                
		                // Set the new scene to the current stage
		                stage.setScene(newScene);
   
		                
		                
		                
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
	            
	            
	        }
	    }
	});
	
	}

	public void hps(ActionEvent e) {
		System.out.println("button pressed to load planID numbers");

		listView.getItems().clear();
		listView.getItems().addAll(planNumbers);

	};

};




