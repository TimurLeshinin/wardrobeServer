package com.example.wardrobeserver.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
public class Outfit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String  name;
    private String  description;

    @ManyToOne
    private User owner;

    @ManyToMany(mappedBy = "likes")
    private Collection<User> users;

    @ManyToMany(mappedBy = "outfits")
    private List<Clothe> clothes;

}
