package org.example.dto.assembler;

import org.example.dto.MessageDTO;
import org.example.model.gpt.Message;
import org.springframework.stereotype.Component;

@Component
public class MessageDtoAssembler implements GenericDtoAssembler<Message, MessageDTO> {
    @Override
    public MessageDTO convertToDto(Message modelObj) {
        MessageDTO messageDTO = new MessageDTO();
        messageDTO.setMessage( modelObj.getContent() );
        return messageDTO;
    }

    @Override
    public Message convertFromDto(MessageDTO modelObj) {
        Message message = new Message();
        message.setRole( "user" );
        message.setContent( modelObj.getMessage() );
        return message;
    }
}
