package com.example.wardrobeserver.services;

import com.example.wardrobeserver.domain.Clothe;
import com.example.wardrobeserver.domain.Friend;
import com.example.wardrobeserver.domain.User;
import com.example.wardrobeserver.repos.FriendRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class FriendService {
    private final FriendRepository repository;
    List<Friend> all = null;

    public FriendService(FriendRepository repository) {
        this.repository = repository;
        all = repository.findAll();
    }

    public void addRequest(Friend friend) {

        for (Friend current : all) {
            if (current.getFriendRequester().getId().equals(friend.getFriendRequester().getId())
                    && current.getFriendReceiver().getId().equals(friend.getFriendReceiver().getId())) {
                throw new IllegalArgumentException("Request has been sent");

            }
        }
        friend.setStatus(Friend.StatusCode.SENT);

        repository.save(friend);
        all.add(friend);
    }

    public Iterable<User> getFriends(Long id) {
        List<User> frineds = new ArrayList<>();

        for (Friend current : all) {
            if (current.getStatus() == Friend.StatusCode.ACCEPTED) {

                if (current.getFriendRequester().getId().equals(id))
                    frineds.add(new User(current.getFriendReceiver()));
                else if (current.getFriendReceiver().getId().equals(id))
                    frineds.add(new User(current.getFriendRequester()));
            }
        }

        return (Iterable<User>)frineds;
    }

    public void acceptRequest(Friend friend) {
        Long requester_id = friend.getFriendRequester().getId();
        Long receiver_id = friend.getFriendReceiver().getId();


        for (Friend current : all) {

            if (current.getFriendRequester().getId().equals(requester_id)) {
                if (current.getFriendReceiver().getId().equals( receiver_id)){

                    current.setStatus(Friend.StatusCode.ACCEPTED);
                    repository.save(current);
                    return;
                }
            }
        }

        throw new IllegalArgumentException();
    }

    public void denyRequest(Friend friend) {
        List<Friend> all = repository.findAll();

        for (Friend current : all) {
            if (current.getFriendRequester().getId().equals(friend.getFriendRequester().getId())
                    && current.getFriendReceiver().getId().equals(friend.getFriendReceiver().getId())) {
                repository.delete(current);
                all.remove(current);
                break;
            }
        }

    }
}
