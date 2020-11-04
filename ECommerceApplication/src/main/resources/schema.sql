create table seller (  
id int(5) NOT NULL,
name varchar(50),
rating int(5),
PRIMARY KEY (id)
);

create table users (  
id int(5) NOT NULL,
username varchar(10),
email varchar(30),
address_line1 varchar(50),
address_line2 varchar(50),
pin int(6),
PRIMARY KEY (id)
);

create table categories (  
id int(5) NOT NULL,
name varchar(50),
seller_id int(5),
PRIMARY KEY (id),
foreign key (seller_id) references seller(id)
);


create table products (  
id int(5) NOT NULL,
name varchar(50),
description varchar(100),
price int(6),
quantity int(10),
rating int(1),
seller_id int(5),
category_id int(5),
PRIMARY KEY (id),
foreign key (seller_id) references seller(id),
foreign key (category_id) references categories(id)
);

--


create table users_cart (  
id int(5) AUTO_INCREMENT NOT NULL,
user_id int(5),
product_id int(5),
quantity int(5),
PRIMARY KEY (id),
foreign key (user_id) references users(id),
foreign key (product_id) references products(id)
);


create table orders (  
id int(5) AUTO_INCREMENT NOT NULL,
total_amount int(7),
user_id int(5),
product_id int(5),
order_date date,
quantity int(5),
payment_info varchar(10),
order_status varchar(10),
PRIMARY KEY (id),
foreign key (product_id) references products(id),
foreign key (user_id) references users(id)
);

