//Filename: Transmission.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Transmission' class, that has been derived from 'Feature'
//abstract base class. Inherits all 'Feature' class fields and methods with feature
//name field set to "Transmission".
//All available options loaded from external file automatically upon instantiation


package com.company;

public class Transmission extends Feature
{
    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Transmission()
    {
        super();
        this.name = "Transmission";
        Load_options();
    }



    //Constructor with arguments
    //INPUT: list of options to copy, selected option
    //OUTPUT: no return value
    public Transmission(int num)
    {
        this.name = "Transmission";
        Load_options();
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Transmission(Transmission to_copy)
    {
        super(to_copy);
        this.name = to_copy.name;
        Load_options();
    }


    //main: testing class methods
    public static void main(String[] args)
    {
        Transmission a_feat = new Transmission();
        a_feat.display_all();
    }
}
