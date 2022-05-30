class PermanentEmployee extends Employee {

	private double basicPay;
	private String[] salaryComponents;
	private Asset[] assets;
	private float experience;

	public PermanentEmployee(String employeeName, double basicPay, String salaryComponents[], Asset assets[]) {
		super(employeeName);
		this.basicPay = basicPay;
		this.salaryComponents = salaryComponents;
		this.assets = assets;

		int permanentIdCounter = getPermanentIdCounter();
		permanentIdCounter++;
		setEmployeeId("E" + permanentIdCounter);
	}

	public double calculateBonus(float experience) {
		double bonusAmount = 0;
		if (experience < 2.5)
			throw new InvalidExperienceException("A minimum of 2.5 years is required for bonus!");
		else if (experience < 4 && experience >= 2.5)
			bonusAmount = 2550;
		else if (experience < 8 && experience >= 4)
			bonusAmount = 5000;
		else if (experience < 12 && experience >= 8)
			bonusAmount = 8750;
		else if (experience >= 12)
			bonusAmount = 13000;
		return bonusAmount;
	}

	public void calculateSalary(float experience) {
		setExperience(experience);
		double bonus;

		try {
			bonus = calculateBonus(experience);
		} catch (InvalidExperienceException e) {
			bonus = 0;
		}

		// handle numberformatexception
		String strDA = salaryComponents[0];
		double da = Double.parseDouble(strDA.substring(3, 5));
		da = basicPay * (da / 100);

		String strHRA = salaryComponents[1];
		double hra = Double.parseDouble(strHRA.substring(4, 6));
		hra = basicPay * (hra / 100);

		double salary = basicPay + bonus + da + hra;
		setSalary((int) Math.round(salary));

	}

	public Asset[] getAssetsByDate(String lastDate) {

		int datePartFromlastDate = Integer.parseInt(lastDate.substring(9, 11));
		int monthPartFromlastDate = Resources.getMonth(lastDate.substring(5, 8));
		int yearPartFromlastDate = Integer.parseInt(lastDate.substring(0, 4));

		Asset assetsByDate[] = new Asset[assets.length]; // length is same as original asset array

		int count = 0;
		for (Asset asset : assets) {

			String assetExpiryDate = asset.getAssetExpiry();

			int datePartFromAssetExpiry = Integer.parseInt(assetExpiryDate.substring(9, 11));

			String month = assetExpiryDate.substring(5, 8);
			int monthPartFromAssetExpiry = Resources.getMonth(month);

			int yearPartFromAssetExpiry = Integer.parseInt(assetExpiryDate.substring(0, 4));

			if ((datePartFromAssetExpiry <= datePartFromlastDate) && (monthPartFromAssetExpiry <= monthPartFromlastDate)
					&& (yearPartFromAssetExpiry <= yearPartFromlastDate))
				assetsByDate[count++] = asset;
		}

		return assetsByDate;
	}

	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	public double getBasicPay() {
		return basicPay;
	}

	public void setBasicPay(double basicPay) {
		this.basicPay = basicPay;
	}

	public String[] getSalaryComponents() {
		return salaryComponents;
	}

	public void setSalaryComponents(String[] salaryComponents) {
		this.salaryComponents = salaryComponents;
	}

	public Asset[] getAssets() {
		return assets;
	}

	public void setAssets(Asset[] assets) {
		this.assets = assets;
	}

	@Override
	public String toString() {
		return "Employee Id: " + getEmployeeId() + ", Employee Name: " + getEmployeeName() + ", Basic Pay: "
				+ getBasicPay() + ", Salary Components: " + getSalaryComponents() + ", Assets: " + getAssets();
	}
}
