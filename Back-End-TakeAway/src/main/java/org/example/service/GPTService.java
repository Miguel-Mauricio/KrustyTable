package org.example.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.model.gpt.Message;
import org.example.model.gpt.RequestGPT;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * This will have the logic of a REST Client, used to fetch and post requests/payloads
 * */

@Service
public class GPTService {

    private final String base_url = "https://api.openai.com/v1/chat/completions";
    private final String bearerToken = "Bearer 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";

    //https://www.baeldung.com/spring-resttemplate-post-json
    public Message sendGetRequest(String endpoint, Message requestMessage) throws IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.set(HttpHeaders.AUTHORIZATION, bearerToken);

        //Assign the necessary values to our gpt object to use as post params
        RequestGPT gpt = new RequestGPT();
        gpt.setModel("gpt-3.5-turbo");
        gpt.setTemperature(0.5f);
        gpt.setMax_tokens(50);

        Message message = new Message();
        message.setRole("system");
        message.setContent("Be really polite");
        gpt.addMessage(message);

        gpt.addMessage(requestMessage);

        HttpEntity<RequestGPT> gptEntity = new HttpEntity<>(gpt, httpHeaders);

        //Send our request
        String responseGPT = restTemplate.postForObject(base_url, gptEntity, String.class);

        //Allows us to create objects with the put method and get JSON objects from string
        JSONObject jsonObject = new JSONObject(responseGPT);

        JSONObject messageObj = jsonObject.getJSONArray("choices").getJSONObject(0).getJSONObject("message");

        ObjectMapper objectMapper = new ObjectMapper();

        Message responseMessage = objectMapper.readValue(messageObj.toString(), Message.class);

        System.out.println(responseMessage);

        return responseMessage;
    }


}
