package io.iveczek.walkingskeleton.stocks;

import net.webservicex.StockQuoteSoap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StockQuoteService {

    @Autowired
    private StockQuoteSoap stockQuoteClient;

    public String getStockQuoteByTicker(String ticker){
        return stockQuoteClient.getQuote(ticker);
    }
}
