package EX_01;

import java.util.HashMap;
import java.util.Map;

class InventoryItem {

    private final int itemId;
    private final String itemName;
    private final String category;
    private int quantity;
    private double unitPrice;

    public InventoryItem(int itemId, String itemName, String category, int quantity, double unitPrice) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.category = category;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void updateQuantity(int quantityChange) {
        this.quantity += quantityChange;
    }

    public void updatePrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    @Override
    public String toString() {
        return "Item ID: " + itemId +
                ", Name: " + itemName +
                ", Category: " + category +
                ", Quantity: " + quantity +
                ", Unit Price: " + unitPrice;
    }
}


class Inventory {

    private final Map<Integer, InventoryItem> inventory = new HashMap<>();

    public void addItem(InventoryItem item) {
        inventory.put(item.getItemId(), item);
    }

    public InventoryItem findItem(int itemId) {
        return inventory.get(itemId);
    }

    public boolean updateStock(int itemId, int quantityChange) {
        InventoryItem item = inventory.get(itemId);
        if (item == null) {
            return false;
        }

        item.updateQuantity(quantityChange);
        return true;
    }

    public boolean updatePrice(int itemId, double newPrice) {
        InventoryItem item = inventory.get(itemId);
        if (item == null) {
            return false;
        }

        item.updatePrice(newPrice);
        return true;
    }

    public boolean removeItem(int itemId) {
        return inventory.remove(itemId) != null;
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        for (InventoryItem item : inventory.values()) {
            System.out.println(item);
        }
    }
}

class InventoryManagementSystem {

    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        inventory.addItem(new InventoryItem(201, "Laptop", "Electronics", 15, 65000.00));
        inventory.addItem(new InventoryItem(202, "Mouse", "Electronics", 100, 799.00));
        inventory.addItem(new InventoryItem(203, "Office Chair", "Furniture", 25, 4500.00));

        System.out.println("Initial Inventory:");
        inventory.displayInventory();

        System.out.println("\nSearching for item 202:");
        InventoryItem item = inventory.findItem(202);
        System.out.println(item != null ? item : "Item not found.");

        System.out.println("\nUpdating stock and price for item 202:");
        inventory.updateStock(202, 20);
        inventory.updatePrice(202, 749.00);
        System.out.println(inventory.findItem(202));

        System.out.println("\nRemoving item 203:");
        System.out.println(inventory.removeItem(203) ? "Item removed." : "Item not found.");

        System.out.println("\nFinal Inventory:");
        inventory.displayInventory();

        System.out.println("\nAnalysis:");
        System.out.println("- Data storage uses a HashMap for fast key-based retrieval.");
        System.out.println("- Search, add, update, and remove operations are average O(1).");
        System.out.println("- This is efficient for warehouse inventory where quick access is required.");
    }
}
