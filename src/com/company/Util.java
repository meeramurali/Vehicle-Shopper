//Filename: Util.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Util' class that manages some basic utility functions.
//Supported operations include:
//- scanner input
//- again() to ask the user if the previous operation is to be repeated


package com.company;

import java.util.Scanner;


public class Util
{
    protected Scanner input;        //To read data from input buffer



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Util()
    {
        input = new Scanner(System.in);
    }



    //Asks the user if they want to start over
    //INPUT: no arguments
    //OUTPUT: true (if user response is yes) /false
    public boolean again()
    {
        //Read user response for if previous operation is to be repeated
        System.out.println("Start over? yes/no: ");
        String response = new String();
        response = input.next();
        input.nextLine();

        //convert to uppercase
        //Return true if "YES", false otherwise
        if (response.toUpperCase().equals("YES"))
            return true;
        return false;
    }
}