//Filename: Option.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Option' class, that is a single node in a linear linked list of options,
//where each node contains a String description (like “Red” option for Exterior color feature), and a
//reference to the next node in list.
//Supported operations include:
//- Set option description (Sets data field value)
//- Display option
//- Traverse next Option
//- Connect next Option


package com.company;

public class Option extends Util
{
    protected String data;      //description of option
    protected Option next;      //reference to the next node in list



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Option()
    {
        this.data = null;
        this.next = null;
    }



    //Constructor with arguments
    //INPUT: description to copy
    //OUTPUT: no return value
    public Option(String a_data)
    {
        this.data = a_data;
        this.next = null;
    }



    //Copy constructor
    //INPUT: option to copy
    //OUTPUT: no return value
    public Option(Option to_copy)
    {
        this.data = to_copy.data;
        this.next = null;
    }



    //Sets option description to argument value
    //INPUT: description to copy
    //OUTPUT: no return value
    public void Set(String a_data)
    {
        this.data = a_data;
    }



    //Sets next node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_next(Option connection)
    {
        this.next = connection;
    }



    //Returns next node reference
    //INPUT: no arguments
    //OUTPUT: next node reference
    public Option Get_next()
    {
        return this.next;
    }



    //Displays option description
    //INPUT: no arguments
    //OUTPUT: no return value
    public void display()
    {
        //display option description
        System.out.println("\t" + this.data);
    }
}
