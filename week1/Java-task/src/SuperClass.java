//    Find Output

public class SuperClass {

    static void show() {
        System.out.println("super class show method");
    }

    static class StaticMethods {
        void show() {
            System.out.println("sub class show method");
        }
    }

    public static void main(String[] args) {
        SuperClass.show();
        new SuperClass.StaticMethods().show();
    }
}
// Output
//super class show method
//sub class show method
