package PetTracker;

import java.util.Objects;
import java.util.Optional;

public class Person {
    private final String name;
    private Integer age;
    private Optional<Dog> dog;

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Optional<Dog> getDog() {
        return dog;
    }

    public void setDog(Optional<Dog> dog) {
        this.dog = dog;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(dog, person.dog);
    }

    public Person(String name, Integer age, Dog dog) {
        this.name = name;
        this.age = age;
        this.dog = Optional.ofNullable(dog);
    }

    // Constructor calling the above constructor with null for dog
    public Person(String name, Integer age) {
        this(name, age, null); // Calls the second constructor with no dog
    }

    // Method to check if person has an old dog
    public boolean hasOldDog() {
        return dog.map(d -> d.getAge() >= 10).orElse(false);
    }

    // Method to change the dog's name
    public void changeDogsName(String newName) {
        dog.ifPresentOrElse(
                d -> d.setName(newName),
                () -> { throw new RuntimeException(this.name + " does not own a dog!"); }
        );
    }
}
