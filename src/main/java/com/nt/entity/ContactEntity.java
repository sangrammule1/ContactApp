package com.nt.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
@Entity
@Table(name = "CONTACTS")
public class ContactEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "CID")
	private Integer contactId;
	@Column(name = "CNAME")
	private String contactName;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "CONTACTNUM")
	private Long contactNum;
	@Column(name = "ACTIVE_SWITCH")
	private String activeSwitch;
	@CreationTimestamp
	@Column(name = "CREATED_TIME",updatable = false)
	private Date createdTime;
	@UpdateTimestamp
	@Column(name = "UPDATED_TIME",insertable = false)
	private Date updatedTime;

}
