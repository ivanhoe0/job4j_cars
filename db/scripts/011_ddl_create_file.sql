CREATE TABLE "file" (
   id SERIAL PRIMARY KEY,
   name VARCHAR NOT NULL,
   path VARCHAR NOT NULL UNIQUE,
   post_id INT REFERENCES auto_post(id)
);