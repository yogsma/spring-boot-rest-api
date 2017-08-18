package com.betterjavacode.benefits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.betterjavacode.benefits.entities.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Role findByRole(String role);
}
