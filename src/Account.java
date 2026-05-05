import java.util.*;
import java.io.*;

class Account {
    String accountNo;
    double balance;
    String accountType;
    ArrayList<String> history = new ArrayList<>();

    Account(String accNo, double balance, String type) {
        this.accountNo = accNo;
        this.balance = balance;
        this.accountType = type;
    }

    void addTransaction(String record) {
        history.add(record);
        saveToFile(record);
    }

    void checkBalance() {
        System.out.println("Balance: " + balance);
    }

    void showHistory() {
        System.out.println("\nTransaction History:");
        for (String h : history) {
            System.out.println(h);
        }
    }

    void saveToFile(String record) {
        try {
            FileWriter fw = new FileWriter("transactions.txt", true);
            fw.write(accountNo + " : " + record + "\n");
            fw.close();
        } catch (IOException e) {
            System.out.println("File error!");
        }
    }
}
