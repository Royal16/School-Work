package hotelcheckin;

public class Main {

    public static void main(String[] args) {
        int nrRooms = 20;
        Rooms rooms = new Rooms(nrRooms);
        Hotel hotel = new Hotel(rooms, nrRooms);
        Persons person = new Persons(hotel, "Shrimp");
        Persons person1 = new Persons(hotel, "Baljeet");
        Persons person2 = new Persons(hotel, "Baby Boss");
    }
}