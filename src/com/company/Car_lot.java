//Filename: Car_lot.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Car_lot' class which is derived from the "BST_Vehicles" class.
//Supported operations include inserting a new vehicle, displaying all vehicle,
//and finding all matches for a customized vehicle
//External data file is used to load data for all vehicles in car lot.


package com.company;

public class Car_lot extends BST_Vehicles
{
    protected String name;          //Name of the car lot (e.g. Carmax)



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Car_lot ()
    {
        super();
        name = null;
    }



    //Constructor with argument
    //INPUT: name of car lot
    //OUTPUT: no return value
    public Car_lot (String a_name)
    {
        super();
        name = a_name;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Car_lot(Car_lot to_copy)
    {
        super(to_copy);
        this.name = to_copy.name;
    }



    //Displays all vehicles in car lot in order of vehicle name
    //INPUT: no return value
    //OUTPUT: number of vehicles
    public int Display()
    {
        //Display car lot name
        System.out.println("\n*** Car lot: " + this.name + " ***\n");

        //Display all vehicles
        return display_inorder();
    }



    //Compares car lot name with that of argument object
    //INPUT: car lot to compare with
    //OUTPUT: true (less than argument), false (greater than or equal to argument)
    public boolean Is_less_than(Car_lot to_compare)
    {
        //If current object's name is less than argument's return true
        if (this.name.compareTo(to_compare.name) < 0)
            return true;

        //If current object's name is greater than or equal to argument's return false
        else
            return false;
    }



    //Wrapper - Displays all matches in car lot for argument vehicle
    //INPUT: vehicle to match
    //OUTPUT: number of matches
    public int Display_matches(Vehicle custom)
    {
        int num_matches;        //total number of matches

        //Display car lot name
        System.out.println("\n*** Car lot: " + this.name + " ***\n");

        //Display all matches found
        num_matches = display_matches(custom);
        if (num_matches == 0)
            System.out.println("No matches found");

        return num_matches;
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Car_lot test = new Car_lot("Carmax");
        test.Load_vehicles("resources/Vehicles.txt");
        int dis = test.Display();
        System.out.println("(" + dis + " vehicles found)");
    }
}
