import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MethodReferenceExample {

    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        System.out.println("--- Using Lambda Expressions ---");
        // Lambda for printing (equivalent to Consumer<String>)
        names.forEach(name -> System.out.println(name));

        // Lambda for transforming to uppercase (equivalent to Function<String, String>)
        List<String> upperNamesLambda = names.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase names (Lambda): " + upperNamesLambda);

        System.out.println("\n--- Using Method References (More suitable here) ---");
        // Method reference for printing (Instance method of a particular object: System.out)
        // More concise and readable than the lambda `name -> System.out.println(name)`
        names.forEach(System.out::println);

        // Method reference for transforming to uppercase (Instance method of an arbitrary object of a particular type: String)
        // More concise and readable than the lambda `s -> s.toUpperCase()`
        List<String> upperNamesMethodRef = names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase names (Method Reference): " + upperNamesMethodRef);

        // Example of Static Method Reference
        List<Integer> numbers = Arrays.asList(10, 5, 20, 15);
        // Find max using lambda
        Integer maxLambda = numbers.stream()
                .reduce((a, b) -> Math.max(a, b))
                .orElse(0);
        System.out.println("\nMax number (Lambda): " + maxLambda);

        // Find max using static method reference
        Integer maxMethodRef = numbers.stream()
                .reduce(Math::max)
                .orElse(0);
        System.out.println("Max number (Method Reference): " + maxMethodRef);

        // Example of Constructor Reference
        List<String> words = Arrays.asList("hello", "world");
        // Convert to new String objects using lambda
        List<String> newStringsLambda = words.stream()
                .map(s -> new String(s))
                .collect(Collectors.toList());
        System.out.println("New Strings (Lambda): " + newStringsLambda);

        // Convert to new String objects using constructor reference
        List<String> newStringsMethodRef = words.stream()
                .map(String::new)
                .collect(Collectors.toList());
        System.out.println("New Strings (Method Reference): " + newStringsMethodRef);
    }
}