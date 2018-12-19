//Filename: BST_Car_lots.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'BST_Car_lots' class which has been implemented as a
//Binary Search tree of car lot nodes sorted by name of car lot.
//Supported operations include inserting a new car lot, displaying all car lots,
//and finding all matches for a customized vehicle
//External data file is used to load data for vehicles in each car lot.

package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class BST_Car_lots extends Util 
{
    protected Car_lot_Node root;    //root to Binary Search Tree of Car lot nodes

    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public BST_Car_lots()
    {
        root = null;
    }



    //Wrapper - Inserts a new car lot to the BST
    //INPUT: 1 argument: car lot to add
    //OUTPUT: no return value
    public void insert(Car_lot to_add)
    {
        this.root = insert(this.root, to_add);
    }



    //Inserts new car lot to BST recursively
    //INPUT: root node reference, car lot to add
    //OUTPUT: revised root reference
    protected Car_lot_Node insert(Car_lot_Node root, Car_lot to_add)
    {
        //base case
        if (root == null)
        {
            root = new Car_lot_Node(to_add);
            return root;
        }

        //If name of car lot to add is less than current
        //traverse left subtree
        if (to_add.Is_less_than(root))
            root.Set_left(insert(root.Get_left(), to_add));

        //If name of car lot to add is greater than or equal to current
        //traverse right subtree
        else
            root.Set_right(insert(root.Get_right(), to_add));

        return root;
    }



    //Wrapper - displays all car lots in BST in sorted order by name
    //INPUT: no arguments
    //OUTPUT: number of lots
    public int display_inorder()
    {
        return display_inorder(this.root);
    }



    //Displays all car lots in BST in sorted order by name recursively
    //INPUT: root node reference
    //OUTPUT: number of lots
    protected int display_inorder(Car_lot_Node root)
    {
        int displayed = 0;  //number of lots in tree

        //base case
        if (root == null)
            return 0;

        //traverse left subtree
        displayed += display_inorder(root.Get_left());

        //display current node
        root.Display();
        ++displayed;
        System.out.println();

        //traverse right subtree
        displayed += display_inorder(root.Get_right());

        return displayed;
    }



    //Loads car lots data from external file
    //INPUT: path to external file
    //OUTPUT: number of lots loaded from file
    public int Load_lots(String path)
    {
        File file = new File(path);   //file to load data from
        int num_loaded = 0;           //number of lots loaded from file

        try
        {
            //Read file using scanner, one line at a time
            Scanner file_read = new Scanner(file);
            file_read.useDelimiter(",");
            while (file_read.hasNext())
            {
                //Read a lot name from file
                String lot_name = file_read.next();

                //Create a new car lot with name
                Car_lot new_lot = new Car_lot(lot_name);

                //Load vehicles for car lot from file
                if (new_lot.Load_vehicles("resources/" + lot_name + ".txt") > 0)
                {
                    //Insert lot into BST
                    insert(new_lot);
                    ++num_loaded;
                }
            }
        }

        //If file not found
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }

        return num_loaded;
    }



    //Wrapper - Displays all matches in each car lot for argument vehicle
    //INPUT: vehicle to match
    //OUTPUT: number of matches
    public int Display_matches(Vehicle custom)
    {
        return Display_matches(this.root, custom);
    }



    //Displays all matches in each car lot for argument vehicle recursively
    //INPUT: root node reference, vehicle to match
    //OUTPUT: number of matches
    protected int Display_matches(Car_lot_Node root, Vehicle custom)
    {
        int num_matches = 0;        //total number of matches in all lots

        //base case
        if (root == null)
            return 0;

        //Display matches for current car lot
        num_matches += root.Display_matches(custom);

        //Traverse left and right subtree
        num_matches += Display_matches(root.Get_left(), custom) + Display_matches(root.Get_right(), custom);

        return num_matches;
    }


    //main: testing class methods
    public static void main(String[] args)
    {
        BST_Car_lots lots = new BST_Car_lots();
        int l = lots.Load_lots("resources/lots.txt");
        lots.display_inorder();

        Vehicle D = new Vehicle("Customized");
        D.Set_feature("Exterior_Color", "Black");
        D.Set_feature("Transmission", "Automatic");

        System.out.println("\nMatches found: ");
        int num_matches = lots.Display_matches(D);
        System.out.println(num_matches + " found");
    }
}
