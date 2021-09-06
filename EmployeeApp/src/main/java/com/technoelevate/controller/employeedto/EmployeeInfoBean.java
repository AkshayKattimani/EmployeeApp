package com.technoelevate.controller.employeedto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EmployeeInfoBean implements Serializable {
	private String fname;
	private String lname;
	private int id;
	private String password;
}
