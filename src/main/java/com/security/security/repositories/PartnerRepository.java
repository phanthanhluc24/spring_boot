package com.security.security.repositories;

import com.security.security.models.Partners;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PartnerRepository extends JpaRepository<Partners,Integer> {
    @Query("SELECT p FROM Partners p WHERE p.sportId =?1")
    List<Partners> findPartnersBySportId(int sportId);
    List<Partners> findPartnersByAge(int age);
    List<Partners> findPartnersByGender(String gender);
    List<Partners> findPartnersByAgeAndGender(int age, String gender);
    @Query("SELECT p FROM Partners p WHERE (p.age=?1 OR p.gender=?2) AND p.sportId=?3")
    List<Partners> findPartnersByAgeOrGenderAndSportId(int age, String gender, int sportId);
}
