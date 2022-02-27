package io.github.vvijayk1999.mailorderpharmacy.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Drug {

	@Id
	private String drugId;

	private String drugName;
	private String manufacturer;
	private Date mnfDate;
	private Date expDate;

	public Drug() {
		super();
	}

	public Drug(String drugId, String drugName, String manufacturer, Date mnfDate, Date expDate) {
		super();
		this.drugId = drugId;
		this.drugName = drugName;
		this.manufacturer = manufacturer;
		this.mnfDate = mnfDate;
		this.expDate = expDate;
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
}
