public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Cash cash = new Cash();
        cash.setPerson(new Person("Joe"));
        Person person = cash.getPerson();
        System.out.println("The same: " + (person == cash.getPerson()));
    }
}

class Person implements Cloneable {
    private String name;
    private int age;
    private double salary;

    public Person(String name) {
        this.name = name;
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        return (Person) super.clone();
    }
}

class Cash {
    private Person person;

    public Person getPerson() throws CloneNotSupportedException {
        return person.clone();
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
