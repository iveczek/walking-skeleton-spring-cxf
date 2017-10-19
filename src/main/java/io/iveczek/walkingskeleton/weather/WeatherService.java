package io.iveczek.walkingskeleton.weather;

import net.webservicex.GlobalWeatherSoap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.ws.soap.SOAPFaultException;

@Component
public class WeatherService {

    private static final Logger log = LoggerFactory.getLogger(WeatherService.class);

    @Autowired
    private GlobalWeatherSoap weatherClient;

    public String getWeather(){

        String response;

        try {
            response = weatherClient.getWeather("Paris", "France");

        } catch (SOAPFaultException e) {
            log.error("Error calling WeatherService: {}", e);
            response = "Soap exception";
        }

        return response;
    }
}
