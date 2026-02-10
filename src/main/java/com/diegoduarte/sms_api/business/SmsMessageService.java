package com.diegoduarte.sms_api.business;

import com.diegoduarte.sms_api.business.converter.SmsMessageConverter;
import com.diegoduarte.sms_api.business.dto.SmsMessageDTO;
import com.diegoduarte.sms_api.infrastructure.entity.SmsMessageEntity;
import com.diegoduarte.sms_api.infrastructure.exceptions.ResourceNotFoundException;
import com.diegoduarte.sms_api.infrastructure.enums.StatusEnum;
import com.diegoduarte.sms_api.infrastructure.repository.SmsMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SmsMessageService {

    private final SmsMessageRepository smsMessageRepository;
    private final SmsMessageConverter smsMessageConverter;

    public SmsMessageDTO atualizarStatus (StatusEnum statusEnum, Long id) {
        try {
            SmsMessageEntity smsMessageEntity = smsMessageRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Mensagem não encontrada."));
            smsMessageEntity.setStatus(statusEnum);
            return smsMessageConverter.paraSmsDTO(smsMessageRepository.save(smsMessageEntity));
        } catch (ResourceNotFoundException e) {
            throw new ResourceNotFoundException("Erro ao alterar status de envio", e.getCause());
        }
    }

    public SmsMessageDTO enviarSms(SmsMessageDTO smsDTO) {
        SmsMessageEntity entity = new SmsMessageEntity();
        entity.setMessage(smsDTO.getMessage());
        entity.setPhoneNumber(smsDTO.getPhoneNumber());
        entity.setStatus(StatusEnum.ENVIADO);

        entity.setSentAt(LocalDateTime.now());

        return smsMessageConverter.paraSmsDTO(smsMessageRepository.save(entity));
    }

    public List<SmsMessageDTO> listarMensagensUltimas24Horas(StatusEnum status) {
        LocalDateTime agora = LocalDateTime.now();
        LocalDateTime agoraMenos24H = agora.minusHours(24);

        List<SmsMessageEntity> lista = smsMessageRepository.findBySentAtBetweenAndStatus(agoraMenos24H, agora, status);

        return lista.stream()
                .map(smsMessageConverter::paraSmsDTO)
                .toList();
    }

}
