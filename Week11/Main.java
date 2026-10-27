import java.io.*;

class Student implements Serializable {
    int id;
    String name;
    transient String password;

    Student(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            Student[] students = {
                new Student(1, "Sanvi", "abc123"),
                new Student(2, "Riaan", "xyz456")
            };

            // Save objects to a file
            ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("student.dat"));
            out.writeObject(students);
            out.close();

            System.out.println("Objects saved successfully.");

            // Read objects from the file
            ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("student.dat"));

            Student[] loaded = (Student[]) in.readObject();
            in.close();

            // Display loaded objects
            for (Student s : loaded) {
                System.out.println("ID: " + s.id);
                System.out.println("Name: " + s.name);
                System.out.println("Password: " + s.password);
                System.out.println();
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }
}
