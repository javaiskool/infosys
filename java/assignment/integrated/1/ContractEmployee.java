class ContractEmployee extends Employee {

	private double wagePerHour;

	public ContractEmployee(String employeeName, double wagePerHour) {
		super(employeeName);

		int contractIdCounter = getContractIdCounter();
		contractIdCounter++;
		setEmployeeId("C" + contractIdCounter);
		this.wagePerHour = wagePerHour;
	}

	public void calculateSalary(float hoursWorked) {

		double salary =0;
		if (hoursWorked >= 190) 		
			salary=wagePerHour * hoursWorked;
		else if (hoursWorked < 190) {
			double salaryTobeDeducted = (wagePerHour / 2) * (190 - hoursWorked);
			salary=wagePerHour * hoursWorked;
			salary = salary - salaryTobeDeducted;
		}
		setSalary(Math.round(salary));

	}

	public double getWagePerHour() {
		return wagePerHour;
	}

	public void setWagePerHour(double wagePerHour) {
		this.wagePerHour = wagePerHour;
	}

	@Override
	public String toString() {
		return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName() + ", Wage Per Hour: "
				+ getWagePerHour();
	}
}