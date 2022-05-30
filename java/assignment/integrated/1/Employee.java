
abstract class Employee {

	private String employeeId;
	private String employeeName;
	private double salary;

	private static int contractIdCounter;
	private static int permanentIdCounter;

	static {
		contractIdCounter = 10000;
		permanentIdCounter = 10000;
	}

	public Employee(String employeeName) {
		super();
		this.employeeName = employeeName;

		if (this instanceof ContractEmployee) {
			int contractIdCounter = getContractIdCounter();
			contractIdCounter++;
			setContractIdCounter(contractIdCounter);
			setEmployeeId("C" + contractIdCounter);
		} else if (this instanceof PermanentEmployee) {
			int permanentIdCounter = getPermanentIdCounter();
			permanentIdCounter++;
			setPermanentIdCounter(permanentIdCounter);
			setEmployeeId("E" + permanentIdCounter);
		}
	}

	public void setEmployeeName(String employeeName) {
		if (employeeName.matches("[A-Z][a-zA-Z]+(\\s+[A-Z][a-zA-Z]+)+")) {
			this.employeeName = employeeName;
		}
	}

	public abstract void calculateSalary(float salaryFactor);

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary > 0) {
			this.salary = salary;
		} else {
			this.salary = 0;
		}
	}

	public static int getContractIdCounter() {
		return contractIdCounter;
	}

	public static void setContractIdCounter(int contractIdCounter) {
		Employee.contractIdCounter = contractIdCounter;
	}

	public static int getPermanentIdCounter() {
		return permanentIdCounter;
	}

	public static void setPermanentIdCounter(int permanentIdCounter) {
		Employee.permanentIdCounter = permanentIdCounter;
	}

	@Override
	public String toString() {
		return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName();
	}
}