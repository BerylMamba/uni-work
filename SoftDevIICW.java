/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package softdeviicw;

import java.util.*;
import java.io.BufferedWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mirza Agha Bilal
 */
public class SoftDevIICW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        String name = "name";
        String fname = "fname";

        String[] ship = new String[12];

        for (int i = 0; i < ship.length; i++) {
            ship[i] = "Empty Cabin";
        }

        String choice = "enter";

        while (!choice.equals("q")) {

            System.out.println("\nPlease select one of the following options: ");
            System.out.println(
                    "V: View all cabins \nA: Add a customer to a cabin \nE: Display Empty cabins \nD: Delete customer from cabin \nF: Find cabin from customer name \nS: Store program data into file \nL: Load program data from file \nO: View passengers Ordered alphabetically by name \nQ: Quit the Program.");
            System.out.println("");
            System.out.print("Enter Your Choice: ");

            Scanner in = new Scanner(System.in);
            choice = in.next();

            System.out.println("");

            if (choice.equals("v") || choice.equals("V")) // this allows the user to input both lower and uppercase from
                                                          // the options
            {
                viewCabins(ship);

            } else if (choice.equals("a") || choice.equals("A")) {
                addClient(ship);

            } else if (choice.equals("e") || choice.equals("E")) {
                displayEmpty(ship);

            } else if (choice.equals("d") || choice.equals("D")) {
                deleteClient(ship, name);

            } else if (choice.equals("f") || choice.equals("F")) {
                findName(ship);

            } else if (choice.equals("s") || choice.equals("S")) {
                storeData(ship);

            } else if (choice.equals("l") || choice.equals("L")) {
                loadData(ship);

            } else if (choice.equals("o") || choice.equals("O")) {
                sortAlpha(ship);
            } else if (choice.equals("q") || choice.equals("Q")) { // this would end the while loop
                break;

            }
        }
    }

    public static void viewCabins(String ship[]) {

        for (int i = 0; i < ship.length; i++) {
            System.out.println("Cabin " + (i + 1) + ": " + ship[i]);
        }

    }

    public static void addClient(String ship[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Cabin number (from 1 to 12): ");

        int number = in.nextInt();

        System.out.println("You have chosen: " + number);
        System.out.print("Please enter your name: ");

        String name = in.next();
        ship[number - 1] = name; // take away one from the user input as the index starts from 0

    }

    public static void displayEmpty(String ship[]) {

        for (int i = 0; i < ship.length; i++) {
            if (ship[i].equals("Empty Cabin")) {
                System.out.println("Cabin " + (i + 1) + ": " + ship[i]);
            }
        }

    }

    public static void deleteClient(String ship[], String name) {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter a Cabin you would like to empty (from 1 to 12): ");

        int delete = in.nextInt();

        ship[delete - 1] = "Empty cabin";
        System.out.println("Cabin " + delete + " has been emptied. ");

    }

    public static void findName(String ship[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("What is the Custoumers name you would like to find: ");
        String find = in.next();
        // boolean found = false; // first i used a boolean which would check through
        // the array for the name and if true it would print the name

        for (int i = 0; i < ship.length; i++) {
            if (find.equals(ship[i])) {
                // found = true;
                System.out.println(find + " is found in Cabin Number " + (i + 1));
                break;
            } else {
                System.out.println(find + " is not found in Cabin Number " + (i + 1));
            }
        }
        // if (found) {
        // System.out.println(find + " is found in Cabin Number " + (i + 1)); // however
        // when trying to print the cabin number i had to put it within the for loop
        // which rendered the boolean useless
        // }
    }

    public static void storeData(String ship[]) throws IOException {

        try {
            FileWriter store = new FileWriter("data.txt");
            for (int i = 0; i < ship.length; i++) {
                store.write("Cabin " + (i + 1) + ": " + ship[i] + System.lineSeparator());
            }
            store.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    public static void loadData(String ship[]) throws IOException {

        String fileName = "data.txt";

        FileReader load = new FileReader(fileName);

        try {
            char[] a = new char[2048]; // this sets a characteer limit to which it can load up
            load.read(a);
            System.out.println("Data loaded from file: ");
            System.out.println();

            for (char c : a) {
                System.out.print(c);
            }
        } finally {
            load.close();
        }

    }

    public static void sortAlpha(String ship[]) {

        Arrays.sort(ship);
        for (int i = 0; i < ship.length; i++) {
            System.out.println(ship[i]);
        }
    }
}