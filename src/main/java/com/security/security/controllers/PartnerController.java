package com.security.security.controllers;

import com.security.security.dto.SearchByCriteriaRequest;
import com.security.security.models.Partners;
import com.security.security.services.impl.PartnerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@Controller
@RequestMapping("/api/v1/research")
public class PartnerController {
    @Autowired
    private PartnerServiceImpl partnerServiceImpl;
    @GetMapping("/")
    public ResponseEntity<List<Partners>> searchByCriteria(
            @RequestBody SearchByCriteriaRequest request) {
        try {
            if((request.getAge()!=0 || request.getGender()!=null) && request.getSportId()!=0){
                List<Partners> partners=partnerServiceImpl.getPartnersByAgeOrGenderAndSportId(request.getAge(), request.getGender(), request.getSportId());
                return ResponseEntity.ok(partners);
            }
           else if(request.getGender()!=null && request.getAge()!=0){
                List<Partners> partners =partnerServiceImpl.getPartnersByAgeAndGender(request.getAge(), request.getGender());
                return ResponseEntity.ok(partners);
           }
            else if (request.getAge()!=0){
                List<Partners> partners= partnerServiceImpl.getPartnersByAge(request.getAge());
                return ResponseEntity.ok(partners);
            } else if (request.getGender()!=null) {
                List<Partners> partners= partnerServiceImpl.getPartnersByGender(request.getGender());
                return  ResponseEntity.ok(partners);
            } else
                if (request.getSportId()!=0) {
                List<Partners> partners= partnerServiceImpl.getPartnersBySportId(request.getSportId());
                return  ResponseEntity.ok(partners);
            }
            else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
