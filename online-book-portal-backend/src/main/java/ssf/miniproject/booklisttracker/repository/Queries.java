package ssf.miniproject.booklisttracker.repository;

public class Queries {


   public static final String SQL_INSERT_USER = "insert into users(id, username, password) values(?, ?, sha(?))";

   public static final String SQL_VALIDATE_LOGIN = "select count(*) > 0 as valid_cred from user where username = ? and password = sha(?)";
}
