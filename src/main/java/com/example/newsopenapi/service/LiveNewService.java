package com.example.newsopenapi.service;

import com.example.newsopenapi.data.ResponseObject;
import com.google.gson.Gson;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class LiveNewService {

    private static final String NEWS_URL = "http://api.mediastack.com/v1/news?access_key=888145d80b079765ed5e653a76b67a6b" +
            "&sort=popularity";

    public ResponseObject informationReturned(String category) {

        String urlWithFilters = NEWS_URL;
        if(category !=null && !category.isBlank()){
            urlWithFilters = urlWithFilters + "&categories=" + category;
        }
        HttpHeaders headers = new HttpHeaders();
        RestTemplate restTemplate = new RestTemplate();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> response = restTemplate.exchange(urlWithFilters, HttpMethod.GET, entity, String.class);
        return getCurrentNews(response.getBody());
    }

    private ResponseObject getCurrentNews(String response)
    {
        ResponseObject responseObject = new Gson().fromJson(response, ResponseObject.class);
        return responseObject;
    }
}
