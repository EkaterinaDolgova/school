--liquibase formatted sql

--changeset edolgova:1
--CREATE INDEX student_name_index on student(name);

--changeset edolgova:2
--CREATE INDEX faculty_color_index on faculty(color);
--CREATE INDEX faculty_name_index on faculty(name);