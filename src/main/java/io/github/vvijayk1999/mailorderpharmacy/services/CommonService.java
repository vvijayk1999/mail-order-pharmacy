package io.github.vvijayk1999.mailorderpharmacy.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.github.vvijayk1999.mailorderpharmacy.models.User;
import io.github.vvijayk1999.mailorderpharmacy.repositories.UserRepository;

@Service
public class CommonService {

	@Autowired
	UserRepository userRepository;

	public String getLoggedinUsername() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user;
		if (principal instanceof UserDetails) {
			user = userRepository.findByEmailId(((UserDetails) principal).getUsername());
		} else {
			user = userRepository.findByEmailId(principal.toString());
		}
		if (user == null) {
			return null;
		}
		return user.getFirstName() + " " + user.getLastName();
	}

	public String getLoggedinEmailId() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			return ((UserDetails) principal).getUsername();
		}
		return principal.toString();
	}
}
