package projectTrial;

class Withdrawal implements Transaction{
	String withdrawalId;
	Withdrawal(String id){
		this.withdrawalId = id;
	}
	
	public void process(Account acc,  double amount) {
		if(amount <= acc.balance) {
			acc.balance -= amount;
			acc.addTransaction("Withdrawn : " + amount);
			System.out.println("Withdrawal successful.");
		}
		else {
			System.out.println("Insufficient balance!");
		}
	}
}
