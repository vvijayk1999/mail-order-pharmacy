package io.github.vvijayk1999.mailorderpharmacy.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.vvijayk1999.mailorderpharmacy.models.Drug;

public interface DrugRepository extends CrudRepository<Drug, String> {

	List<Drug> findByDrugIdContaining(String drugId);

	List<Drug> findByDrugNameContaining(String drugName);

}
