import java.util.*;
public class ShoppingCart {
    private static HashMap<String, Double> items = new HashMap<>();
    private static HashMap<String, Integer> cart = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        items.put("Laptop", 55000.0);
        items.put("Headphones", 1500.0);
        items.put("Mouse", 600.0);
        items.put("Keyboard", 1200.0);
        items.put("Mobile", 18000.0);
        while (true) {
            System.out.println("\n==== ONLINE SHOPPING CART ====");
            System.out.println("1. View Items");
            System.out.println("2. Add Item to Cart");
            System.out.println("3. View Cart");
            System.out.println("4. Calculate Total");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    viewItems();
                    break;
                case 2:
                    addToCart(sc);
                    break;
                case 3:
                    viewCart();
                    break;
                case 4:
                    calculateTotal();
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    private static void viewItems() {
        System.out.println("\n--- AVAILABLE ITEMS ---");
        items.forEach((item, price) ->
                System.out.println(item + " - Rs. " + price));
    }
    private static void addToCart(Scanner sc) {
        System.out.print("Enter item name: ");
        String itemName = sc.nextLine();
        if (!items.containsKey(itemName)) {
            System.out.println("Item not found!");
            return;
        }
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();
        cart.put(itemName, cart.getOrDefault(itemName, 0) + qty);
        System.out.println(qty + " x " + itemName + " added to cart.");
    }
    private static void viewCart() {
        System.out.println("\n--- YOUR CART ---");
        if (cart.isEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }
        cart.forEach((item, qty) ->
                System.out.println(item + " | Qty: " + qty + " | Price: Rs. " + items.get(item)));
    }
    private static void calculateTotal() {
        double total = 0;
        for (String item : cart.keySet()) {
            total += items.get(item) * cart.get(item);
        }
        System.out.println("\n--- TOTAL BILL ---");
        System.out.println("Total Amount: Rs. " + total);
    }
}
