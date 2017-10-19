package io.iveczek.walkingskeleton.config;

import org.apache.cxf.interceptor.AbstractLoggingInterceptor;

public abstract class CxfSoapClient {

    protected AbstractLoggingInterceptor getPrettyLoggingInterceptor(AbstractLoggingInterceptor loggingInterceptor) {
        loggingInterceptor.setPrettyLogging(true);
        return loggingInterceptor;
    }
}
