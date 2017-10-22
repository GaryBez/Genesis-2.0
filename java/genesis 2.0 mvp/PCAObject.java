package application;

import javafx.scene.Node;

public class PCAObject{
	private Node node;
	private PCASubject subject;
	private String colour;
	private String icon;
	
	public String getNode() {
		return node.getId();
	}
	
	public void setNodeID(Node point) {
		this.node.setId(point.getId()); 
	}
	
	public PCASubject getSubj() {
		return subject;
	}
	
	public void setSubj(PCASubject subj) {
		this.subject = subj;
	}	
}
