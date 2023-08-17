CREATE TABLE if not exists client(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    NAME VARCHAR(200) NOT NULL CHECK (LENGTH(NAME) >= 3 AND LENGTH(NAME) <= 200)
    );
CREATE TABLE if not exists planet(
    id VARCHAR(50) PRIMARY KEY,
    NAME VARCHAR(500) NOT NULL
    );
CREATE TABLE if not exists ticket(
    ID INT PRIMARY KEY AUTO_INCREMENT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    client_id INT REFERENCES Client(id) on delete cascade on update cascade,
    from_planet_id VARCHAR(50) REFERENCES Planet(id) on delete cascade on update cascade,
    to_planet_id VARCHAR(50) REFERENCES Planet(id) on delete cascade on update cascade,
    FOREIGN KEY (client_id) REFERENCES Client(id),
    FOREIGN KEY (from_planet_id) REFERENCES Planet(id),
    FOREIGN KEY (to_planet_id) REFERENCES Planet(id)
    );


