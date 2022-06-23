ALTER TABLE student
    ADD CONSTRAINT age_constraint CHECK (age > 16);

ALTER TABLE student
    ADD PRIMARY KEY (id);

ALTER TABLE student
    ADD CONSTRAINT name_unique UNIQUE (name);

ALTER TABLE faculty
    ADD CONSTRAINT login_pass_unique UNIQUE (color, name);

ALTER TABLE student
    ALTER COLUMN age SET DEFAULT 50;

