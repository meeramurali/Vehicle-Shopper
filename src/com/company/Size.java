//Filename: Size.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Size' class, that has been derived from 'Feature'
//abstract base class. Inherits all 'Feature' class fields and methods with feature
//name field set to "Size"
//All available options loaded from external file automatically upon instantiation


package com.company;

public class Size extends Feature
{
    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Size()
    {
        super();
        this.name = "Size";
        Load_options();
    }



    //Constructor with arguments
    //INPUT: selected option
    //OUTPUT: no return value
    public Size(int num)
    {
        this.name = "Size";
        Load_options();
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Size(Size to_copy)
    {
        super(to_copy);
        this.name = to_copy.name;
        Load_options();
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Size a_feat = new Size();
        a_feat.display_all();
    }
}
