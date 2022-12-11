package com.example.wardrobeserver.services;


import com.example.wardrobeserver.domain.Friend;
import com.example.wardrobeserver.domain.User;
import com.example.wardrobeserver.repos.FriendRepository;
import com.example.wardrobeserver.repos.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Set;

@Service
public class UserService {

    private UserRepository userRepository;
    private FriendService friendService;
    private ArrayList<User> users;

    public UserService(UserRepository userRepository, FriendService friendService) {
        this.userRepository = userRepository;

        users = (ArrayList<User>) userRepository.findAll();
        this.friendService = friendService;
    }

    public void regUser(User user) {

        for (User it : users) {
            if (user.getEmail().equals(it.getEmail())) {
                throw new IllegalArgumentException("Email has been used.");
            }
        }
        users.add(user);

        userRepository.save(user);
    }

    public User authUser(User user) {

        for (User it : users) {
            if (user.getEmail().equals(it.getEmail())) {
                if (it.getPassword().equals(user.getPassword())) {
                    User user1 = new User(it);
                    return user1;
                }
            }
        }


        throw new IllegalArgumentException("Incorrect login or password.");
    }

    public User getById(long id) {

        return userRepository.getReferenceById(id);
    }

    public Long getId(User user) {
        for (User it : users) {
            if(it.getEmail().equals(user.getEmail()))
            {
                return it.getId();
            }
        }
        return null;
    }

    public ArrayList<User> getUsers() {
        ArrayList<User> list = new ArrayList<>();
        for (User user : users) {
            list.add(new User(user));
        }
        return list;
    }
}
