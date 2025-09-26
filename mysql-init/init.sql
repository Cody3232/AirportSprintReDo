ALTER USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'rootpassword';
CREATE DATABASE IF NOT EXISTS airportdb;
CREATE USER IF NOT EXISTS 'airportuser'@'%' IDENTIFIED WITH mysql_native_password BY 'airportpass';
GRANT ALL PRIVILEGES ON airportdb.* TO 'airportuser'@'%';
FLUSH PRIVILEGES;
