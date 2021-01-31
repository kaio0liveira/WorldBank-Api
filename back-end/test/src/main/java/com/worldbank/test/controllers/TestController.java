package com.worldbank.test.controllers;

import com.worldbank.test.dtos.CountryResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class TestController {

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public TestController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @GetMapping("countries/{code}")
    public ResponseEntity<List<CountryResponseDTO>> getCountries(@PathVariable String code) {
        String uri = "http://api.worldbank.org/v2/country/{code}/indicator/SI.POV.DDAY?format=json";

        Map<String, String> params = Collections.singletonMap("code", code);

        Object[] responseObjects = this.restTemplate.getForObject(uri, Object[].class, params);
        List<Object> countriesList = (List<Object>) responseObjects[1];

        List<CountryResponseDTO> countries = countriesList.stream()
                .map(countryLinkedHasMap -> objectMapper.convertValue(countryLinkedHasMap, CountryResponseDTO.class))
                .collect(Collectors.toList());

        return ResponseEntity.ok(countries);
    }
}
