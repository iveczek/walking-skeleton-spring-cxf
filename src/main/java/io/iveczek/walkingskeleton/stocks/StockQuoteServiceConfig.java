package io.iveczek.walkingskeleton.stocks;

import net.webservicex.StockQuoteSoap;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StockQuoteServiceConfig {

    @Bean
    public StockQuoteSoap stockQuoteSoapClient(){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://www.webservicex.com/stockquote.asmx");
        factory.getInInterceptors().add(getPrettyLoggingInterceptor(new LoggingInInterceptor()));
        factory.getOutInterceptors().add(getPrettyLoggingInterceptor(new LoggingOutInterceptor()));
        factory.setServiceClass(StockQuoteSoap.class);

        return (StockQuoteSoap) factory.create();
    }

    private AbstractLoggingInterceptor getPrettyLoggingInterceptor(AbstractLoggingInterceptor loggingInterceptor) {
        loggingInterceptor.setPrettyLogging(true);
        return loggingInterceptor;
    }
}
