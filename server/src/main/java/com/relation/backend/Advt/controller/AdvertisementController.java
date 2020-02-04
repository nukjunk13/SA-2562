package com.relation.backend.Advt.controller;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.net.URLDecoder;

import com.relation.backend.Advt.entity.Advertisement;
import com.relation.backend.Advt.entity.Sponsor;
import com.relation.backend.Advt.entity.Employee;
import com.relation.backend.Advt.entity.Adtype;
import com.relation.backend.Advt.repository.AdvertisementRepository;
import com.relation.backend.Advt.repository.SponsorRepository;
import com.relation.backend.Advt.repository.EmployeeRepository;
import com.relation.backend.Advt.repository.AdtypeRepository;


import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AdvertisementController {
    @Autowired
    private final AdvertisementRepository advertisementRepository;
    @Autowired
    private SponsorRepository sponsorRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AdtypeRepository adtypeRepository;

    AdvertisementController(AdvertisementRepository  advertisementRepository) {
        this.advertisementRepository = advertisementRepository;
    }

    @GetMapping("/advertisement")
    public Collection<Advertisement> Advertisements() {
        return advertisementRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping("/advertisement/{adtype}/{id_employee}/{id_sponsor}/{adLink}/{adTitle}")
    public Advertisement newAdvertisement (Advertisement  newAdvertisement ,
                               @PathVariable long adtype,
                               @PathVariable String adLink,
                               @PathVariable String adTitle,
                               @PathVariable long id_employee,
                               @PathVariable long id_sponsor) {
        //Advertisement newAdvertisement = new Advertisement();

        Adtype type = adtypeRepository.findById(adtype);
        Employee employee = employeeRepository.findById(id_employee);
        Sponsor sponsor = sponsorRepository.findById(id_sponsor);

        newAdvertisement.setAdLink(adLink);
        newAdvertisement.setAdTitle(adTitle);
        newAdvertisement.setAdDate(new Date());
        newAdvertisement.setType(type);
        newAdvertisement.setEmployee(employee);
        newAdvertisement.setSponsor(sponsor);

        return advertisementRepository.save(newAdvertisement);//บันทึก Objcet ชื่อ Advertisement

    }
}