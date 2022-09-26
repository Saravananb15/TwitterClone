package com.tweetapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tweetapp.entities.UsersEntity;
import com.tweetapp.repo.UsersRepo;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UsersRepo userRepository;

	public UserDetails loadUserByUsername(String loginId) throws UsernameNotFoundException {
		UsersEntity user = userRepository.findByLoginId(loginId);
		if (user.getLoginId() == null) {
			throw new UsernameNotFoundException(loginId);
		} else {
			AppUser appUser = new AppUser(user);
			return appUser;
		}
	}
}
