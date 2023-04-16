package ssf.miniproject.booklisttracker.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ssf.miniproject.booklisttracker.model.User;

@Controller
@RequestMapping(path="/api", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "*")
public class UserController {

    @PostMapping(path = "/login", consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public ResponseEntity<String>postUserEntity(@RequestBody MultiValueMap<String, String> form){
         
        System.out.println(">>> user information: " + form);

        User newUser = User.createForm(form);
        System.out.println(">>> user " + newUser);

        return ResponseEntity.ok(newUser.toJson().toString());
    }


    @GetMapping(path = "/testing", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseBody
    public ResponseEntity<String>testing(){


        return ResponseEntity.ok("hello");
    }
    
}
