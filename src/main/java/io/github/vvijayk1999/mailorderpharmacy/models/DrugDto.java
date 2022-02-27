package io.github.vvijayk1999.mailorderpharmacy.models;

import java.util.Date;

public class DrugDto {

	private String drugId;
	private String drugName;
	private String manufacturer;
	private Date mnfDate;
	private Date expDate;
	private String location;
	private int quantity;

	public DrugDto() {
		super();
	}

	public DrugDto(String drugId, String location, String drugName, String manufacturer, Date mnfDate, Date expDate,
			int quantity) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.manufacturer = manufacturer;
		this.mnfDate = mnfDate;
		this.expDate = expDate;
		this.location = location;
		this.quantity = quantity;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public Date getMnfDate() {
		return mnfDate;
	}

	public void setMnfDate(Date mnfDate) {
		this.mnfDate = mnfDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
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
