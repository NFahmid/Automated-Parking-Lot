import java.util.List;

/**
 * Interface defining search operations for a parking lot.
 * This follows the Single Responsibility Principle by separating search functionality
 * from parking operations.
 */
public interface SearchService {
    /**
     * Finds registration numbers of vehicles with the specified color.
     * 
     * @param color the color to search for
     * @return a list of registration numbers
     */
    List<String> findRegistrationNumbersByColor(String color);
    
    /**
     * Finds slot numbers containing vehicles of the specified color.
     * 
     * @param color the color to search for
     * @return a list of slot numbers
     */
    List<Integer> findSlotNumbersByColor(String color);
    
    /**
     * Finds the slot number containing a vehicle with the specified registration number.
     * 
     * @param registrationNumber the registration number to search for
     * @return the slot number, or -1 if not found
     */
    int findSlotByRegistrationNumber(String registrationNumber);
    
    /**
     * Gets the current status of the parking lot.
     */
    void getStatus();
}