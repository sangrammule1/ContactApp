package com.nt.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.nt.entity.ContactEntity;

public interface ContactRepo extends JpaRepository<ContactEntity, Integer> {
	
	public List<ContactEntity> findByActiveSwitch(String activeSwitch);
	
	public ContactEntity findByEmail(String email);
	
	@Query("update ContactEntity set activeSwitch='N' where contactId=:id")
	@Transactional
	@Modifying
	public void deleteContact(Integer id);
	
}
