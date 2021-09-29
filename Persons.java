package hotelcheckin;

import javax.sound.midi.Soundbank;

public class Persons {

    private Hotel hotel;
    private String personName;

    public Persons(Hotel hotel, String name){
        this.hotel = hotel;
        this.personName = name;
    }

    public void checkIn(){
        hotel.checkIn(this.personName);
    }

    public void checkOut(){
        System.out.println(hotel.checkOut(this.personName));
        System.out.println("-----------------------------------------------------------");
    }
}
