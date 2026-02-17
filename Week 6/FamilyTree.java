public class FamilyTree {
    
    static class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }
        
        public String getName() {
            return name;
        }

        public void introduce() {
            System.out.println("Hi, I'm " + getName());
        }

        public void interact() {
            System.out.println(getName() + " interacts.");
        }
    }

    static class Grandparent extends Person {
        public Grandparent(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(getName() + " tells a story.");
        }
    }

    static class Parent extends Person {
        public Parent(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(getName() + " says: Hello!");
        }
    }

    static class Child extends Person {
        public Child(String name) {
            super(name);
        }

        @Override
        public void interact() {
            System.out.println(getName() + " is playing.");
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
