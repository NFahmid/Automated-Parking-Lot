/**
 * Interface representing a vehicle that can be parked in the parking lot.
 * This follows the Interface Segregation Principle by defining a minimal interface
 * that clients need to implement.
 */
public interface Vehicle {
    /**
     * Gets the registration number of the vehicle.
     * 
     * @return the registration number
     */
    String getRegistrationNumber();
    
    /**
     * Gets the color of the vehicle.
     * 
     * @return the color
     */
    String getColor();
}