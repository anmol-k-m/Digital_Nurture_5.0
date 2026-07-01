import java.util.*;

class Product {

    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product ID: " + productId +
                ", Name: " + productName +
                ", Category: " + category;
    }
}

class SearchOperations {

    public static Product linearSearch(Product[] products, int productId) {

        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }

        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {

        int left = 0;
        int right = products.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (products[mid].getProductId() == productId) {
                return products[mid];
            }

            if (products[mid].getProductId() < productId) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return null;
    }
}

public class ECommerceSearchDemo {

    public static void main(String[] args) {

        Product[] products = {
                new Product(103, "Keyboard", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Mouse", "Electronics"),
                new Product(104, "Watch", "Accessories")
        };

        int searchId = 102;

        Product linearResult = SearchOperations.linearSearch(products, searchId);

        if (linearResult != null) {
            System.out.println("Linear Search Result:");
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found using Linear Search.");
        }

        Arrays.sort(products, Comparator.comparingInt(Product::getProductId));

        Product binaryResult = SearchOperations.binarySearch(products, searchId);

        if (binaryResult != null) {
            System.out.println("\nBinary Search Result:");
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found using Binary Search.");
        }
    }
}