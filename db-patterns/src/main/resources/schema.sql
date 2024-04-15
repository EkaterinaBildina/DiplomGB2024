CREATE TABLE IF NOT EXISTS patterns_db (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    size INT NOT NULL,
    consumption DOUBLE NOT NULL,
    price DECIMAL(10, 2) NOT NULL

);