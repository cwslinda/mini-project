package ssf.miniproject.booklisttracker.model;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.json.Json;
import jakarta.json.JsonObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(User.class);
    private String username;
    private String id;
    private String password;
    private List<Book> books = new LinkedList<>();
    
    
    
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(CopyOnWriteArrayList<Book> books) {
        this.books = books;
    }

    public User() {
        this.id = generateId(8);
    }

    public User(String username) {
        this.id = generateId(8);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private String generateId(int numChars) {
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < numChars) {
            sb.append(Integer.toHexString(r.nextInt()));
        }

        return sb.toString().substring(0,numChars);
    }

    public void saveBook(String bookIdToSave, List<Book> list){
        Book book = new Book();
        for(Book b : list){
            if(String.valueOf(b.getId()).equals(bookIdToSave)){
                book = b;
                for(Book bOne : books){
                    if(bOne.getId() == book.getId()){
                        return;
                    }
                }

                books.add(book);
            }

        }
    }

    public static User createForm(MultiValueMap<String, String> form) {
		User user = new User();
        user.setUsername(form.getFirst("username"));
        user.setPassword(form.getFirst("password"));
        return user;
		
	}

    public JsonObject toJson() {
		return Json.createObjectBuilder()
			.add("username", username)
            .add("password", password)
			.build();
	}
    
        public void delBook(String bookIdToDel){
            for(Book book: books){
                if(String.valueOf(book.getId()).equals(bookIdToDel)){
                    books.remove(book);
                }
            }
        }
    
    }