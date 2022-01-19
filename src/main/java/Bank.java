import java.math.BigInteger;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Bank {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        AccountRepository accountRepository = new AccountRepository();
        CardRepository cardRepository = new CardRepository();
        TransactionRepository transactionRepository = new TransactionRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        Services services = new Services();
        Random random = new Random();

        String firstName;
        String lastName;
        Integer nationalCode;
        Integer amount;
        int cvv2 = 1000 + random.nextInt(9999);
        String password;
        String firstCardPassword;
        String secondCardPassword;
        Long cardNumber = (random.nextLong() % 1000000000000000L);
        Long firstCardNumber;
        Long secondCardNumber;
        int firstCardCvv2;
        int secondCardCvv2;


        System.out.println("What do you want to do : \n1.Make an account \n2.Money transfer \n3.change password ");
        Integer order = scanner.nextInt();
        if (order == 1) {
            System.out.println("enter your first name: ");
            firstName = scanner.nextLine();
            System.out.println("enter your first name: ");
            lastName = scanner.nextLine();
            System.out.println("enter your national code: ");
            nationalCode = scanner.nextInt();
            System.out.println("how much money you want to put in account ? ");
            amount = scanner.nextInt();
            System.out.println("enter your password: ");
            password = scanner.nextLine();
            services.createAccount(firstName, lastName, nationalCode, amount, null, AccountStatus.ALLOW,
                    cvv2, password, cardNumber);
            System.out.println("Account and Card is made ");
        }
        if (order == 2) {
            System.out.println("enter your card number : ");
            firstCardNumber = scanner.nextLong();
            System.out.println("enter your password: ");
            firstCardPassword = scanner.nextLine();
            System.out.println("enter your cvv2: ");
            firstCardCvv2 = scanner.nextInt();
            Card firstCard = new Card(firstCardCvv2, firstCardPassword, firstCardNumber);
            System.out.println("enter amount: ");
            amount = scanner.nextInt();

            System.out.println("enter destination card number : ");
            secondCardNumber = scanner.nextLong();
            Card secondCard = new Card(null, null, secondCardNumber);
            services.CardToCard(firstCard, secondCard, amount);

        }
        if (order == 3) {
            System.out.println("enter your card number : ");
            firstCardNumber = scanner.nextLong();
            System.out.println("enter your current password");
            password = scanner.nextLine();
            Card card = new Card(null, password, firstCardNumber);
            if (cardRepository.checkPassword(card)) {
                System.out.println("Enter your new password: ");
                String newPassword = scanner.nextLine();
                cardRepository.changePassword(card, newPassword);
            }
        }

    }
}
