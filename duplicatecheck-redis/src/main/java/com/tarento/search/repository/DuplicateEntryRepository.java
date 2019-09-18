package com.tarento.search.repository;

import org.springframework.data.repository.CrudRepository;

import com.tarento.search.entity.DuplicateEntry;

public interface DuplicateEntryRepository extends CrudRepository<DuplicateEntry, Long> {
		
	DuplicateEntry findByAlphanumericKey(String alphaNumericKey);
	
}
