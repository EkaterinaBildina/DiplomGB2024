CREATE TABLE IF NOT EXISTS textile_db (
    id VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    price DECIMAL(10, 2) NOT NULL,
    rolllength DECIMAL(10, 2) NOT NULL
);