package com.security.security.services.impl;

import com.security.security.models.Partners;
import com.security.security.repositories.PartnerRepository;
import com.security.security.services.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartnerServiceImpl implements PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public List<Partners> getPartnersByAge(int age){
        return partnerRepository.findPartnersByAge(age);
    }

    @Override
    public List<Partners> getPartnersByGender(String gender){
        return partnerRepository.findPartnersByGender(gender);
    }

    @Override
    public List<Partners> getPartnersBySportId(int sportId){
        return partnerRepository.findPartnersBySportId(sportId);
    }

    @Override
    public  List<Partners>getPartnersByAgeAndGender(int age, String gender){
        return partnerRepository.findPartnersByAgeAndGender(age,gender);
    }

    @Override
    public List<Partners> getPartnersByAgeOrGenderAndSportId(int age, String gender, int sportId){
        return partnerRepository.findPartnersByAgeOrGenderAndSportId(age,gender,sportId);
    }
}
