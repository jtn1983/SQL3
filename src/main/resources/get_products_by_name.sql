SELECT product_name
FROM db_example.orders
         JOIN db_example.customers ON orders.customer_id = customers.id
WHERE name = :name