package dv607.OOA.controller;


import dv607.OOA.model.Member;
import dv607.OOA.view.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by MohamedOsman on 2016-09-22.
 */
public class MainController {
    private final int MEMBER_OPTION = 1;
    private  final int SECERATARY_OPTION = 2;
    private  final int SIGN_UP_OPTION = 3;


    private Member member;
    private Console console;
    private boolean run = true;
    private Scanner scan;




    private FileHandler fileHandler = new FileHandler();
    MemberController memberController;
    SercretaryController sercretaryController;
    private boolean memberRun= false;
    private  String user;
    private boolean sercartyRun =false;


    public void systemRun(Console console) {
        memberController = new MemberController();
        SercretaryController sercretaryController = new SercretaryController();
        this.console = console;
         memberController.setMemberlist(fileHandler.getAllMembers());
        while (run) {

            this.console.ViewMainMenu();
            int option= console.getInputInt();

            if (option == MEMBER_OPTION) {
                if(memberController.getCurrentUser() == null) {
                    System.out.print("Enter your username: ");
                    user = console.getInputString();
                    if(memberController.getMember(user)==null) {
                      this.console.ShowErrorMessage(0);
                        continue;
                    }
                    else {
                      memberController.setCurrentUser(memberController.getMember(user));
                        memberRun = true;
                        System.out.println(" - Logged in as " + memberController.getCurrentUser().getMemberID());
                    }
                }


              memberController.memberOption(memberRun, console);

            } else if (option == SECERATARY_OPTION) {
                sercartyRun= true;
                sercretaryController.scerartyOptiopn(sercartyRun, console);



            } else if (option == SIGN_UP_OPTION) {

                   registerMember();

            }
        }
    }




    // registers new member.
        private void registerMember (){
            Scanner scan = new Scanner(System.in);
            member = new Member();
            System.out.println("Enter Name");
            String name = scan.next();
            member.setName(name);
            System.out.println("Enter person Number");
            String personNr = scan.next();
            member.setPersonNr(personNr);
            System.out.println("Enter  username");
            String userName = scan.next();
            member.setMemberID(userName);
            fileHandler.registerMember(member.getMemberID(),member.getName(),member.getPersonNr());
            memberController.getMemberList().add(member);



        }
}


