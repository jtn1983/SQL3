INSERT INTO db_example.customers (name, surname, age, phone_number)
VALUES ('Sergey', 'Ivanov', 26, '1234567'),
       ('Ivan', 'Petrov', 33, '98766544'),
       ('Petr', 'Sidorov', 45, '28417294');

INSERT INTO db_example.orders (customer_id, product_name, amount)
VALUES (1, 'iphone', 1),
       (2, 'samsung', 2),
       (1, 'lg', 1);