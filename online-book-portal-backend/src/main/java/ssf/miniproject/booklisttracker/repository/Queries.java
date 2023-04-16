package ssf.miniproject.booklisttracker.repository;

public class Queries {


   public static final String SQL_INSERT_USER = "insert into user(id, username, password, booklist) values(?, ?, sha(?), ?)";

   public static final String SQL_VALIDATE_LOGIN = "select count(*) > 0 as valid_cred from user where username = ? and password = sha(?)";
}
