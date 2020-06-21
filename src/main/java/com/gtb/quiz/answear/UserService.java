package com.gtb.quiz.answear;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private ArrayList<User> usersList=new ArrayList<>();


    public UserService() {
        usersList.add(new User(1, "KAMIL",24,"https://inews.gtimg.com/newsapp_match/0/3581582328/0",
                "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Repellendus, non, dolorem, cumque distinctio magni quam expedita velit laborum sunt amet facere tempora ut fuga aliquam ad asperiores voluptatem dolorum! Quasi."));
    }

    public List<User> getAllUsers() {
        return usersList;
    }

    public User getUserById(long id){
        for (User temp : usersList ){
            if(temp.getId()==id){
                return temp;
            }
        }
        return null;
    }

//    public void login(User user) {
//
//    }

//    public ResponseEntity<Void> register(CreateAccountRequest createAccountRequest) {
//
//        User newUser = createAccountRequest.toUser();
//
//        if(usersList.contains(newUser)){
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//        }
//
//        usersList.add(newUser);
//
//        return ResponseEntity.status(HttpStatus.CREATED).build();
//    }
}