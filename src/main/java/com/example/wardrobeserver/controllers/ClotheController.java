package com.example.wardrobeserver.controllers;

import com.example.wardrobeserver.domain.Clothe;
import com.example.wardrobeserver.services.ClotheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClotheController {

    @Autowired
    private ClotheService clotheService;

    @PostMapping(value = "/clothe/add")
    public ResponseEntity addClothe(@RequestBody Clothe clothe)
    {
        clotheService.addClothe(clothe);

        return  ResponseEntity.ok(clothe);
    }

    @PostMapping(value = "/clothe/get")
    public ResponseEntity getClothe(@RequestBody Clothe clothe)
    {
        return  ResponseEntity.ok(clothe);
    }

    @PostMapping(value = "/clothe/getAll")
    public ResponseEntity getAll()
    {
        return  ResponseEntity.ok(clotheService.getAll());
    }
}
