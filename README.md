
//ECOM Model Assignment 1:- 
customer (id, name, contact, city)
user (id, username, password, role)
product(id, title, price, description, stock_qty)
vendor (id,name,city)
category(id, name, sequence) review(id, message, rating)
Business Logic
Vendor can sell multiple products, whereas each product will have One vendor.
One Category will have many products, where as One product will belong to only single category
A Customer will be having unique login credentials
Vendor will also be having unique login credentials
Product will have multiple reviews but 1 review will belong to single product at a time.
Customer will post multiple review but review will again belong to one customer.
Customer can buy many producs and each product can be bouht by many customers. Create EER diagram on workbench and using forward engg, create DB and tables.


//Assignment 2:- 
Create Crud Ops for product with vendor and category

//Assignment 3:- 
Create an Application, having login screen as the first screen and then show the dashboard having following functionalities
1. Fetch all data
2. Insert data in DB through form
3. Allow user to delete the record hard/soft
Note: Design app using bootstrap and create navbar for navigation

//Assignment 4:- 
Create APIs for crud ops for PolicyHolder
