package io.github.vvijayk1999.mailorderpharmacy.models;

import java.util.List;

public class DrugLocation {

	private Drug drug;
	private List<LocationQuantity> locations;

	public DrugLocation() {
		super();
	}

	public DrugLocation(Drug drug, List<LocationQuantity> location) {
		super();
		this.drug = drug;
		this.locations = location;
	}

	public Drug getDrug() {
		return drug;
	}

	public void setDrug(Drug drug) {
		this.drug = drug;
	}

	public List<LocationQuantity> getLocations() {
		return locations;
	}

	public void setLocations(List<LocationQuantity> locations) {
		this.locations = locations;
	}

}
