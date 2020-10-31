package com.nt.domain;

import lombok.Data;

@Data
public class Contact {
	
	private Integer contactId;
	private String contactName;
	private String email;
	private Long contactNum;
	private String activeSwitch;

}
