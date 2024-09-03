import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
    private ArrayList<Room> rooms = new ArrayList<>();
    private ArrayList<Reservation> reservations = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void start() {
        initializeRooms();
        int choice;
        do {
            showMainMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    createReservation();
                    break;
                case 2:
                    modifyReservation();
                    break;
                case 3:
                    cancelReservation();
                    break;
                case 4:
                    viewReservations();
                    break;
                case 5:
                    checkRoomAvailability();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        } while (choice != 0);
    }

    private void initializeRooms() {
        rooms.add(new Room(101, "Single", true));
        rooms.add(new Room(102, "Double", true));
        rooms.add(new SuiteRoom(201, "Suite", true, 2));
    }

    private void showMainMenu() {
        System.out.println("\n--- Hotel Management System ---");
        System.out.println("1. Create Reservation");
        System.out.println("2. Modify Reservation");
        System.out.println("3. Cancel Reservation");
        System.out.println("4. View Reservations");
        System.out.println("5. Check Room Availability");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private void createReservation() {
        System.out.print("Enter customer name: ");
        String customerName = scanner.nextLine();
        Room room = selectRoom();
        if (room == null || !room.isAvailable()) {
            System.out.println("Room not available.");
            return;
        }

        LocalDate checkInDate = getDateInput("Enter check-in date (YYYY-MM-DD): ");
        LocalDate checkOutDate = getDateInput("Enter check-out date (YYYY-MM-DD): ");

        if (checkInDate == null || checkOutDate == null || checkOutDate.isBefore(checkInDate)) {
            System.out.println("Invalid dates provided.");
            return;
        }

        if (checkInDate.isBefore(LocalDate.now())) {
            System.out.println("Check-in date cannot be in the past.");
            return;
        }

        if (isRoomReserved(room, checkInDate, checkOutDate)) {
            System.out.println("Room is already reserved during the selected dates.");
            return;
        }

        Reservation reservation = new Reservation(customerName, room, checkInDate.toString(), checkOutDate.toString());
        reservations.add(reservation);
        room.setAvailability(false);
        System.out.println("Reservation created successfully!");
    }

    private LocalDate getDateInput(String prompt) {
        System.out.print(prompt);
        String dateStr = scanner.nextLine();
        try {
            return LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            System.out.println("Invalid date format.");
            return null;
        }
    }

    private boolean isRoomReserved(Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().equals(room)) {
                LocalDate existingCheckIn = LocalDate.parse(reservation.getCheckInDate(), dateFormatter);
                LocalDate existingCheckOut = LocalDate.parse(reservation.getCheckOutDate(), dateFormatter);

                if (!(checkOutDate.isBefore(existingCheckIn) || checkInDate.isAfter(existingCheckOut))) {
                    return true;
                }
            }
        }
        return false;
    }

    private Room selectRoom() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable()) {
                room.displayRoomInfo();
                System.out.println();
            }
        }
        System.out.print("Enter room number: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) {
                return room;
            }
        }
        System.out.println("Room not found.");
        return null;
    }

    private void modifyReservation() {
        System.out.print("Enter customer name to modify reservation: ");
        String customerName = scanner.nextLine();
        Reservation reservation = findReservationByCustomerName(customerName);
        if (reservation != null) {
            System.out.print("Enter new check-in date (YYYY-MM-DD): ");
            String checkInDate = scanner.nextLine();
            System.out.print("Enter new check-out date (YYYY-MM-DD): ");
            String checkOutDate = scanner.nextLine();
            reservation = new Reservation(customerName, reservation.getRoom(), checkInDate, checkOutDate);
            System.out.println("Reservation modified successfully!");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private void cancelReservation() {
        System.out.print("Enter customer name to cancel reservation: ");
        String customerName = scanner.nextLine();
        Reservation reservation = findReservationByCustomerName(customerName);
        if (reservation != null) {
            reservations.remove(reservation);
            reservation.getRoom().setAvailability(true);
            System.out.println("Reservation cancelled successfully!");
        } else {
            System.out.println("Reservation not found.");
        }
    }

    private void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        for (Reservation reservation : reservations) {
            reservation.displayReservationInfo();
            System.out.println();
        }
    }

    private void checkRoomAvailability() {
        for (Room room : rooms) {
            room.displayRoomInfo();
            System.out.println();
        }
    }

    private Reservation findReservationByCustomerName(String customerName) {
        for (Reservation reservation : reservations) {
            if (reservation.getCustomerName().equalsIgnoreCase(customerName)) {
                return reservation;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new Hotel().start();
    }
}
1