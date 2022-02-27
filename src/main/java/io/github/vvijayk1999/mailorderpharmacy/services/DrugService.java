package io.github.vvijayk1999.mailorderpharmacy.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.vvijayk1999.mailorderpharmacy.models.Drug;
import io.github.vvijayk1999.mailorderpharmacy.models.DrugLocation;
import io.github.vvijayk1999.mailorderpharmacy.models.LocationQuantity;
import io.github.vvijayk1999.mailorderpharmacy.repositories.DrugRepository;
import io.github.vvijayk1999.mailorderpharmacy.repositories.LocationRepository;

@Service
public class DrugService {

	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	DrugRepository drugRepository;

	@Autowired
	LocationRepository locationRepository;

	public List<DrugLocation> getAllDrugsNested() {

		Iterable<Drug> drugIterable = drugRepository.findAll();
		List<Drug> drugs = new ArrayList<Drug>();
		drugIterable.forEach(drugs::add);

		return getDrugLocationsByDrugs(drugs);
	}

	public List<DrugLocation> getDrugsByIdNested(String drugId) {

		return getDrugLocationsByDrugs(drugRepository.findByDrugIdContaining(drugId));
	}

	public List<DrugLocation> getDrugsByNameNested(String drugName) {

		return getDrugLocationsByDrugs(drugRepository.findByDrugNameContaining(drugName));
	}

	private List<DrugLocation> getDrugLocationsByDrugs(List<Drug> drugs) {
		List<DrugLocation> drugLocation = new ArrayList<DrugLocation>();
		drugs.forEach((drug) -> {
			List<LocationQuantity> locations = locationRepository.findAllByDrugId(drug.getDrugId());

			drugLocation.add(new DrugLocation(drug, locations));
		});

		return drugLocation;
	}
}
