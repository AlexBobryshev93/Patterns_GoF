/*
Applied when we need too many different constructors. They can be replaced with
an auxiliary Builder class
 */
public class Main {
    public static void main(String[] args) {
       Person person = new PersonBuilder().setName("Andy").setAge(19).setSalary(900).build();
       System.out.println(person);
    }
}

class Person {
    private String name;
    private int age;
    private double salary;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

// Typically this class also implements an interface with the methods
class PersonBuilder {
    private Person person = new Person();

    public PersonBuilder setName(String name) {
        person.setName(name);
        return this;
    }

    public PersonBuilder setAge(int age) {
        person.setAge(age);
        return this;
    }

    public PersonBuilder setSalary(double salary) {
        person.setSalary(salary);
        return this;
    }

    public Person build() {
        return person;
    }
}
