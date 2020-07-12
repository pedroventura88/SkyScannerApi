package com.estudo.skyscannerapi.configuracao;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ConectaApiSkyscanner {

    private static final String RAPID_API_NAME_HOST = "x-rapidapi-host";
    private static final String RAPID_API_HOST = "skyscanner-skyscanner-flight-search-v1.p.rapidapi.com";
    private static final String RAPID_API_NAME_KEY = "x-rapidapi-key";
    private static final String RAPID_API_KEY = "2cd6897d4fmshc78ed50d3c9d0d4p1a64c6jsn86d73865203f";


    public String buscarPaises() {

        try {

            HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi" +
                    ".com/apiservices/reference/v1.0/countries/pt-BR")
                    .header(RAPID_API_NAME_HOST, RAPID_API_HOST)
                    .header(RAPID_API_NAME_KEY, RAPID_API_KEY)
                    .asString();

            return response.getBody().toString();
        } catch (UnirestException e) {
            return "Falha ao receber dados da API";

        }

    }

    public String buscarLocalizacoes() {
        try {
            HttpResponse<String> response = Unirest.get("https://skyscanner-skyscanner-flight-search-v1.p.rapidapi" +
                    ".com/apiservices/autosuggest/v1.0/UK/GBP/en-GB/?query=Stockholm")
                    .header(RAPID_API_NAME_HOST, RAPID_API_HOST)
                    .header(RAPID_API_NAME_KEY, RAPID_API_KEY)
                    .asString();

            return response.getBody().toString();
        }catch (UnirestException e) {
            return "Falha ao receber dados de localização da API";
        }
    }
}
