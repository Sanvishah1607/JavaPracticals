import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotBlank {
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}


class SignupForm {

    @NotBlank
    String username;

    @NotBlank
    @MaxLength(10)
    String password;

    @MaxLength(50)
    String email;

    SignupForm(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}


public class FormValidator {

    public static List<String> validate(Object object) {

        List<String> errors = new ArrayList<>();

        
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {

            try {
                field.setAccessible(true);
                Object value = field.get(object);

                
                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().trim().isEmpty()) {
                        errors.add(field.getName() + " must not be blank");
                    }
                }

                
                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    int max = annotation.value();

                    if (value != null && value.toString().length() > max) {
                        errors.add(field.getName()
                                + " must not exceed "
                                + max + " characters");
                    }
                }

            } catch (IllegalAccessException e) {
                errors.add("Cannot access field: " + field.getName());
            }
        }

        return errors;
    }

    public static void main(String[] args) {

        SignupForm form = new SignupForm(
                "",
                "verylongpassword123",
                "user@example.com"
        );

        List<String> errors = validate(form);

        if (errors.isEmpty()) {
            System.out.println("Form is valid.");
        } else {
            System.out.println("Validation Errors:");

            for (String error : errors) {
                System.out.println("- " + error);
            }
        }
    }
}