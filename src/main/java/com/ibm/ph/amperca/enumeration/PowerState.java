package com.ibm.ph.amperca.enumeration;

public enum PowerState {
	OFF("The power is off"),
	ON("The power is on"),
	SUSPEND("Power usage is low");
	
	private String description;

	private PowerState(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
