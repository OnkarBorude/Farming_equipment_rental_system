package com.farmars.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmars.entity.Users;



@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {
	public Optional<Users> findByEmailAndPassword(String email, String password);
	
	public Optional<Users> findByEmail(String email);
}
