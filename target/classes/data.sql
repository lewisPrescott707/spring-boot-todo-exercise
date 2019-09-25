CREATE TABLE IF NOT EXISTS Todo(id IDENTITY PRIMARY KEY, done BOOLEAN, text VARCHAR(255));
DELETE FROM Todo;
INSERT INTO Todo VALUES(1, false, 'Prepare presentation');
INSERT INTO Todo VALUES(2, false, 'Procrastinate');
INSERT INTO Todo VALUES(3, true, 'Have presentation');
