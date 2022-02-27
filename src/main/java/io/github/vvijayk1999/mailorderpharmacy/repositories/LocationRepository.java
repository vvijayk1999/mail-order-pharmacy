package io.github.vvijayk1999.mailorderpharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.vvijayk1999.mailorderpharmacy.models.LocationId;
import io.github.vvijayk1999.mailorderpharmacy.models.LocationQuantity;

public interface LocationRepository extends CrudRepository<LocationQuantity, LocationId> {

	List<LocationQuantity> findAllByDrugId(String drugId);

}
