
class Stack<T> {
    private Object[] arr;
    private int top;

    Stack(int size) {
        arr = new Object[size];
        top = -1;
    }

    public void push(T value) {
        if (top == arr.length - 1) {
            System.out.println("Stack is full!");
            return;
        }
        arr[++top] = value;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty!");
            return null;
        }
        return (T) arr[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class GenericStackDemo {
    public static void main(String[] args) {

        Stack<Integer> s1 = new Stack<>(5);
        s1.push(10);
        s1.push(20);
        System.out.println("Integer: " + s1.pop());

        Stack<String> s2 = new Stack<>(5);
        s2.push("Java");
        s2.push("Hello");
        System.out.println("String: " + s2.pop());

        System.out.println("Empty pop: " + s1.pop());
        System.out.println("Is empty: " + s1.isEmpty());
    }
}
