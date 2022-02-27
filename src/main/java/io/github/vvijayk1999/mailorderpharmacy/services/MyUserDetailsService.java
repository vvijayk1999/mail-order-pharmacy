package io.github.vvijayk1999.mailorderpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.github.vvijayk1999.mailorderpharmacy.exceptions.UsernameAlreadyExistsException;
import io.github.vvijayk1999.mailorderpharmacy.models.User;
import io.github.vvijayk1999.mailorderpharmacy.repositories.UserPrincipal;
import io.github.vvijayk1999.mailorderpharmacy.repositories.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {

		User user = userRepository.findByEmailId(emailId);

		if (user == null)
			throw new UsernameNotFoundException("User does not exist in DB");
		return new UserPrincipal(user);
	}

	public User save(User user) throws UsernameAlreadyExistsException {

		User repouser = userRepository.findByEmailId(user.getEmailId());
		if (repouser != null) {
			throw new UsernameAlreadyExistsException(
					"User with email-id '" + user.getEmailId() + "' already exists. Try logging in.");
		}

		User encryptedUser = new User(user.getEmailId(), user.getPhoneNumber(),
				passwordEncoder.encode(user.getPassword()), user.getFirstName(), user.getLastName());

		return userRepository.save(encryptedUser);
	}

}
