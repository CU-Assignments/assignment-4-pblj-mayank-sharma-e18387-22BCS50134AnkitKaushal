import java.util.*;

public class CardCollectionDemo {
    private Map<String, List<String>> cardMap;

    public CardCollectionDemo() {
        cardMap = new HashMap<>();
    }

    public void addCard(String symbol, String card) {
        cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
    }

    public List<String> getCardsBySymbol(String symbol) {
        return cardMap.getOrDefault(symbol, new ArrayList<>());
    }

    public void displayAllCards() {
        if (cardMap.isEmpty()) {
            System.out.println("No cards available.");
            return;
        }
        for (Map.Entry<String, List<String>> entry : cardMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CardCollectionDemo collection = new CardCollectionDemo();

        collection.addCard("Hearts", "Ace");
        collection.addCard("Hearts", "King");
        collection.addCard("Spades", "Queen");
        collection.addCard("Diamonds", "Jack");
        collection.addCard("Clubs", "10");

        while (true) {
            System.out.println("\nCard Collection System");
            System.out.println("1. Find Cards by Symbol");
            System.out.println("2. Display All Cards");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter symbol (e.g., Hearts, Spades): ");
                    String symbol = scanner.nextLine();
                    List<String> cards = collection.getCardsBySymbol(symbol);
                    if (cards.isEmpty()) {
                        System.out.println("No cards found for " + symbol);
                    } else {
                        System.out.println("Cards in " + symbol + ": " + cards);
                    }
                    break;
                case 2:
                    collection.displayAllCards();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
