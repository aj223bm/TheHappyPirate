package dv607.OOA.controller;

import dv607.OOA.model.Boat;
import dv607.OOA.model.Member;
import dv607.OOA.view.Console;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MohamedOsman on 2016-09-22.
 */
public class MemberController {
    private final int REGISTER_BOAT = 1;
    private final int REMOVE_BOAT = 2;
    private final int UPPDATE_BOAT_INFO = 3;
    private final int CHANGE_MEMBER_INFO = 4;
    private final int REMOVE_ACCOUNT = 5;
    private final int LOG_OUT=6;
    private Member currentUser;
    private Console mConsole;


    private FileHandler fileHandler = new FileHandler();
    private List<Member> memberList = new ArrayList<Member>();
    private List<Boat>  currentUserBoats = new ArrayList<Boat>();


    public void memberOption(boolean memberRun, Console console) {
        currentUserBoats= fileHandler.addMembersBoats(currentUser);
        while (memberRun) {
            Scanner scan = new Scanner(System.in);
           mConsole=console;
            mConsole.ViewMemeberMenu();



            int option2 = scan.nextInt();
            if (option2 == REGISTER_BOAT) {
                registerBoat(getCurrentUser());
            } else if (option2 == REMOVE_BOAT) {
               removeBoat(currentUser);
            } else if (option2 == UPPDATE_BOAT_INFO) {
                System.out.println("Uppdated");
            } else if (option2 == REMOVE_ACCOUNT) {
                removeMember(getCurrentUser());
                memberRun = false;
                setCurrentUser(null);
                memberRun = false;
                continue;

            } else if (option2 == CHANGE_MEMBER_INFO) {
                changeMemberInformation(getCurrentUser());

            } else if (option2 == LOG_OUT) {
                console.println(" - Logged out " + getCurrentUser().getMemberID()+ ", have a nice day! :)");
                setCurrentUser(null);
                memberRun = false;
                continue;

            }
        }

    }

    private void removeBoat(Member  user ) {

        String [] boatnames = new String[currentUserBoats.size()];
        for(int i = 0; i<currentUserBoats.size();i++ ){
            boatnames[i] = "-"+currentUserBoats.get(i).getType()+ "_" + currentUserBoats.get(i).getSize();
        }

        if(boatnames.length != 0) {
            int option = mConsole.printArray(boatnames);
            if(option == boatnames.length) {
                // Back to menu
            }
            else {
                fileHandler.removeBoat(user.getMemberID(), boatnames[option]);
                currentUserBoats.remove(option);

            }
        }
        else {
            mConsole.println("There are no boats to remove!");
        }
    }

    private void changeMemberInformation(Member currentUser) {
        String[] changeoptions = {"Change name","Change Username", " Change personNumber"};
      int options=  mConsole.printArray(changeoptions);

        if(options==0){//  user should press 1 sicen the index of array starts  at 0
            mConsole.println("You choose to change your name");
            mConsole.println("Enter new name ");
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.next();
         fileHandler.changeUserInformation(newName);
            currentUser.setName(newName);

        }
        else if(options ==1){
            System.out.println("change username");

        }


    }

    public void registerBoat(Member currentUser) {
        Scanner scan = new Scanner(System.in);
        Boat boat = new Boat();
        System.out.println("Enter Boat Type: ");
        String type = scan.next();
        boat.setType(type);
        System.out.println("Enter Boat Size: ");
        int size = scan.nextInt();
        boat.setSize(size);
        currentUser.setBoat(boat);
        currentUser.addBoats();
        System.out.println(currentUser.getNrofBoats());


        try {
            if (fileHandler.registerBoat(currentUser.getMemberID(),currentUser.getBoat().getType(), currentUser.getBoat().getSize())) {

            } else {
                mConsole.ShowErrorMessage(1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void removeMember(Member member) {
        fileHandler.removeMember(member.getMemberID());
        memberList.remove(member);
        mConsole.println(" - " + member.getMemberID()+" your account has been removed");


    }


    public Member getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Member currentUser) {
        this.currentUser = currentUser;
    }



    public List<Member> getMemberList() {
        return memberList;

    }



    public Member getMember(String memberID){
        for (int i = 0; i <getMemberList().size(); i++) {
            if (memberID.equals(memberList.get(i).getMemberID())) {
                return getMemberList().get(i);
            }
        }

        return null;

    }

    public void setMemberlist(List<Member> memberList) {
        this.memberList = memberList;
    }
}

