package com.example.wardrobeserver.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String email;

    public User( User user) {
        this.id = user.id;
        this.username = user.username;
        this.email = user.email;
        this.password = user.password;
        this.privateAccount = user.privateAccount;
        this.requestedFriends = null;
        this.receivedFriends = null;
        this.collections = null;
        this.likes = null;
    }

    private String password;

    public User(String username, String email, String password,boolean privateAccount) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.privateAccount = privateAccount;
    }
    boolean privateAccount;

    @OneToMany(mappedBy = "friendRequester")
    private Set<Friend> requestedFriends = new LinkedHashSet<Friend>();

    @OneToMany(mappedBy = "friendReceiver")
    private Set<Friend> receivedFriends = new LinkedHashSet<Friend>();

    @ManyToMany
    private Collection<Outfit> collections;
    @ManyToMany
    private  Collection<Outfit> likes;
}
