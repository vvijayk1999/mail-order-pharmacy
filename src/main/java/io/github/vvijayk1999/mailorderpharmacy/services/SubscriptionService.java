package io.github.vvijayk1999.mailorderpharmacy.services;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.vvijayk1999.mailorderpharmacy.exceptions.DrugNotFoundException;
import io.github.vvijayk1999.mailorderpharmacy.exceptions.UnauthorizedAccessException;
import io.github.vvijayk1999.mailorderpharmacy.models.LocationId;
import io.github.vvijayk1999.mailorderpharmacy.models.LocationQuantity;
import io.github.vvijayk1999.mailorderpharmacy.models.Subscription;
import io.github.vvijayk1999.mailorderpharmacy.models.dtos.PrescriptionDTO;
import io.github.vvijayk1999.mailorderpharmacy.repositories.DrugRepository;
import io.github.vvijayk1999.mailorderpharmacy.repositories.LocationRepository;

@Service
public class SubscriptionService {

	@Autowired
	public SubscriptionRepository subscriptionRepository;

	@Autowired
	public DrugRepository drugRepository;

	@Autowired
	public LocationRepository locationRepository;

	@Autowired
	public CommonService commonService;

	public boolean subscribe(PrescriptionDTO prescription) throws DrugNotFoundException {

		// Check if given drug is available
		LocationQuantity location;
		try {
			location = locationRepository.findById(new LocationId(prescription.getDrugId(), prescription.getLocation()))
					.get();
		} catch (NoSuchElementException e) {
			throw new DrugNotFoundException("Drug with ID '" + prescription.getDrugId()
					+ "' is not available in location '" + prescription.getLocation() + "' at the moment.");
		}

		if (prescription.getQuantity() > location.getQuantity()) {
			throw new DrugNotFoundException("Drug quantity " + prescription.getQuantity() + " is inadequate.");
		}

		location.setQuantity(location.getQuantity() - prescription.getQuantity());

		// Update location table
		locationRepository.save(location);

		Subscription subscription = new Subscription(commonService.getLoggedinEmailId(),
				drugRepository.findById(prescription.getDrugId()).get().getDrugName(), 0, true, new Date(),
				prescription.getInsuranceProvider(), prescription.getPolicyNumber(), prescription.getDoctorName(),
				prescription.getPrescriptionDate(), prescription.getLocation(), prescription.getDrugId(),
				prescription.getDefinition(), prescription.getQuantity(), prescription.getCourseDuration());

		subscriptionRepository.save(subscription);

		return true;
	}

	public List<Subscription> getSubscriptions(String emailId) {
		return subscriptionRepository.findAllByEmailId(emailId);
	}

	public String getEmailId(long subscriptionId) throws NoSuchElementException {
		Subscription subscription = subscriptionRepository.findBySubscriptionId(subscriptionId);
		if (subscription == null) {
			return null;
		}
		return subscription.getEmailId();
	}

	public boolean updateSubscription(long subscriptionId, int quantity, int courseDuration)
			throws DrugNotFoundException {
		Subscription subscription = subscriptionRepository.findById(subscriptionId).get();

		LocationQuantity location = locationRepository
				.findById(new LocationId(subscription.getDrugId(), subscription.getLocation())).get();

		if (quantity > location.getQuantity()) {
			throw new DrugNotFoundException("Drug quantity " + quantity + " is inadequate.");
		}

		// Update subscription entity
		subscription.setQuantity(subscription.getQuantity() + quantity);
		subscription.setCourseDuration(subscription.getCourseDuration() + courseDuration);
		subscription.setRefillCycle(subscription.getRefillCycle() + 1);
		subscriptionRepository.save(subscription);

		// Update location entity
		location.setQuantity(location.getQuantity() - quantity);
		locationRepository.save(location);

		return true;
	}

	public boolean unsubscribe(long subscriptionId) throws NoSuchElementException, UnauthorizedAccessException {

		String loggedInEmailId = commonService.getLoggedinEmailId();
		String unsubEmailId = getEmailId(subscriptionId);

		if (!loggedInEmailId.equals(unsubEmailId)) {
			throw new UnauthorizedAccessException("You are not Authorized to perform this action.");
		}

		Subscription subscription = subscriptionRepository.findById(subscriptionId).get();
		subscriptionRepository.delete(subscription);
		return true;

	}

	public boolean refill(long subscriptionId, PrescriptionDTO prescription)
			throws UnauthorizedAccessException, NoSuchElementException, DrugNotFoundException {
		String loggedInEmailId = commonService.getLoggedinEmailId();
		String unsubEmailId = getEmailId(subscriptionId);

		if (!loggedInEmailId.equals(unsubEmailId)) {
			throw new UnauthorizedAccessException("You are not Authorized to perform this action.");
		}
		updateSubscription(subscriptionId, prescription.getQuantity(), prescription.getCourseDuration());
		return true;
	}

	public PrescriptionDTO getRefill(long subscriptionId) throws UnauthorizedAccessException {
		String loggedInEmailId = commonService.getLoggedinEmailId();
		String unsubEmailId;
		PrescriptionDTO prescription;
		try {
			unsubEmailId = getEmailId(subscriptionId);
			Subscription subscription = subscriptionRepository.findById(subscriptionId).get();
			prescription = new PrescriptionDTO(subscription.getInsuranceProvider(), subscription.getPolicyNumber(),
					subscription.getDoctorName(), subscription.getPrescriptionDate(), subscription.getLocation(),
					subscription.getDrugId(), subscription.getDefinition(), subscription.getQuantity(),
					subscription.getCourseDuration());

		} catch (NoSuchElementException e) {
			throw new UnauthorizedAccessException("You are not Authorized to perform this action.");
		}
		if (!loggedInEmailId.equals(unsubEmailId)) {
			throw new UnauthorizedAccessException("You are not Authorized to perform this action.");
		}
		return prescription;

	}
}
