package com.example.wardrobeserver.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

@Data
@Entity
public class Friend implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    User friendRequester;
    @ManyToOne
    User friendReceiver;

    StatusCode status;


    public enum StatusCode{
        SENT,
        ACCEPTED
    }

}
