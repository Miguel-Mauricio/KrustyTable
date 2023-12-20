package org.example.model.gpt;

import java.util.LinkedList;
import java.util.List;

/**
 * Our model class for chat gpt
 * */
public class RequestGPT{
    private String model;

    private List<Message> messages = new LinkedList<>();

    private Float temperature;

    private Integer max_tokens;

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Float getTemperature() {
        return temperature;
    }

    public void setTemperature(Float temperature) {
        this.temperature = temperature;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public void addMessage(Message message){
        this.messages.add(message);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "RequestGPT{" +
                "model='" + model + '\'' +
                ", messages=" + messages +
                ", temperature=" + temperature +
                ", max_tokens=" + max_tokens +
                '}';
    }
}
