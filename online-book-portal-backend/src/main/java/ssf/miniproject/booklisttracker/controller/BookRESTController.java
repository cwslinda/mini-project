package ssf.miniproject.booklisttracker.controller;


import java.io.StringReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.SimpleType;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import ssf.miniproject.booklisttracker.model.Book;
import ssf.miniproject.booklisttracker.model.User;
import ssf.miniproject.booklisttracker.repository.BooksRepo;
import ssf.miniproject.booklisttracker.service.BookService;
import ssf.miniproject.booklisttracker.service.UserService;

@Controller
@RequestMapping("/api")
public class BookRESTController {
    private static final Logger logger = LoggerFactory.getLogger(BookRESTController.class);

    @Autowired
    BookService service;

    @Autowired
    private UserService userSvc;

    @Autowired
    BooksRepo repo;




    @GetMapping(path="/search", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<List<Book>> searchResults(
                                        @RequestParam String keyword) {

        List<Book> bookList = service.getSearchBooks(keyword);

        // exceeded api request limit
        if (bookList == null) {
            return ResponseEntity.status(504).build();
        }
        
        return ResponseEntity.ok(bookList);
    }

    @GetMapping(path="/book/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<Book> getSingleBook(@PathVariable String id) {
       
       Book book = service.getSingleBook(id);

        // exceeded api request limit
        if (book == null) {
            return ResponseEntity.status(504).build();
        }
        
        return ResponseEntity.ok(book);
    }

    @GetMapping(path="/user/{userId}", produces=MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<User> getUserBooks(@PathVariable("userId") String id){


        Optional<User> userOpts = userSvc.findUserById(id); 
    
        User u = new User();
        if(!userOpts.isEmpty() ){
            u = userOpts.get();
            u.setBooks(service.getUserBooks(u.getId()));
        }

        return ResponseEntity.ok(u);

    
    }

    @PostMapping(path="/save/{userId}", 
    consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<String> saveUserBook(@PathVariable("userId") String id, @RequestPart("title") String title, @RequestPart("bookId") String bookId) {

        
        System.out.println("title >>>" + title);
        System.out.println(bookId);
        Book book = new Book();
        book.setTitle(title);
        System.out.println(book.getTitle());

        


        return ResponseEntity.ok("okay");
    }
}