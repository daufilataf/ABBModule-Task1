This task has been written by Fuad Fataliyev for ABBModule-Task1:

TASK:

Task: Implement a simple inventory management system in Java.

 Requirements:

 Create classes to represent an inventory item, inventory manager, and custom exceptions. The InventoryItem class should have attributes like item ID, name, quantity, and price. Implement appropriate constructors and methods to set and retrieve these attributes. 

Create custom exception classes, such as InvalidDataException for invalid inventory item data, ItemNotFoundException for when an item is not found in the inventory, and FileIOException for file input/output errors. Throw these custom exceptions when appropriate conditions are encountered. 

Create an InventoryManager class to manage inventory items using file I/O. Implement methods in the InventoryManager class to read inventory items from a file, add a new inventory item, search for an inventory item by ID, update inventory items, and delete inventory items.

 Use file I/O to store and retrieve inventory items in a text file. Implement error handling for scenarios such as attempting to remove or find an item that doesn't exist, updating an item with invalid data, file not found, permissions issues, etc.

 Test your system by creating inventory items, performing operations like adding, searching, updating, and deleting items, and handling exceptions gracefully. 

Classes : FileIOException,InvalidDataException,ItemNotFoundException,InventoryItem,InventoryManager,Main 

InventoryItem class have : itemId,name,quantity,price and constructors and methods 

InventoryManager class have : FILE_NAME(local file location), List<InventoryItem> readInventoryItems(), void writeInventoryItems(List<InventoryItem> items), void addItem(InventoryItem item), InventoryItem findItem(int itemId), void updateItem(InventoryItem newItem), void deleteItem(int itemId) 

Main class use all method
