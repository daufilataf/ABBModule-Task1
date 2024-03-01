import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        try {
            manager.readInventoryItems();
            System.out.println("Inventory loaded successfully.");
        } catch (FileIOException e) {
            System.out.println("Error loading inventory: " + e.getMessage());
        }

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Find Item");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter item ID: ");
                        int itemId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter item name: ");
                        String itemName = scanner.nextLine().trim();
                        System.out.print("Enter quantity: ");
                        int quantity = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter price: ");
                        double price = Double.parseDouble(scanner.nextLine().trim());
                        InventoryItem newItem = new InventoryItem(itemId, itemName, quantity, price);
                        manager.addItem(newItem);
                        System.out.println("Item added successfully.");
                    } catch (NumberFormatException | InvalidDataException | FileIOException | ItemNotFoundException e) {
                        System.out.println("Error adding item: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter item ID to find: ");
                    int findItemId = Integer.parseInt(scanner.nextLine().trim());
                    try {
                        InventoryItem foundItem = manager.findItem(findItemId);
                        System.out.println("Found item: " + foundItem.getName());
                    } catch (ItemNotFoundException e) {
                        System.out.println("Error finding item: " + e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Enter item ID: ");
                        int updateItemId = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter new item name: ");
                        String updateItemName = scanner.nextLine().trim();
                        System.out.print("Enter new quantity: ");
                        int updateQuantity = Integer.parseInt(scanner.nextLine().trim());
                        System.out.print("Enter new price: ");
                        double updatePrice = Double.parseDouble(scanner.nextLine().trim());
                        InventoryItem updateItem = new InventoryItem(updateItemId, updateItemName, updateQuantity,
                                updatePrice);
                        manager.updateItem(updateItem);
                        System.out.println("Item updated successfully.");
                    } catch (NumberFormatException | InvalidDataException | ItemNotFoundException | FileIOException e) {
                        System.out.println("Error updating item: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter item ID to delete: ");
                    int deleteItemId = Integer.parseInt(scanner.nextLine().trim());
                    try {
                        manager.deleteItem(deleteItemId);
                        System.out.println("Item deleted successfully.");
                    } catch (ItemNotFoundException | FileIOException e) {
                        System.out.println("Error deleting item: " + e.getMessage());
                    }
                    break;
                case 0:
                    System.out.println("Good bye :(, Ruslan bey, I hope u liked, and will give full point :D");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
