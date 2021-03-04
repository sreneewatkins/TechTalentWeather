package com.tts.techtalentweather.controller;

import com.tts.techtalentweather.model.Request;
import com.tts.techtalentweather.model.Response;
import com.tts.techtalentweather.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    /*
    gets weather data for a particular location, adds it to the model,
    and returns an index page.
     */
    /*
    @GetMapping
    public String getIndex(Model model) {
        Response response = weatherService.getForecast("71104");
        model.addAttribute("data", response);
        return "index";
    }
    */

    /*
    We need to make some changes to our controller to handle the form.
    First, we're going to change our existing method so that it doesn't
    call the WeatherService.
     */
    @GetMapping
    public String getIndex(Model model) {
        model.addAttribute("request", new Request());
        return "index";
    }

    /*
    Next, we'll create a new method to handle the POST request from the
    form, and display the index.html page with weather data on it.
     */
    @PostMapping
    public String postIndex(Request request, Model model) {
        Response data = weatherService.getForecast(request.getZipCode());
        model.addAttribute("data", data);
        return "index";
    }

}//end WeatherController class
