/**
 * 
 */
package com.tarento.search.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @author chenaray
 *
 */
@Entity
public class DuplicateEntry {
	
	@Id
	private String id;

	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]{20}$")
	private String alphanumericKey;
	@Transient
	private boolean state;
	
	/**
	 * 
	 */
	public DuplicateEntry() {
		super();		
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
		
	/**
	 * 
	 */
	public DuplicateEntry(String alphanumericKey) {
		super();
		this.id = UUID.randomUUID().toString();
		this.alphanumericKey = alphanumericKey;
	}
	
		
	public String getAlphanumericEntry() {
		return alphanumericKey;
	}

	public void setAlphanumericEntry(String alphanumericEntry) {
		this.alphanumericKey = alphanumericEntry;
	}
	
	public boolean getState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public String toString() {
		return "DuplicateEntry [id=" + getId() + ", duplicateKey=" + alphanumericKey + ", state="+getState()+"]";
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
