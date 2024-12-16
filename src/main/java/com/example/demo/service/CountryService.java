package com.example.demo.service;


import com.example.demo.model.Country;
import com.example.demo.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Optional<Country> getCountryByName(String name) {
        return countryRepository.findById(name);
    }

    public Country createCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String name, Country country) {
        if (countryRepository.existsById(name)) {
           //country.setName(name);
            country.setName(name);

            return countryRepository.save(country);
        }
        return null;
    }

    public boolean deleteCountry(String name) {
        if (countryRepository.existsById(name)) {
            countryRepository.deleteById(name);
            return true;
        }
        return false;
    }
}

