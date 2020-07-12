package com.estudo.skyscannerapi;

import com.estudo.skyscannerapi.entidades.Paises;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


@SpringBootTest
class SkyscannerApiApplicationTests {

    @Test
    void consumeApi() throws UnirestException {

        RestTemplate template = new RestTemplate();

        HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/reference/v1.0/countries/pt-BR")
                .header("x-rapidapi-host", "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com")
                .header("x-rapidapi-key", "2cd6897d4fmshc78ed50d3c9d0d4p1a64c6jsn86d73865203f")
                .asString();

        ResponseEntity<Paises> responseEntity = template.getForEntity(response.getBody(), Paises.class, HttpMethod.GET);

    }

}
