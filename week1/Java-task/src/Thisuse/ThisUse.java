package Thisuse;

public class ThisUse extends Super {
    int num;

    public ThisUse(int num) {
        this.num = num; // referring to current class's 'num' using 'this'
    }

    @Override
    public void display() {
        System.out.println("display method");
    }

    public void Show() {
        this.display();              // calls current class's display()
        display();                   // same as above, implicit 'this'
        System.out.println(this.num); // prints current class's num (10)
        System.out.println(num);      // same as above, implicit 'this'
    }

    public static void main(String[] args) {
        ThisUse o = new ThisUse(10);
        o.Show();
    }
}

//Output
//display method
//display method
//10
//10
