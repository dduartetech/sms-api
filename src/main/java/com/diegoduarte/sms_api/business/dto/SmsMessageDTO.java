package com.diegoduarte.sms_api.business.dto;

import com.diegoduarte.sms_api.infrastructure.enums.StatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SmsMessageDTO {

    private Long id;
    private String message;
    private String phoneNumber;
    private StatusEnum status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime sentAt;
}
