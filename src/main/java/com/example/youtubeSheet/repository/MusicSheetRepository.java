package com.example.youtubeSheet.repository;


import com.example.youtubeSheet.entity.MusicSheet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MusicSheetRepository extends JpaRepository<MusicSheet,Long> {
    List<MusicSheet> findBySiteUser_username(String username);


}
