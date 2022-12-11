package com.example.wardrobeserver.controllers;

import com.example.wardrobeserver.domain.Clothe;
import com.example.wardrobeserver.domain.Friend;
import com.example.wardrobeserver.domain.User;
import com.example.wardrobeserver.services.FriendService;
import com.example.wardrobeserver.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FriendController {
    @Autowired
    private FriendService friendService;
    @Autowired
    private UserService userService;


    @PostMapping(value = "/friend/sendRequest")
    public ResponseEntity sendRequest(@RequestBody Friend friend)
    {
        try {
            friendService.addRequest(friend);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok(friend);
    }

    @PostMapping(value = "/friend/denyRequest")
    public ResponseEntity denyRequest(@RequestBody Friend friend)
    {
        try {
            friendService.denyRequest(friend);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

        return  ResponseEntity.ok("");
    }


    @PostMapping(value = "/friend/get")
    public ResponseEntity getFriends(@RequestBody User user)
    {
        Long id =    userService.getId(user);
        try {
            if (id == null)
                throw new Exception();

            Iterable<User> friends = friendService.getFriends(id);
            return  ResponseEntity.ok(friends);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }

    }

    @PostMapping(value = "/friend/accept")
    public ResponseEntity acceptRequest(@RequestBody Friend friend)
    {
        try {
            friendService.acceptRequest(friend);
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().build();
        }
        return  ResponseEntity.ok("Ok");
    }

}
