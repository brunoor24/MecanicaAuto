CREATE TABLE IF NOT EXISTS reserve(
	id SERIAL,
	fecha date,
	hora time,
	description VARCHAR (40) NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY client_id REFERENCES client(id)

);
