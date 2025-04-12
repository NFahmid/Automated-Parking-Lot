import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingLot parkingLot = new ParkingLot();
        boolean isRunning = true;
        boolean isInitialized = false;

        System.out.println("Welcome to Parking Lot Management System");

        while (isRunning) {
            if (!isInitialized) {
                System.out.println("\nPlease initialize the parking lot first using: create_parking_lot <n>");
            } else {
                System.out.println("\nAvailable commands:");
                System.out.println("1. park <registration_number> <color>");
                System.out.println("2. leave <slot_number>");
                System.out.println("3. status");
                System.out.println("4. registration_numbers_for_cars_with_colour <color>");
                System.out.println("5. slot_numbers_for_cars_with_colour <color>");
                System.out.println("6. slot_number_for_registration_number <registration_number>");
                System.out.println("7. exit");
            }
            System.out.print("Enter command: ");

            String input = scanner.nextLine();
            String[] parts = input.split(" ");

            try {
                switch (parts[0].toLowerCase()) {
                    case "create_parking_lot":
                        if (parts.length < 2) {
                            System.out.println("Invalid command format. Use: create_parking_lot <n>");
                            break;
                        }
                        try {
                            int size = Integer.parseInt(parts[1]);
                            parkingLot.initialize(size);
                            System.out.println("Created a parking lot with " + size + " slots");
                            isInitialized = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid parking lot size. Please enter a valid number.");
                        }
                        break;
                        
                    case "1":
                    case "park":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        if (parts.length < 3) {
                            System.out.println("Invalid command format. Use: park <registration_number> <color>");
                            break;
                        }
                        String regNumber = parts[1];
                        String color = parts[2];
                        Car car = new Car(regNumber, color);
                        Ticket ticket = parkingLot.parkCar(car);
                        if (ticket != null) {
                            System.out.println("Allocated slot number: " + ticket.getSlotNumber());
                        } else {
                            System.out.println("Sorry, parking lot is full");
                        }
                        break;

                    case "2":
                    case "leave":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        if (parts.length < 2) {
                            System.out.println("Invalid command format. Use: Leave <slot_number>");
                            break;
                        }
                        int leaveSlot = Integer.parseInt(parts[1]);
                        boolean success = parkingLot.leaveSlot(leaveSlot);
                        if (success) {
                            System.out.println("Slot number " + leaveSlot + " is free");
                        } else {
                            System.out.println("Slot number " + leaveSlot + " is already empty or invalid");
                        }
                        break;

                    case "3":
                    case "status":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        parkingLot.getStatus();
                        break;

                    case "4":
                    case "registration_numbers_for_cars_with_colour":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        if (parts.length < 2) {
                            System.out.println("Invalid command format. Use: Registration numbers for cars with color <color>");
                            break;
                        }
                        String colorToFind = parts[1];
                        List<String> regNumbers = parkingLot.findRegNumbersByColor(colorToFind);
                        if (regNumbers.isEmpty()) {
                            System.out.println("No cars found with color " + colorToFind);
                        } else {
                            System.out.println(String.join(", ", regNumbers));
                        }
                        break;

                    case "5":
                    case "slot_numbers_for_cars_with_colour":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        if (parts.length < 2) {
                            System.out.println("Invalid command format. Use: Slot numbers for cars with color <color>");
                            break;
                        }
                        String colorForSlots = parts[1];
                        List<Integer> slotNumbers = parkingLot.findSlotNumbersByColor(colorForSlots);
                        if (slotNumbers.isEmpty()) {
                            System.out.println("No cars found with color " + colorForSlots);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            for (Integer slot : slotNumbers) {
                                sb.append(slot).append(", ");
                            }
                            if (sb.length() > 0) {
                                sb.setLength(sb.length() - 2);
                            }
                            System.out.println(sb.toString());
                        }
                        break;

                    case "6":
                    case "slot_number_for_registration_number":
                        if (!isInitialized) {
                            System.out.println("Parking lot not initialized. Please use create_parking_lot command first.");
                            break;
                        }
                        if (parts.length < 2) {
                            System.out.println("Invalid command format. Use: Slot number for registration number <registration_number>");
                            break;
                        }
                        String regNumberToFind = parts[1];
                        int foundSlot = parkingLot.findSlotByRegNumber(regNumberToFind);
                        if (foundSlot != -1) {
                            System.out.println(foundSlot);
                        } else {
                            System.out.println("Not found");
                        }
                        break;

                    case "7":
                    case "exit":
                        isRunning = false;
                        System.out.println("Exiting Parking Lot Management System. Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid command. Please try again.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}