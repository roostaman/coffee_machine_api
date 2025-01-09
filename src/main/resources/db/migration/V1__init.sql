-- Create "drinks" table
CREATE TABLE drinks (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    water INTEGER NOT NULL,
    milk INTEGER NOT NULL,
    coffee INTEGER NOT NULL
);

-- Create "drink_stats" table
CREATE TABLE drink_stats (
    id BIGSERIAL PRIMARY KEY,
    drink_name VARCHAR(255) NOT NULL UNIQUE,
    count INTEGER NOT NULL
);

-- Create "ingredient_stock" table
CREATE TABLE ingredient_stock (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    quantity INTEGER NOT NULL CHECK (quantity >= 0)
);

-- Create "orders" table
CREATE TABLE orders (
    id BIGSERIAL PRIMARY KEY,
    drink_id BIGINT NOT NULL,
    order_date TIMESTAMP NOT NULL,
    CONSTRAINT fk_orders_drink FOREIGN KEY (drink_id) REFERENCES drinks (id) ON DELETE CASCADE
);

-- Add some sample data
INSERT INTO drinks (name, water, milk, coffee) VALUES
('Espresso', 30, 0, 15),
('Americano', 100, 0, 15),
('Cappuccino', 50, 50, 15);

INSERT INTO ingredient_stock (name, quantity) VALUES
('water', 2000),
('milk', 300),
('coffee', 500);
