package com.dev.sayan.microservice.productservice.configs;

import com.dev.sayan.microservice.productservice.interceptors.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {

        SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
        simpleClientHttpRequestFactory.setConnectTimeout(5000);
        simpleClientHttpRequestFactory.setReadTimeout(5000);
        return new RestTemplate(simpleClientHttpRequestFactory);
    }

    @Bean
    public MyInterceptor  myInterceptor() {
        return new MyInterceptor();
    }

    @Bean
    public RestClient restClient(ClientHttpRequestInterceptor clientHttpRequestInterceptor){

        return RestClient.builder()
                .requestInterceptor(clientHttpRequestInterceptor)
                .build();
    }
}
