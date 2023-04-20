package ssf.miniproject.booklisttracker.repository;

public class Queries {


   public static final String SQL_INSERT_USER = "insert into users(id, username, password, email) values(?, ?, sha(?), ?)";

   public static final String SQL_VALIDATE_USER = "select count(*) > 0 as valid_cred from users where username = ? and password = sha(?)";

   public static final String SQL_FIND_BY_USERNAME_PASSWORD = "select * from users where username = ? and password = sha(?)";
   
   public static final String SQL_SELECT_BOOKS_BY_USERID = "select * from books where user_id = ?";

   public static final String SQL_INSERT_BOOK = "insert into books(id, title, description, authors, publishedDate, urlLink, imageUrl, previewLink, user_id) values (?,?,?,?,?,?,?,?,?)";

   public static final String SQL_FIND_USER_BY_ID = "select * from users where id = ?";

   public static final String SQL_SELECT_BOOK_BY_BOOKID = "select * from books where bookId = ?";

}
