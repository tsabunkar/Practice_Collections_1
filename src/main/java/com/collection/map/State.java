package com.collection.map;

public class State {

	private String stateName;

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	@Override
	public String toString() {
		return "State [stateName=" + stateName + "]";
	}

	public State(String stateName) {
		super();
		this.stateName = stateName;
	}
	
	
}
