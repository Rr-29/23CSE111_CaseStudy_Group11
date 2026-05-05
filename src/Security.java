package projectTrial;

 class Security {
	String username;
	int password;
	Security(String user, int pass){
		this.username = user;
		this.password = pass;
	}
	boolean verifyPassword(int pass) {
		return this.password == pass;
	}
	void changePin(int newPin) {
		this.password = newPin;
		System.out.println("PIN updated successfully.");
	}
}
