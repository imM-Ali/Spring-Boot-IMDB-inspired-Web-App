package com.web.dssapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.dssapp.model.Role;
import com.web.dssapp.model.User;
import com.web.dssapp.repository.RoleRepository;


@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	

	@Override
	public Boolean addRole(Role role) {
		try {		
			//by default every new sign up will be classes as a normal user
			role.set_id(1);
			roleRepository.save(role);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	@Override
	public List<Role> getAllRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Role getRoleByName(String role) {		
		return roleRepository.findRoleByName(role);
	}
	
	@Override
	public Optional<Role> getRoleById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findRoleById(id);
	}

	@Override
	public Boolean deleteRoleById(int id) {
		try {
			roleRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}


}