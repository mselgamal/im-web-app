CREATE USER 'chatadmin'@'localhost' IDENTIFIED BY 'chatadmin';

GRANT ALL PRIVILEGES ON * . * TO 'chatadmin'@'localhost';

ALTER USER 'chatadmin'@'localhost' IDENTIFIED WITH mysql_native_password BY 'chatadmin';
