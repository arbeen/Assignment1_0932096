package test;
import PetTracker.Dog;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    void testDogCreation() {
        Dog dog = new Dog("Buddy", 5);
        assertEquals("Buddy", dog.getName(), "Dog name should be Buddy");
        assertEquals(5, dog.getAge(), "Dog age should be 5");
    }

    @Test
    void testSetName() {
        Dog dog = new Dog("Buddy", 5);
        dog.setName("Charlie");
        assertEquals("Charlie", dog.getName(), "Dog name should be Charlie after update");
    }

    @Test
    void testSetAge() {
        Dog dog = new Dog("Buddy", 5);
        dog.setAge(7);
        assertEquals(7, dog.getAge(), "Dog age should be 7 after update");
    }

    @Test
    void testEqualsMethod() {
        Dog dog1 = new Dog("Buddy", 5);
        Dog dog2 = new Dog("Buddy", 5);
        Dog dog3 = new Dog("Charlie", 7);

        assertTrue(dog1.equals(dog2), "Dogs with the same name and age should be equal");
        assertFalse(dog1.equals(dog3), "Dogs with different names or ages should not be equal");
    }
}
