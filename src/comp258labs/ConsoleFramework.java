/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package comp258labs;

import java.util.Scanner;

/**
 *
 * @author jaden
 */
public abstract class ConsoleFramework {

    public Scanner input = new Scanner(System.in);
    public final int QUIT_OPTION = 0;

    public final void run() {
        startProgram();
        int choice;
        do {
            choice = showMenu();
            if (choice != QUIT_OPTION) {
                executeAction(choice);
            }
        } while (choice != QUIT_OPTION);
        endProgram();
    }

    public abstract int showMenu();

    public abstract void executeAction(int choice);

    public void startProgram() {
        //TODO: Start up language
    }

    public void endProgram() {
        //TODO: Start up language
    }

    protected int readInt(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextInt()) {
            System.out.println("Please enter a whole number.");
            input.nextLine();
            System.out.println(prompt);
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    protected int readDouble(String prompt) {
        System.out.println(prompt);
        while (!input.hasNextDouble()) {
            System.out.println("Please enter a whole number.");
            input.nextLine();
            System.out.println(prompt);
        }
        int value = input.nextInt();
        input.nextLine();
        return value;
    }

    protected String readString(String prompt) {
        System.out.println(prompt);
        String value = input.nextLine();
        return value;
    }
}
