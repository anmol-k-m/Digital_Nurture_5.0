package EX_03;

class CustomerOrder {

    private final int orderId;
    private final String customerName;
    private final int quantity;
    private final double unitPrice;

    public CustomerOrder(int orderId, String customerName, int quantity, double unitPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public double getTotalPrice() {
        return quantity * unitPrice;
    }

    @Override
    public String toString() {
        return "Order ID: " + orderId +
                ", Customer: " + customerName +
                ", Quantity: " + quantity +
                ", Unit Price: " + unitPrice +
                ", Total Price: " + getTotalPrice();
    }
}

class OrderSortOperations {

    public static void mergeSort(CustomerOrder[] orders) {
        if (orders == null || orders.length < 2) {
            return;
        }

        mergeSort(orders, 0, orders.length - 1);
    }

    private static void mergeSort(CustomerOrder[] orders, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(orders, left, mid);
        mergeSort(orders, mid + 1, right);
        merge(orders, left, mid, right);
    }

    private static void merge(CustomerOrder[] orders, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;

        CustomerOrder[] leftOrders = new CustomerOrder[leftSize];
        CustomerOrder[] rightOrders = new CustomerOrder[rightSize];

        for (int i = 0; i < leftSize; i++) {
            leftOrders[i] = orders[left + i];
        }

        for (int j = 0; j < rightSize; j++) {
            rightOrders[j] = orders[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while (i < leftSize && j < rightSize) {
            if (leftOrders[i].getTotalPrice() >= rightOrders[j].getTotalPrice()) {
                orders[k] = leftOrders[i];
                i++;
            } else {
                orders[k] = rightOrders[j];
                j++;
            }
            k++;
        }

        while (i < leftSize) {
            orders[k] = leftOrders[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            orders[k] = rightOrders[j];
            j++;
            k++;
        }
    }

    public static void quickSort(CustomerOrder[] orders) {
        if (orders == null || orders.length < 2) {
            return;
        }

        quickSort(orders, 0, orders.length - 1);
    }

    private static void quickSort(CustomerOrder[] orders, int left, int right) {
        if (left >= right) {
            return;
        }

        int pivotIndex = partition(orders, left, right);
        quickSort(orders, left, pivotIndex - 1);
        quickSort(orders, pivotIndex + 1, right);
    }

    private static int partition(CustomerOrder[] orders, int left, int right) {
        CustomerOrder pivot = orders[right];
        int i = left - 1;

        for (int j = left; j < right; j++) {
            if (orders[j].getTotalPrice() >= pivot.getTotalPrice()) {
                i++;
                CustomerOrder temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }

        CustomerOrder temp = orders[i + 1];
        orders[i + 1] = orders[right];
        orders[right] = temp;

        return i + 1;
    }
}

public class CustomerOrderSortingDemo {

    private static CustomerOrder[] createSampleOrders() {
        return new CustomerOrder[] {
                new CustomerOrder(5001, "Aarav Sharma", 2, 12500.00),
                new CustomerOrder(5002, "Neha Verma", 5, 2200.00),
                new CustomerOrder(5003, "Rohan Patel", 1, 45000.00),
                new CustomerOrder(5004, "Isha Khan", 3, 7800.00),
                new CustomerOrder(5005, "Karan Singh", 4, 3100.00)
        };
    }

    private static CustomerOrder[] copyOrders(CustomerOrder[] source) {
        CustomerOrder[] copy = new CustomerOrder[source.length];

        for (int i = 0; i < source.length; i++) {
            copy[i] = source[i];
        }

        return copy;
    }

    private static void printOrders(CustomerOrder[] orders) {
        for (CustomerOrder order : orders) {
            System.out.println(order);
        }
    }

    public static void main(String[] args) {

        CustomerOrder[] originalOrders = createSampleOrders();
        CustomerOrder[] mergeSortedOrders = copyOrders(originalOrders);
        CustomerOrder[] quickSortedOrders = copyOrders(originalOrders);

        System.out.println("Orders Before Sorting (By Total Price):");
        printOrders(originalOrders);

        OrderSortOperations.mergeSort(mergeSortedOrders);

        System.out.println("\nMerge Sort Result (Highest Total Price First):");
        printOrders(mergeSortedOrders);

        OrderSortOperations.quickSort(quickSortedOrders);

        System.out.println("\nQuick Sort Result (Highest Total Price First):");
        printOrders(quickSortedOrders);

        System.out.println("\nMerge Sort Analysis:");
        System.out.println("- Merge sort is stable and consistently runs in O(n log n) time.");
        System.out.println("- It uses O(n) extra space because of the temporary merge arrays.");
        System.out.println("- It is a good choice when predictable performance matters.");

        System.out.println("\nQuick Sort Analysis:");
        System.out.println("- Quick sort is usually faster in practice for in-memory arrays.");
        System.out.println("- It runs in O(n log n) on average and O(n^2) in the worst case.");
        System.out.println("- It uses O(log n) extra space on average due to recursion.");
    }
}
