//Filename: Int_Color.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Int_Color' class, that has been derived from 'Feature'
//abstract base class. Inherits all 'Feature' class fields and methods with feature
//name field set to "Interior Color".
//All available options loaded from external file automatically upon instantiation


package com.company;

public class Int_Color extends Feature
{
    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Int_Color()
    {
        super();
        this.name = "Interior_Color";
        Load_options();
    }



    //Constructor with arguments
    //INPUT: list of options to copy, selected option
    //OUTPUT: no return value
    public Int_Color(int num)
    {
        this.name = "Interior_Color";
        Load_options();
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Int_Color(Int_Color to_copy)
    {
        super(to_copy);
        this.name = to_copy.name;
        Load_options();
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Int_Color a_feat = new Int_Color();
        a_feat.display_all();
    }
}
