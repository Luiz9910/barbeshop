package com.barbearia.barbearia.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResponseDTO {
    private List<String> messages;

    public ResponseDTO(String messages) {
        this.messages = Collections.singletonList(messages);
    }
}
