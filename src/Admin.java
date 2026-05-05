import java.util.*; 
import java.io.*;
class Admin{
	String name;
    String adminId;

    Admin(String id, String name) {
        this.name=name;
        this.adminId = id;
    }

    
    void viewAllUsers(ArrayList<UserBank> users) {
        System.out.println("\n--- ALL USERS ---");
        for (UserBank u : users) {
            System.out.println(u.customer.name + " | Acc: " + u.account.accountNo);
        }
    }

    void viewAllTransactions() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("transactions.txt"));
            String line;
            System.out.println("\n--- ALL TRANSACTIONS ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("No transactions found!");
        }
    }
}
