import java.util.List;


public interface SearchService {

    List<String> findRegistrationNumbersByColor(String color);

    List<Integer> findSlotNumbersByColor(String color);

    int findSlotByRegistrationNumber(String registrationNumber);

    void getStatus();
}