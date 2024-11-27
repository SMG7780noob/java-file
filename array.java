import java.util.Scanner;

public class LibraryBookPurchase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] books = {
            "1. Bhagavad Gita",
            "2. Ramayana",
            "3. Mahabharata",
            "4. Garud Puran",
            "5. Shiv Puran",
            "6. Ram Charit Manas"
        };

        double[] prices = {150.0, 250.0, 350.0, 300.0, 200.0, 180.0};

        double simplePackingCharge = 20.0;
        double giftPackingCharge = 50.0;

        String[] users = new String[3];
        String[] userBooks = new String[3];
        String[] paymentModes = new String[3];
        int userCount = 0;

        while (userCount < 3) {
            System.out.println("Welcome to the Library!");
            System.out.println("Books available for purchase or rental:");
            for (String book : books) {
                System.out.println(book);
            }

            System.out.print("\nEnter the number of the book you want to purchase or rent: ");
            int choice = scanner.nextInt();

            if (choice >= 1 && choice <= books.length) {
                System.out.println("\nDo you want to:");
                System.out.println("1. Purchase the book");
                System.out.println("2. Rent the book (10% of book price)");
                System.out.print("Enter your choice (1 or 2): ");
                int actionChoice = scanner.nextInt();

                double totalCost = 0;

                if (actionChoice == 1) {
                    System.out.println("\nYou selected to purchase: " + books[choice - 1].substring(3));
                    System.out.println("Price: ₹" + prices[choice - 1]);

                    System.out.println("\nChoose a packing type:");
                    System.out.println("1. Simple Packing (₹" + simplePackingCharge + ")");
                    System.out.println("2. Gift Packing (₹" + giftPackingCharge + ")");
                    System.out.print("Enter your choice (1 or 2): ");
                    int packingChoice = scanner.nextInt();

                    double packingCharge = 0;
                    if (packingChoice == 1) {
                        packingCharge = simplePackingCharge;
                    } else if (packingChoice == 2) {
                        packingCharge = giftPackingCharge;
                    } else {
                        System.out.println("Invalid packing choice. Please try again.");
                        continue;
                    }

                    totalCost = prices[choice - 1] + packingCharge;

                } else if (actionChoice == 2) {
                    System.out.println("\nYou selected to rent: " + books[choice - 1].substring(3));
                    totalCost = prices[choice - 1] * 0.10;

                } else {
                    System.out.println("Invalid choice. Please try again.");
                    continue;
                }

                System.out.print("\nEnter your name: ");
                scanner.nextLine();
                String userName = scanner.nextLine();

                System.out.println("\nChoose payment method:");
                System.out.println("1. Cash");
                System.out.println("2. Card");
                System.out.print("Enter your choice (1 or 2): ");
                int paymentMethod = scanner.nextInt();

                String paymentMode;
                if (paymentMethod == 1) {
                    paymentMode = "Cash";
                } else if (paymentMethod == 2) {
                    paymentMode = "Card";
                } else {
                    System.out.println("Invalid payment method. Please try again.");
                    continue;
                }

                System.out.print("Enter the payment amount: ₹");
                double payment = scanner.nextDouble();

                if (payment >= totalCost) {
                    if (actionChoice == 1) {
                        System.out.println("Purchase successful! Thank you, " + userName + ", for buying " + books[choice - 1].substring(3) + ".");
                    } else {
                        System.out.println("Rental successful! Thank you, " + userName + ", for renting " + books[choice - 1].substring(3) + ".");
                    }
                    if (payment > totalCost) {
                        System.out.println("Change returned: ₹" + (payment - totalCost));
                    }

                    users[userCount] = userName;
                    userBooks[userCount] = books[choice - 1].substring(3);
                    paymentModes[userCount] = paymentMode;
                    userCount++;

                } else {
                    System.out.println("Insufficient payment. Transaction failed.");
                }

            } else {
                System.out.println("Invalid book choice. Please try again.");
            }

            if (userCount < 3) {
                System.out.println("\nWould you like another transaction? (y/n)");
                String response = scanner.next();
                if (!response.equalsIgnoreCase("y")) {
                    break;
                }
            }
        }

        System.out.println("\nThe following transactions were completed:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i] + " purchased/rented " + userBooks[i] + " using " + paymentModes[i] + " payment.");
        }

        scanner.close();
    }
}
