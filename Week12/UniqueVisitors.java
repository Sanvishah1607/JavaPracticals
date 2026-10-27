
import java.util.*;

public class UniqueVisitors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter login names separated by spaces:");
        String input = sc.nextLine();

        String[] names = input.split("\\s+");

        HashSet<String> uniqueUsers = new HashSet<>();
        LinkedHashSet<String> orderedUsers = new LinkedHashSet<>();

        for (String name : names) {
            uniqueUsers.add(name);
            orderedUsers.add(name);
        }

        System.out.println("Unique users count: " + uniqueUsers.size());

        System.out.println("First three distinct names:");
        int count = 0;

        for (String name : orderedUsers) {
            if (count == 3)
                break;

            System.out.println(name);
            count++;
        }

        sc.close();
    }
}
