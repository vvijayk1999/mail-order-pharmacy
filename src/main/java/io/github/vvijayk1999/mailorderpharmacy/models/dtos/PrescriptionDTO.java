package io.github.vvijayk1999.mailorderpharmacy.models.dtos;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PrescriptionDTO {

	private String insuranceProvider;
	private long policyNumber;
	private String doctorName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date prescriptionDate;

	private String location;
	private String drugId;
	private String definition;
	private int quantity;
	private int courseDuration;

	public PrescriptionDTO() {
	}

	public PrescriptionDTO(String insuranceProvider, long policyNumber, String doctorName, Date prescriptionDate,
			String location, String drugId, String definition, int quantity, int courseDuration) {
		super();
		this.insuranceProvider = insuranceProvider;
		this.policyNumber = policyNumber;
		this.doctorName = doctorName;
		this.prescriptionDate = prescriptionDate;
		this.location = location;
		this.drugId = drugId;
		this.definition = definition;
		this.quantity = quantity;
		this.courseDuration = courseDuration;
	}

	public String getInsuranceProvider() {
		return insuranceProvider;
	}

	public void setInsuranceProvider(String insuranceProvider) {
		this.insuranceProvider = insuranceProvider;
	}

	public long getPolicyNumber() {
		return policyNumber;
	}

	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public Date getPrescriptionDate() {
		return prescriptionDate;
	}

	public void setPrescriptionDate(Date prescriptionDate) {
		this.prescriptionDate = prescriptionDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDrugId() {
		return drugId;
	}

	public void setDrugId(String drugId) {
		this.drugId = drugId;
	}

	public String getDefinition() {
		return definition;
	}

	public void setDefinition(String definition) {
		this.definition = definition;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCourseDuration() {
		return courseDuration;
	}

	public void setCourseDuration(int courseDuration) {
		this.courseDuration = courseDuration;
	}

}
