//Filename: Ext_color.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Ext_Color' class, that has been derived from 'Feature'
//abstract base class. Inherits all 'Feature' class fields and methods with feature
//name field set to "Exterior Color".
//All available options loaded from external file automatically upon instantiation


package com.company;


public class Ext_Color extends Feature
{
    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Ext_Color()
    {
        super();
        this.name = "Exterior_Color";
        Load_options();
    }



    //Constructor with arguments
    //INPUT: list of options to copy, selected option
    //OUTPUT: no return value
    public Ext_Color(int num)
    {
        this.name = "Exterior_Color";
        Load_options();
        //if invalid option number for selection, set selection to default 0
        if (num >= 1 && num <= this.num_options)
            this.selection = num;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Ext_Color(Ext_Color to_copy)
    {
        super(to_copy);
        this.name = to_copy.name;
        Load_options();
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        Ext_Color a_feat = new Ext_Color();
        if (a_feat.set("Silver") != 0)

        //a_feat.display_all();
        a_feat.display();
    }
}
