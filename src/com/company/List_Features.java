//Filename: List_Features.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'List_Features' class, that manages a linear linked list of
//'Feature' class references. Uses dynamic binding and upcasting to allow
//each element in list to be a derived class object that extends 'Feature' class
//Supported operations include:
//- Display all features
//- Display all options for a specific feature
//- Select an option for a specific feature
//- Remove selection for a specific feature
//- Display selection for a specific feature
//- Add a new option for a feature


package com.company;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class List_Features extends Util
{
    protected Feature head;        //head to list of feature references
    protected int num_features;    //total number of features in list



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public List_Features()
    {
        //Allocate space for array
        head = null;
        num_features = 0;
        Load_features();
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public List_Features(List_Features to_copy)
    {
        this.head = null;
        this.num_features = 0;

        //Copy argument list
        this.head = Copy(this.head, to_copy.head);
    }



    //Copies a list of options into this object
    //INPUT: 2 arguments: destination node reference, source node reference
    //OUTPUT: reference of new head of list
    protected Feature Copy(Feature dest, Feature src)
    {
        //base case
        if (src == null)
        {
            dest = null;
            return dest;
        }

        //Copy current node
        dest = new Feature(src) {
        };

        //Recursive call
        dest.Set_next(Copy(dest.Get_next(), src.Get_next()));
        return dest;
    }


    //Wrapper function - inserts a new node to end of list
    //INPUT: new feature to add
    //OUTPUT: true/false: success/failure
    public boolean insert(Feature to_add)
    {
        //flag failure if null argument
        if (to_add == null)
            return false;

        //Insert to end of list
        this.head = insert(to_add, this.head);
        return true;
    }



    //Inserts a new node to end of list recursively
    //INPUT: string description of new option to add, head pointer to list
    //OUTPUT: reference of new head of list
    private Feature insert(Feature to_add, Feature head)
    {
        //base case
        if (head == null)
        {
            //Downcast/RTTI
            if(to_add.name.equals("Exterior_Color")) {
                head = new Ext_Color();
                ++this.num_features;
            }

            else if(to_add.name.equals("Interior_Color")) {
                head = new Int_Color();
                ++this.num_features;
            }

            else if(to_add.name.equals("Cylinders")) {
                head = new Cylinders();
                ++this.num_features;
            }

            else if(to_add.name.equals("Transmission")) {
                head = new Transmission();
                ++this.num_features;
            }

            else if(to_add.name.equals("Size")) {
                head = new Size();
                ++this.num_features;
            }

            return head;
        }

        //recursive call to next node
        head.Set_next(insert(to_add, head.Get_next()));
        return head;
    }



    //Displays all feature names
    //INPUT: no arguments
    //OUTPUT: number of features
    public int Display_all()
    {
        //For each feature in list, display name of feature
        int count = 0;
        return Display_all(this.head, count);
    }



    //Displays names of all features in list recursively
    //INPUT: head pointer to list, counter to display item number
    //OUTPUT: int (number of items in list)
    public int Display_all(Feature current, int count)
    {
        //base case
        if (current == null)
            return 0;

        //Increment counter
        ++count;

        //display current node
        System.out.print("\t" + count + ".  ");
        current.display_name();

        //Recursive call to next node
        return 1 + Display_all(current.Get_next(), count);
    }



    //Displays all options for a feature
    //INPUT: no arguments
    //OUTPUT: number of options
    public int Display_feature_options()
    {
        int f_num = 0;          //position number of selected feature
        int num_options = 0;    //value to return

        //Display all features to select from
        System.out.println("\n*** Features: ***");
        if (Display_all() == 0)
            System.out.printf("\n*** No features to display ***\n");

        //Read position number of feature to display options for
        System.out.print("Select feature to display options for (e.g. Enter '3' for Cylinders: ");
        f_num = input.nextInt();

        //Flag if invalid position number
        if (f_num < 1 || f_num > num_features)
            System.out.println("\n*** Invalid Entry ***\n");

        //Display all options for selected feature
        else {
            Feature found = null;
            int timer = 0;
            found = Find(f_num, timer, this.head);
            if (found != null) {
                num_options = found.display_options();
                System.out.println();
            }
        }

        return num_options;
    }



    //Finds feature at a specific position number in list
    //INPUT: position number, feature reference (to be updated to found object)
    //OUTPUT: number of options
    protected Feature Find(int pos, int timer, Feature head)
    {
        //base case
        if (head == null)
            return null;

        ++timer;

        //position number reached?
        if (timer == pos)
        {
            return head;
        }

        //recursive call to next node
        else
            return Find(pos, timer, head.Get_next());
    }


    //Finds feature with matching name
    //INPUT: Feature name
    //OUTPUT: true/false (found/not found)
    protected Feature Find(String feat_name, Feature head)
    {
        //base case
        if (head == null)
            return null;

        //position number reached?
        if (head.name.equals(feat_name))
        {
            return head;
        }

        //recursive call to next node
        else
            return Find(feat_name, head.Get_next());
    }



    //Selects an option for a feature
    //INPUT: no arguments
    //OUTPUT: String description of option selected
    public String Read_feature_selection()
    {
        int f_num = 0;          //position number of selected feature
        int num_options = 0;    //number of options available for selected feature
        int sel = 0;            //Option number to select
        String to_return = new String();    //String description of option selected

        //Display all features to select from
        System.out.println("\n*** Features: ***");
        if (Display_all() == 0)
            System.out.printf("\n*** No features to display ***\n");

        //Read position number of feature to display options for
        System.out.print("Select feature to set (e.g. Enter '3' for Cylinders): ");
        f_num = input.nextInt();
        input.nextLine();

        //Flag if invalid position number
        if (f_num < 1 || f_num > num_features)
            System.out.println("\n*** Invalid Entry ***\n");

        else
        {
            //Display all options for selected feature
            Feature found = null;
            int timer = 0;
            found = Find(f_num, timer, this.head);
            if (found != null){
                num_options = found.display_options();
                System.out.println();

            //Read selected option number
            System.out.print("Enter option number to select: ");
            sel = input.nextInt();
            input.nextLine();

            //Set selected option for feature
            to_return = found.set(sel);
            }
        }

        return to_return;
    }



    //Displays all selected options for features
    //INPUT: no arguments
    //OUTPUT: number of selections
    public int Display_selections()
    {
        int count = 0;
        //For each feature for which a selection has been made
        // Display selection

        return Display_selections(this.head, count);
    }



    //Displays all selected features in list recursively
    //INPUT: head pointer to list, counter to display item number
    //OUTPUT: int (number of selections)
    public int Display_selections(Feature current, int count)
    {
        int selected = 0;       //value to return

        //base case
        if (current == null)
            return 0;

        //Increment counter
        ++count;

        //Display selection
        if (current.selection != 0) {
            if (current.display())
                ++selected;
        }

        //Recursive call to next node
        selected += Display_selections(current.Get_next(), count);

        return selected;
    }



    //Adds new option for a feature
    //INPUT: 2 arguments: String description of option to add, name of feature
    //OUTPUT: 0/1: failure (no match for feature found)/success
    public boolean add_feature_option(String option_to_add, String feature_name)
    {
        boolean found = false;      //if no match for feature found
        Feature current = this.head;

        //Repeat for each item in list of features until end of list or done
        while (current != null && !found)
        {
            //If match found for feature name
            if (current.name.equals(feature_name))
            {
                //Add new option to the corresponding list of options
                if (current.insert(option_to_add))
                    //Flag as done
                    found = true;
            }

            //move current to next node
            current = current.Get_next();
        }

        return found;
    }



    //Resets selection for a feature
    //INPUT: no arguments
    //OUTPUT: Name of feature that's been reset
    public String remove_feature_selection()
    {
        int f_num = 0;              //position number of selected feature
        String to_return = "none";  //Name of feature that's been reset

        //Display all features to select from
        System.out.println("\n*** Features: ***");
        if (Display_all() == 0)
            System.out.printf("\n*** No features to display ***\n");

        //Read in feature number to reset
        System.out.print("Select feature to reset (e.g. Enter '3' for Cylinders): ");
        f_num = input.nextInt();
        input.nextLine();

        //flag if invalid
        if (f_num < 1 || f_num > num_features)
            System.out.println("\n*** Invalid Entry ***\n");

        //Reset selected feature
        //Return feature name
        else
        {

            //Display all options for selected feature
            Feature found = null;
            int timer = 0;
            found = Find(f_num, timer, this.head);
            if (found != null) {
                found.remove_selection();
                to_return = found.name;
            }
        }

        return to_return;
    }



    //Wrapper: Finds number of features that match with argument list
    //INPUT: List of features to compare
    //OUTPUT: Returns number of features that match
    public int Find_match(List_Features to_compare)
    {
        return Find_match(this.head, to_compare.head);
    }



    //Finds number of features that match with argument list recursively
    //INPUT: Head node reference of current object, head node reference of list to compare with
    //OUTPUT: Returns number of features that match
    protected int Find_match(Feature head, Feature to_compare_head)
    {
        int num_matches = 0;

        //base case
        if (head == null)
            return 0;

        //check current feature
        if (head.Match(to_compare_head))
            ++num_matches;

        //recursive call for next in list
        num_matches += Find_match(head.Get_next(), to_compare_head.Get_next());

        return num_matches;
    }



    //Loads all available features from external file
    //INPUT: no arguments
    //OUTPUT: no return value
    protected void Load_features()
    {
        String path = "resources/features.txt"; //file path
        File file = new File(path);             //file to load data from
        Feature new_feat = null;                //To read each feature

        try
        {
            //Read file using scanner, one option at a time
            Scanner file_read = new Scanner(file);
            file_read.useDelimiter(",");
            while (file_read.hasNext())
            {
                //Read a line from file
                String feat_name = file_read.next();

                //Insert new feature of type
                if (feat_name.equals("Exterior_Color"))
                    new_feat = new Ext_Color();

                else if (feat_name.equals("Interior_Color"))
                    new_feat = new Int_Color();

                else if (feat_name.equals("Cylinders"))
                    new_feat = new Cylinders();

                else if (feat_name.equals("Transmission"))
                    new_feat = new Transmission();

                else if (feat_name.equals("Size"))
                    new_feat = new Size();

                insert(new_feat);
            }
        }

        //If file not found
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }



    //Sets a given option for given feature as selected
    //INPUT: feature name, option selected
    //OUTPUT: true/false (success/failure)
    public boolean Set_feature(String feature_name, String option_selected)
    {
        boolean success = false;        //value to return

        //Find feature in list that matches name
        Feature found = Find(feature_name, this.head);

        //If feature found, set selected option
        if (found != null)
        {
            //flag success
            if (found.set(option_selected) != 0)
                success = true;
        }

        return success;
    }



    //Wrapper: Counts number of features that have a selected option set
    //INPUT: no arguments
    //OUTPUT: number of features set
    public int Count_selected_features()
    {
        return Count_selected_features(this.head);
    }



    //Counts number of features that have a selected option set recursively
    //INPUT: head node reference
    //OUTPUT: number of features set
    protected int Count_selected_features(Feature head)
    {
        int count_set = 0;      //value to return

        //base case
        if (head == null)
            return 0;

        //if selection NOT at default value 0
        //increment count
        if (head.selection != 0)
            ++count_set;

        //recursive call for next in list
        count_set += Count_selected_features(head.Get_next());

        return count_set;
    }



    //main: to test class methods
    public static void main(String[] args)
    {
        List_Features a_list = new List_Features();

        a_list.Set_feature("Size", "Compact");
        a_list.Set_feature("Transmission", "Manual");
        a_list.Display_selections();
        System.out.println("Num set: " + a_list.Count_selected_features());
    }
}
