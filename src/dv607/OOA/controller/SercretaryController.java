package dv607.OOA.controller;


import dv607.OOA.model.Boat;
import dv607.OOA.model.Member;
import dv607.OOA.view.Console;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by MohamedOsman on 2016-09-22.
 */
public class SercretaryController {

    private final int LIST_MEMBERS_COMPACT = 1;
    private final int LIST_MEMBERS_VERBOSE = 2;
    private final int SEE_MEMBER_INFOMATION = 3;
    private final int BACK_TO_MAIN = 4;
    private final int COMPACT = 1;
    private final int VERBOSE = 2;
    private List<Member> members = new ArrayList<Member>();
    private Console mConsole;
    private FileHandler fileHandler = new FileHandler();
    private List<Boat> currentUserBoats;

    public void scerartyOptiopn(boolean sercartyRun, Console console) {
        members = fileHandler.getAllMembers();
        while (sercartyRun) {

            mConsole = console;
            console.viewSeceratyMenu();
            int choice = console.getInputInt();
            if (choice == LIST_MEMBERS_COMPACT) {

                listMembers(COMPACT);
                continue;
            } else if (choice == LIST_MEMBERS_VERBOSE) {

                listMembers(VERBOSE);
                continue;
            } else if (choice == SEE_MEMBER_INFOMATION) {
                System.out.println("See member");
                continue;
            } else if (choice == BACK_TO_MAIN) {
                sercartyRun = false;
            }


        }
    }


    private void listMembers(int choice) {
        for (int i = 0; i < members.size(); i++) {
            currentUserBoats = fileHandler.getMembersBoats(members.get(i)); //  Kolla denna metoden med om det felet ligger här.


            String membername = "";

            String memberID = "";
            String personNr = "";
            String boatType = "";
            int boatSize = 0;
            int numOfBoats = 0;
            if (choice == COMPACT) {
                memberID = members.get(i).getMemberID();
                membername = members.get(i).getName();
                numOfBoats = fileHandler.listMembersBoats(memberID).length;
                mConsole.println("Member name: " + membername + ", Member ID" + memberID + "  " + numOfBoats);

            }
            /**
             *
             * Har fastant göra detta   kan inte skriva ut alla medlmens boattyper och sizer utan den bara skriver ett av varje
             *  helt krazy  Kolla på det! kan du kanske lösa det
             *
             * */

            else if (choice == VERBOSE) {

                memberID = members.get(i).getMemberID();
                membername = members.get(i).getName();
                personNr = members.get(i).getPersonNr();
                mConsole.println("Member name: " + membername + ", Member ID: " +
                        memberID + "- Member Personnr: " + personNr +
                        ", Boat:" + ", size: " + boatSize);

            }

        }


    }





}

