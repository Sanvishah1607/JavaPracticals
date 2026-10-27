import java.lang.annotation.*;
import java.lang.reflect.Field;

// Custom Column annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Column {
    String name();
}

// Student class
class Student {

    @Column(name = "student_id")
    int id;

    @Column(name = "student_name")
    String name;

    @Column(name = "student_email")
    String email;

    public void display() {
        System.out.println("ID    : " + id);
        System.out.println("Name  : " + name);
        System.out.println("Email : " + email);
    }
}

// Object Mapper
public class ObjectMapperExample {

    public static <T> T mapObject(
            Class<T> clazz,
            String[] headers,
            String[] values) throws Exception {

        T object = clazz.getDeclaredConstructor().newInstance();

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {

            // Check @Column annotation
            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();

                // Find matching header
                for (int i = 0; i < headers.length; i++) {

                    if (headers[i].equals(columnName)) {

                        field.setAccessible(true);

                        // Set value according to field type
                        if (field.getType() == int.class) {
                            field.setInt(object,
                                    Integer.parseInt(values[i]));
                        } else if (field.getType() == String.class) {
                            field.set(object, values[i]);
                        }

                        break;
                    }
                }
            }
        }

        return object;
    }

    public static void main(String[] args) throws Exception {

        String[] headers = {
            "student_id",
            "student_name",
            "student_email"
        };

        String[] values = {
            "101",
            "Sanvi",
            "sanvi@example.com"
        };

        Student student = mapObject(
                Student.class,
                headers,
                values
        );

        student.display();
    }
}