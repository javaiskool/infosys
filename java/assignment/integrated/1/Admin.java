class Admin {
	void generateSalarySlip(Employee employees[], float salaryFactor[]) {
		int index = 0;

		for (Employee employee : employees) {
			if (employee instanceof PermanentEmployee) {
				PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
				permanentEmployee.calculateSalary(salaryFactor[index++]);
			} else if (employee instanceof ContractEmployee) {
				ContractEmployee contractEmployee = (ContractEmployee) employee;
				contractEmployee.calculateSalary(salaryFactor[index++]);
			}
		}
	}

	int generateAssetsReport(Employee employees[], String lastDate) {
		int totalNoOfAssetsForAllEmployees = 0;

		for (Employee employee : employees) {
			if (employee instanceof PermanentEmployee) {
				PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
				try {
					Asset asset[] = permanentEmployee.getAssetsByDate(lastDate);

					int totalNoOfAssetsForCurrentEmployee = asset.length;
					totalNoOfAssetsForAllEmployees += totalNoOfAssetsForCurrentEmployee;
				} catch (InvalidAssetsException e) {
					return -1;
				}
			}
		}
		return totalNoOfAssetsForAllEmployees;
	}

	String[] generateAssetsReport(Employee employees[], char assetCategory) {
		if (Character.isUpperCase(assetCategory)) {
			assetCategory = (char) (assetCategory + 32);
		}
		String assetIds[] = new String[employees.length * 3];

		int index = 0;

		for (Employee employee : employees) {
			if (employee instanceof PermanentEmployee) {
				PermanentEmployee permanentEmployee = (PermanentEmployee) employee;
				Asset assetsOfTheCurrentEmployee[] = permanentEmployee.getAssets();
				for (Asset asset : assetsOfTheCurrentEmployee) {
					String assetIdTobeChecked = asset.getAssetId();
					assetIdTobeChecked = assetIdTobeChecked.toLowerCase();

					if (((assetIdTobeChecked) != null) && (assetIdTobeChecked.charAt(0) == assetCategory)) {
						assetIds[index++] = assetIdTobeChecked;

					}
				}

			}
		}

		return assetIds;
	}

}