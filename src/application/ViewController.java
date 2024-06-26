package application;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ViewController implements Initializable {

	@FXML
	private Button backBtn;
	@FXML
	private Label nameLabel;
	@FXML
	private ImageView imagebox;
	
	private Scene preScene;
	
	private Stage stage;
	
	public void setPreScene(Scene preScene) {
		this.preScene = preScene;
	};
	
	// have an image viewer method for the image
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	    // Load the image and set it to the ImageView
	    Image image = new Image(getClass().getResourceAsStream("truck plans/SW-0148.jpg"));
	    imagebox.setImage(image);
	}
	
	
	// back button for going back to original scene.

	public void backBtn(ActionEvent event) throws IOException {
		System.out.println("you have clicked the back button chich");
		
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(preScene);
        stage.show();
				
	}


	
	
	
}
