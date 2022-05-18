package com.ouhlar.chatty.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MessageDto {

    private String message;
    private String sender;

}
