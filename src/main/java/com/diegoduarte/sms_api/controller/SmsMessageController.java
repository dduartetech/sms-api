package com.diegoduarte.sms_api.controller;

import com.diegoduarte.sms_api.business.SmsMessageService;
import com.diegoduarte.sms_api.business.dto.SmsMessageDTO;
import com.diegoduarte.sms_api.infrastructure.enums.StatusEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class SmsMessageController {

    private final SmsMessageService smsMessageService;

    @PostMapping
    public ResponseEntity<SmsMessageDTO> enviarSms (@RequestBody SmsMessageDTO smsMessageDTO) {
        return ResponseEntity.ok(smsMessageService.enviarSms(smsMessageDTO));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<SmsMessageDTO> atualizarStatus (@RequestParam("status") StatusEnum statusEnum,
                                                           @PathVariable("id") Long id) {
        return ResponseEntity.ok(smsMessageService.atualizarStatus(statusEnum, id));
    }

    @GetMapping("/relatorio")
    public ResponseEntity<List<SmsMessageDTO>> listarMensagensUltimas24Horas(@RequestParam("status") StatusEnum status) {
        return ResponseEntity.ok(smsMessageService.listarMensagensUltimas24Horas(status));
    }

}
