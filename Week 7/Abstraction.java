// Encapsulation: Using private variables and public methods to control access
class Person {
    private String name;
    private int age;
    
    public Person() {
    }
    
    public Person(String name, int age) {
        setName(name);
        setAge(age);
    }
 
    public void setName(String newName) {
        if (newName != null && !newName.trim().isEmpty()) {
            name = newName;
        } else {
            System.out.println("Error: Name cannot be null or empty.");
        }
    }
 
    public void setAge(int newAge) {
        if (newAge >= 0 && newAge <= 150) {
            age = newAge;
        } else {
            System.out.println("Error: Age must be between 0 and 150.");
        }
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
}
 
// Polymorphism: Using method overriding with inheritance
class Animal {
    public void sound() {
        System.out.println("Animal makes a sound");
    }
}
 
class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
}
 
// Inheritance: Extending classes to inherit properties and methods
class Vehicle {
    protected String brand;
 
    public void drive() {
        System.out.println("Vehicle is driving");
    }
}
 
class Car extends Vehicle {
    public Car(String brand) {
        this.brand = brand;
    }
 
    public void honk() {
        System.out.println("Car honks");
    }
}
 
// Abstraction: Using abstract classes and methods
abstract class Shape {
    abstract void draw();
}
 
class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing Circle");
    }
}
 
public class Abstraction {
    public static void main(String[] args) {
        // Encapsulation example
        Person person = new Person();
        person.setName("John");
        person.setAge(30);
        System.out.println("Person: " + person.getName() + ", Age: " + person.getAge());
 
        // Polymorphism example
        Animal animal = new Dog(); // Polymorphism: Dog object as Animal reference
        animal.sound(); // Output: Dog barks
 
        // Inheritance example
        Car car = new Car("Toyota");
        car.drive(); // Output: Vehicle is driving
        car.honk(); // Output: Car honks
 
        // Abstraction example
        Shape shape = new Circle();
        shape.draw(); // Output: Drawing Circle
    }
}
