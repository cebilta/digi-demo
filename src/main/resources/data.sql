CREATE TABLE pdf_files (
   id SERIAL PRIMARY KEY,
   file_name VARCHAR(255) NOT NULL,
   file_path VARCHAR(255) NOT NULL
);


CREATE TABLE pdf_data (
   id SERIAL PRIMARY KEY,
   file_nam VARCHAR(255) NOT NULL,
   file_pah VARCHAR(255) NOT NULL
);