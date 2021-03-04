package com.tts.techtalentweather.service;

import com.tts.techtalentweather.model.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    /*
    create a private String variable that reads our API key from
    application.properties. This will automatically get set at runtime.
     */
    @Value("${api_key}")
    private String apiKey;

    /*
    Create a method that will take in a zip code and return a Response
    object containing data from the API.
     */
    public Response getForecast(String zipCode) {
        String url = "http://api.openweathermap.org/data/2.5/weather?zip=" +
                zipCode + "&units=imperial&appid=" + apiKey;
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, Response.class);
    }

}//end WeatherService class
