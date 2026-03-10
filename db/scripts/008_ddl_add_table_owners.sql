CREATE TABLE owners (
   id SERIAL PRIMARY KEY,
   "name" VARCHAR,
   user_id INT REFERENCES auto_user(id)
)