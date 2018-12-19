//Filename: Vehicle.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Vehicle' class, that has been derived from 'List_Features'
//class. A vehicle consists of the vehicle name and a list of selected feature options
//Supported operations include:
//- Display all selected features
//- Comparing names with another vehicle object

package com.company;


public class Vehicle extends List_Features
{
    protected String name;      //Name of vehicle (e.g. Honda Accord)



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Vehicle()
    {
        super();
        this.name = null;
    }



    //Constructor with argument
    //INPUT: name of vehicle
    //OUTPUT: no return value
    public Vehicle(String a_name)
    {
        super();
        this.name = a_name;
    }



    //Constructor with arguments
    //INPUT: name of vehicle, list of features to copy
    //OUTPUT: no return value
    public Vehicle(String a_name, List_Features to_copy)
    {
        super(to_copy);
        this.name = a_name;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Vehicle(Vehicle to_copy)
    {
       super(to_copy);
       this.name = to_copy.name;
    }



    //Displays selected feature options for vehicle
    //INPUT: no arguments
    //OUTPUT: no return value
    public void Display()
    {
        //Display vehicle name
        System.out.println("Vehicle name: " + this.name);

        //Display selected feature options
        super.Display_selections();
    }



    //Compares vehicle name with that of argument object
    //INPUT: vehicle to compare with
    //OUTPUT: true (less than argument), false (greater than or equal to argument)
    public boolean Is_less_than(Vehicle to_compare)
    {
        if (this.name.compareTo(to_compare.name) < 0)
            return true;

        else
            return false;
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Vehicle A = new Vehicle("Accord");
        Vehicle B;

        if(A.Set_feature("Exterior_Color", "Red")
                && A.Set_feature("Size", "Full-size"))
        {
            A.Display();
        }

        B = new Vehicle(A);
        B.Display();

        Vehicle C = new Vehicle("BMW");

        if (C.Is_less_than(A))
            System.out.println("Is less than");
        else
            System.out.println("Greater or equal to");
    }

}
