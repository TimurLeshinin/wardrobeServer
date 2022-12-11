package com.example.wardrobeserver.services;

import com.example.wardrobeserver.domain.Clothe;
import com.example.wardrobeserver.domain.User;
import com.example.wardrobeserver.repos.ClotheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class ClotheService {

    @Autowired
    private ClotheRepository clotheRepository;

    public void addClothe( Clothe clothe)
    {
        Iterable<Clothe> users  = clotheRepository.findAll();

//        for(User it : users)
//        {
//            if(user.getEmail().equals(it.getEmail()))
//            {
//                throw new IllegalArgumentException("Email has been used.");
//            }
//        }

        clotheRepository.save(clothe);
    }

    public Iterable<Clothe> getAll()
    {
        return  clotheRepository.findAll();
    }
}
