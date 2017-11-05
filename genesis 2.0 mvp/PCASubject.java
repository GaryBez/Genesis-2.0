package application;

import java.io.Serializable;

public class PCASubject implements Serializable {
	
	private static final long serialVersionUID = 6997827831785759993L; //double check this number
	private float[] values; //contains the data.
	private  String name;
	private  String controlTag; //this holds that last word in the line
	private  String[] phenotypeData;
	
	private PCAPopulationGroup group;  //need to come back and implement grouping code
	
	public PCASubject(float[] values, String name) {
		this.name = name;
		this.values = values;
	}
	
	public String getName() {
		return name;
	}
	
	public float[] getData() {
		return values;
	}
	
	public String getControlTag() {
		return controlTag;
	}
	
	public int getNumComponents() {
		return values.length;
	}
	
	public void setPhenoData(String[] phenoData) {
		this.phenotypeData = phenoData;
	}
	
	public String[] getPhenoData() {
		return phenotypeData;
	}
	
	public boolean hasPhenoData() {
		if (phenotypeData==null) {
			return false;
		}
		else {
			return true;
		}
	}

}
