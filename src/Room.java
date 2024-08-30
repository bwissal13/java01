public class Room {

        private int nbr;
        private String type;
        private boolean availability;

        public Room(int number, String type, boolean availability) {
            this.nbr = number;
            this.type = type;
            this.availability = availability;
        }

        public int getNumber() {
            return nbr;
        }

        public String getType() {
            return type;
        }

        public boolean isAvailable() {
            return availability;
        }

        public void setAvailability(boolean availability) {
            this.availability = availability;
        }

        public void displayRoomInfo() {
            System.out.println("Room Number: " + nbr);
            System.out.println("Room Type: " + type);
            System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
        }
}


