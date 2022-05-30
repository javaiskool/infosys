class InvalidExperienceException extends RuntimeException {
	private String message;

	public InvalidExperienceException(String message) {
		super(message);
		this.message = message;
	}

}
