package com.example.wardrobeserver.repos;

import com.example.wardrobeserver.domain.Clothe;
import com.example.wardrobeserver.domain.Friend;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClotheRepository extends JpaRepository<Clothe,Long> {
}
