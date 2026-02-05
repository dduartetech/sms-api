package com.diegoduarte.sms_api.business;

import com.diegoduarte.sms_api.infrastructure.entity.SmsMessageEntity;
import com.diegoduarte.sms_api.infrastructure.repository.SmsMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SmsMessageService {

    private final SmsMessageRepository smsMessageRepository;
}
