package io.iveczek.walkingskeleton.rest;

import io.iveczek.walkingskeleton.stocks.StockQuoteService;
import io.iveczek.walkingskeleton.weather.WeatherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Api(value = "/skeleton", description = "Operation about Skeleton")
@Path("/skeleton")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class DemoResource {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private StockQuoteService stockQuoteService;

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
    @ApiOperation(value = "Get weather in ...")
    public Response getWeather(){
        return Response.ok(weatherService.getWeather()).build();
    }

    @GET
    @Path("/stock/{ticker}")
    @ApiOperation(value = "Get stockQuote by ticker.")
    public Response getStocks(
            @ApiParam(value = "Ticker of the company", required = true, defaultValue = "MSFT") @PathParam("ticker") String ticker){
        return Response.ok(stockQuoteService.getStockQuoteByTicker(ticker)).build();
    }
}