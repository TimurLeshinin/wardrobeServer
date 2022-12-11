package com.example.wardrobeserver.repos;

import com.example.wardrobeserver.domain.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutfitRepository extends JpaRepository<Outfit,Long> {
}
