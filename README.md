# Vehicle-Shopper

This application allows the user to build a customized vehicle by
selecting from a list of available options for each feature such as size, exterior color,
interior color, transmission, and cylinders. The application then searches and displays
matches found in all car lots data base.

Supported operations include selecting an option for a feature, displaying all selections,
and removing selection (resetting a feature)

External data files are used to load available options for each feature, and data for vehicles
in each car lot. Inheritance and dynamic binding used to create different features and available options for each.

Data structure: BST of BSTs (Data base is a BST of ‘Car_lot’s; Each car lot is a BST of ‘Vehicle’s)

## UML Class Diagram

![UML diagram](/resources/UML.png)
![UML diagram](/resources/UML2.png)
