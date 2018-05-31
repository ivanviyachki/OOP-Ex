package org.elsys.employees;

public class StateCompany extends Company {

	/**
	 * State company also has budget but can hire people even when the budget is
	 * exceeded.
	 * 
	 * @param budget
	 */
	
	public void hire(Employee e) {
			EmployeesList.add(e);		
	}
	public StateCompany(double budget) {
		super(budget);
		// TODO Auto-generated constructor stub
	}
	

}
