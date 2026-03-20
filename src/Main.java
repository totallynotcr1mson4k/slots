import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int balance = 10000;

        System.out.println("--- slots ---");
        System.out.println("777 = x50 | any three numbers = x10 | two numbers = x2 | nothing = x0");
        System.out.println("balance: $" + balance);

        while (balance > 0) {
            System.out.print("\nbet (0 to exit): ");
            if (!scanner.hasNextInt()) {
                scanner.next();
                continue;
            }

            int bet = scanner.nextInt();
            if (bet == 0) break;
            if (bet > balance || bet <= 0) {
                System.out.println("not enough money or incorrect bet.");
                continue;
            }

            balance -= bet;
            System.out.print("... [ ? ] [ ? ] [ ? ]");
            Thread.sleep(800);

            int s1 = random.nextInt(8); // 0-7
            int s2 = random.nextInt(8);
            int s3 = random.nextInt(8);

            System.out.printf("\rresult: [ %d ] [ %d ] [ %d ]\n", s1, s2, s3);

            if (s1 == 7 && s2 == 7 && s3 == 7) {
                int win = bet * 50;
                balance += win;
                System.out.println("BIG WIN: $" + win);
            } else if (s1 == s2 && s2 == s3) {
                int win = bet * 10;
                balance += win;
                System.out.println("jackpot: $" + win);
            } else if (s1 == s2 || s2 == s3 || s1 == s3) {
                int win = bet * 2;
                balance += win;
                System.out.println("still won: $" + win);
            } else {
                System.out.println("you lost.");
            }

            System.out.println("balance: $" + balance);
        }

        System.out.println(balance <= 0 ? "no money left" : "bye bye.");
        scanner.close();
    }
}

// все было написано в IntelliJ IDEA Community Edition 2025.2.5 мной :)