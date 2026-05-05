package projectTrial;

class Deposit implements Transaction {
	String depositId;
	Deposit(String id){
		this.depositId = id;
	}
	
	public void process(Account acc, double amount) {
		acc.balance += amount;
		acc.addTransaction("Deposited : " + amount);
		System.out.println("Deposit successful.");
	}
}
