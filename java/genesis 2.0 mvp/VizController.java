package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class VizController {
	
	@FXML ScatterChart<Number, Number> scatterplot;
	
	@FXML
	private Button btnFileChooserData;
	private Button btnFileChooserPheno;
	private String file_path_data;
	private PCASubject[] data_list;
	private XYChart.Series<Number, Number> pcaSeries = new XYChart.Series<Number, Number>();
	
	public void ButtonDataAction(ActionEvent event) throws IOException {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File ("C:\\Users\\grbez\\Desktop\\Genesis\\genesis-master\\examples\\PCA"));
		fc.getExtensionFilters().addAll(
				new ExtensionFilter("Evec Files", "*.evec"));
		File selectedFile = fc.showOpenDialog(null);
		
		if (selectedFile != null) {
			file_path_data = selectedFile.getAbsolutePath();
			System.out.println(file_path_data);
			InputPCAData input = new InputPCAData();
			data_list = input.readPCAInput(file_path_data);
			}
		else {
			System.out.println("file does not exist!");
		}
		
		
		for(int j=0;j<data_list.length;j++) {
			pcaSeries.getData().add(new XYChart.Data<Number, Number>(data_list[j].getData()[0], data_list[j].getData()[1]));
			System.out.println(pcaSeries.getData().get(j));
		}
		
	}
	
//	public String ButtonPhenoAction(ActionEvent event) throws FileNotFoundException {
//		FileChooser fc = new FileChooser();
//		fc.setInitialDirectory(new File ("C:\\Users\\grbez\\Desktop\\Genesis\\genesis-master\\examples\\PCA"));
//		fc.getExtensionFilters().addAll(
//				new ExtensionFilter("Phe Files", "*.phe"));
//		File selectedFile = fc.showOpenDialog(null);
//		
//		if (selectedFile != null) {
//			file_path_data = selectedFile.getAbsolutePath();
//			System.out.println(file_path_data);
//			return file_path_data; 
//			}
//		else {
//			System.out.println("file does not exist!");
//			return null;
//		}
//	}
	
	public void ButtonPlotAction(ActionEvent event) {
		System.out.println("Watsup");
		scatterplot.getData().add(pcaSeries);
	}
	
	
}
