package com.example.wardrobeserver.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;


@Data
@Entity
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String name;
    private String type;

    @ManyToMany
    private Collection<Outfit> outfits;
}
