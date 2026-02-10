package com.diegoduarte.sms_api.business.converter;

import com.diegoduarte.sms_api.business.dto.SmsMessageDTO;
import com.diegoduarte.sms_api.infrastructure.entity.SmsMessageEntity;
import lombok.Builder;
import org.springframework.stereotype.Component;

@Builder
@Component
public class SmsMessageConverter {

    public SmsMessageEntity paraSmsEntity (SmsMessageDTO smsMessageDTO) {
        return SmsMessageEntity.builder()
                .message(smsMessageDTO.getMessage())
                .phoneNumber(smsMessageDTO.getPhoneNumber())
                .status(smsMessageDTO.getStatus())
                .sentAt(smsMessageDTO.getSentAt())
                .build();
    }

    public SmsMessageDTO paraSmsDTO (SmsMessageEntity smsMessageEntity) {
        return SmsMessageDTO.builder()
                .id(smsMessageEntity.getId())
                .message(smsMessageEntity.getMessage())
                .phoneNumber(smsMessageEntity.getPhoneNumber())
                .status(smsMessageEntity.getStatus())
                .sentAt(smsMessageEntity.getSentAt())
                .build();
    }
}
