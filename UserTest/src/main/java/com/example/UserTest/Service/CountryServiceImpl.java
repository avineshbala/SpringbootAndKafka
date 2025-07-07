package com.example.UserTest.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.UserTest.Bean.Country;
import com.example.UserTest.model.countriesdto;
import com.example.UserTest.model.country;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;

@Service
public class CountryServiceImpl implements CountryService{

    @Autowired
    RestTemplate restTemplate;

    //@RateLimiter(name = "getCountriesRateLimiter")
    @CircuitBreaker(name ="getCountriesCircuitBreaker")
     public Object getCountries(){
        System.out.println("Getting countries");
        //Object response = restTemplate.getForObject("https://restcountries.com/v3.1/all", Object.class);

ResponseEntity<List<country>> response = restTemplate.exchange("https://restcountries.com/v3.1/all", HttpMethod.GET,
 null, new ParameterizedTypeReference<List<country>>() {});
        //System.out.println(response);
        List<countriesdto> countrydto = response.getBody().stream().map(countryMap -> new countriesdto(countryMap.getCca2(),countryMap.getName().getCommon())).collect(Collectors.toList());
        return countrydto;
    }

    public Object sendEmptyCountries(Exception e){
        System.out.println("Falling back");
        Object response = restTemplate.getForObject("https://restcountries.com/v3.1/all", Object.class);
        //System.out.println(response);
        return response;
    }


}
