
import java.util.*;

public class Leaderboard {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Map<String, Integer> scores = new HashMap<>();

        System.out.println("Enter number of players:");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter player name and score:");
            String name = sc.next();
            int score = sc.nextInt();
            scores.put(name, score);
        }

        System.out.println("Enter top-N:");
        int topN = sc.nextInt();

        // Sort by score descending, then name ascending
        List<Map.Entry<String, Integer>> players =
                new ArrayList<>(scores.entrySet());

        players.sort(
            Comparator.<Map.Entry<String, Integer>>comparingInt(
                Map.Entry::getValue)
                .reversed()
                .thenComparing(Map.Entry::getKey)
        );

        System.out.println("Leaderboard:");

        for (int i = 0; i < Math.min(topN, players.size()); i++) {
            System.out.println(
                players.get(i).getKey() + " - " +
                players.get(i).getValue());
        }

        sc.close();
    }
}
