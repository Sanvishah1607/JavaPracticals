
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

class Pair<A, B> {
    private A first;
    private B second;

    Pair(A first, B second) {
        this.first = first;
        this.second = second;
    }

    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }
}

public class GenericContainers {

    // Generic method to return the first element
    public static <T> T firstElement(T[] array) {
        return array[0];
    }

    public static void main(String[] args) {

        // Box with different types
        Box<Integer> b1 = new Box<>();
        b1.set(100);
        System.out.println("Box Integer: " + b1.get());

        Box<String> b2 = new Box<>();
        b2.set("Hello Java");
        System.out.println("Box String: " + b2.get());

        // Pair with different types
        Pair<String, Integer> p = new Pair<>("sanvi", 20);
        System.out.println("Pair: " + p.getFirst() + ", " + p.getSecond());

        // Generic method with different arrays
        String[] names = {"Sanvi", "Dhanvi", "Datta"};
        Integer[] numbers = {10, 20, 30};

        System.out.println("First name: " + firstElement(names));
        System.out.println("First number: " + firstElement(numbers));
    }
}
