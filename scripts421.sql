ALTER TABLE student

    ADD CONSTRAINT age_constraint CHECK (age <16 or age=20);

ALTER TABLE student
    ADD PRIMARY KEY (name);



