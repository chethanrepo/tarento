package com.tarento.search.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarento.search.entity.DuplicateEntry;
import com.tarento.search.repository.DuplicateEntryRepository;

@Service
public class DuplicateEntryComponent {
	private static final Logger logger = LoggerFactory.getLogger(DuplicateEntryComponent.class);
	
	@Autowired
	DuplicateEntryRepository duplicateEntryRepository;

	public DuplicateEntryComponent() {
		// TODO Auto-generated constructor stub
	}	
	
	public DuplicateEntry getDuplicateEntry(String alphanumericKey){ 
		logger.info("Looking for duplicate entry :  "+ alphanumericKey);
		DuplicateEntry de = duplicateEntryRepository.getAlphanumericKeyByAlphanumericKey(alphanumericKey);
		if(de != null) {
			de.setState(true);
		} else {
			de = duplicateEntryRepository.save(new DuplicateEntry(alphanumericKey));
			de.setState(false);
		}
		return de;
	}

}
