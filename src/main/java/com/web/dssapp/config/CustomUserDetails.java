package com.web.dssapp.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.web.dssapp.model.Role;
import com.web.dssapp.model.User;
import com.web.dssapp.repository.RoleRepository;
import com.web.dssapp.service.RoleServiceImpl;


public class CustomUserDetails implements UserDetails {
	
	
	private User user;
	private RoleRepository roleRepository;

    public CustomUserDetails(User user, RoleRepository roleRepository) {
		super();
		this.user = user;
		this.roleRepository = roleRepository;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		
		Optional<Role> a = roleRepository.findById(user.getRole_id());
		
		if (a.isPresent()) {
			list.add(new SimpleGrantedAuthority(a.get().toString()));
		}
		
		return list;
	}
       
	
	
	public User getContext() {
	return this.user;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
