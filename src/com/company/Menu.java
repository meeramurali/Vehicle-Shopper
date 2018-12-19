//Filename: Menu.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program manages the 'Menu' class, to display menu of operations and read user choice
//of operation to perform
//Supported operations include displaying all features, displaying all options
//for a specific feature, selecting an option for a feature, displaying all selections,
//and removing selection (resetting a feature)


package com.company;

public class Menu extends Util
{
    //Displays menu of operations
    //INPUT: no arguments
    //OUTPUT: no return value
    public void display()
    {
        System.out.println("*** Select operation: ***");
        System.out.println("\ta. Select a feature option");
        System.out.println("\tb. Remove a selection");
        System.out.println("\tc. Display all selections made so far");
        System.out.println("\td. Done");

    }



    //Reads user selection for operation to perform
    //INPUT: no arguments
    //OUTPUT: user selection (from 'a' to 'd')
    public char read_user_selection()
    {
        char response;      //user selection to return
        boolean invalid;    //to flag invalid response

        //Repeat until valid response is read
        do
        {
            //Reset invalid flag
            invalid = false;

            //Display menu
            display();

            //Read in user response
            System.out.print("Enter a letter from a to d: ");
            response = input.next().charAt(0);
            input.nextLine();

            //convert to lower case
            response = Character.toLowerCase(response);

            //If invalid, set flag
            if (!(response >= 'a' && response <='d'))
            {
                System.out.println("\n*** Invalid entry! Try again... ***\n");
                invalid = true;
            }
        }
        while (invalid);

        return response;
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Menu test = new Menu();

        char sel = test.read_user_selection();
        System.out.println("You selected: " + sel);
    }
}
