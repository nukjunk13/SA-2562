package com.relation.backend.Advt.controller;
import com.relation.backend.Advt.entity.Sponsor;
import com.relation.backend.Advt.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class SponsorController {

    @Autowired
    private final SponsorRepository sponsorRepository;

    public SponsorController(SponsorRepository sponsorRepository) {
        this.sponsorRepository = sponsorRepository;
    }

    @GetMapping("/sponsor")
    public Collection<Sponsor> Sponsors() {
        return sponsorRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/sponsor/{name}")
    public Sponsor newSponsor  (Sponsor  newSponsor,@PathVariable String name) {
        //Sponsor newSponsor = new Sponsor();
        newSponsor.setName(name);
        return sponsorRepository.save(newSponsor);//บันทึก Objcet ชื่อ Sponsor

    }
}