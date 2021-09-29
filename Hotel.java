package hotelcheckin;

public class Hotel {

    private Rooms rooms;
    private int numberOfRooms;
    private int min = 1;
    private int max;
    private boolean personOnRoom;
    private int counter = 0;
    static private String PersonInTheRoom[];
    private String checkOutPrint;

    public Hotel(Rooms rooms, int numberOfRooms){
        this.rooms = rooms;
        this.numberOfRooms = numberOfRooms;
        this.PersonInTheRoom = new String[numberOfRooms + 1];
    }

    public void checkIn(String name) {
        max = this.numberOfRooms;
        boolean personInfo = getPersonInfo(name);
            if(personInfo == true) {
                System.out.println("You already have your room");
                System.out.println("-----------------------------------------------------------");
            }else{
                int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
                this.PersonInTheRoom[random] = name;
                System.out.println("The key to room " + random + " has been given to " + name);
                System.out.println("-----------------------------------------------------------");
                this.rooms.setRoomOccupied(random, name);
            }
    }
    
    public boolean getPersonInfo(String name){
        for(int i = 0; i < PersonInTheRoom.length; i++){
            if(PersonInTheRoom[i] == name){
                personOnRoom = true;
                break;
            }else{
                personOnRoom = false;
            }
        }
        return personOnRoom;
    }
    public String checkOut(String name){
        for (int i = 0; i < PersonInTheRoom.length; i++){
            if(PersonInTheRoom[i] == name){
                checkOutPrint = "The key to room " + i + " has been returned by " + name;
                PersonInTheRoom[i] = "null";
                this.rooms.setRoomFree(i);
                break;
            }else{
                checkOutPrint = "You weren't on any room";
            }
        }
        return checkOutPrint;
        }

    }

