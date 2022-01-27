import java.math.BigInteger;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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
        int cvv2 = 1000 + random.nextInt(999);
        Integer password;
        Integer firstCardPassword;
        String secondCardPassword;
        //Long cardNumber = (random.nextLong() % 10000000000000000L) + (5000000000000000L);
        Long cardNumber = (random.nextLong() % 100000000L) + (6104337500000000L);
        Long firstCardNumber;
        Long secondCardNumber;
        int firstCardCvv2;
        int secondCardCvv2;

        while (true) {
            System.out.println("What do you want to do : \n1.Make an account \n2.Money transfer" +
                    " \n3.change password \n4.Transactions \n5.Exit ");
            Integer order = scanner.nextInt();
            scanner.nextLine();
            if (order == 1) {
                System.out.println("enter your first name: ");
                firstName = scanner.nextLine();
                System.out.println("enter your last name: ");
                lastName = scanner.nextLine();
                System.out.println("enter your national code: ");
                nationalCode = scanner.nextInt();
                System.out.println("how much money you want to put in account ? ");
                amount = scanner.nextInt();
                System.out.println("enter your password: ");
                password = scanner.nextInt();
                services.createAccount(firstName, lastName, nationalCode, amount, null, AccountStatus.ALLOW,
                        cvv2, password, cardNumber);
                System.out.println("Account and Card is made ");
                System.out.println("Your cvv2 is:" + cvv2 + "  and your cardNumber is: " + cardNumber + "\n please take a note of them! ");
            }
            if (order == 2) {
                System.out.println("enter your card number : ");
                firstCardNumber = scanner.nextLong();
                System.out.println("enter your password: ");
                firstCardPassword = scanner.nextInt();
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
                int numberOfWrongPasswordEntered = 0;
                System.out.println("enter your card number : ");
                firstCardNumber = scanner.nextLong();
                System.out.println("enter your national code: ");
                Integer nationalCodeChangePassword = scanner.nextInt();
                System.out.println("enter your current password");
                password = scanner.nextInt();
                Card card = new Card(null, password, firstCardNumber);
                while (numberOfWrongPasswordEntered < 4) {
                    if (cardRepository.checkPassword(card)) {
                        System.out.println("Enter your new password: ");
                        Integer newPassword = scanner.nextInt();
                        cardRepository.changePassword(card, newPassword);
                        System.out.println("Done! ");
                        break;
                    } else {
                        System.out.println("wrong password! ");
                        numberOfWrongPasswordEntered++;
                    }
                    if (numberOfWrongPasswordEntered == 3) {   //Block account after 3 wrong password
                        services.blockAccountByNationalCode(nationalCodeChangePassword);
                    }
                }
            }
            if (order == 4) {
                System.out.println("enter your card number : ");
                firstCardNumber = scanner.nextLong();
                System.out.println("enter your national code: ");
                nationalCode = scanner.nextInt();
                System.out.println("enter your password");
                password = scanner.nextInt();
                scanner.nextLine();
                Card card = new Card(null, password, firstCardNumber);
                System.out.println("enter your start date: yyyyMMdd ");
                Date startDate = Date.valueOf(scanner.nextLine());
                System.out.println("enter your start date: yyyyMMdd ");
                Date endDate = Date.valueOf(scanner.nextLine());
                services.viewTransactions(card,startDate  ,endDate );
            }
            if (order == 5)
                break;
        }
    }
}
//SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
//        Date parsed = format.parse("20110210");
//        java.sql.Date sql = new java.sql.Date(parsed.getTime());

//java.util.Date utilDate = new java.util.Date();
//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

// date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(startDate);;
// date2 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(endDate);


//try {
//                    parsed1 = format.parse(scanner.nextLine());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("enter your end date: yyyyMMdd ");
//                try {
//                    parsed2 = format.parse(scanner.nextLine());
//                } catch (ParseException e) {
//                    e.printStackTrace();
//                }
//                //Date date1 = Date.valueOf("00/00/2000");
//                Date date2 = Date.valueOf(LocalDate.now());
//                java.util.Date utilDate = new java.util.Date();
//                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());