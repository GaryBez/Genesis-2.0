package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;

public class MainController {
	
	@FXML ScatterChart<Number, Number> scatterPlot;
	
	
	public void btnPlot(ActionEvent event) {
		
		XYChart.Series<Number, Number> pcaSeries = new XYChart.Series<Number, Number>();
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.7, -0.278));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.2, 0.74));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.84, -0.23));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.15, 0.15));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.56, 0.99));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.93, -0.42));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.20, -0.218));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.11, -0.453));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.54, -0.42));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.69, 0.79));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.75, 0.92));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.71, -0.84));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.45, 0.12));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.23, -0.422));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.32, -0.763));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.88, -0.825));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.15, 0.431));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.43, -0.911));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.67, 0.77));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.51, -0.6));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.66, 0.5));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(0.28, -0.5));
		pcaSeries.getData().add(new XYChart.Data<Number, Number>(-0.3, 0.214));
		
		scatterPlot.getData().add(pcaSeries);
		Node test = pcaSeries.getNode();
		
		for (final XYChart.Data<Number, Number> data:pcaSeries.getData()) {
			Node newNode = data.getNode();
			newNode.setId("Is it working?");
		}
		
		
		for (final XYChart.Data<Number, Number> data: pcaSeries.getData())  {
			
			data.getNode().addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
//					
					Tooltip.install(data.getNode(), new Tooltip("X: " + data.getXValue() + "\n Y: " + String.valueOf(data.getYValue())));
					
					
				}
				
			});
			
			data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
				
				@Override
				public void handle(MouseEvent event) {
//					
					
					data.getNode().setStyle("-fx-shape: 'M 20.0 20.0  v24.0 h 10.0  v-24   Z'");
					System.out.println(data.getNode());
				}
				
			});
		}
		
		
		
	}
	
	

	

}
