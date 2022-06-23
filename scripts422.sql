CREATE TABLE cars (
                         id bigint unique ,
                         name varchar primary key,
                         people_id bigint REFERENCES cars (id)
);

CREATE TABLE peoples (
                         id bigint unique ,
                         name varchar primary key,
                         cars_id bigint REFERENCES peoples (id)
);


