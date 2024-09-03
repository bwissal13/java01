public class SuiteRoom extends Room {
    private int numberOfBedrooms;

    public SuiteRoom(int number, String type, boolean availability, int numberOfBedrooms) {
        super(number, type, availability);
        this.numberOfBedrooms = numberOfBedrooms;
    }

    @Override
    public void displayRoomInfo() {
        super.displayRoomInfo();
        System.out.println("Number of Bedrooms: " + numberOfBedrooms);
    }
}
