package com.technoelevate.controller.services;

import java.util.List;

import com.technoelevate.controller.employeedto.EmployeeInfoBean;

public interface EmployeeService {

	public EmployeeInfoBean authenticate(int id, String password);

	public boolean addEmployee(EmployeeInfoBean employeeInfoBean);

	public EmployeeInfoBean getEmployees(int id);

	public boolean deleteEmployee(int id);

	public boolean updateRecords(EmployeeInfoBean employeeInfoBean);

	public List<EmployeeInfoBean> getAllEmployees();

}
