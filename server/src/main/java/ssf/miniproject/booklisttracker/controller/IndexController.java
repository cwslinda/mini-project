// package ssf.miniproject.booklisttracker.controller;


// import java.util.concurrent.CopyOnWriteArrayList;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import ssf.miniproject.booklisttracker.model.Book;
// import ssf.miniproject.booklisttracker.model.User;
// import ssf.miniproject.booklisttracker.repository.BooksRepo;
// import ssf.miniproject.booklisttracker.service.BooksService;

// @Controller
// @RequestMapping(path = "/")
// public class IndexController {
//     private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

//     @Autowired
//     User user;

//     @Autowired
//     BooksService service;

//     @Autowired 
//     BooksRepo bookRepo;

//     @GetMapping({"/","/logout"})
//     public String showIndexPage(Model model) {
        
//         User user = new User("");
//         model.addAttribute("user", user);
        
//         return "login";
//     }
    
    // @GetMapping({"/user", "/user/{newUsername}"})
    // public String getSavedBooks(@RequestParam(required=false, value="username") String username,
    //                             @PathVariable(required=false) String newUsername, 
    //                             Model model){

    //     if (username == null){
    //         username = newUsername;
    //     }

    //     user = bookRepo.getUserByUsername(username);
    //     if (user == null) {
    //         user = new User(username);
    //         bookRepo.save(user);
    //     }
    //     model.addAttribute("user", user);

    //     return "show";
    // }


    // @GetMapping("/delete/{bookToDel}")
    // public String deleteBook(@PathVariable String bookToDel, Model model) {

    //     logger.info("book to be deleted >> " + bookToDel);
        
   

    //     user.delBook(bookToDel);
    //     bookRepo.save(user);
    //     model.addAttribute("user", user);

    //     return "show";
    // }

    
//    @GetMapping(path = "/others")
//    public String showRec(Model model){
//         CopyOnWriteArrayList<Book> latestBookList = service.getBooks();
//         model.addAttribute("latestBookList", latestBookList);
//         return "books";

//    }
// }



