CREATE TABLE IF NOT EXISTS vehicule(
	 id SERIAL,
     plate VARCHAR(50) NOT NULL,
     model VARCHAR(50) NOT NULL,
     brand VARCHAR (10) NOT NULL,
     type VARCHAR (10)NOT NULL,
     status BOOLEAN
     PRIMARY KEY (id)

);
