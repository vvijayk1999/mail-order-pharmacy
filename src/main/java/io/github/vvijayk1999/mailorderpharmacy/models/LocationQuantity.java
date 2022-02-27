package io.github.vvijayk1999.mailorderpharmacy.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(LocationId.class)
public class LocationQuantity {

	@Id
	private String drugId;

	@Id
	private long locationId;

	private String location;

	private int quantity;

	public LocationQuantity() {
		super();
	}

	public LocationQuantity(String drugId, long locationId, String location, int quantity) {
		super();
		this.drugId = drugId;
		this.locationId = locationId;
		this.location = location;
		this.quantity = quantity;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
