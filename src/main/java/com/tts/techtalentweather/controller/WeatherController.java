package com.tts.techtalentweather.controller;

import com.tts.techtalentweather.model.Response;
import com.tts.techtalentweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /*
    gets weather data for a particular location, adds it to the model,
    and returns an index page.
     */
    @GetMapping
    public String getIndex(Model model) {
        Response response = weatherService.getForecast("71104");
        model.addAttribute("data", response);
        return "index";
    }

}//end WeatherController class
