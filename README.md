# Hotel Management System

## Overview

This project is a simple hotel management system implemented in Java. It allows users to create, modify, and cancel room reservations, as well as check room availability. The system uses `ArrayList` to store room and reservation data, and it handles input through the command line.

## Features

- **Create Reservation**: Users can create a reservation by selecting an available room and providing customer details and the reservation period.
- **Modify Reservation**: Existing reservations can be modified by updating the check-in and check-out dates.
- **Cancel Reservation**: Users can cancel a reservation by providing the customer name.
- **View Reservations**: Users can view all existing reservations.
- **Check Room Availability**: Users can view the availability of all rooms.

## Class Structure

### 1. `Hotel`

The `Hotel` class is the main class that handles the overall management of the hotel. It includes the following methods:

- `start()`: Initiates the program and displays the main menu.
- `initializeRooms()`: Initializes the rooms available in the hotel.
- `showMainMenu()`: Displays the main menu options.
- `createReservation()`: Handles the creation of new reservations.
- `modifyReservation()`: Allows modification of existing reservations.
- `cancelReservation()`: Cancels a reservation.
- `viewReservations()`: Displays all reservations.
- `checkRoomAvailability()`: Displays the availability of all rooms.
- `selectRoom()`: Allows the user to select a room by entering the room number.
- `getDateInput(String prompt)`: Handles date input with validation.
- `isRoomReserved(Room room, LocalDate checkInDate, LocalDate checkOutDate)`: Checks if a room is reserved during a specific period.
- `findReservationByCustomerName(String customerName)`: Finds a reservation by the customer's name.

### 2. `Reservation`

The `Reservation` class represents a reservation in the hotel. It includes:

- **Fields**: `customerName`, `room`, `checkInDate`, `checkOutDate`.
- **Constructor**: Initializes a reservation with customer name, room, and reservation dates.
- **Methods**:
    - `getCustomerName()`: Returns the customer's name.
    - `getRoom()`: Returns the room associated with the reservation.
    - `getCheckInDate()`, `getCheckOutDate()`: Returns the check-in and check-out dates.
    - `displayReservationInfo()`: Displays the reservation details.

### 3. `Room`

The `Room` class represents a room in the hotel. It includes:

- **Fields**: `nbr`, `type`, `availability`.
- **Constructor**: Initializes a room with a number, type, and availability status.
- **Methods**:
    - `getNumber()`, `getType()`: Returns the room number and type.
    - `isAvailable()`, `setAvailability(boolean availability)`: Gets and sets the room's availability.
    - `displayRoomInfo()`: Displays the room's details.

### 4. `SuiteRoom`

The `SuiteRoom` class extends the `Room` class and represents a suite room with additional information about the number of bedrooms.
