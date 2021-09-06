package com.technoelevate.controller.dao;

import java.util.List;

import com.technoelevate.controller.employeedto.EmployeeInfoBean;

public interface EmployeeDAO {
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);

	public EmployeeInfoBean authenticate(int id, String password);

	public EmployeeInfoBean getEmployee(int id);

	public boolean deleteEmployee(int id);

	public boolean updateRecords(EmployeeInfoBean employeeInfoBean);

	public List<EmployeeInfoBean> getAllEmployees();

}
