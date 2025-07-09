//The Singleton Pattern ensures that only one instance of a class is created throughout the application's lifecycle,
// and it provides a global point of access to that instance.
public class Singleton {
    private static Singleton instance;

    private Singleton() {}

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
