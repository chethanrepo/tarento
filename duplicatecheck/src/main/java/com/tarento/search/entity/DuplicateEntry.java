/**
 * 
 */
package com.tarento.search.entity;

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
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]{20}$", message = "Input should be alphanumeric and length must be 20 chars")
	private String alphanumericKey;
	@Transient
	private boolean state;
	
	/**
	 * 
	 */
	public DuplicateEntry() {
		super();		
	}	
		
	/**
	 * 
	 */
	public DuplicateEntry(String alphanumericKey) {
		super();
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
		return "DuplicateEntry [alphanumericKey=" + getAlphanumericEntry() + ", state="+getState()+"]";
	}
    
	@Override
	public int hashCode() {
		return alphanumericKey.hashCode();
	}
 
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof DuplicateEntry)) {
			return false;
		}
		DuplicateEntry other = (DuplicateEntry) obj;
		return getAlphanumericEntry().equals(other.getAlphanumericEntry());
	}


}
