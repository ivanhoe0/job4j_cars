ALTER TABLE auto_post
ADD COLUMN file_id INT REFERENCES "file"(id)