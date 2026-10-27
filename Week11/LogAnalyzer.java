
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class LogAnalyzer {
    public static void main(String[] args) throws IOException {

        // Create text files
        Files.write(Paths.get("log1.txt"),
                Arrays.asList("Error in login", "User logged in", "Error in payment"));

        Files.write(Paths.get("log2.txt"),
                Arrays.asList("System running", "Error detected", "Process completed"));

        Path[] files = {
            Paths.get("log1.txt"),
            Paths.get("log2.txt")
        };

        String keyword = "Error";
        int totalLines = 0;
        int keywordCount = 0;

        for (Path path : files) {
            int fileLines = 0;

            // Read each file line by line
            try (java.io.BufferedReader reader = Files.newBufferedReader(path)) {
                String line;

                while ((line = reader.readLine()) != null) {
                    totalLines++;
                    fileLines++;

                    if (line.contains(keyword)) {
                        keywordCount++;
                    }
                }
            }

            // Get file attributes
            BasicFileAttributes attr =
                    Files.readAttributes(path, BasicFileAttributes.class);

            System.out.println("File: " + path);
            System.out.println("Size: " + attr.size() + " bytes");
            System.out.println("Lines: " + fileLines);
        }

        System.out.println("\nTotal lines: " + totalLines);
        System.out.println("Lines containing '" + keyword + "': " + keywordCount);
    }
}
