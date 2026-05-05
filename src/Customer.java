package projectTrial;

class Customer{
	String name;
	String customerId;
	String phone;
	int age;
	Customer(String id, String name, String phone, int age){
		this.name=name;
		this.customerId = id;
		this.phone = phone;
		this.age = age;
	}
}