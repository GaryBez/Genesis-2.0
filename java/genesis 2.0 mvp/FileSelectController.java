package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class FileSelectController {
	
	@FXML
	private Button btnFileChooserData;
	private String file_path;
	
	public String ButtonOneAction(ActionEvent event) throws FileNotFoundException {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File ("C:\\Users\\grbez\\Desktop\\Genesis\\genesis-master\\examples\\PCA"));
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Evec Files", "*.evec"));
		File selectedFile = fc.showOpenDialog(null);
		
		if (selectedFile != null) {
			file_path = selectedFile.getAbsolutePath();
			return file_path; 
			}
		else {
			System.out.println("file does not exist!");
			return null;
		}
	}

}
