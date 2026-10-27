
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a paragraph:");
        String paragraph = sc.nextLine().toLowerCase();

        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        // Count word frequency
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Sort by frequency (highest first)
        List<String> list = new ArrayList<>(map.keySet());

        list.sort(Comparator.comparingInt(
                (String word) -> map.get(word)).reversed());

        // Display result
        System.out.println("Word Frequencies:");

        for (String word : list) {
            System.out.println(word + " : " + map.get(word));
        }

        sc.close();
    }
}
