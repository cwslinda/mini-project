package ssf.miniproject.booklisttracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssf.miniproject.booklisttracker.repository.UserRepo;

@Service
public class UserService {
    

    @Autowired 
    private UserRepo userRepo;


    public boolean createNewUser(String id, String username, String password) {
        System.out.println("in service");
        System.out.println(username);
        System.out.println(id);
        System.out.println(password);
        return userRepo.insertUserIntoRepo(id, username, password);
    }
}
