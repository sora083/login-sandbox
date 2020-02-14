CREATE TABLE if NOT EXISTS users (
  id INT PRIMARY KEY,
  name VARCHAR(255),
  email VARCHAR(255),
  encrypted_password VARCHAR(255),
  age INT,
  sex tinyint,
  created_at datetime,
  updated_at datetime
);

DELETE FROM users;

INSERT INTO users VALUES
( 1 , 'John' ,'john@example.com', '$2a$10$VXdds6MD7Un/kKbzWOC43uSXGuyI4yPOGszGxzPWI2GiS3zonAnta', 26 , 1 , NOW() , NOW()),
( 2 , 'Bob' ,'bob@example.com','$2a$10$GTiBVrju5FsJ2IwEo4ZgCuGtyr7EcIq3oqxKdXeKJNOV2yjka1KVW', 40 , 1, NOW() , NOW()),
( 3 , 'Michael' ,'michael@example.com','$2a$10$VXdds6MD7Un/kKbzWOC43uSXGuyI4yPOGszGxzPWI2GiS3zonAnta', 20 , 1, NOW() , NOW()),
( 4 , 'Mary' ,'mary@example.com','$2a$10$VXdds6MD7Un/kKbzWOC43uSXGuyI4yPOGszGxzPWI2GiS3zonAnta', 30 , 0, NOW() , NOW());
