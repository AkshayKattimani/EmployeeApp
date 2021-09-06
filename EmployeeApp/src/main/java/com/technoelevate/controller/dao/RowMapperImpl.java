package com.technoelevate.controller.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.technoelevate.controller.employeedto.EmployeeInfoBean;

public class RowMapperImpl implements RowMapper<EmployeeInfoBean> {

	@Override
	public EmployeeInfoBean mapRow(ResultSet rs, int rowNum) throws SQLException {
		EmployeeInfoBean employeeInfoBean = new EmployeeInfoBean();

		employeeInfoBean.setFname(rs.getString(2));
		employeeInfoBean.setLname(rs.getString(3));
		employeeInfoBean.setId(rs.getInt(4));
		employeeInfoBean.setPassword(rs.getString(5));
		return employeeInfoBean;
	}

}
