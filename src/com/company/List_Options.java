//Filename: List_Options.java

//Name:     Meera Murali
//Email:    mmurali@pdx.edu
//Class:    202
//Program:  5
//Date:     08/30/2017

//This program implements the 'List_Options' class, that manages a linear linked list of
//'Option' class objects.
//Supported operations include:
//- Add a new option to list
//- Copy a list of options
//- Display all options in list
//- Display option at a specific position number in list
//- Retrieve option at a specific position number in list



package com.company;

public class List_Options extends Util
{
    protected Option head;      //head pointer to linear linked list of options
    protected int num_options;  //number of options in list



    //Default constructor
    //INPUT: no arguments
    //OUTPUT: no return value
    public List_Options()
    {
        this.head = null;
        this.num_options = 0;
    }



    //Copy constructor
    //INPUT: object to copy
    //OUTPUT: no return value
    public List_Options(List_Options to_copy)
    {
        this.head = null;
        this.num_options = 0;

        //Copy argument list of options
        this.head = Copy(this.head, to_copy.head);
    }



    //Copies a list of options into this object
    //INPUT: 2 arguments: destination node reference, source node reference
    //OUTPUT: reference of new head of list
    protected Option Copy(Option dest, Option src)
    {
        //base case
        if (src == null)
        {
            dest = null;
            return dest;
        }

        //Copy current node
        dest = new Option(src);
        ++this.num_options;

        //Recursive call
        dest.Set_next(Copy(dest.Get_next(), src.Get_next()));
        return dest;
    }



    //Wrapper function - inserts a new node to end of list
    //INPUT: string description of new option to add
    //OUTPUT: true/false: success/failure
    public boolean insert(String to_add)
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
    private Option insert(String to_add, Option head)
    {
        //base case
        if (head == null) {
            head = new Option(to_add);
            ++this.num_options;
            return head;
        }

        //recursive call to next node
        head.Set_next(insert(to_add, head.Get_next()));
        return head;
    }



    //Wrapper - Displays all options in list
    //INPUT: no arguments
    //OUTPUT: int (number of items in list)
    public int display_all()
    {
        int count = 0;
        return display_all(this.head, count);
    }



    //Displays all options in list recursively
    //INPUT: head pointer to list, counter to display item number
    //OUTPUT: int (number of items in list)
    public int display_all(Option current, int count)
    {
        //base case
        if (current == null)
            return 0;

        //Increment counter
        ++count;

        //display current node
        System.out.print("\t" + count + ".  ");
        current.display();

        //Recursive call to next node
        return 1 + display_all(current.Get_next(), count);
    }



    //Wrapper - Displays option at given position number in list
    //INPUT: position number
    //OUTPUT: false(invalid position nuber)/success
    public boolean display(int item_number)
    {
        int timer = 1;      //to count position number

        //Flag failure if invalid position number
        if (item_number < 1 || item_number > this.num_options)
            return false;

        //Display option at position
        return display(this.head, item_number, timer);
    }



    //Displays option at given position number in list recursively
    //INPUT: node reference, position number, timer to count positions
    //OUTPUT: false(invalid position nuber)/success
    public boolean display(Option head, int item_number, int timer)
    {
        //base case
        if(head == null)
            return false;

        //time to display?
        if (timer  == item_number) {
            head.display();
            return true;
        }

        //Increment timer
        ++timer;

        //Recursive call
        return display(head.Get_next(), item_number, timer);
    }



    //Wrapper: Retrieves description of option at given position number
    //INPUT: position number
    //OUTPUT: "none"(invalid position nuber)/success (string description of option)
    public String get_option(int item_number)
    {
        int timer = 1;      //to count positions

        //Flag failure if invalid position number
        if (item_number < 1 || item_number > this.num_options)
            return "none";

        //Return description of option at given position number
        return get_option(this.head, item_number, timer);
    }



    //Retrieves description of option at given position number recursively
    //INPUT: node reference, position number, timer to count positions
    //OUTPUT: "none"(invalid position nuber)/success (string description of option)
    public String get_option(Option head, int item_number, int timer)
    {
        //base case
        if(head == null)
            return "none";

        //time to retrieve?
        if (timer  == item_number) {
            return head.data;
        }

        //Increment timer
        ++timer;

        //Recursive call
        return get_option(head.Get_next(), item_number, timer);
    }



    //Wrapper: Finds position number of an option
    //INPUT: option to search for
    //OUTPUT: position number in list starting from 1
    public int Find(String to_find)
    {
        int pos = 1;     //position number in list starting from 1
        return Find(this.head, to_find, pos);
    }



    //Finds position number of an option recursively
    //INPUT: head reference to list, option to search for, position number tracker
    //OUTPUT: position number in list starting from 1
    protected int Find(Option head, String to_find, int pos)
    {
        //base case
        if (head == null)
            return 0;

        //If its a match, return current position number
        if (head.data.equals(to_find))
            return pos;

        //Otherwise traverse next in list
        else
            return Find(head.Get_next(), to_find, ++pos);
    }



    //main: testing class methods
    public static void main(String[] args)
    {
        List_Options my_list = new List_Options();

        if (!my_list.insert("Option 1"))
            System.out.println("Unable to add option\n");

        else
            System.out.println("Option added\n");

        if (!my_list.insert("Option 2"))
            System.out.println("Unable to add option\n");

        else
            System.out.println("Option added\n");

        if (!my_list.insert("Option 3"))
            System.out.println("Unable to add option\n");

        else
            System.out.println("Option added\n");

        int num = my_list.display_all();
        System.out.println("\n" + num + " options\n");

        if (!my_list.display(3))
            System.out.println("invalid item number");

        int pos = my_list.Find("Option 4");
        System.out.println("Match found at " + pos);

        List_Options copy = new List_Options(my_list);
        System.out.println("\n\nCopied: " + copy.num_options);
        copy.display_all();
    }

}
