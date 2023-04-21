package ssf.miniproject.booklisttracker.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import ssf.miniproject.booklisttracker.model.User;
import ssf.miniproject.booklisttracker.service.UserService;

@Restcontroller
@RequestMapping(path="/api")
public class UserController {

    @Autowired 
    private UserService svc;

    @PostMapping(path="/register", consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<String>registerUser(@RequestPart("username") String username, @RequestPart("password") String password, @RequestPart("email") String email){
         
        User u = new User();


       try {
        if (svc.validateUser(username, password) == false){
            String userId = UUID.randomUUID().toString().substring(0,8);
            svc.createNewUser(userId, username, password, email);

            return ResponseEntity.ok(Json.createObjectBuilder()
            .add("userId", userId)
            .add("username", username)
            .add("email", email)
            .build().toString());}
       } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500)
                .body(Json.createObjectBuilder().add("error", e.getMessage()).toString());
       }

       User user = svc.findUserByUsernameAndPassword(username, password);  

       return ResponseEntity.ok(Json.createObjectBuilder()
                            .add("userId", user.getId())
                            .add("username", username)
                            .add("email", email)
                            .build().toString());
    }


    // @GetMapping(value="/login", produces=MediaType.APPLICATION_JSON_VALUE)
    // @ResponseBody
    // @CrossOrigin()
    // public ResponseEntity<String> userLogin(@RequestPart("username") String username, @RequestPart("password") String password, @RequestPart("email") String email) {

    // }


}


    

