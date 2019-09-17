package com.tarento.search.entity;

import java.util.UUID;

import javax.persistence.Id;

public class BaseEntity {
	
	@Id
	private String id;
 
	public BaseEntity() {
		this.id = UUID.randomUUID().toString();
	}
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseEntity)) {
			return false;
		}
		BaseEntity other = (BaseEntity) obj;
		return getId().equals(other.getId());
	}
}