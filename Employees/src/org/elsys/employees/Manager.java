package org.elsys.employees;

public class Manager extends Employee {
	
	int level;
	/**
	 * Creates new manager with the given id, name, salary and level.
	 * @param id
	 * @param name
	 * @param salary
	 * @param level
	 */
	public Manager(long id, String name, double salary, int level) {
		super(id, name, salary);
		this.level = level;
	}

	/**
	 * Creates new manager with the given id, name, salary and with level 1.
	 * @param id
	 * @param name
	 * @param salary
	 */
	public Manager(long id, String name, double salary) {
		super(id, name, salary);
		this.level = 1;
	}

	public int getLevel() {
		return level;
	}
}
