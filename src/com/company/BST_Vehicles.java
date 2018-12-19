//Filename: BST_Vehicles.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'BST_Vehicles' class which has been implemented as a
//Binary Search tree of vehicle nodes sorted by name of vehicle.
//Supported operations include inserting a new vehicle, displaying all vehicle,
//and finding all matches for a customized vehicle
//External data file is used to load data for vehicles.


package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BST_Vehicles extends Util
{
    protected Vehicle_Node root;      //root to Binary Search Tree of vehicles



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public BST_Vehicles()
    {
        this.root = null;
    }



    //Copy constructor
    //INPUT: BST object to copy
    //OUTPUT: no return value
    public BST_Vehicles(BST_Vehicles to_copy)
    {
        //copy argument data into current object
        this.root = null;
        this.root = copy(this.root, to_copy.root);
    }



    //Copies all data from a BST object
    //INPUT: destination root reference, source root reference
    //OUTPUT: revised destination root reference
    protected Vehicle_Node copy(Vehicle_Node dest, Vehicle_Node src)
    {
        //base case
        if (src == null)
            return null;

        //copy current node
        dest = new Vehicle_Node(src);

        //Traverse left and right subtrees
        dest.Set_left(copy(dest.Get_left(), src.Get_left()));
        dest.Set_right(copy(dest.Get_right(), src.Get_right()));

        return dest;
    }



    //Wrapper - Inserts a new vehicle to the BST
    //INPUT: 1 argument: vehicle to add
    //OUTPUT: no return value
    public void insert(Vehicle to_add)
    {
        this.root = insert(this.root, to_add);
    }



    //Inserts new vehicle to BST recursively
    //INPUT: root node reference, vehicle to add
    //OUTPUT: revised root reference
    protected Vehicle_Node insert(Vehicle_Node root, Vehicle to_add)
    {
        //base case
        if (root == null)
        {
            root = new Vehicle_Node(to_add);
            return root;
        }

        //If name of vehicle to add is less than current
        //traverse left subtree
        if (to_add.Is_less_than(root))
            root.Set_left(insert(root.Get_left(), to_add));

        //If name of vehicle to add is greater than or equal to current
        //traverse right subtree
        else
            root.Set_right(insert(root.Get_right(), to_add));

        return root;
    }



    //Wrapper - displays all vehicles in BST in sorted order by name
    //INPUT: no arguments
    //OUTPUT: number of lots
    public int display_inorder()
    {
        return display_inorder(this.root);
    }



    //Displays all vehicles in BST in sorted order by name recursively
    //INPUT: root node reference
    //OUTPUT: number of vehicles
    protected int display_inorder(Vehicle_Node root)
    {
        int displayed = 0;      //number of vehicles in tree

        //base case
        if (root == null)
            return 0;

        //traverse left subtree
        displayed += display_inorder(root.Get_left());

        //display current vehicle
        root.Display();
        ++displayed;
        System.out.println();

        //traverse right subtree
        displayed += display_inorder(root.Get_right());

        return displayed;
    }



    //Loads vehicles data from external file
    //INPUT: path to external file
    //OUTPUT: number of vehicles loaded from file
    public int Load_vehicles(String path)
    {
        File file = new File(path);   //file to load data from
        Vehicle new_veh = null;       //to read each vehicle in file
        int num_loaded = 0;           //number of vehicles loaded from file

        try
        {
            //Read file using scanner, one line at a time
            Scanner file_read = new Scanner(file);
            file_read.useDelimiter(Pattern.compile("(\\n)"));
            while (file_read.hasNext())
            {
                //Read a line from file
                String line = file_read.next();

                //Split line using comma as delimiter
                String [] parts = line.split(",");

                //First part of each line is the vehicle name
                String veh_name = parts[0];

                //Build new vehicle with name
                new_veh = new Vehicle(veh_name);

                //Remaining parts of line are feature selections separated by commas
                for (int j = 1; j < parts.length; ++j)
                {
                    String [] sub_parts = parts[j].split(":");
                    String feat_name = sub_parts[0];
                    String opt_sel = sub_parts[1];

                    new_veh.Set_feature(feat_name, opt_sel);
                }

                //Insert vehicle into BST
                insert(new_veh);
                ++num_loaded;
            }
        }

        //If file not found
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return num_loaded;
    }



    //Wrapper - Displays all matches for argument vehicle
    //INPUT: vehicle to match
    //OUTPUT: number of matches
    public int display_matches(Vehicle custom)
    {
        return display_matches(root, custom);
    }



    //Displays all matches for argument vehicle recursively
    //INPUT: root node reference, vehicle to match
    //OUTPUT: number of matches
    protected int display_matches(Vehicle_Node root, Vehicle to_compare)
    {
        int num_matches = 0;            //total number of matches in all lots
        int num_features_custom;        //number of selected features in custom vehicle (argument)

        //base case
        if (root == null)
            return 0;

        //number of selected features in custom vehicle (argument)
        num_features_custom = to_compare.Count_selected_features();

        //if match is found for all selected features
        if (root.Find_match(to_compare) == num_features_custom)
        {
            //display match
            root.Display();
            System.out.println();

            //increment number of matches
            ++num_matches;
        }

        //recursively traverse left and right subtrees
        num_matches += display_matches(root.Get_left(), to_compare) + display_matches(root.Get_right(), to_compare);

        return num_matches;
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        /*
        BST_Vehicles veh_list = new BST_Vehicles();

        Vehicle A = new Vehicle("Accord");
        A.Set_feature("Exterior_Color", "Red");
        A.Set_feature("Size", "Mid-size");

        Vehicle B = new Vehicle("BMW");
        B.Set_feature("Exterior_Color", "Blue");
        B.Set_feature("Size", "Full-size");

        Vehicle C = new Vehicle("Honda");
        C.Set_feature("Exterior_Color", "Blue");
        C.Set_feature("Size", "Compact");


        veh_list.insert(A);
        veh_list.insert(B);
        veh_list.insert(C);

        int d = veh_list.display_inorder();
        System.out.println("\n" + d + " vehicles total");

        int match = B.Find_match(C);
        System.out.println("\nMatch feat: " + match);
        */

        Vehicle D = new Vehicle("Customized");
        D.Set_feature("Exterior_Color", "Blue");
        D.Set_feature("Size", "Mid-size");

        BST_Vehicles test = new BST_Vehicles();
        test.Load_vehicles("resources/Carmax.txt");
        test.display_inorder();

        System.out.println("\nMatches found: ");
        int num_matches = test.display_matches(D);
        System.out.println(num_matches + " found");
    }
}
