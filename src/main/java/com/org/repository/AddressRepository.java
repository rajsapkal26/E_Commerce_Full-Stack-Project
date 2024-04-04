package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.model.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

	
	
}
