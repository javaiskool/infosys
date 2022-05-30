class Resources {

	public static int getMonth(String month) {
		int value;

		switch (month) {
		case "Jan":
			value = 1;
			break;
		case "Feb":
			value = 2;
			break;
		case "Mar":
			value = 3;
			break;
		case "Apr":
			value = 4;
			break;
		case "May":
			value = 5;
			break;
		case "Jun":
			value = 6;
			break;
		case "Jul":
			value = 7;
			break;
		case "Aug":
			value = 8;
			break;
		case "Sep":
			value = 9;
			break;
		case "Oct":
			value = 10;
			break;
		case "Nov":
			value = 11;
			break;
		case "Dec":
			value = 12;
			break;

		default:
			value = 0;

		}

		return value;
	}
}
