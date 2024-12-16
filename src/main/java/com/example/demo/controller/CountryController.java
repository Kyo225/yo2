package com.example.demo.controller;

import com.example.demo.model.Country;
import com.example.demo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getCountries() {
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<Country> createCountry(@RequestBody Country country) {
        return ResponseEntity.status(201).body(countryService.createCountry(country));
    }

    @PutMapping("/{name}")
    public ResponseEntity<Country> updateCountry(@PathVariable String name, @RequestBody Country country) {
        Country updatedCountry = countryService.updateCountry(name, country);
        if (updatedCountry != null) {
            return ResponseEntity.ok(updatedCountry);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String name) {
        if (countryService.deleteCountry(name)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.status(404).build();
    }
}
