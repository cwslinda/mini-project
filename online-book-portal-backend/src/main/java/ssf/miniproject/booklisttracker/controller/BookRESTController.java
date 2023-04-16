package ssf.miniproject.booklisttracker.controller;


import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ssf.miniproject.booklisttracker.model.Book;
import ssf.miniproject.booklisttracker.model.User;
import ssf.miniproject.booklisttracker.repository.BooksRepo;
import ssf.miniproject.booklisttracker.service.BooksService;

@RestController
@RequestMapping("/api")
public class BookRESTController {
    private static final Logger logger = LoggerFactory.getLogger(BookRESTController.class);

    @Autowired
    BooksService service;

    @Autowired
    BooksRepo repo;

    // @GetMapping(value = "/user/{username}", produces = "application/json")
    // public ResponseEntity<User> getUserList(@PathVariable String username) {

    //     User user = repo.getUserByUsername(username);

    //     if (user == null) {
    //         return ResponseEntity.notFound().build();
    //     }

    //     return ResponseEntity.ok(user);
    // }

    // @GetMapping (path="/userList", produces = "application/json")
    // public ResponseEntity<String> getList(){
    //     String userList = service.getList();
       
    //     return ResponseEntity.ok(userList);
    // }

    @GetMapping(value="/search", produces=MediaType.APPLICATION_JSON_VALUE)
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
}