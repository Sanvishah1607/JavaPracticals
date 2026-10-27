import java.util.*;

class OutOfStockException extends Exception {
    int shortfall;

    OutOfStockException(int shortfall) {
        this.shortfall = shortfall;
    }

    public String getMessage() {
        return "Out of stock. Shortfall = " + shortfall;
    }
}

class InvalidQuantityException extends Exception {
    InvalidQuantityException() {
        super("Invalid quantity. Quantity must be greater than 0.");
    }
}

class Warehouse {
    HashMap<String, Integer> stock = new HashMap<>();

    void addItem(String item, int qty) {
        stock.put(item, qty);
    }

    void issue(String item, int qty)
            throws OutOfStockException, InvalidQuantityException {

        if (qty <= 0) {
            throw new InvalidQuantityException();
        }

        int available = stock.getOrDefault(item, 0);

        if (qty > available) {
            throw new OutOfStockException(qty - available);
        }

        stock.put(item, available - qty);

        System.out.println("Issued " + qty + " " + item);
    }
}

public class Main {
    public static void main(String[] args) {

        Warehouse w = new Warehouse();

        w.addItem("Pen", 10);
        w.addItem("Book", 5);
        w.addItem("Bag", 3);

        // item, quantity
        String[][] requests = {
            {"Pen", "5"},
            {"Book", "10"},
            {"Bag", "0"},
            {"Pen", "3"},
            {"Laptop", "2"}
        };

        for (String[] request : requests) {

            String item = request[0];
            int qty = Integer.parseInt(request[1]);

            try {
                w.issue(item, qty);

            } catch (OutOfStockException e) {
                System.out.println(
                    "Failed: " + item +
                    " - " + e.getMessage()
                );

            } catch (InvalidQuantityException e) {
                System.out.println(
                    "Failed: " + item +
                    " - " + e.getMessage()
                );
            }
        }

        System.out.println("\nProcessing completed.");
    }
}