package org.example.controller;

import org.example.dto.MessageDTO;
import org.example.dto.assembler.MessageDtoAssembler;
import org.example.model.gpt.Message;
import org.example.service.GPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Class that will get and massage json data from RAWG.io api
 * */

@RestController
@RequestMapping("/api/gpt")
public class GPTController {

    private GPTService gptService;

    private MessageDtoAssembler messageDtoAssembler;

    @Autowired
    public void setGptService(GPTService gptService) {
        this.gptService = gptService;
    }

    @Autowired
    public void setMessageDtoAssembler(MessageDtoAssembler messageDtoAssembler) {
        this.messageDtoAssembler = messageDtoAssembler;
    }

    @RequestMapping(value = "/",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<MessageDTO> postPrompt(@Valid @RequestBody MessageDTO messageDTO, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            messageDTO.setErrors(bindingResult.getAllErrors());
            return new ResponseEntity<>(messageDTO, HttpStatus.BAD_REQUEST);
        }

        System.out.println("Request received: " + messageDTO);

        try {
            Message responseGPT = gptService.sendGetRequest("", messageDtoAssembler.convertFromDto(messageDTO) );
            return new ResponseEntity<>(messageDtoAssembler.convertToDto(responseGPT), HttpStatus.OK);
        }catch (Exception err){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
