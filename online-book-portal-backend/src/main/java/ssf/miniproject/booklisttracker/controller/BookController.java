package ssf.miniproject.booklisttracker.controller;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.booklisttracker.model.Book;
import ssf.miniproject.booklisttracker.model.User;
import ssf.miniproject.booklisttracker.repository.BooksRepo;
import ssf.miniproject.booklisttracker.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController {
    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    @Value("searchParam")
    String searchParam;
    
    @Autowired
    User currentUser;

    @Autowired
    BooksRepo bookRepo;

    @Autowired
    BookService service;

    // @GetMapping("/search")
    // public String searchBooks(@RequestParam("searchParam") String searchKeyword,
    //                              @RequestParam String username,
    //                              Model model) {

    //     logger.info("search terms >>> " + searchKeyword);
        
    //     currentUser = bookRepo.getUserByUsername(username);
    //     model.addAttribute("user", currentUser);

    //     List<Book> bookList = service.getSearchBooks(searchKeyword);
    //     bookRepo.setSearchedBooks(bookList);
        
    //     searchParam = searchKeyword;
        
    //     model.addAttribute("searchParam", searchParam);
    //     model.addAttribute("searchResults", bookList);

    //     return "searchResult";

    // }

    // @GetMapping(path = "/others")
    // public String showRec(Model model){
    //      CopyOnWriteArrayList<Book> latestBookList = service.getBooks();
    //      model.addAttribute("latestBookList", latestBookList);
    //      return "books";
 
    // }
    
    // @PostMapping(path="/save/{toBeSavedId}", consumes="application/x-www-form-urlencoded", produces="text/html")
    // public String saveBook(@PathVariable String toBeSavedId, 
    //                         @RequestParam("username") String username,
    //                         Model model) {

    //     currentUser.saveBook(toBeSavedId, bookRepo.getSearchedBooks());
    //     bookRepo.save(currentUser);

    //     model.addAttribute("user", currentUser);
    //     model.addAttribute("toBeSavedId", toBeSavedId);
    //     model.addAttribute("searchParam", searchParam);
    //     model.addAttribute("searchResults", bookRepo.getSearchedBooks());
        
    //     return "searchResult";
    // }


    // @GetMapping(path = "/search")
    // public String getBooks(Model model){
    //     CopyOnWriteArrayList<Book> bookList = service.getSearchBooks(keywords);

    //     model.addAttribute("bookList", bookList);
    //     return "searchResult";
    // }

   
}
