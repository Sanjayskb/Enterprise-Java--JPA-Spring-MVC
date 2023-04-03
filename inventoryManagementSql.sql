create database inventory;
use inventory;

CREATE TABLE supplier (
  supplier_id INT AUTO_INCREMENT PRIMARY KEY,
  supplier_name VARCHAR(255) NOT NULL,
  supplier_detail VARCHAR(255) NOT NULL,
  supplier_contact_no VARCHAR(20) NOT NULL,
  supplier_email VARCHAR(255) NOT NULL
);
INSERT INTO supplier (supplier_name, supplier_detail, supplier_contact_no, supplier_email) VALUES
  ('Supplier A', 'This is the detail for Supplier A', '+1-123-456-7890', 'supplierA@example.com'),
  ('Supplier B', 'This is the detail for Supplier B', '+44-20-1234-5678', 'supplierB@example.com'),
  ('Supplier C', 'This is the detail for Supplier C', '+81-3-1234-5678', 'supplierC@example.com'),
  ('Supplier D', 'This is the detail for Supplier D', '+61-2-1234-5678', 'supplierD@example.com'),
  ('Supplier E', 'This is the detail for Supplier E', '+86-10-1234-5678', 'supplierE@example.com');

CREATE TABLE product (
  product_id INT AUTO_INCREMENT PRIMARY KEY,
  product_name VARCHAR(255) NOT NULL,
  product_detail VARCHAR(255) NOT NULL,
  product_price DECIMAL(10, 2) NOT NULL,
  supplier_id INT NOT NULL,
  FOREIGN KEY (supplier_id) REFERENCES supplier(supplier_id)
);
INSERT INTO product (product_name, product_detail, product_price, supplier_id) VALUES
  ('Product A', 'This is the detail for Product A', 10.99, 1),
  ('Product B', 'This is the detail for Product B', 19.99, 2),
  ('Product C', 'This is the detail for Product C', 7.50, 1),
  ('Product D', 'This is the detail for Product D', 24.99, 3),
  ('Product E', 'This is the detail for Product E', 12.49, 2);


CREATE TABLE user (
  user_id INT AUTO_INCREMENT PRIMARY KEY,
  email VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);
CREATE TABLE orders (
  order_id INT AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  user_id INT NOT NULL,
  quantity INT NOT NULL,
  amount DECIMAL(10, 2) NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(product_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id)
);
CREATE TABLE inventory (
  inventory_id INT AUTO_INCREMENT PRIMARY KEY,
  product_id INT NOT NULL,
  count INT NOT NULL,
  FOREIGN KEY (product_id) REFERENCES product(product_id)
);

-- Inserting values into user table
INSERT INTO user (email, password) VALUES
  ('john@example.com', 'password123'),
  ('jane@example.com', 'letmein'),
  ('bob@example.com', 'pa$$word'),
  ('alice@example.com', 'secret123'),
  ('david@example.com', 'davidpassword');

-- Inserting values into orders table
INSERT INTO orders (product_id, user_id, quantity, amount) VALUES
  (1, 3, 2, 19.99),
  (1, 1, 1, 29.99),
  (1, 4, 3, 49.99),
  (1, 2, 1, 9.99),
  (1, 5, 2, 39.99);

select * from product;
-- Inserting values into inventory table

INSERT INTO inventory (product_id, count) VALUES
  (1, 50),
  (2, 25),
  (3, 10),
  (4, 100),
  (5, 75);
drop database inventory