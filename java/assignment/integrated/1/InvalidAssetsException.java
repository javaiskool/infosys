class InvalidAssetsException extends RuntimeException {
	private String message;

	public InvalidAssetsException(String message) {
		super(message);
		this.message = message;
	}
}