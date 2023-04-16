package ssf.miniproject.booklisttracker.repository;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import ssf.miniproject.booklisttracker.model.Book;
import ssf.miniproject.booklisttracker.model.User;

@Repository
public class BooksRepo {
    private static final Logger logger = LoggerFactory.getLogger(BooksRepo.class);
    
    private User user;
    private String username;
    private CopyOnWriteArrayList<Book> savedBooks = new CopyOnWriteArrayList<>();
    private List<Book> searchedBooks = new CopyOnWriteArrayList<>();

    


    // @Autowired
    // RedisTemplate<String, Object> template;


    public BooksRepo(){
        
    }

    public BooksRepo(String username){
        this.username = username;
    }
    
    // public void save(User user) {
    //         template.opsForValue().set(user.getUsername(), user);
    //     }
        
    
    // public User getUserByUsername(String username) {
    //         User result = null;
    
    //         Set<String> keys = template.keys("*");
    //         if (keys.contains(username)) {
    //             result = (User) template.opsForValue().get(username);
    //         }
    
    //         return result;
    //     }

    public CopyOnWriteArrayList<Book> getSavedBooks() {
        return savedBooks;
    }

    public void setSavedBooks(CopyOnWriteArrayList<Book> savedBooks) {
        this.savedBooks = savedBooks;
    }



    public List<Book> getSearchedBooks() {
        return searchedBooks;
    }

    public void setSearchedBooks(List<Book> searchedBooks) {
        this.searchedBooks = searchedBooks;
    }
}

