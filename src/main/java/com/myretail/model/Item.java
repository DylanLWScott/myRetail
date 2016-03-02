package com.myretail.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Item {
	private String general_description;

	public String getGeneral_description() {
		return general_description;
	}

	public void setGeneral_description(String general_description) {
		this.general_description = general_description;
	}

}
