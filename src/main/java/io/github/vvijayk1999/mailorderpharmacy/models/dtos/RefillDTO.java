package io.github.vvijayk1999.mailorderpharmacy.models.dtos;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class RefillDTO {
	@Min(value = 1, message = "Quantity must be minimum of 1.")
	@Max(value = 500, message = "Quantity must be maximum of 500.")
	private int quantity;

	@Min(value = 6, message = "Quantity must be minimum of 6.")
	@Max(value = 180, message = "Quantity must be maximum of 180.")
	private int courseDuration;

	public RefillDTO() {
		super();
	}

	public RefillDTO(int quantity, int courseDuration) {
		super();
		this.quantity = quantity;
		this.courseDuration = courseDuration;
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
