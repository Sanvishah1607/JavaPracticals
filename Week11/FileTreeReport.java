
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.Instant;

public class FileTreeReport {
    public static void main(String[] args) throws IOException {

        Path folder = Paths.get("testfolder");
        Path report = Paths.get("report.txt");

        Files.createDirectories(folder);
        Files.writeString(folder.resolve("file1.txt"), "Hello Java");
        Files.writeString(folder.resolve("file2.txt"), "NIO Example");

        try (java.io.BufferedWriter writer =
                     Files.newBufferedWriter(report)) {

            writer.write("FILE TREE REPORT\n");
            writer.write("------------------------------\n");

            Files.walkFileTree(folder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(
                        Path file, BasicFileAttributes attrs)
                        throws IOException {

                    writer.write("Name: " + file.getFileName() + "\n");
                    writer.write("Size: " + attrs.size() + " bytes\n");
                    writer.write("Modified: " +
                            Instant.ofEpochMilli(
                                attrs.lastModifiedTime().toMillis()) + "\n");
                    writer.write("------------------------------\n");

                    return FileVisitResult.CONTINUE;
                }
            });
        }

        System.out.println("Report generated in report.txt");
    }
}
