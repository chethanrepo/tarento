package com.tarento.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarento.search.entity.DuplicateEntry;

public interface DuplicateEntryRepository extends JpaRepository<DuplicateEntry, Long> {
		
	DuplicateEntry getAlphanumericKeyByAlphanumericKey(String alphaNumericKey);
	
}
