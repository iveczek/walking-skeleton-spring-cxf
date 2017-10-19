package io.iveczek.walkingskeleton.weather;

import net.webservicex.GlobalWeatherSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WeatherService {

    @Autowired
    private GlobalWeatherSoap weather;

    public String getWeather(){

        return this.weather.getWeather("Paris", "France");



    }
}
