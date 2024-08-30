public class Reservation {
    private String customerName;
    private Room room;
    private String checkInDate;
    private String checkOutDate;

    public Reservation(String customerName, Room room, String checkInDate, String checkOutDate) {
        this.customerName = customerName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void displayReservationInfo() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Room Number: " + room.getNumber());
        System.out.println("Check-In Date: " + checkInDate);
        System.out.println("Check-Out Date: " + checkOutDate);
    }
}
