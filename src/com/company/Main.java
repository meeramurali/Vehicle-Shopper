//Filename: Main.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program is an application to allow the user to build a customized vehicle by
//selecting from a list of available options for each feature such as size, exterior color,
//interior color, transmission, and cylinders. The application then searches and displays
//matches found in all car lots data base.
//Supported operations include selecting an option for a feature, displaying all selections,
//and removing selection (resetting a feature)
//External data file is used to load available options for each feature, and data for vehicles
//in each car lot.

package com.company;

import java.util.Scanner;



//main
public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);     //to read input stream
        Menu operations = new Menu();               //Menu of operations for building custom vehicle
        char response;                              //user selection from menu
        Vehicle customized;                         //Custom built with selected features
        BST_Car_lots lots = new BST_Car_lots();     //To load all car lots
        int num_lots = lots.Load_lots("resources/lots.txt");    //number of lots loaded from file

        System.out.println("\n*** " + num_lots + " car lot(s) loaded from file ***\n");

        do {
            //Build customized vehicle
            System.out.println("\n*** Build your custom vehicle by selecting desired feature options ***");
            System.out.print("\nFirst, enter a name for your customized vehicle (e.g. \"My dream car 2017\"): ");
            customized = new Vehicle(input.nextLine());
            System.out.println("\n*** Awesome! Let's get started!... ***\n");

            do {
                //Read operation to perform
                response = operations.read_user_selection();

                switch (response)
                {
                    //Select a feature option
                    case 'a':
                        String selected = customized.Read_feature_selection();
                        System.out.println("\n*** Selected: " + selected + " ***\n");
                        break;

                    //Reset a feature selected (remove selection)
                    case 'b':
                        String reset = customized.remove_feature_selection();
                        System.out.println("\n*** Reset: " + reset + " ***\n");
                        break;

                    //Display selected features so far
                    case 'c':
                        if (customized.Count_selected_features() == 0)
                            System.out.println("\n*** No features selected so far! ***\n");

                        else {
                            System.out.println("\n*** Your custom build so far.. ***\n");
                            customized.Display();
                            System.out.println();
                        }
                        break;
                }
            }
            while (response != 'd');    //Repeat until user is 'Done'

            //Display matches in each car lot for the selected features
            if (customized.Count_selected_features() != 0) {
                int num_matches = 0;

                System.out.println("\n*** Searching for matches... ***\n");
                num_matches = lots.Display_matches(customized);
                System.out.println("\n*** " + num_matches + " match(es) found! ***\n");

            }
        }
        while (operations.again()); //Repeat if user wants to start over
    }
}
