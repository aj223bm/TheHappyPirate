package dv607.OOA;

import dv607.OOA.controller.MainController;
import dv607.OOA.view.Console;

import java.net.ConnectException;

public class Main {


    public static void main(String[] args) {
        MainController mainController = new MainController();
        Console console =new Console();
        mainController.systemRun(console);



    }
}
