package test;
import PetTracker.Dog;
import PetTracker.Person;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

class PersonTest {

    @Test
    void testPersonCreationWithNoDog() {
        Person person = new Person("Arbin", 30);
        assertEquals("Arbin", person.getName(), "Person's name should be Arbin");
        assertEquals(30, person.getAge(), "Person's age should be 30");
        assertFalse(person.hasOldDog(), "Person without a dog should not have an old dog");
    }

    @Test
    void testPersonCreationWithDog() {
        Dog dog = new Dog("Puppy", 11);
        Person person = new Person("Arbin", 30, dog);
        assertTrue(person.hasOldDog(), "Person should have an old dog if the dog's age is >= 10");
    }

    @Test
    void testHasOldDog() {
        Dog dogYoung = new Dog("Puppy", 5);
        Dog dogOld = new Dog("Max", 10);

        Person personWithYoungDog = new Person("Arbin", 30, dogYoung);
        Person personWithOldDog = new Person("Jane", 28, dogOld);

        assertFalse(personWithYoungDog.hasOldDog(), "Person with a young dog should not have an old dog");
        assertTrue(personWithOldDog.hasOldDog(), "Person with an old dog should have an old dog");
    }

    @Test
    void testChangeDogsNameWithDog() {
        Dog dog = new Dog("Puppy", 5);
        Person person = new Person("Arbin", 30, dog);

        person.changeDogsName("Charlie");
        assertEquals("Charlie", dog.getName(), "Dog's name should be changed to Charlie");
    }

    @Test
    void testChangeDogsNameWithoutDog() {
        Person person = new Person("Arbin", 30);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            person.changeDogsName("Puppy");
        });
        assertEquals("Arbin does not own a dog!", exception.getMessage(), "Exception message should match expected");
    }

    @Test
    void testEqualsMethod() {
        Dog dog1 = new Dog("Puppy", 5);
        Dog dog2 = new Dog("Puppy", 5);
        Person person1 = new Person("Arbin", 30, dog1);
        Person person2 = new Person("Arbin", 30, dog2);

        assertEquals(person1, person2, "Persons with the same name, age, and dog should be equal");

        Dog dog3 = new Dog("Max", 7);
        Person person3 = new Person("Arbin", 30, dog3);
        assertNotEquals(person1, person3, "Persons with different dogs should not be equal");
    }
}
