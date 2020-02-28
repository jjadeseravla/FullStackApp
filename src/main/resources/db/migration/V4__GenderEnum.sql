CREATE TYPE gender AS ENUM ('MALE', 'FEMALE');

ALTER TABLE student
ALTER COLUMN gender TYPE gender
USING (gender::gender)
-- alters the v1 where gender was set to varchar
-- to modify the table student on the column gender
-- which has a type gender.
-- using USING as we already have contents in our table to modify
-- this is called casting