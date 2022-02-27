package io.github.vvijayk1999.mailorderpharmacy.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Subscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subscriptionId;
	private String emailId;
	private String drugName;
	private int refillCycle;
	private boolean status;
	private Date subscriptionDate;
	private String insuranceProvider;
	private long policyNumber;
	private String doctorName;
	private Date prescriptionDate;
	private String location;
	private String drugId;
	private String definition;
	private int quantity;
	private int courseDuration;

	public Subscription() {
		super();
	}

	public Subscription(String emailId, String drugName, int refillCycle, boolean status, Date subscriptionDate,
			String insuranceProvider, long policyNumber, String doctorName, Date prescriptionDate, String location,
			String drugId, String definition, int quantity, int courseDuration) {
		super();
		this.emailId = emailId;
		this.drugName = drugName;
		this.refillCycle = refillCycle;
		this.status = status;
		this.subscriptionDate = subscriptionDate;
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

	public long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String username) {
		this.emailId = username;
	}

	public String getDrugName() {
		return drugName;
	}

	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}

	public int getRefillCycle() {
		return refillCycle;
	}

	public void setRefillCycle(int refillCycle) {
		this.refillCycle = refillCycle;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Date getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(Date subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
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
