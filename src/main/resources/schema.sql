CREATE TABLE db_example.customers
(
    id           int AUTO_INCREMENT PRIMARY KEY,
    name         varchar(255),
    surname      varchar(255),
    age          int,
    phone_number varchar(255)
);
CREATE TABLE db_example.orders
(
    id           int AUTO_INCREMENT PRIMARY KEY,
    date         datetime DEFAULT CURRENT_TIMESTAMP,
    customer_id  int,
    product_name varchar(255),
    amount       int,
    FOREIGN KEY (customer_id) REFERENCES customers (id)
)
