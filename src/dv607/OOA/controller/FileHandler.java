package dv607.OOA.controller;


import dv607.OOA.model.Boat;
import dv607.OOA.model.Member;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    static String path = "/Users/database/Members.txt";


    public boolean registerBoat(String memberID, String type, int size) throws IOException {
        try {
            String input;
            input = readFile();

            input = input.replace(memberID + "Boats", memberID + "Boats\n" + type + "_" + size);

            FileOutputStream out = new FileOutputStream(path);
            out.write(input.getBytes());

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }


    public boolean registerMember(String memberID, String name, String personNr) {
        try {
            String input;
            input = readFile();

            if (!input.contains(memberID)) { //if member doesn't exist
                input = input + ":" + memberID + "\n" + name + "\n" + personNr + "\n" + memberID + "Boats\n";

                FileOutputStream out = new FileOutputStream(path);
                out.write(input.getBytes());

                out.close();
                return true; //registered
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    private String readFile() {

        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));

            String line;
            String input = "";

            while ((line = file.readLine()) != null) input += line + '\n';

            file.close();

            return input;
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }

    }


//    public  boolean userExists(String memberID)  {
//
//        String input;
//        input = readFile();
//
//        if (input.contains(":" + memberID + "\n")) {
//            return true;
//        }
//         return false;
//
//    }


    public String[] listMembersBoats(String memberID) {

        ArrayList<String> arr = new ArrayList<String>();
        arr.clear();

        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));

            String line;

            boolean addLines = false;
            while ((line = file.readLine()) != null) {
                if (addLines && line.contains("-")) {
                    arr.add(line.substring(1, line.length())); // Removes '-' from start of line.
                }

                if (line.equals(memberID + "Boats")) {
                    addLines = true;
                } else if (line.contains(":")) {
                    if (addLines) {
                        addLines = false;
                        break;
                    }
                }
            }

            file.close();

        } catch (IOException e) {
            e.printStackTrace();

        }
        String newArr[] = arr.toArray(new String[0]);
        return newArr;

    }


    public void removeBoat(String memberID,String boat) {

        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));


            String line;
            String input = "";

            boolean replace = false;
            while ((line = file.readLine()) != null) {
                if (replace && line.contains(boat)) {
                    replace = false;
                } else if (line.equals(memberID + "Boats")) {
                    replace = true;
                    input += ("\n" + line);
                } else {
                    input += ("\n" + line);
                }
            }

            FileOutputStream out = new FileOutputStream(path);
            out.write(input.getBytes());

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }





    public void removeMember(String memberID) {

        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));


            String line;
            String input = "";

            boolean replace = false;
            while ((line = file.readLine()) != null) {
                if (replace && line.contains(":")) {
                    replace = false;
                     input += ("\n" + line);
                } else if (line.equals(":"+ memberID)) {
                    replace = true;

                } else if(!replace){
                    input += ("\n" + line);
                }

            }

            FileOutputStream out = new FileOutputStream(path);
            out.write(input.getBytes());

            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public List<Member> getAllMembers() {
        BufferedReader file;
        try {
            file = new BufferedReader(new FileReader(path));
            List<Member> members = new ArrayList<Member>();
            String line;
            boolean createMember = false;
            Member member = null;
            int lineCounter = 0;
            while ((line = file.readLine()) != null) {
                if(line.contains(":") && !createMember) {
                    createMember = true;
                    member = new Member();
                    member.setMemberID(line.substring(1));
                    lineCounter = 1;

                }
                else if(lineCounter == 1) {
                    member.setName(line);
                    lineCounter ++;
                }
                else if(lineCounter == 2) {
                    member.setPersonNr(line);
                    lineCounter = 0;
                    members.add(member);
                    createMember=false;
                }

            }
            return members;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;

    }


    public List<Boat> addMembersBoats(String memberID) {
        String stringArr[] = listMembersBoats(memberID);

        List<Boat> boats = new ArrayList<Boat>();

        String temp[];

        for(int i=0; i<stringArr.length; i++) {

            temp = stringArr[i].split("_");

            Boat boat = new Boat();
            boat.setType(temp[0]);
            boat.setSize(Integer.valueOf(temp[1]));

            boats.add(boat);
        }
        return boats;

    }

    public  void changeUserInformation(String information) {




    }
}





