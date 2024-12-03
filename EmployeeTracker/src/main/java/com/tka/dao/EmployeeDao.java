package com.tka.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.query.Query;
import com.tka.entity.Country;
import com.tka.entity.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {

		Session session = null;
		String msg = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			session.persist(c);
			session.getTransaction().commit();
			msg = "Country Added Successfully...";
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;

	}

	public String updateCountry(Country c, int id) {

		Session session = null;
		String msg = null;
		Country country = null;

		try {

			session = factory.openSession();
			session.beginTransaction();
			country = session.get(Country.class, id);
			country.setCname(c.getCname());
			session.merge(country);
			session.getTransaction().commit();
			msg = "Country Updated Successfully..";

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteCountry(int id) {

		Session session = null;
		String msg = null;
		Country country = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			country = session.get(Country.class, id);
			session.remove(country);
			session.getTransaction().commit();
			msg = "Country deleted succesfully...";
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Country> getAllCountries() {
		Session session = null;
		List<Country> li = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			li = session.createQuery("from Country", Country.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return li;
	}

	public Country getCountryById(int id) {

		Session session = null;
		Country c = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			c = session.get(Country.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return c;
	}

	public String addEmployee(Employee emp) {
		Session session = null;
		String msg = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			session.persist(emp);
			session.getTransaction().commit();
			msg = "Employee Registered Successfully...";
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(long id, Employee emp) {
		Session session = null;
		String msg = null;
		Employee employee = null;

		try {

			session = factory.openSession();
			session.beginTransaction();
			employee = session.get(Employee.class, id);
			employee.setName(emp.getName());
			employee.setStatus(emp.getStatus());
			employee.setDepartment(emp.getDepartment());
			employee.setMobileno(emp.getMobileno());
			employee.setEmailid(emp.getEmailid());
			employee.setCreatedBy(emp.getCreatedBy());
			employee.setUpdatedBy(emp.getUpdatedBy());
			employee.setCreatedDate(emp.getCreatedDate());
			employee.setUpdatedDate(emp.getUpdatedDate());
			employee.setSalary(emp.getSalary());
			employee.setCountry(emp.getCountry());
			session.merge(employee);
			session.getTransaction().commit();
			msg = "Employee Updated Successfully..";

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public String deleteEmployee(long id) {

		Session session = null;
		String msg = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			emp = session.get(Employee.class, id);
			session.remove(emp);
			session.getTransaction().commit();
			msg = "Employee deleted succesfully...";
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getAllEmployees() {

		Session session = null;
		List<Employee> li = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			li = session.createQuery("from Employee", Employee.class).list();
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return li;
	}

	public Employee getEmployeeById(long id) {

		Session session = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			session.beginTransaction();
			emp = session.get(Employee.class, id);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp;
	}

	public List<Employee> salaryRange(double startSal, double endSal) {

		Session session = null;
		List<Employee> li = null;
		String hqlQuery = "from Employee where salary between :startSal and :endSal";
		try {
			session = factory.openSession();
			session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("startSal", startSal);
			query.setParameter("endSal", endSal);
			li = query.list();
			session.getTransaction().commit();

		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return li;
	}
	
	public Employee login(Employee emp) {
		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:emailid and mobileno=:mobileno";
		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			query.setParameter("emailid", emp.getEmailid());
			query.setParameter("mobileno", emp.getMobileno());
			employee = query.uniqueResult();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return employee;
	}

}
