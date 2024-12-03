package com.tka.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.dao.EmployeeDao;
import com.tka.entity.Country;
import com.tka.entity.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String addCountry(Country c) {

		String msg = dao.addCountry(c);

		return msg;

	}

	public String updateCountry(Country c, int id) {

		String msg = dao.updateCountry(c, id);
		return msg;
	}

	public String deleteCountry(int id) {
		String msg = dao.deleteCountry(id);
		return msg;
	}

	public List<Country> getAllCountries() {
		List<Country> li = dao.getAllCountries();
		return li;
	}

	public Country getCountryById(int id) {
		Country c = dao.getCountryById(id);
		return c;
	}

	public String addEmployee(Employee emp) {
		String msg = dao.addEmployee(emp);
		return msg;
	}

	public String updateEmployee(long id, Employee emp) {
		String msg = dao.updateEmployee(id, emp);
		return msg;
	}

	public String deleteEmployee(long id) {
		String msg = dao.deleteEmployee(id);
		return msg;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> li = dao.getAllEmployees();
		return li;
	}

	public Employee getEmploeeById(long id) {
		Employee emp = dao.getEmployeeById(id);
		return emp;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {
		List<Employee> list = dao.salaryRange(startSal, endSal);
		return list;
	}
	
	public Map login(Employee emp) {
		Employee obj = dao.login(emp);
		Map map = new HashMap();
		if (Objects.isNull(obj)) {
			map.put("msg", "Invalid User");
			map.put("user", obj);
		} else {
			map.put("msg", "Valid User");
			map.put("user", obj);
		}
		return map;
	}

}
