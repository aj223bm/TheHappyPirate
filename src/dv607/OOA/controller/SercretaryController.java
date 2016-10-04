package dv607.OOA.controller;

import dv607.OOA.view.Console;
import jdk.nashorn.internal.ir.WhileNode;

import java.awt.*;
import java.util.Scanner;

/**
 * Created by MohamedOsman on 2016-09-22.
 */
public class SercretaryController {

    private final int LIST_MEMBERS_COMPACT = 1;
    private final int LIST_MEMBERS_VERBOSE = 2;
    private final int SEE_MEMBER_INFOMATION = 3;
    private final int BACK_TO_MAIN= 4;


    public void scerartyOptiopn(boolean sercartyRun, Console console) {

        while(sercartyRun){
            console.viewSeceratyMenu();
            int choice =console.getInputInt();
            if(choice==LIST_MEMBERS_COMPACT){
                listMembers();
             continue;
            }
            else if(choice==LIST_MEMBERS_VERBOSE){
                System.out.println("LIST VERBOSE");
                continue;
            }

            else if(choice==SEE_MEMBER_INFOMATION){
                System.out.println("See member");
                continue;
            }
            else if(choice==BACK_TO_MAIN){
                sercartyRun=false;
            }






        }
    }

    private void listMembers() {
    }
}
