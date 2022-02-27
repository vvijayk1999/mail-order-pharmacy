package io.github.vvijayk1999.mailorderpharmacy.repositories;

import org.springframework.data.repository.CrudRepository;

import io.github.vvijayk1999.mailorderpharmacy.models.User;

public interface UserRepository extends CrudRepository<User, Long> {

	public User findByEmailId(String username);
}
