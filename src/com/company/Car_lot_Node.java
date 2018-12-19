//Filename: Car_lot_Node.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'Car_lot_Node' class which is derived from the "Car_lot" class.
//It manages a single node in a binary search tree of car lot nodes sorted by name of car lot.
//Supported operations include traversing left, traversing right, connecting left, connecting right.


package com.company;

public class Car_lot_Node extends Car_lot 
{
    protected Car_lot_Node left;        //left child
    protected Car_lot_Node right;       //right child



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public Car_lot_Node ()
    {
        super();
        this.left = null;
        this.right = null;
    }



    //Constructor with argument
    //INPUT: name of car lot
    //OUTPUT: no return value
    public Car_lot_Node(String a_name)
    {
        super(a_name);
        this.left = null;
        this.right = null;
    }



    //Constructor with argument
    //INPUT: car lot to copy
    //OUTPUT: no return value
    public Car_lot_Node(Car_lot to_copy)
    {
        super(to_copy);
        this.left = null;
        this.right = null;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public Car_lot_Node(Car_lot_Node to_copy)
    {
        super(to_copy);
        this.left = null;
        this.right = null;
    }



    //Sets left node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_left(Car_lot_Node connection)
    {
        this.left = connection;
    }



    //Sets right node reference to argument value
    //INPUT: node reference to set to
    //OUTPUT: no return value
    public void Set_right(Car_lot_Node connection)
    {
        this.right = connection;
    }



    //Returns left node reference
    //INPUT: no arguments
    //OUTPUT: left node reference
    public Car_lot_Node Get_left()
    {
        return this.left;
    }



    //Returns right node reference
    //INPUT: no arguments
    //OUTPUT: right node reference
    public Car_lot_Node Get_right()
    {
        return this.right;
    }
}
