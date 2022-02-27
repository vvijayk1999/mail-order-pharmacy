package io.github.vvijayk1999.mailorderpharmacy.models;

import java.io.Serializable;

@SuppressWarnings("serial")
public class LocationId implements Serializable {

	private String drugId;
	private String location;

	public LocationId() {
		super();
	}

	public LocationId(String drugId, String location) {
		super();
		this.drugId = drugId;
		this.location = location;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((drugId == null) ? 0 : drugId.hashCode());
		result = prime * result + ((location == null) ? 0 : location.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LocationId other = (LocationId) obj;
		if (drugId == null) {
			if (other.drugId != null)
				return false;
		} else if (!drugId.equals(other.drugId))
			return false;
		if (location == null) {
			if (other.location != null)
				return false;
		} else if (!location.equals(other.location))
			return false;
		return true;
	}

}
