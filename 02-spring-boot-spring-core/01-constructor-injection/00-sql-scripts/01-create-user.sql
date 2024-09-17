DROP USER if exists 'springstudent'@'localhost';
CREATE USER 'springstudent'@'localhost' identified by 'springstudent';
grant all privileges on * . * to 'springstudent'@'localhost';