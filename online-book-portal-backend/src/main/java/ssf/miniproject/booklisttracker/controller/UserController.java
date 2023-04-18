package ssf.miniproject.booklisttracker.controller;

import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;

import jakarta.json.Json;
import ssf.miniproject.booklisttracker.service.UserService;

@Controller
@RequestMapping(path="/api")
public class UserController {

    @Autowired 
    private UserService svc;

    @PostMapping(path="/register", consumes=MediaType.MULTIPART_FORM_DATA_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    @CrossOrigin()
    public ResponseEntity<String>postUserEntity(@RequestPart("username") String username, @RequestPart("password") String password){
         
        String id = UUID.randomUUID().toString().substring(0,8);

       try {
        svc.createNewUser(id, username, password);
       } catch (Exception e) {
                e.printStackTrace();
                return ResponseEntity.status(500)
                .body(Json.createObjectBuilder().add("error", e.getMessage()).toString());
       }

       return ResponseEntity.ok(Json.createObjectBuilder().add("id", id).build().toString());
    }
}


    

