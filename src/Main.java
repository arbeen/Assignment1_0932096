import PetTracker.Person;

public class Main {
    public static void main(String[] args) {
        // person without a dog
        Person personWithoutDog = new Person("John", 30);

        try {
            // Try to change the dog’s name (which should throw an exception)
            personWithoutDog.changeDogsName("Buddy");
        } catch (RuntimeException e) {
            // Catch the exception and print the message
            System.out.println("Unable to change dogs name: " + e.getMessage());
        }
    }
}