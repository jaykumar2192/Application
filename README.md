# ECommerceApplication
ECommerceApplication
________________________________________________________________________________________________________________________________

This is a REST WebService created using Java, Spring Boot and H2 as a database. The applications has two interfaces Seller and Users

Application uses 6 tables for the working:

Seller: Table holds Seller Information
User: Table holds User Information
Categories: All the products are divided into different categories like, Electronices, Clothes, Furniture, Toys.
Product: Tables hold all the information related to products in each category
UserCart: Table holds information of User Cart for all the users.
Orders: Upon successful order this user holds the user information

Screenshots of the flow diagrams are added into the projects under images folder.

________________________________________________________________________________________________________________________________

Responsibilities:

1) Seller can do the following operations : /seller

POST /createSeller      : Create seller

GET /getSeller          : Get all sellers

POST /addProduct        : Add a product

GET /getProducts        : Get all products

GET /getAllCategories   : Get all categories

POST /createCategory    : Create a new category

____________________________________________________________________________________

2) User can do the following operations :  /user

GET /getProducts          : To get all products information

GET /getProductsByName    : To get the products by name

POST /addToCart           : Add product to the cart

GET /getCartByUserId      : Get user cart details

GET /emptyCart            : Empty user cart based on user id

GET /processOrder         : Process user order

GET /ordersByUserId       : Get order by user id

POST /createUser          : Create new user

GET /getAllCategories     : Get all categories

________________________________________________________________________________________________________________________________

Working:

User: A user can check for the products information, then based upon the choice user add the product to its cart and an entry will be created in UserCart table. A user can also empty the cart based upon the choice.

If the user wanted to process the order, the user can make a call to /processOrder operation and this involved various stages:
a) All the products added in the user cart gets fetched.
b) Based on the quantity of the product a user wanted to buy, it gets validated by the available quantity of the product.
c) If the quantity is not available user gets a message for the products which are out of stock.
d) Else the order processing moves to the next step
e) New entry are created in the order table with all the details
f) Also, the no of quantity of products available gets updated once the user order is successfull.
g) At last user cart gets cleared.
h) Upon successfull completion of all the steps the invoice gets returned to the user.

Seller: A seller can add new products, categories into the products, categories table. A seller can also check all the products and based on that a seller can add more products to the database.

