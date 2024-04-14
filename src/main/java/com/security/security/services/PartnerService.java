package com.security.security.services;

import com.security.security.models.Partners;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PartnerService {
    List<Partners> getPartnersByAge(int age);
    List<Partners> getPartnersByGender(String gender);
    List<Partners>getPartnersBySportId(int sportId);
    List<Partners>getPartnersByAgeAndGender(int age, String gender);
    List<Partners>getPartnersByAgeOrGenderAndSportId(int age, String gender, int sportId);
}
