package com.technoelevate.controller.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.technoelevate.controller.dao.EmployeeDAO;
import com.technoelevate.controller.employeedto.EmployeeInfoBean;
@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDAO dao;

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public EmployeeInfoBean authenticate(int id, String password) {
		if (id <= 0) {
			return null;
		}
		return dao.authenticate(id, password);

	}

	@Override
	public EmployeeInfoBean getEmployees(int id) {
		if (id <= 0) {
			return null;
		}
		return dao.getEmployee(id);

	}

	@Override
	public boolean deleteEmployee(int id) {
		if (id <= 0) {
			return false;
		}
		return dao.deleteEmployee(id);

	}

	@Override
	public boolean updateRecords(EmployeeInfoBean employeeInfoBean) {
		return dao.updateRecords(employeeInfoBean);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployees() {
		return dao.getAllEmployees();
	}

}
