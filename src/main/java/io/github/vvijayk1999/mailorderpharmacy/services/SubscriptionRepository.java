package io.github.vvijayk1999.mailorderpharmacy.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import io.github.vvijayk1999.mailorderpharmacy.models.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

	public List<Subscription> findAllBySubscriptionId(long subscriptionId);

	public List<Subscription> findAllByEmailId(String emailId);

	public Subscription findBySubscriptionId(long subscriptionId);
}
