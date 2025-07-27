package com.dev.sayan.microservice.productservice.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@RestController

public class ProductController {

    @Autowired
    //RestTemplate restTemplate;
    RestClient restClient;

    @GetMapping("/{id}")
    public ResponseEntity<String> getOrderFromProduct(@PathVariable Long id){

       // String response =  restTemplate.getForObject("http://localhost:8081/"+id,String.class);
        String response = restClient.get()
                        .uri("http://localhost:8081/"+id)
                                .retrieve()
                                        .body(String.class);
        System.out.println("Response: " + response);

//        HttpURLConnection  httpURLConnection = null;
//
//        try{
//            String url = "http://localhost:8081/" + id;
//            URL obj = new URL(url);
//            httpURLConnection = (HttpURLConnection)obj.openConnection();
//            httpURLConnection.setRequestMethod("GET");
//            httpURLConnection.setRequestProperty("Accept", "application/json");
//            //httpURLConnection.setConnectTimeout(5);
//           // httpURLConnection.setReadTimeout(1000);
//            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//            StringBuilder response = new StringBuilder();
//            String responseLine;
//            while((responseLine=in.readLine())!=null){
//                response.append(responseLine);
//            }
//            in.close();
//            System.out.println("Response: "+response.toString());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            if(httpURLConnection!=null){
//                httpURLConnection.disconnect();
//            }
//        }

        return ResponseEntity.ok("Order call successful with id : " + id);

    }
}
