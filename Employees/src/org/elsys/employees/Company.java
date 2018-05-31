package org.elsys.employees;

import java.util.ArrayList;
import java.util.List;

public class Company {
	
	List<Employee> EmployeesList= new ArrayList<>();
	double budget;
	/**
	 * Creates company with budget provided as parameter.
	 * 
	 * @param budget
	 */
	public Company(double budget) {
		this.budget = budget;
	}

	/**
	 * Returns the budget of the company.
	 * 
	 * @return
	 */
	public double getBudget() {
		return budget;
	}

	/**
	 * Returns the remaining budget of the company - the company budget minus
	 * the salaries of all employees (including the managers).
	 * 
	 * @return
	 */
	public double getBudgetLeft() {
		
		for(Employee e : EmployeesList) {
			budget -= e.getSalary();
		}
		return budget;
	}

	/**
	 * Hires an employees in the company.
	 * 
	 * If the budget is going to be exceeded, {@link NotEnoughBudgetException}
	 * must be thrown.
	 * 
	 * @param e
	 *            the employee to be hired
	 */
	public void hire(Employee e) {
		if(getBudgetLeft() >= e.getSalary()) {
			EmployeesList.add(e);
		}else throw new NotEnoughBudgetException();
	}

	/**
	 * Fires an employee.
	 * 
	 * @param e
	 *            employee to be fired
	 */
	public void fire(Employee e) {
		if(isHired(e)){
			EmployeesList.remove(e);
		}
	}

	/**
	 * Checks whether the given employee is hried in the company
	 * 
	 * @param e
	 */
	public boolean isHired(Employee e) {

		return EmployeesList.contains(e);
	}

	/**
	 * Closes the company. Sets the budget to 0 and fires all employees
	 */
	public void close() {
		EmployeesList.clear();
		budget = 0;
	}

	/**
	 * Returns a list of all managers with the given level.
	 * 
	 * @param level
	 * @return
	 */
	public List<Manager> getManagersWithLevel(int level) {
			List<Manager> manager = new ArrayList<>();
			
			for(Employee e : EmployeesList) {
				if(e instanceof Manager) {
					if(level == ((Manager) e).getLevel()) {
						manager.add((Manager) e);
					}
				}
			}
		
		return manager;
	}
}
