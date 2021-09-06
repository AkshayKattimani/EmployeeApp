package com.technoelevate.controller.services;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.technoelevate.controller.dao.EmployeeDAOImplJdbc;
import com.technoelevate.controller.employeedto.EmployeeInfoBean;

@Component
public class EmployeeServiceJdbc {
	
	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/technoelevate/services/config.xml");
	EmployeeDAOImplJdbc dao = context.getBean("myEmployeeDAO",EmployeeDAOImplJdbc.class);
	
	
	public int addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}
	
	
	
	public EmployeeInfoBean authenticate(int id,String password) {
		//System.out.println(password);
		EmployeeInfoBean empPasskey= dao.authenticate(id, password);
		if(password.equals(empPasskey.getPassword())) {
			return empPasskey;
		}else return null;
	}
	
	
	public List<EmployeeInfoBean> getAllEmployees(){
		return dao.getAllEmployees();
	}

}
