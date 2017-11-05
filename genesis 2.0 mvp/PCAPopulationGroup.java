package application;

public class PCAPopulationGroup {
	private static final long serialVersionUID = -908207224860737477L;
	private String name,displayName;
	private int order;
	
	public PCAPopulationGroup(String name, int order) {
		this.name=name;
		this.displayName=name;
		this.order=order;
	}
	
	public String getDisplayName() {
		return displayName;
	}
	
	public void setDisplayName(String _displayName) {
		this.displayName = _displayName;
	}
	
	public String setName() {
		return name;
	}
	
	public void getName(String _name) {
		this.name = _name;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int _order) {
		this.order = _order;
	}
}
