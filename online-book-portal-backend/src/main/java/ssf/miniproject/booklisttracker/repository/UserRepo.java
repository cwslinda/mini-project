package ssf.miniproject.booklisttracker.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



import ssf.miniproject.booklisttracker.model.User;

import static ssf.miniproject.booklisttracker.repository.Queries.*;

@Repository
public class UserRepo {


    @Autowired
    private JdbcTemplate template;


    public  boolean insertUserIntoRepo(String id, String username, String password){

        System.out.println("inserting into mysql");
        int inserted = template.update(SQL_INSERT_USER, id, username, password);

        return inserted > 0;
    }

    public Integer validateUser(User user) throws Exception {

        return template.queryForObject(SQL_VALIDATE_LOGIN, Integer.class, new Object[] { user.getUsername(), user.getPassword() });
    }


}
