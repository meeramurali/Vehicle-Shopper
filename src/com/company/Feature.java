//Filename: Feature.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  4
//Date:     08/21/2017

//This program implements the 'Feature' class, that has been implemented as an abstract base class,
//from which individual features like ‘Exterior color’, ‘Interior color’, ‘Size’, ‘Transmission’,
//‘Cylinders’ etc. are derived. This allows for a set of ‘Feature’ references to be created, each
// of which can reference a derived class object through dynamic binding and upcasting.
//Supported operations include:
//- Select an option (update ‘Selection’ field value)
//- Remove selection (reset ‘Selection’ field value to default)
//- Display selected option (display ‘Option’ at position number ‘Selection’ value in list of options)
//All available options for a feature are loaded from external file automatically upon instantiation


package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


abstract public class Feature extends List_Options
{
    protected String name;          //name of feature (e.g. "Exterior color")
    protected int selection;        //selected option
    protected Feature next;         //reference to next feature in list



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Feature() {
        this.selection = 0;
        this.next = null;
    }



    //Constructor with arguments
    //INPUT: selected option
    //OUTPUT: no return value
    public Feature(int num) {
        //if invalid option number for selection, set selection to default 0
        if (!(num >= 1 && num <= this.num_options))
            this.selection = 0;

            //Set selection
        else
            this.selection = num;

        this.next = null;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Feature(Feature to_copy) {
        super(to_copy);
        this.next = null;
        this.selection = to_copy.selection;
        this.name = to_copy.name;
    }



    //Displays selected option for feature
    //INPUT: no arguments
    //OUTPUT: true/false (success/failure)
    public boolean display() {
        //If selection set, display selected option
        if (selection > 0)
            System.out.print(this.name + ": ");

        return super.display(this.selection);
    }



    //Displays name of feature
    //INPUT: no arguments
    //OUTPUT: no return value
    public void display_name() {
        System.out.println(this.name);
    }



    //Displays all options
    //INPUT: no arguments
    //OUTPUT: number of options
    public int display_options() {
        //Display feature name
        System.out.println("\n *** " + this.name + ": ***");

        //Display options
        return super.display_all();
    }



    //Sets selection as position number of option selected
    //INPUT: selected option number
    //OUTPUT: String description of option selected
    public String set(int set_num) {
        //If invalid position number, return "none"
        if (!(set_num >= 0 && set_num <= this.num_options))
            return "none";

        //Set selection
        this.selection = set_num;

        //Return string description of option selected
        return get_option(set_num);
    }



    //Sets selection
    //INPUT: selected option
    //OUTPUT: position of option selected
    public int set(String option_sel) {
        int pos = Find(option_sel);
        set(pos);
        return pos;
    }



    //Sets selection to default 0 value
    //INPUT: no arguments
    //OUTPUT: no return value
    public void remove_selection() {
        this.selection = 0;
    }



    //Sets next node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_next(Feature connection) {
        this.next = connection;
    }



    //Returns next node reference
    //INPUT: no arguments
    //OUTPUT: next node reference
    public Feature Get_next() {
        return this.next;
    }



    //Compares with argument feature to check if same option has been selected
    //INPUT: Feature to compare with
    //OUTPUT: true (match) / false (no match)
    public boolean Match(Feature to_match)
    {
        //If selections match, return true
        if (this.selection != 0 && get_option(this.selection).equals(to_match.get_option(to_match.selection)))
            return true;

        else
            return false;
    }



    //Loads options from file
    //INPUT: no arguments
    //OUTPUT: no return value
    protected void Load_options()
    {
        String path = "resources/" + this.name + ".txt";    //path of file
        File file = new File(path);                         //file to load data

        try
        {
            //Read file using scanner, one option at a time
            Scanner file_read = new Scanner(file);
            file_read.useDelimiter(",");
            while (file_read.hasNext())
            {
                //Read a line from file
                String opt = file_read.next();

                //insert option
                insert(opt);
            }
        }

        //If file not found
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
