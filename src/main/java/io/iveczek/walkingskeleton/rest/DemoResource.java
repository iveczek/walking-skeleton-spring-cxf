package io.iveczek.walkingskeleton.rest;

import io.iveczek.walkingskeleton.weather.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/skeleton", description = "Operation about Skeleton")
@Path("/skeleton")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DemoResource {

    @Autowired
    WeatherService weatherService;

    @GET
    @Path("/demo")
    @ApiOperation(value = "Get some demo data",
            notes = "Return simple object",
            response = Person.class)
    public Response getPerson(){
        return Response.ok(new Person("John", "Doe")).build();
    }

    @GET
    @Path("/weather")
    @ApiOperation(value = "Get weather in Sundsvall")
    public Response getWeather(){
        return Response.ok(weatherService.getWeather()).build();
    }
}

