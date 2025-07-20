import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapToUpperCaseExample {

    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        System.out.println("Original list: " + words);

        // Using map with a lambda expression
        List<String> upperCaseWordsLambda = words.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase (Lambda): " + upperCaseWordsLambda);

        // Using map with a method reference (more concise for this specific case)
        List<String> upperCaseWordsMethodRef = words.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
        System.out.println("Uppercase (Method Reference): " + upperCaseWordsMethodRef);

        // Example with a custom object (assuming it has a getName() method and we want to uppercase names)
        List<Person> people = Arrays.asList(
                new Person("alice"),
                new Person("bob"),
                new Person("charlie")
        );
        System.out.println("\nOriginal Person names:");
        people.forEach(p -> System.out.println(p.getName()));


        List<String> upperCasePersonNames = people.stream()
                .map(person -> person.getName().toUpperCase())
                .collect(Collectors.toList());
        System.out.println("Uppercase Person names: " + upperCasePersonNames);

    }
}

class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}