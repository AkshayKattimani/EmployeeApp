package com.technoelevate.controller.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.technoelevate.controller.employeedto.EmployeeInfoBean;


public abstract class EmployeeDAOImplJdbc {
	JdbcTemplate template;

	public void setTemplete(JdbcTemplate template) {
		this.template = template;
	}

	public int addEmployee(EmployeeInfoBean employeeInfoBean) {

		String query = "insert into employeeapp(firstName, lastName, email, password) values(?,?,?,?)";
		int result = template.update(query, employeeInfoBean.getFname(), employeeInfoBean.getLname(),
				employeeInfoBean.getId(), employeeInfoBean.getPassword());
		return result;

	}

	public List<EmployeeInfoBean> getAllEmployees() {
		RowMapper<EmployeeInfoBean> rowMapper = new RowMapperImpl();
		String query = "SELECT * FROM `employeemanagement@2021`.employeeapp;";
		List<EmployeeInfoBean> employees = template.query(query, rowMapper);
		return employees;


	}

	public EmployeeInfoBean authenticate(int id, String password) {
		RowMapper<EmployeeInfoBean> rowMapper = new RowMapperImpl();
		String query = "SELECT * FROM `employeemanagement@2021`.employeeapp WHERE id =?";
		EmployeeInfoBean employee = template.queryForObject(query, rowMapper, id);
		return employee;

	}

}
