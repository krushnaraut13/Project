package com.tka.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.entity.Country;
import com.tka.entity.Employee;
import com.tka.service.EmployeeService;

@RestController
@RequestMapping("api")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/addcountry")
	public ResponseEntity<String> addCountry(@RequestBody Country c) {
		String msg = service.addCountry(c);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updatecountry/{id}")
	public ResponseEntity<String> updateCountry(@RequestBody Country c, @PathVariable int id) {
		String msg = service.updateCountry(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("deletecountry/{id}")
	public ResponseEntity<String> deleteCountry(@PathVariable int id) {
		String msg = service.deleteCountry(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getallcountries")
	public ResponseEntity<List<Country>> getAllCountries() {
		List<Country> li = service.getAllCountries();
		return ResponseEntity.ok(li);
	}

	@GetMapping("getcountrybyid/{id}")
	public ResponseEntity<Country> getCountryById(@PathVariable int id) {
		Country c = service.getCountryById(id);
		return ResponseEntity.status(201).body(c);
	}

	@PostMapping("addemployee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee emp) {
		String msg = service.addEmployee(emp);
		return ResponseEntity.ok(msg);
	}

	@PutMapping("updateemployee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable long id, @RequestBody Employee emp) {
		String msg = service.updateEmployee(id, emp);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("delete-employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable long id) {
		String msg = service.deleteEmployee(id);
		return ResponseEntity.ok(msg);
	}

	@GetMapping("getallemployees")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> li = service.getAllEmployees();
		return ResponseEntity.ok(li);
	}

	@GetMapping("getemployeebyid/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
		Employee emp = service.getEmploeeById(id);
		return ResponseEntity.status(201).body(emp);
	}

	@GetMapping("salaryRange/{startSal}/{endSal}")
	public ResponseEntity<List<Employee>> salaryRange(@PathVariable double startSal, @PathVariable double endSal) {
		List<Employee> list = service.salaryRange(startSal, endSal);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("login")
	public ResponseEntity<Map> login(@RequestBody Employee emp) {
		Map map = service.login(emp);
		return ResponseEntity.ok(map);
	}

}
