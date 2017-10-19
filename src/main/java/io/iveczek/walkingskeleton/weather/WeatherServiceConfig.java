package io.iveczek.walkingskeleton.weather;

import net.webservicex.GlobalWeatherSoap;
import org.apache.cxf.interceptor.AbstractLoggingInterceptor;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherServiceConfig {

    @Bean
    public GlobalWeatherSoap globalWeatherSoapClient(){
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setAddress("http://www.webservicex.com/globalweather.asmx");
        factory.getInInterceptors().add(getPrettyLoggingInterceptor(new LoggingInInterceptor()));
        factory.getOutInterceptors().add(getPrettyLoggingInterceptor(new LoggingOutInterceptor()));
        factory.setServiceClass(GlobalWeatherSoap.class);

        return (GlobalWeatherSoap) factory.create();
    }

    private AbstractLoggingInterceptor getPrettyLoggingInterceptor(AbstractLoggingInterceptor loggingInterceptor) {
        loggingInterceptor.setPrettyLogging(true);
        return loggingInterceptor;
    }
}
