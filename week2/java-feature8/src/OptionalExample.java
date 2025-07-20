import java.util.Optional;

public class OptionalExample {

    public static Optional<String> getName(boolean retrieveName) {
        if (retrieveName) {
            return Optional.of("John Doe"); // Value is present
        } else {
            return Optional.empty(); // Value is absent
        }
    }

    public static void main(String[] args) {

        // Case 1: Optional contains a value
        Optional<String> name1 = getName(true);
        if (name1.isPresent()) {
            System.out.println("Name (ifPresent): " + name1.get());
        }

        // Using orElse() to provide a default value if absent
        String displayName1 = name1.orElse("Guest");
        System.out.println("Name (orElse): " + displayName1);

        // Using ifPresent() with a Consumer lambda
        name1.ifPresent(name -> System.out.println("Name (ifPresent with lambda): " + name));

        System.out.println("-------------------------");

        // Case 2: Optional is empty
        Optional<String> name2 = getName(false);
        if (name2.isPresent()) { // This block will not execute
            System.out.println("Name (ifPresent): " + name2.get());
        } else {
            System.out.println("Name is not available.");
        }

        // Using orElse() for a default value when absent
        String displayName2 = name2.orElse("Anonymous");
        System.out.println("Name (orElse): " + displayName2);

        // Using orElseThrow() to throw an exception if absent
        try {
            name2.orElseThrow(() -> new IllegalArgumentException("Name not found!"));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}