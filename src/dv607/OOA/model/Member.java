package dv607.OOA.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman and Adam Johansson on 2016-09-15.
 */
public class Member {
    private String name;
    private String PersonNr;  // dont forget to parse
    private String MemberID;
    private int  numberofBoats;
    private Boat boat;

    public List<Boat> getBoats() {
        return boats;
    }

    private List<Boat> boats = new ArrayList<Boat>();
    private String  memberInformaiton ;


    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;


    }
   public void addBoats(Boat boat1 ){
       if(boat1!=null){
           boats.add(boat1);

       }


    }

    public int getNrofBoats(){

       return boats.size();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonNr() {
        return PersonNr;
    }

    public void setPersonNr(String personNr) {
        PersonNr = personNr;
    }

    public String getMemberID() {
        return MemberID;
    }

    public void setMemberID(String memberID) {
        MemberID = memberID;
    }

    public int getNumberofBoats() {
        return numberofBoats;
    }

    public void setNumberofBoats(int numberofBoats) {
        this.numberofBoats = numberofBoats;
    }




    public  String getMemberInformaiton(){
        return "Name "+ getName()+
                "Person Number " + getPersonNr()+
                "UserName "+  getMemberID();


    }


    
}
