public class familyTree {
    
    static class Person {
        String name;

        public Person(String name) {
            this.name = name;
        }

        public void introduce() {
            System.out.println("Hi, I'm " + name);
        }

        public void interact() {
            System.out.println(name + " interacts.");
        }
    }

    static class Grandparent extends Person {
        public Grandparent(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(name + " tells a story.");
        }
    }

    static class Parent extends Person {
        public Parent(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(name + " says: Hello!");
        }
    }

    static class Child extends Person {
        public Child(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(name + " is playing.");
        }
    }

    public static void main(String[] args) {
        Person[] family = new Person[3];
        family[0] = new Grandparent("Grandfather");
        family[1] = new Parent("Father");
        family[2] = new Child("Child");

        for (Person person : family) {
            person.introduce();
            person.interact(); 
        }
    }
}
