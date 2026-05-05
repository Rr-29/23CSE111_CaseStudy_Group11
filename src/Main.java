import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<UserBank> users = new ArrayList<>();

    public static void main(String[] args) {

        users.add(new UserBank(
                new Customer("C01", "Anandu", "9999999999", 20),
                new Account("A01", 1000, "Savings"),
                new Security("user1", 1234)
        ));

        users.add(new UserBank(
                new Customer("C02", "Rahul", "8888888888", 22),
                new Account("A02", 2000, "Savings"),
                new Security("user2", 4321)
        ));

        while (true) {
            System.out.println("\n--- BANK SYSTEM ---");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    register();
                    break;
                case 3:
                    System.out.println("Thank you!");
                    return;
            }
        }
    }
        
        static void login() {
            System.out.print("Enter username: ");
            String username = sc.next();

            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (username.equals("admin") && pin == 0000) {
                Admin admin = new Admin("A0", "SuperAdmin");
                adminMenu(admin);
                return;
            }

            for (UserBank user : users) {
                if (user.security.username.equals(username) &&
                    user.security.verifyPassword(pin)) {

                    System.out.println("Login successful! Welcome " + user.customer.name);
                    userMenu(user);
                    return;
                }
            }

            System.out.println("Invalid credentials!");
        }
        
        static void userMenu(UserBank user) {
            Deposit deposit = new Deposit("D01");
            Withdrawal withdrawal = new Withdrawal("W01");

            int opt;
            do {
                System.out.println("\n1.Deposit 2.Withdraw 3.Balance 4.History 5.Change PIN 6.Logout");
                opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        System.out.print("Amount: ");
                        deposit.process(user.account, sc.nextDouble());
                        break;

                    case 2:
                        System.out.print("Amount: ");
                        withdrawal.process(user.account, sc.nextDouble());
                        break;

                    case 3:
                        user.account.checkBalance();
                        break;

                    case 4:
                        user.account.showHistory();
                        break;

                    case 5:
                        System.out.print("New PIN: ");
                        user.security.changePin(sc.nextInt());
                        break;
                }

            } while (opt != 6);
        }
        
        static void register() {
            System.out.print("Enter name: ");
            String name = sc.next();

            System.out.print("Enter phone: ");
            String phone = sc.next();

            System.out.print("Enter age: ");
            int age = sc.nextInt();

            System.out.print("Create username: ");
            String username = sc.next();

            System.out.print("Create PIN: ");
            int pin = sc.nextInt();

            String cid = "C" + (users.size() + 1);
            String accNo = "A" + (users.size() + 1);

            Customer c = new Customer(cid, name, phone, age);
            Account a = new Account(accNo, 0.0, "Savings");
            Security s = new Security(username, pin);

            users.add(new UserBank(c, a, s));

            System.out.println("Registration successful!");
        }
        
        static void adminMenu(Admin admin) {
            int opt;
            do {
                System.out.println("\n--- ADMIN PANEL ---");
                System.out.println("1.View Users 2.View Transactions 3.Logout");
                opt = sc.nextInt();

                switch (opt) {
                    case 1:
                        admin.viewAllUsers(users);
                        break;
                    case 2:
                        admin.viewAllTransactions();
                        break;
                }
            } while (opt != 3);
        }
    }
