package dv607.OOA.view;


import java.util.Scanner;

/**
 * Created by MohamedOsman on 2016-09-19.
 */
public class Console {

    private final int ERROR_USERNAME=0;
    private final int  ERROR_BOAT_REG = 1;

    public int getInputInt() {
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        return choice;
    }

    public  String getInputString() {
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        return choice;
    }

    public  void ViewMemeberMenu(){
        System.out.println("\nMember Menu");
        System.out.println("1: Register boat");
        System.out.println("2: Remove boat");
        System.out.println("3: update Boat information");
        System.out.println("4: Change member information");
        System.out.println("5: Remove Account");
        System.out.println("\n 6: Log out");

    }



    public void ViewMainMenu() {
        System.out.println("Welcom To club, Please chose from the menu");
        System.out.println();
        System.out.println("1:member");
        System.out.println("2:Seceraty");
        System.out.println("3:Sign up");
    }


    public void  ShowErrorMessage(int id ){
      switch (id){
          case ERROR_USERNAME:
              System.out.println(" - Error logging in, try again or Sign up!");

          case ERROR_BOAT_REG:
              System.out.println("Error, The boat clould be registerd");
      }



    }

    public int printArray(String [] arr) {
        if(arr.length != 0) {
            Scanner scan = new Scanner(System.in);
            System.out.println("\nChoose a number: ");
            for(int i=0; i<arr.length; i++) {
                System.out.println((i+1) + ". " + (arr[i]));
            }
            System.out.println("\n" + (arr.length + 1) + ". Back");
            int option = scan.nextInt();
            return option-1;
        }
        else {
            System.out.println("There is nothing here!");
            return -1;
        }
    }

    public void print(String s) {
        System.out.print(s);
    }

    public void println(String s) {
        System.out.println(s);
    }


    public void viewSeceratyMenu() {
        System.out.println("\nSecretary Menu");
        System.out.println("1: List members(compact)");
        System.out.println("2: List members(Verbose");
        System.out.println("3: see member information");
        System.out.println("\n 4: Back to main menu");

    }
}
