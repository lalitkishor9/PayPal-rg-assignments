import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {

    public static void main(String[] args) {

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        System.out.println("Original list: " + names);

        // --- Before Java 8 (Anonymous Inner Class) ---
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.compareTo(s2);
            }
        });
        System.out.println("Sorted using anonymous inner class: " + names);

        // Reset list for lambda example
        names.clear();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        // --- With Java 8 (Lambda Expression) ---
        // Sorting the list using a lambda expression
        Collections.sort(names, (s1, s2) -> s1.compareTo(s2));
        System.out.println("Sorted using lambda expression: " + names);

        // Another example: Iterating over a list
        System.out.println("\nIterating with lambda:");
        names.forEach(name -> System.out.println("Hello, " + name));
    }
}