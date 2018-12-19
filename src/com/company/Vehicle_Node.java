//Filename: Vehicle_Node.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Vehicle_Node' class which is derived from the "Vehicle" class.
//It manages a single node in a binary search tree of vehicle nodes sorted by name of vehicle.
//Supported operations include traversing left, traversing right, connecting left, connecting right.

package com.company;

public class Vehicle_Node extends Vehicle
{
    protected Vehicle_Node left;        //left child
    protected Vehicle_Node right;       //right child



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Vehicle_Node ()
    {
        super();
        this.left = null;
        this.right = null;
    }



    //Constructor with argument
    //INPUT: name of vehicle
    //OUTPUT: no return value
    public Vehicle_Node(String a_name)
    {
        super(a_name);
        this.left = null;
        this.right = null;
    }



    //Constructor with arguments
    //INPUT: name of vehicle, list of features to copy
    //OUTPUT: no return value
    public Vehicle_Node(String a_name, List_Features to_copy)
    {
        super(a_name, to_copy);
        this.left = null;
        this.right = null;
    }



    //Constructor with argument
    //INPUT: vehicle to copy
    //OUTPUT: no return value
    public Vehicle_Node(Vehicle to_copy)
    {
        super(to_copy);
        this.left = null;
        this.right = null;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Vehicle_Node(Vehicle_Node to_copy)
    {
        super(to_copy);
        this.left = null;
        this.right = null;
    }



    //Sets left node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_left(Vehicle_Node connection)
    {
        this.left = connection;
    }



    //Sets right node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_right(Vehicle_Node connection)
    {
        this.right = connection;
    }



    //Returns left node reference
    //INPUT: no arguments
    //OUTPUT: left node reference
    public Vehicle_Node Get_left()
    {
        return this.left;
    }



    //Returns right node reference
    //INPUT: no arguments
    //OUTPUT: right node reference
    public Vehicle_Node Get_right()
    {
        return this.right;
    }
}
