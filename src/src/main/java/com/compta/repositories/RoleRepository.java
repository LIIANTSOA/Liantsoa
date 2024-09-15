package com.compta.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compta.models.Role;


public interface RoleRepository extends JpaRepository<Role,Long>{
    Role findByCodeRole(String codeRole);
}
