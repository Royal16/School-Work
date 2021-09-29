package hotelcheckin;

public class Rooms {

    private int[] nrOfRooms;
    public Rooms(int numberOfRooms){
        this.nrOfRooms = new int[numberOfRooms + 1];
    }


    public boolean isOcuppied(int roomNumber){
        if (this.nrOfRooms[roomNumber] == 1){
            return true;
        }else{
            return false;
        }
    }

    public void setRoomOccupied(int random, String name){
        this.nrOfRooms[random] = 1;
        System.out.println("Room " + random + " is now being used by " + name);
        System.out.println("-----------------------------------------------------------");
    }

    public void setRoomFree(int room){
        this.nrOfRooms[room] = 0;
        System.out.println("Room " + room + " is no longer being used");
        System.out.println("-----------------------------------------------------------");
    }
}
