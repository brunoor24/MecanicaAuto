CREATE TABLE IF NOT EXISTS reserve_service(
	id SERIAL,
	service_id int not null,
	reserve_id int not null,
    PRIMARY KEY (id),
    FOREIGN KEY service_id REFERENCES service(id)
    FOREIGN KEY reserve_id REFERENCES reserve(id)

);