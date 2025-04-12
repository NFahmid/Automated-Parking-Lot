/**
 * Implementation of the Vehicle interface representing a car.
 * This follows the Liskov Substitution Principle by properly implementing the Vehicle interface.
 */
public class Car implements Vehicle {
    private String registrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }
}