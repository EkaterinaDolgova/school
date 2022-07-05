CREATE TABLE cars (
                         id bigint unique ,
                         name varchar primary key,
                         model varchar,
                         price numeric
);

CREATE TABLE peoples (
                         id bigint unique ,
                         name varchar primary key,
                         age integer,
                         avtocard integer,
                         cars_id bigint REFERENCES peoples (id)
);


