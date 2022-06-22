CREATE TABLE lessons (
                         id bigint unique ,
                         name varchar primary key,
                         student_id bigint REFERENCES student (id)
);

CREATE TABLE teacher (
                         id bigint unique ,
                         name varchar primary key,
                         lessons_id bigint REFERENCES lessons (id)
);


